package hal.u22.works.team.a.tools;

import java.sql.SQLException;
import java.util.ArrayList;

import hal.u22.works.team.a.NewProjectPostsConfirmationScreenActivityInfo.NewProjectPostsConfirmationScreenActivityInfo;
import hal.u22.works.team.a.entities.Posts;

public class DataAccess extends Dao {
	/**
	 * フィールド。
	 */
	private String _sql;
	/**
	 * コンストラクタ。
	 *
	 * @throws Exception 全ての例外。
	 */
	public DataAccess() throws Exception, SQLException {
		super();
	}

	public void InsertPosts(NewProjectPostsConfirmationScreenActivityInfo info) throws Exception, SQLException{
		String sql = "insert into posts(member_no, category_no,post_date, post_money, place, latitude, longitude, title, content, photo, target_money, cleaning_flag) values("
				+ " '" + info.getMemberNo() +"',"	//メンバーID			o
				+ " '" + info.getCategoryNo() +"'," //カテゴリーNO			o
				+ " cast( now() as date),"			//プロジェクト日			o
				+ " '" + info.getPostMoney() +"',"  //プロジェクト初期投資	o
				+ " '" + info.getPlace() +"',"		//場所				o
				+ " '" + info.getLatitude() +"',"	//緯度				o
				+ " '" + info.getLongitude() +"',"	//経度				o
				+ " '" + info.getTitle() +"',"		//タイトル				o
				+ " '" + info.getContent() +"',"	//内容				o
				+ " '" + info.getPhoto() +"',"		//写真名				o
				+ " 0,"								//収益				o
				+ " 0"								//クリーン確認 初期値０	o		
				+ ")";
		
		try {
			if(!info.getTitle().equals("")) {
				System.out.println("Insert");
				System.out.println(sql);
				st.executeUpdate(sql);
			}
		}catch (Exception e) {
			System.out.println(e);
			
			// TODO: handle exception	
		}
	}
	
	//自分の投稿の情報を抽出
	public ArrayList<Posts> MyPostSelect(int no) throws Exception, SQLException {
		ArrayList<Posts> result = new ArrayList<Posts>();
		try {
			this._sql = "SELECT no,title, photo, post_money,post_date,cleaning_flag ";
			this._sql += "FROM posts WHERE member_no = "+no+" ";
			this._sql += "ORDER BY post_date desc";
			rs = st.executeQuery(this._sql);
			Posts p = null;
			while(rs.next()) {
				p = new Posts();
				p.setNo( rs.getInt("no") );
				p.setTitle( rs.getString("title") );
				p.setPhoto( rs.getString("photo") );
				p.setMoney( rs.getInt("post_money") );
				p.setDate( rs.getString("post_date") );
				p.setStatus( rs.getInt("cleaning_flag") );
				result.add(p);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}
	//自分の投稿の情報を抽出
	public ArrayList<Posts> MyAssistSelect(int no) throws Exception, SQLException {
		ArrayList<Posts> result = new ArrayList<Posts>();
		try {
			this._sql = "Select p.no,p.title,p.photo,a.assist_money,a.assist_date,p.cleaning_flag ";
			this._sql += "From posts p ";
			this._sql += "RIGHT JOIN assists a ON a.post_no = p.no ";
			this._sql += "WHERE a.member_no = "+no+" ";
			this._sql += "ORDER BY a.assist_date desc";
			rs = st.executeQuery(this._sql);
			Posts p = null;
			while(rs.next()) {
				p = new Posts();
				p.setNo( rs.getInt("p.no") );
				p.setTitle( rs.getString("p.title") );
				p.setPhoto( rs.getString("p.photo") );
				p.setMoney( rs.getInt("a.assist_money") );
				p.setDate( rs.getString("a.assist_date") );
				p.setStatus( rs.getInt("p.cleaning_flag") );
				result.add(p);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}
	
	
}

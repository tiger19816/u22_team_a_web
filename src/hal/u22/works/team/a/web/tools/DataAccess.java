package hal.u22.works.team.a.web.tools;

import java.sql.SQLException;
import java.util.ArrayList;

import hal.u22.works.team.a.achievement.list.screen.AchievementListScreenInfo;
import hal.u22.works.team.a.web.entities.Posts;
import hal.u22.works.team.a.web.newProject.NewProjectPostsConfirmationScreenActivityInfo;

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
	
	/**
	 * Postsテーブルの cleaning_flag を もとに  no, title, place, post_date の適切な全行を取得するクラス
	 * 
	 * @param flagNum
	 * @return
	 */
	
	public ArrayList<AchievementListScreenInfo> getPostsAllTable(String flagNum){
		//取得した値の格納先
		ArrayList<AchievementListScreenInfo> table = new ArrayList<AchievementListScreenInfo>();
		//SQL文の作成
		String sql = "select no, title, place, post_date from posts where cleuning_flag = " + flagNum + " order by post_date ASC" ;
		System.out.println(sql);
		//SQLの発行
		try {
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AchievementListScreenInfo list = new AchievementListScreenInfo();
				list.setNo(rs.getString("no"));
				list.setTitle(rs.getString("title"));
				list.setPlace(rs.getString("post_place"));
				table.add(list);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return  table;
	}
	
	/**
	 * Postsテーブルの cleaning_flag、 no を もとに  no, title, place, post_date, content, photo, 
	 * と assistの中の寄付金合計と Postsテーブルの初期投資金額を合計した値 (posts.post_money + assists.add_money) as money  
	 * の行を取得するクラス
	 * 
	 * @param no
	 * @param flagNum
	 * @return
	 */
	public AchievementListScreenInfo getPostsTable(String no,String flagNum){
		//取得した値の格納先
		AchievementListScreenInfo list = new AchievementListScreenInfo();
		//SQL文の作成
		String sql = "select posts.no, posts.title, posts.place, posts.post_date, posts.content, posts.photo, (posts.post_money + assists.add_money) as money, target_money from posts "
				+ "inner join (SELECT post_no, sum(assist_money) as add_money from assists GROUP by post_no) as assists"
				+ "on assists.post_no = posts.no "
				+ "where cleuning_flag = " + flagNum + " and posts.no =" + no +" order by post_date ASC" ;
		System.out.println(sql);
		//SQLの発行
		try {
			rs = st.executeQuery(sql);
			while(rs.next()) {
				list.setNo(rs.getString("posts.no"));
				list.setTitle(rs.getString("posts.title"));
				list.setPlace(rs.getString("posts.post_place"));
				list.setPostDate(rs.getString("posts.post_date"));
				list.setContent(rs.getString("posts.content"));
				list.setPhoto(rs.getString("posts.photo"));
				list.setPostMoney(rs.getString("money"));
				list.setTargetMoney(rs.getString("target_money"));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return  list;
	}
	
	
	/**
	 * Postsテーブルの no に適応する行 のカラム（ cleaning_flag） を  flagNum へ更新するクラス
	 * 
	 * @param no
	 * @param flagNum
	 */
	
	public void UpdateCleuningFlag(String no, String flagNum) {
		//SQL文の作成
		String sql = "update posts set cleuning_flag = " + flagNum + " where no = " + no; 
		System.out.println(sql);
		//SQLの発行
		try {
			st.executeUpdate(sql);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * Postsテーブルの no に適応する行 のcleaning_flag  を  flagNum, target_money を money へ更新するクラス
	 * 
	 * @param no
	 * @param flagNum
	 * @param money
	 */
	
	public void UpdateCleuningFlag(String no, String flagNum, String money) {
		//SQL文の作成
		String sql = "update posts set cleuning_flag = " + flagNum + ", target_money = " + money + " where no = " + no; 
		System.out.println(sql);
		//SQLの発行
		try {
			st.executeUpdate(sql);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	


}
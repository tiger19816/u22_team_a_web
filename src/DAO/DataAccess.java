package DAO;

import java.sql.SQLException;

import hal.u22.works.team.a.NewProjectPostsConfirmationScreenActivityInfo.NewProjectPostsConfirmationScreenActivityInfo;

public class DataAccess extends Dao {

	/**
	 * コンストラクタ。
	 *
	 * @throws Exception 全ての例外。
	 */
	public DataAccess() throws Exception, SQLException {
		super();
	}

	public void InsertPosts(NewProjectPostsConfirmationScreenActivityInfo info) throws Exception, SQLException{
		String sql = "insert into posts(member_no, post_date, post_money, place, latitude, longutude, title, content, photo, target_money, cleaning_flag) values("
				+ " '" + info.getMemberNo() +"',"	//メンバーID			o
				+ " '" + info.getCategoryNo() +"'," //カテゴリーNO			o
				+ " cast( now() as date),"			//プロジェクト日			o
				+ " '" + info.getPostMoney() +"',"  //プロジェクト初期投資	o
				+ " '" + info.getPlace() +"',"		//場所				o
				+ " '" + info.getLatitude() +"',"	//latitude			
				+ " '" + info.getLongitude() +"',"	//longitude			
				+ " '" + info.getTitle() +"',"		//タイトル				o
				+ " '" + info.getContent() +"',"	//内容				o
				+ " '" + info.getPhoto() +"',"		//写真名				o
				+ " '" + info.getPostMoney() +"',"	//収益				
				+ " 0"								//クリーン確認 初期値０			
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
	
}

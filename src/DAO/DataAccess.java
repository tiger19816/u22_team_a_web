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
				+ " ,"//メンバーID
				+ " ,"//カテゴリーNO
				+ " ,"//プロジェクト日
				+ " ,"//プロジェクト初期投資
				+ " ,"//場所
				+ " ,"//latitude
				+ " ,"//longitude
				+ " ,"//タイトル
				+ " ,"//内容
				+ " ,"//写真名
				+ " ,"//収益
				+ " 0"//クリーン確認 初期値０
				+ ")";
		
		try {
			if(!info.getTitle().equals("")) {
				System.out.println("Insert");
				st.executeUpdate(sql);
			}
		}catch (Exception e) {
			System.out.println(e);
			
			// TODO: handle exception	
		}
	}
	
	public void InsertTest(NewProjectPostsConfirmationScreenActivityInfo info) throws Exception, SQLException{
		
		String sql = "insert into u22_test(title, ImgName, place, category) values("
				+ " '" + info.getTitle() + "',"//title
				+ " '" + info.getPhoto() + "',"//imgName
				+ " '" + info.getPlace() + "',"//place
				+ " '" + info.getCategoryNo() + "'"//category
				+ ")";
		System.out.println(sql);
		try {
			if(!info.getTitle().equals("")) {
				System.out.println("Insert");
				st.executeUpdate(sql);
			}
		}catch (Exception e) {
			System.out.println(e);
			
			// TODO: handle exception	
		}
	}
}

package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import hal.u22.works.team.a.achievement.list.screen.AchievementListScreenInfo;
import hal.u22.works.team.a.web.tools.Dao;

public class DataAccess extends Dao {

	/**
	 * コンストラクタ。
	 *
	 * @throws Exception 全ての例外。
	 */
	public DataAccess() throws Exception, SQLException {
		super();
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
		String sql = "select posts.no, posts.title, posts.place, posts.post_date, posts.content, posts.photo, (posts.post_money + assists.add_money) as money from posts "
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
				list.setTargetMoney(rs.getString("money"));
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

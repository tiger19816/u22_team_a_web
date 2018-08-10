package DAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;


public class u22Dao extends Dao {

	public u22Dao() throws SQLException, ClassNotFoundException{
		super();
	}
	public String getProjectInfo(String proId)throws SQLException,ClassNotFoundException{
		String sql = "";
		String result = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");

		sql  = "SELECT posts.no, member_no, categories.name, post_date, post_money, place, latitude, longitude, title, content, photo, target_money, cleaning_flag ";
		sql += "FROM posts ";
		sql += "INNER JOIN categories ON category_no = categories.no ";
		if(proId != ""){
			sql += "WHERE posts.no = '" + proId + "';";
		}

		this.read(sql);
		while(this.rs.next()){

			result += "\"memberNo\":" + this.rs.getString("member_no") + ", \n";
			result += "\"categoryName\":" + this.rs.getString("name") + ", \n";
			result += "\"postDate\":" + (this.rs.getString("post_date")) + ", \n";
			result += "\"postMoney\":" + this.rs.getString("post_money") + ", \n";
			result += "\"place\":" + this.rs.getString("place") + ", \n";
			result += "\"latitude\":" + this.rs.getString("latitude") + ", \n";
			result += "\"longitude\":" + this.rs.getString("longitude") + ", \n";
			result += "\"title\":" + this.rs.getString("title") + ", \n";
			result += "\"content\":" + this.rs.getString("content") + ", \n";
			result += "\"photo\":" + this.rs.getString("photo") + ", \n";
			result += "\"targetMoney\":" + this.rs.getString("target_money") + ", \n";
			result += "\"cleaningFlag\":" + this.rs.getString("cleaning_flag");

		}
		return result;
	}
	public void setDonation(String proId, String donation)throws SQLException, ClassNotFoundException{

		String sql = "";
		String result = "";

		sql  = "SELECT post_money ";
		sql += "FROM posts ";

		if(proId != ""){
			sql += "WHERE posts.no = '" + proId + "';";
		}
		System.out.println(sql);

		this.read(sql);
		while(this.rs.next()){

			donation = String.valueOf(Integer.parseInt(donation) + Integer.parseInt(rs.getString("post_money")));

		}

		sql = "UPDATE posts SET post_money = '" + donation + "' WHERE no = '" + proId + "';";
		this.upgrade(sql);
	}

}

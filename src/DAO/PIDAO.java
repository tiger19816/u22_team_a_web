package DAO;

import java.sql.SQLException;

public class PIDAO extends Dao{

	public PIDAO() throws SQLException, ClassNotFoundException{
		super();
	}

	public String getProjectInfo(String no)throws SQLException, ClassNotFoundException{

		String sql = "";
		String result = "";

		sql  = "SELECT post_date, place, content ";
		sql += "FROM posts ";
		sql += "WHERE no = '" + no + "';";

		this.read(sql);
		while(this.rs.next()){
			result += "\"postDate\":'" + this.rs.getString("post_date") + "'\n";
			result += "\"place\":'" + this.rs.getString("place") + "'\n";
			result += "\"content\":'" + this.rs.getString("content") + "'\n";
		}
		return result;
	}

	public void setDonation(String no, String donation)throws SQLException, ClassNotFoundException{
		String sql = "";
		int postMoney = 0;

		sql  = "SELECT post_money ";
		sql += "FROM posts ";
		sql += "WHERE no = '" + no + "';";

		this.read(sql);
		while(this.rs.next()){
			postMoney = this.rs.getInt("post_money");
		}
		postMoney += Integer.parseInt(donation);

		sql  = "UPDATE posts ";
		sql += "SET post_money = '" + postMoney + "' ";
		sql += "WHERE no = '" + no + "'";

		this.upgrade(sql);

	}

}

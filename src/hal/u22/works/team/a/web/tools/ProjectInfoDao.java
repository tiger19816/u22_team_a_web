package hal.u22.works.team.a.web.tools;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ProjectInfoDao extends Dao{

	public ProjectInfoDao() throws SQLException, ClassNotFoundException{
		super();
	}
	//プロジェクトの詳細をDBから取り出すメソッド
	public String getProjectInfo(String no)throws SQLException, ClassNotFoundException{

		String sql = "";
		String result = "";
		//画像URLをとりあえず直打ち
		String imageUrl = "http://192.168.42.27:8080/u22_team_a_web/temp/";

		sql  = "SELECT no, post_date, (post_money + COALESCE(SUM(assists.assist_money),0)) AS 'donation_money', place, content, photo, cleaning_flag, target_money ";
		sql += "FROM posts ";
		sql += "LEFT JOIN assists ON no = assists.post_no ";
		sql += "WHERE no = '" + no + "' ";
		sql += "GROUP BY no ASC";
		this.read(sql);
		while(this.rs.next()){
			System.out.println(rs.getString("cleaning_flag"));
			System.out.println(this.rs.getString("target_money" ));
			result += "\"donationMoney\":'" + this.rs.getString("donation_money") + "',\n";
			result += "\"postDate\":'" + this.rs.getString("post_date") + "',\n";
			result += "\"place\":'" + this.rs.getString("place") + "',\n";
			result += "\"content\":'" + this.rs.getString("content") + "',\n";
			result += "\"photo\":'" + this.rs.getString("photo") + "',\n";
			result += "\"cleanFlag\":'"+ this.rs.getString("cleaning_flag") + "',\n";
			result += "\"targetMoney\":'" + this.rs.getString("target_money" ) + "'";
		}
		return result;
	}
//寄付金額をDBに登録するメソッド
//かつ、金額によってフラグを操作するメソッド
	public void setDonation(String postNo, String memberNo, String donation)throws SQLException, ClassNotFoundException{

		String sql = "";
		String flg = "0";
		int fastMoney = 5000;

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String toDay = sdf.format(calendar.getTime());

		sql  = "INSERT INTO assists(`member_no`, `post_no`, `assist_money`, `assist_date`) ";
		sql += "VALUES('" + memberNo + "', '" + postNo + "', '" + donation + "', '" + toDay + "')";
		this.upgrade(sql);

		sql  = "SELECT no, (post_money + COALESCE(SUM(assists.assist_money),0)) AS 'donation_money',  target_money, cleaning_flag ";
		sql += "FROM posts ";
		sql += "LEFT JOIN assists ON no = assists.post_no ";
		sql += "WHERE no = '" + postNo + "' ";
		sql += "GROUP BY no ASC";
		this.read(sql);
		while(this.rs.next()){
			if(this.rs.getInt("cleaning_flag") == 0 && this.rs.getInt("donation_money") >= fastMoney){
				flg = "1";
			}
			if(this.rs.getInt("cleaning_flag") == 2 && this.rs.getInt("donation_money") >= this.rs.getInt("target_money")){
				flg = "3";
			}
		}
		if(flg != "0"){
			sql  = "UPDATE posts ";
			sql += "SET cleaning_flag = '" + flg + "' ";
			sql += "WHERE no = '" + postNo + "'";
			this.upgrade(sql);
		}
	}
}
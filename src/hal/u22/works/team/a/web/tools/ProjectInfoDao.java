package hal.u22.works.team.a.web.tools;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProjectInfoDao extends Dao{

	public ProjectInfoDao() throws SQLException, ClassNotFoundException{
		super();
	}
	//プロジェクトの詳細をDBから取り出すメソッド
	public String getProjectInfo(String no)throws SQLException, ClassNotFoundException{

		String sql = "";
		String result = "";

		sql  = "SELECT no, title, post_date, (post_money + COALESCE(SUM(assists.assist_money),0)) AS 'donation_money', place, content, photo, cleaning_flag, target_money ";
		sql += "FROM posts ";
		sql += "LEFT JOIN assists ON no = assists.post_no ";
		sql += "WHERE no = '" + no + "' ";
		sql += "GROUP BY no ASC";
		this.read(sql);
		while(this.rs.next()){
			result += "\"title\":'" + this.rs.getString("title") + "',\n";
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
//清掃が完了している場合に、その画像を表示する為のメソッド
	public String getCleaningImage(String result, String no)throws SQLException, ClassNotFoundException{

		String sql = "";

		sql  = "SELECT posts.no, COALESCE(cleanings.photo,0) AS photo, COALESCE(cleanings.complete_flag,0) AS flag ";
		sql += "FROM posts ";
		sql += "LEFT JOIN cleanings ON posts.no = cleanings.post_no ";
		sql += "WHERE posts.no = '" + no + "' ";
		sql += "limit 1";

		System.out.println(sql);

		this.read(sql);
		while(this.rs.next()){
			if(!this.rs.getString("flag").equals(null)){
				result += ",\n\"completeFlag\":'" + this.rs.getString("flag") + "',\n";
				if(this.rs.getString("flag").equals("1")){
					result += "\"cleaningPhoto\":'" + this.rs.getString("photo") + "'";
				}else{
					result += "\"cleaningPhoto\": ''";
				}
			}else{
				result += ",\"completeFlag\": ''";
				result += ",\"cleaningPhoto\": ''";
			}
		}
		return result;
	}
//寄付金額をDBに登録するメソッド
//かつ、金額によってフラグを操作するメソッド
	public void setDonation(String postNo, String memberNo, String donation)throws SQLException, ClassNotFoundException{

		String sql = "";
		String flg = "0";
		int fastMoney = 3000;

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
	//業者をリストとして取り出すメソッド
	public List<String[]> getSupplierList()throws SQLException, ClassNotFoundException{

		List<String[]> supplierList = new ArrayList<String[]>();

		String supplierSQL = "";
		supplierSQL  = "SELECT no, name ";
		supplierSQL += "FROM supplier";

		this.read(supplierSQL);

		while(this.rs.next()){
			String[] supplier = new String[2];
			supplier[0] = this.rs.getString("no");
			supplier[1] = this.rs.getString("name");
			System.out.println(supplier[0]+ ":" +supplier[1]);
			supplierList.add(supplier);
		}
		return supplierList;

	}
	//プロジェクトをリストとして取り出すメソッド
	public List<String[]> getProjectsList()throws SQLException, ClassNotFoundException{

		List<String[]> projectList = new ArrayList<String[]>();

		String projectSQL = "";
		projectSQL  = "SELECT no, title ";
		projectSQL += "FROM posts ";
		projectSQL += "WHERE cleaning_flag = '4'";

		this.read(projectSQL);

		while(this.rs.next()){
			String[] project = new String[2];
			project[0] = this.rs.getString("no");
			project[1] = this.rs.getString("title");
			System.out.println(project[0]+ ":" +project[1]);
			projectList.add(project);
		}

		return projectList;
	}
	//更新メソッド
	public void updateData(String supplierNo, String postNo, String fileName)throws SQLException, ClassNotFoundException{

		String sql;

		sql  = "INSERT INTO cleanings(supplier_no, post_no, photo, complete_flag) ";
		sql += "VALUES(" + supplierNo + ", " + postNo + ", '" + fileName + "', 1)";
		System.out.println(sql);
		upgrade(sql);

		rs.next();

		sql  = "UPDATE posts SET cleaning_flag = '5'";
		sql += "WHERE no = '" + postNo + "'";
		upgrade(sql);



	}
}
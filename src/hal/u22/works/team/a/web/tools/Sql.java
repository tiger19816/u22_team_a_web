package hal.u22.works.team.a.web.tools;

import java.sql.SQLException;

public class Sql extends Dao {
	public Sql() throws SQLException,ClassNotFoundException{
		super();
	}

	/**
	 * お問い合わせテーブルContactに情報を入力するInsert文発行
	 * @param c
	 * @throws SQLException
	 */
	public void insertContentNew(Contact c)throws SQLException{
		try {
			String sql = "INSERT INTO contact(member_no,content,send_date)VALUES("+c.getMember_no()+",'"+c.getContent()+"','"+c.getDate()+"');";
			System.out.println(sql);
			st.executeUpdate(sql);

		} catch (SQLException e) {
			throw e;


		}
	}

}
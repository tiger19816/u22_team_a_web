package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	private final String DB_HOST = "localhost:3306";
	private final String DB_NAME = "";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	protected Connection cn;
	protected Statement st;
	protected ResultSet rs;

	public Dao() throws SQLException, ClassNotFoundException {
		try {
			// MySQLのドライバと接続する
			Class.forName("com.mysql.jdbc.Driver");

			// Connectionにデータベース名、ユーザ名、パスワードを代入することで
			// 使用するデータベースを特定できる
			this.cn = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + "/" + DB_NAME + "?characterEncoding=utf8", DB_USER, DB_PASS);

			// Statementに使用するデータベース情報を代入する
			this.st = this.cn.createStatement();
		} catch (SQLException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		}
	}

	//更新系SQLを実行する
	public void update(String sql) throws SQLException {
		try {
			this.st.executeUpdate(sql);
		} catch (SQLException e) {
			throw e;
		}
	}

	//クローズするメソッド
	public void close() throws SQLException {
		try {
			if(this.rs != null) {
				this.rs.close();
			}
			if(this.st != null) {
				this.st.close();
			}
			if(this.cn != null) {
				this.cn.close();
			}
		} catch(SQLException e) {
			throw e;
		}
	}
}

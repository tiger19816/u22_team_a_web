package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
	private final String DB_NAME = "u22";
	private final String DB_USER = "root";
	private final String DB_PASS = "";

	protected Connection cn = null;
	protected Statement st = null;
	protected ResultSet rs = null;
	private int rc = 0;

	public Dao() throws SQLException , ClassNotFoundException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.cn = DriverManager.getConnection("jdbc:mysql://localhost/" + DB_NAME + "?characterEncoding=utf8" , DB_USER , DB_PASS);
			this.st = this.cn.createStatement();
		}catch(SQLException e) {
			throw e;
		}catch(ClassNotFoundException e) {
			throw e;
		}
	}

	 public ResultSet execute(String sql)throws SQLException{
	        try{
	            System.out.println(sql);
	            return this.st.executeQuery(sql);
	        }catch(SQLException e) {
	            throw e;
	        }
	    }

	    public void executeUpdate(String sql)throws SQLException {
	        try{
	            this.rc = st.executeUpdate(sql);
	            System.out.println(sql);
	        }catch(SQLException e){
	            System.out.println("SQLエラー");
	            System.out.println(sql);
	            throw e;
	        }
	    }

	    public void close() throws SQLException{
	        try{
	            if(rs != null){
	                rs.close();
	            }
	            if(st != null){
	                st.close();
	            }if(cn != null){
	                cn.close();
	            }
	        }catch(SQLException e){
	            throw e;
	        }
	    }
}




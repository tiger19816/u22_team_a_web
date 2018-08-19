package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

import entities.Posts;

public class DataAccess extends Dao {
	/**
	 * フィールド。
	 */
	private String _sql;
	/**
	 * コンストラクタ。
	 *
	 * @throws Exception 全ての例外。
	 */
	public DataAccess() throws Exception, SQLException {
		super();
	}

	//自分の投稿の情報を抽出
	public ArrayList<Posts> MyPostSelect(int no) throws Exception, SQLException {
		ArrayList<Posts> result = new ArrayList<Posts>();
		try {
			this._sql = "SELECT no,title, photo, post_money,post_date,cleaning_flag ";
			this._sql += "FROM posts WHERE member_no = "+no+" ";
			this._sql += "ORDER BY post_date desc";
			rs = st.executeQuery(this._sql);
			Posts p = null;
			while(rs.next()) {
				p = new Posts();
				p.setNo( rs.getInt("no") );
				p.setTitle( rs.getString("title") );
				p.setPhoto( rs.getString("photo") );
				p.setMoney( rs.getInt("post_money") );
				p.setDate( rs.getString("post_date") );
				p.setStatus( rs.getInt("cleaning_flag") );
				result.add(p);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}
	//自分の投稿の情報を抽出
	public ArrayList<Posts> MyAssistSelect(int no) throws Exception, SQLException {
		ArrayList<Posts> result = new ArrayList<Posts>();
		try {
			this._sql = "Select p.no,p.title,p.photo,a.assist_money,a.assist_date,p.cleaning_flag ";
			this._sql += "From posts p ";
			this._sql += "RIGHT JOIN assists a ON a.post_no = p.no ";
			this._sql += "WHERE a.member_no = "+no+" ";
			this._sql += "ORDER BY a.assist_date desc";
			rs = st.executeQuery(this._sql);
			Posts p = null;
			while(rs.next()) {
				p = new Posts();
				p.setNo( rs.getInt("p.no") );
				p.setTitle( rs.getString("p.title") );
				p.setPhoto( rs.getString("p.photo") );
				p.setMoney( rs.getInt("a.assist_money") );
				p.setDate( rs.getString("a.assist_date") );
				p.setStatus( rs.getInt("p.cleaning_flag") );
				result.add(p);
			}
			return result;
		}
		catch(Exception e) {
			e.printStackTrace();
            throw e;
		}
	}
	
	
}
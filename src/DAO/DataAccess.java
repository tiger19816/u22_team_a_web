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

	//自分の協力投稿の情報を抽出
	public ArrayList<Posts> MyPostSelect(int no) throws Exception, SQLException {
		ArrayList<Posts> result = new ArrayList<Posts>();
		try {
			this._sql = "SELECT p.no,p.title,p.photo,p.cleaning_flag,p.post_date ";
			this._sql += "FROM posts p INNER JOIN assists a ON a.post_no = p.no";
			this._sql += "WHERE p.member_no = "+no+"";//投稿
			this._sql += "OR a.member_no = "+no+"";//協賛
			this._sql += "ORDER BY p.post_date desc";
			rs = st.executeQuery(this._sql);
			Posts p = null;
			while(rs.next()) {
				p = new Posts();
				p.setNo( rs.getInt("no") );
				p.setTitle( rs.getString("title") );
				p.setPhoto( rs.getString("photo") );
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
	

}

package hal.u22.works.team.a.web.distance;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import hal.u22.works.team.a.web.tools.Dao;


/**
 * 距離測定クラス。
 *
 * @author Taiga Hirai
 */

public class Distance extends Dao {
	public Distance() throws SQLException, ClassNotFoundException {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	/**
	 * 距離を求めるメソッド.
	 *
	 * @param lat1 地点1の緯度。
	 * @param lng1 地点1の経度。
	 * @param lat2 地点2の緯度。
	 * @param lng2 地点2の経度。
	 * @param precision 。
	 * @return 距離。
	 */
	protected PreparedStatement st;

	public static float getDistance(double lat1, double lng1, double lat2, double lng2) {
	    int R = 6371; // km
	    double lat = Math.toRadians(lat2 - lat1);
	    double lng = Math.toRadians(lng2 - lng1);
	    double A = Math.sin(lat / 2) * Math.sin(lat / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lng / 2) * Math.sin(lng / 2);
	    double C = 2 * Math.atan2(Math.sqrt(A), Math.sqrt(1 - A));
	    double decimalNo = Math.pow(10, 3);
	    double distance = R * C;
	    distance = Math.round(decimalNo * distance / 1) / decimalNo;
	    return (float) distance;
	}

	public ArrayList<Map<String, String>> getPoint(float lat,float lng)  throws SQLException{
//		ArrayList<ArrayList<String>> point = new ArrayList<ArrayList<String>>();
		ArrayList<Map<String, String>> point = new ArrayList<Map<String, String>>();

		String sql = "SELECT * FROM posts WHERE latitude BETWEEN ?-0.00901 AND ?+0.00901 AND longitude BETWEEN ?-0.010966 AND ?+0.010966;";
		st = cn.prepareStatement(sql);
		st.setFloat(1,lat);
		st.setFloat(2,lat);
		st.setFloat(3,lng);
		st.setFloat(4,lng);
		rs = st.executeQuery();
		while(rs.next()) {
			Map<String, String> rec = new HashMap<String, String>();
			rec.put("point_no", rs.getString("point_no"));
			//point.add(rec);
			//rec = new HashMap<String, String>();
			rec.put("title", rs.getString("title"));
			//point.add(rec);
			//rec = new HashMap<String, String>();
			rec.put("money", rs.getString("money"));
			//point.add(rec);
			//rec = new HashMap<String, String>();
			rec.put("place", rs.getString("place"));
			//point.add(rec);
			//rec = new HashMap<String, String>();
			rec.put("latitude", rs.getString("latitude"));
			//point.add(rec);
			//rec = new HashMap<String, String>();
			rec.put("longitude", rs.getString("longitude"));
			//point.add(rec);
			//rec = new HashMap<String, String>();
			rec.put("content", rs.getString("content"));
			//point.add(rec);
			//rec = new HashMap<String, String>();
			rec.put("phote", rs.getString("phote"));
			//point.add(rec);
			//rec = new HashMap<String, String>();
			rec.put("target_money", rs.getString("target_money"));
//			ArrayList<String> rec = new ArrayList<String>();
//			rec.add("{");
//			point.add(rec);
//			ArrayList<String> rec1 = new ArrayList<String>();
//			rec.add("\"point_no\""+":"+"\""+rs.getString("point_no")+"\"");
//			point.add(rec1);
//			ArrayList<String> rec2 = new ArrayList<String>();
//			rec.add("\"title\""+":"+"\""+rs.getString("title")+"\"");
//			point.add(rec2);
//			ArrayList<String> rec3 = new ArrayList<String>();
//			rec.add("\"money\""+":"+"\""+rs.getString("money")+"\"");
//			point.add(rec3);
//			ArrayList<String> rec4 = new ArrayList<String>();
//			rec.add("\"place\""+":"+"\""+rs.getString("place")+"\"");
//			point.add(rec4);
//			ArrayList<String> rec5 = new ArrayList<String>();
//			rec.add("\"latitude\""+":"+"\""+rs.getString("latitude")+"\"");
//			point.add(rec5);
//			ArrayList<String> rec6 = new ArrayList<String>();
//			rec.add("\"longitude\""+":"+"\""+rs.getString("longitude")+"\"");
//			point.add(rec6);
//			ArrayList<String> rec7 = new ArrayList<String>();
//			rec.add("\"content\""+":"+"\""+rs.getString("content")+"\"");
//			point.add(rec7);
//			ArrayList<String> rec8 = new ArrayList<String>();
//			rec.add("\"photo\""+":"+"\""+rs.getString("phote")+"\"");
//			point.add(rec8);
//			ArrayList<String> rec9 = new ArrayList<String>();
//			rec.add("\"target_money\""+":"+"\""+rs.getString("target_money")+"\"");
//			point.add(rec9);
//			ArrayList<String> rec10 = new ArrayList<String>();
//			rec.add("}");
//			point.add(rec10);
			point.add(rec);
		}
		return point;
	}

}
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
        double A = Math.sin(lat / 2) * Math.sin(lat / 2) + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(lng / 2) * Math.sin(lng / 2);
        double C = 2 * Math.atan2(Math.sqrt(A), Math.sqrt(1 - A));
        double decimalNo = Math.pow(10, 3);
        double distance = R * C;
        distance = Math.round(decimalNo * distance / 1) / decimalNo;
        return (float) distance;
    }

    public ArrayList<Map<String, String>> getPoint(double lat, double lng) throws SQLException {
        ArrayList<Map<String, String>> point = new ArrayList<Map<String, String>>();

        String sql = "SELECT * FROM posts WHERE latitude BETWEEN ?-0.00901 AND ?+0.00901 AND longitude BETWEEN ?-0.010966 AND ?+0.010966;";
        st = cn.prepareStatement(sql);
        st.setDouble(1, lat);
        st.setDouble(2, lat);
        st.setDouble(3, lng);
        st.setDouble(4, lng);
        rs = st.executeQuery();
        while (rs.next()) {
            Map<String, String> rec = new HashMap<String, String>();
            rec.put("no", rs.getString("no"));
            rec.put("member_no", rs.getString("member_no"));
            rec.put("category_no", rs.getString("category_no"));
            rec.put("post_date", rs.getString("post_date"));
            rec.put("post_money", rs.getString("post_money"));
            rec.put("place", rs.getString("place"));
            rec.put("latitude", rs.getString("latitude"));
            rec.put("longitude", rs.getString("longitude"));
            rec.put("title", rs.getString("title"));
            rec.put("content", rs.getString("content"));
            rec.put("photo", rs.getString("photo"));
            rec.put("target_money", rs.getString("target_money"));
            rec.put("cleaning_flag", rs.getString("cleaning_flag"));
            point.add(rec);
        }
        return point;
    }

    public ArrayList<Map<String, String>> getPoint(double lat, double lng, int flag) throws SQLException {
        ArrayList<Map<String, String>> point = new ArrayList<Map<String, String>>();

        String sql = "SELECT * FROM posts WHERE latitude BETWEEN ?-0.00901 AND ?+0.00901 AND longitude BETWEEN ?-0.010966 AND ?+0.010966 AND cleaning_flag = ?;";
        st = cn.prepareStatement(sql);
        st.setDouble(1, lat);
        st.setDouble(2, lat);
        st.setDouble(3, lng);
        st.setDouble(4, lng);
        st.setInt(5, flag);
        rs = st.executeQuery();
        while (rs.next()) {
            Map<String, String> rec = new HashMap<String, String>();
            rec.put("no", rs.getString("no"));
            rec.put("member_no", rs.getString("member_no"));
            rec.put("category_no", rs.getString("category_no"));
            rec.put("post_date", rs.getString("post_date"));
            rec.put("post_money", rs.getString("post_money"));
            rec.put("place", rs.getString("place"));
            rec.put("latitude", rs.getString("latitude"));
            rec.put("longitude", rs.getString("longitude"));
            rec.put("title", rs.getString("title"));
            rec.put("content", rs.getString("content"));
            rec.put("photo", rs.getString("photo"));
            rec.put("target_money", rs.getString("target_money"));
            rec.put("cleaning_flag", rs.getString("cleaning_flag"));
            point.add(rec);
        }
        return point;
    }
}
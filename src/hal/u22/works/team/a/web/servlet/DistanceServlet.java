package hal.u22.works.team.a.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.distance.Distance;

/**
 * Servlet implementation class DistanceServlet
 */
@WebServlet("/DistanceServlet")
public class DistanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistanceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //文字化け対策
        request.setCharacterEncoding("utf-8");

        //現在地の緯度・経度
        double lat = Double.parseDouble(request.getParameter("lat"));
        double lng = Double.parseDouble(request.getParameter("lng"));

        int flag = Integer.valueOf(request.getParameter("flag"));

        response.setContentType("application/json; charset=UTF-8");

        try {
            ArrayList<Map<String, String>> point = new ArrayList<Map<String, String>>();
            Distance d = new Distance();
            if(flag == -1) {
                point = d.getPoint(lat, lng);
            } else {
                point = d.getPoint(lat, lng, flag);
            }
            request.setAttribute("result", point);
            RequestDispatcher rd = request.getRequestDispatcher("DistanceJson.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

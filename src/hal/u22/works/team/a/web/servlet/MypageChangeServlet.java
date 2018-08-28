package hal.u22.works.team.a.web.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.tools.Dao;

/**
 * Login画面からIDとパスワードを受け取りそれに応じた会員画面表示
 *
 * @author Miyazaki Kazuma
 */
@WebServlet("/MypageChangeServlet")
public class MypageChangeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageChangeServlet() {
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

       	String userId = request.getParameter("userId");
       	System.out.println(userId);
       	//値を格納するための変数
       	String no = "";//会員番号
       	String name = "";//氏名
       	String birthdate = "";//生年月日
       	String address = "";//住所
       	String sex = "";//性別
       	String mail_address = "";//メールアドレス
       	String phone = "";//電話番号

        String sql = "SELECT no,name,birthdate,address,sex,mail_address,phone FROM members WHERE no = "
                + userId +";";
        Dao dao = null;
        ResultSet rs = null;
        try {
            dao = new Dao();
            rs = dao.execute(sql);
            if (rs.next()) {
            	no = rs.getString("no");
                name = rs.getString("name");
                birthdate = rs.getString("birthdate");
                address = rs.getString("address");
                mail_address = rs.getString("mail_address");
                phone = rs.getString("phone");
            }
            System.out.println(name);
            System.out.println(birthdate);
            System.out.println(address);
            System.out.println(mail_address);
            System.out.println(phone);
//            request.setAttribute("no", no);
            request.setAttribute("name", name);
            request.setAttribute("birthdate", birthdate);
            request.setAttribute("address", address);
//            request.setAttribute("sex", sex);
            request.setAttribute("mail_address", mail_address);
            request.setAttribute("phone", phone);

        } catch (Exception e) {
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                dao.close();
            } catch (Exception e) {
            }
        }

        RequestDispatcher rd = request.getRequestDispatcher("MypageChangeJson.jsp");
        rd.forward(request, response);
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

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字化け対策
		request.setCharacterEncoding("utf-8");

//		String mailAddress = request.getParameter("id");
//		String password = request.getParameter("password");

		String mailAddress = "mail";
		String password = "pass";

		String[] memberInfo = {"","","","","","",""};

		String sql = "SELECT no,name,birthdate,address,sex,mail_address,phone FROM members WHERE mail_addredss = '" + mailAddress + "' && password = '" + password + "';";
		Dao dao = null;
		ResultSet rs = null;
		try {
			dao = new Dao();
			rs = dao.execute(sql);
			if (rs.next()) {
				String sex = "男";

				memberInfo[0] = rs.getString("no");
				memberInfo[1] = rs.getString("name");
				memberInfo[2] = rs.getString("birthdate");
				memberInfo[3] = rs.getString("address");
				if (rs.getString("sex").equals("1")) {
					sex = "女";
				}
				memberInfo[4] = sex;
				memberInfo[5] = rs.getString("mail_address");
				memberInfo[6] = rs.getString("phone");
			}

		} catch (Exception e) {
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				dao.close();
			}
			catch(Exception e) {
			}
		}

		request.setAttribute("memberInfo", memberInfo);
		RequestDispatcher rd = request.getRequestDispatcher("LoginJson.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

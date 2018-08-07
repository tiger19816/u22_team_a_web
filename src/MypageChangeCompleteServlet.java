

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;


/**
 * Servlet implementation class MypageChangeCompleteServlet
 */
@WebServlet("/MypageChangeCompleteServlet")
public class MypageChangeCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageChangeCompleteServlet() {
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

		//Androidから値を取得
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		//String no = request.getParameter("no");

 		String sql = "UPDATE members SET ";
		sql += "name = '" + name + "', ";
		sql += "address = '" + address + "', ";
		sql += "sex = '" + sex + "', ";
		sql += "mail_address = '" + mail + "', ";
		sql += "phone = '" + phone + "' ;";
		//sql += "WHERE no = 3;";

		Dao dao = null;
		try {
			dao = new Dao();
			dao.executeUpdate(sql);
			request.setAttribute("result", "true");
		} catch (Exception e) {
		} finally {
			try {
				dao.close();
			} catch (Exception e) {
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher("Test.jsp");
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

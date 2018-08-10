

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.u22Dao;

/**
 * Servlet implementation class DonationServlet
 */
@WebServlet("/DonationServlet")
public class DonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonationServlet() {
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

		String id = request.getParameter("id");
		String donation = request.getParameter("donationMoney");

		String result = "";
		u22Dao dao;

		try {
			dao = new u22Dao();
			dao.setDonation(id,donation);
			System.out.println(result);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("result", result);

		RequestDispatcher rd = request.getRequestDispatcher("resultJson.jsp");
		rd.forward(request, response);

//							//JSONを作成する
//							response.setContentType("application/json; charset=UTF-8");
//							PrintWriter out = response.getWriter();
//							out.print("{");
//							out.println("\"result\":true");
//							out.println("}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

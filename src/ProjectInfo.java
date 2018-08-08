

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.u22Dao;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class ProjectInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

<<<<<<< HEAD:src/ProjectInfo.java
    /**
=======
	/**
>>>>>>> 33cf760aba6b0b5ad891bc9c4d873a5212627781:src/TestServlet.java
     * @see HttpServlet#HttpServlet()
     */
    public ProjectInfo() {
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

		//String id = request.getParameter("id");
		String id = "1";

		String result = "";
		u22Dao dao;

		try {
			dao = new u22Dao();
			result = dao.getProjectInfo(id);
			//System.out.println(result);
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

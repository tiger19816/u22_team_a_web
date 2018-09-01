package hal.u22.works.team.a.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.tools.ProjectInfoDao;
/**
 * Servlet implementation class CleaningsListGetServlet
 */
@WebServlet("/CleaningsListGetServlet")
public class CleaningsListGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CleaningsListGetServlet() {
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
		response.setContentType("text/html;charset=utf-8");

		List<String[]> supplierList;
		List<String[]> projectsList;

		try {
			ProjectInfoDao dao = new ProjectInfoDao();

			supplierList = dao.getSupplierList();
			projectsList = dao.getProjectsList();

			request.setAttribute("supplierList", supplierList);
			request.setAttribute("projectsList", projectsList);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("CleanImageUpload.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

package hal.u22.works.team.a.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.tools.ProjectInfoDao;

/**
 * Servlet implementation class ProjectInfoServlet
 */
@WebServlet("/ProjectInfoServlet")
public class ProjectInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectInfoServlet() {
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

        String no = request.getParameter("no");
        String result = "";

        ProjectInfoDao dao = null;

        try {
            dao = new ProjectInfoDao();
            result = dao.getProjectInfo(no);
            result = dao.getCleaningImage(result, no);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("result", result);
        RequestDispatcher rd = request.getRequestDispatcher("ResultJSON.jsp");
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

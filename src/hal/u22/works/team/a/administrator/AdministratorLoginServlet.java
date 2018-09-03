package hal.u22.works.team.a.administrator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hal.u22.works.team.a.web.tools.DataAccess;

/**
 * Servlet implementation class AdministratorLoginServlet
 */
@WebServlet("/AdministratorLoginServlet")
public class AdministratorLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //--------------文字化け対策-----------------------
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //--------------変数宣言------------------
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");
        String strJspName = "AdministratorLoginIndexServlet";
        String name = "";
        //----------------------------------------
        try {
            DataAccess da = new DataAccess();
            if (da.CheckAdminAccess(id, pass)) {
                strJspName = "AdministratorTopServlet";
                name = da.GetAdminName(id, pass);
                HttpSession session = request.getSession(true);
                session.setAttribute("userName", name);
                System.out.println(session.getAttribute("userName"));

            } else {
                AdministratorLoginError error = new AdministratorLoginError();
                error.SetAll(id, pass);
                request.setAttribute("error", error);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        RequestDispatcher rd = request.getRequestDispatcher(strJspName);
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

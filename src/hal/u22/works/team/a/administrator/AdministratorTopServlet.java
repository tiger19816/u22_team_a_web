package hal.u22.works.team.a.administrator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdministratorTopServlet
 */
@WebServlet("/AdministratorTopServlet")
public class AdministratorTopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorTopServlet() {
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
        String strJspName = "AdministratorTopPage.jsp";

        HttpSession session = request.getSession(false);
        System.out.println(session);
        if (null == session.getAttribute("userName")) {
            AdministratorLoginError error = new AdministratorLoginError();
            error.SetErrorLog("ユーザー名が取得できませんでした。もう一度ログインをためしてください。");
            request.setAttribute("error", error);
            strJspName = "AdministratorLoginIndexServlet";
        } else {

            String name = (String) session.getAttribute("userName");
            request.setAttribute("userName", name);
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

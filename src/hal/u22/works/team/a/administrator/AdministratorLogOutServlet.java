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
 * Servlet implementation class AdministratorLogOutServlet
 */
@WebServlet("/AdministratorLogOutServlet")
public class AdministratorLogOutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorLogOutServlet() {
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

        //------------変数宣言------------------
        String strJspName = "./AdministratorLoginIndexServlet";

        //-----------セッションの取得＆初期化
        HttpSession session = request.getSession(true);
        session.invalidate();

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

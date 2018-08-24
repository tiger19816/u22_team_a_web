package hal.u22.works.team.a.administrator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdministratorLoginIndexServlet
 */
@WebServlet("/AdministratorLoginIndexServlet")
public class AdministratorLoginIndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdministratorLoginIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**x
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//--------------文字化け対策-----------------------
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
    	//--------------変数宣言------------------
    	String strJspName = "./AdministratorLogin.jsp";
    	AdministratorLoginError error;
    	if(null != request.getAttribute("error")) {
			error = (AdministratorLoginError)request.getAttribute("error");
		}else {
			error = new AdministratorLoginError();
		}
    	
		request.setAttribute("error", error);
        RequestDispatcher rd = request.getRequestDispatcher(strJspName);
        rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

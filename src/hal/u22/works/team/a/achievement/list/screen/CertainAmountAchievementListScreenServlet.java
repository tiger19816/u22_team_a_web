package hal.u22.works.team.a.achievement.list.screen;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.tools.DataAccess;
/**
 * Servlet implementation class CertainAmountAchievementListScreenServlet
 */
@WebServlet("/CertainAmountAchievementListScreenServlet")
public class CertainAmountAchievementListScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertainAmountAchievementListScreenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//--------------文字化け対策-----------------------
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
    	//--------------変数宣言------------------
		String flagNum ="";
		if(null !=  request.getParameter("flagNum")) {
			flagNum = request.getParameter("flagNum");
		}else {
			flagNum = (String)request.getAttribute("flagNum");
		}
    	ArrayList<AchievementListScreenInfo> arrayAchive=	new ArrayList<AchievementListScreenInfo>(); 
		String strJspName = "TargetAmountAchievementListScreen.jsp"; 
    			
		//--------------処理--------------------------
		try {
			
			//DAOのコンストラクト呼び出し
			DataAccess da = new DataAccess();
			//array＊クラスの値を格納
			arrayAchive = da.getPostsAllTable(flagNum);
			
			if("1".equals(flagNum)) {
				strJspName ="certainAmountAchievementScreen.jsp" ;
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		request.setAttribute("arrayAchive", arrayAchive);
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

package hal.u22.works.team.a.achievement.list.screen;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DataAccess;

/**
 * Servlet implementation class CertainAmountAchievementDetailScreenInsertServlet
 */
@WebServlet("/CertainAmountAchievementDetailScreenInsertServlet")
public class CertainAmountAchievementDetailScreenInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertainAmountAchievementDetailScreenInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//--------------文字化け対策-----------------------
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
    	//--------------変数宣言------------------
    	String no = request.getParameter("no");
		String flagNum = request.getParameter("flagNum");
		String money ="";
		String strJspName = ""; 
    			
		//--------------処理--------------------------
		try {
			
			//DAOのコンストラクト呼び出し
			DataAccess da = new DataAccess();
			//ラスの値を格納
			if("2".equals(flagNum)) {
				flagNum = "3";
				money = request.getParameter("money");
				da.UpdateCleuningFlag(no ,flagNum, money);
				strJspName = "";
			}else {
				flagNum = "4";
				da.UpdateCleuningFlag(no, flagNum);
				strJspName = "";
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		
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

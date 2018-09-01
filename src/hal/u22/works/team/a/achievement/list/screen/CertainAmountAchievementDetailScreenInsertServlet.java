package hal.u22.works.team.a.achievement.list.screen;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.tools.DataAccess;

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
		
		//--------------文字化け対策-----------------------
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");
    	
    	//--------------変数宣言------------------
    	String no = request.getParameter("no");
		String flagNum = request.getParameter("flagNum");
		String money ="";
		String strJspName = "./AdministratorTopServlet";
    	
		//--------------処理--------------------------
		try {
			strJspName ="./CertainAmountAchievementListScreenServlet";
			//DAOのコンストラクト呼び出し
			DataAccess da = new DataAccess();
			//ラスの値を格納
			if("1".equals(flagNum)) {
				flagNum = "2";
				money = request.getParameter("money");
				String allMone = request.getParameter("allMoney");
				if(Integer.parseInt(money) <= Integer.parseInt(allMone) ) {
					flagNum = "4";
					da.UpdateCleuningFlag(no, flagNum);
				}else {
					da.UpdateCleuningFlag(no ,flagNum, money);
				}
				request.setAttribute("flagNum", "1");
			}else {
				flagNum = "4";
				da.UpdateCleuningFlag(no, flagNum);
				request.setAttribute("flagNum", "3");
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

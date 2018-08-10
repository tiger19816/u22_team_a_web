

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DataAccess;
import hal.u22.works.team.a.NewProjectPostsConfirmationScreenActivityInfo.NewProjectPostsConfirmationScreenActivityInfo;

/**
 * Servlet implementation class NewProjectPostsConfirmationScreenActivityServlet
 */
@WebServlet("/NewProjectPostsConfirmationScreenActivityServlet")
public class NewProjectPostsConfirmationScreenActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewProjectPostsConfirmationScreenActivityServlet() {
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
		//クラス宣言
		NewProjectPostsConfirmationScreenActivityInfo info = new NewProjectPostsConfirmationScreenActivityInfo();
		//クラスにAndroidの値を格納1
		System.out.println("from Android!!");
		System.out.println(request.getParameter("title"));
		
		info.setTitle(request.getParameter("title"));
		info.setPhoto(request.getParameter("imgName"));
		info.setPlace(request.getParameter("place"));
		info.setCategoryNo(request.getParameter("category"));
		info.setContent(request.getParameter("content"));
		info.setPostMoney(request.getParameter("InvestmentAmount"));
		//Byte[] ImgFile = request.getParameter("ImfFile");
		
		DataAccess da;
		
		try {
			da = new DataAccess();
			da.InsertTest(info);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

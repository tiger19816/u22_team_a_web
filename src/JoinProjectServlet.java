

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DataAccess;
import entities.Posts;

/**
 * Servlet implementation class JoinProjectServlet
 */
@WebServlet("/JoinProjectServlet")
public class JoinProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//会員NO取得
		String memberNo = "";
		int judge = Integer.parseInt(request.getParameter("flag"));
		System.out.println(memberNo);
		memberNo = "3";
		//投稿情報を格納する配列
		ArrayList<Posts> posts = new ArrayList<Posts>();
		//DBに接続
		DataAccess da = null;
		try {
			da = new DataAccess();
			//投稿情報抽出
			if(judge == 1) {
				posts = da.MyPostSelect(Integer.parseInt(memberNo));
			}else {
				posts = da.MyAssistSelect(Integer.parseInt(memberNo));
			}
			da.close();
		}
		catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		request.setAttribute("LIST", posts);
		RequestDispatcher rd = request.getRequestDispatcher("myposts_list_json.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

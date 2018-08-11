

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Dao;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//文字化け対策
		request.setCharacterEncoding("utf-8");


		String userMail = request.getParameter("id");
		String userPassword = request.getParameter("password");
		int count = 0;
		int userId = 0;

		//ユーザー情報が登録されているかを検索するSQL
		String sql = "select no,count(*) from members ";
		sql += "where mail_address = '" + userMail + "' AND password = '" + userPassword + "';";
		System.out.println(sql);

		//DBに接続
		Dao dao = null;
		ResultSet rs = null;
		try {
			dao = new Dao();
			rs = dao.execute(sql);

			while(rs.next()){
				count = rs.getInt("count(*)");
				userId = rs.getInt("no");
			}
			System.out.println(count);
			if(count != 0){
				request.setAttribute("result","true");
		//		request.setAttribute("userId", userId);		//ユーザーID使わなければ削除
			}else{
				request.setAttribute("result","false");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if (rs != null) {
					rs.close();
				}
					dao.close();
				}
				catch(Exception e) {
				}
			}

		RequestDispatcher rd = request.getRequestDispatcher("UserLoginJson.jsp");
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

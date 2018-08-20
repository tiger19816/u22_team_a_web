
import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.Contact;
import DAO.Sql;

/**
 * Servlet implementation class ContactGetServlet
 */
@WebServlet("/ContactGetServlet")
public class ContactGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactGetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//お問い合わせの内容と名前を受け取る

		String noStr = request.getParameter("no");
		String contentStr = request.getParameter("content");

		//今日の日付の取得
		Calendar cal = Calendar.getInstance();
		int yearInt = cal.get(Calendar.YEAR);
		int monthInt = cal.get(Calendar.MONTH);
		int dateInt = cal.get(Calendar.DATE);

		String yearStr = String.valueOf(yearInt);
		String monthStr = String.valueOf(monthInt);
		String dateStr = String.valueOf(dateInt);

		String date = yearStr + "-" + monthStr + "-" + dateStr;
		System.out.println(date);

		//値をContactクラスに入れる
		Contact c = new Contact();
		int member_no = Integer.parseInt(noStr);

		c.setMember_no(member_no);
		c.setContent(contentStr);
		c.setDate(date);

		//true,falseの格納用
		Boolean dbSuccess = false;

		//DBに入力
		Sql s = null;

		try {
			s = new Sql();
			s.insertContentNew(c);
			dbSuccess = true;
		} catch (Exception e) {

			System.out.println("Exception e");

		} finally {
			try {
				s.close();
			} catch (Exception e) {
				System.out.println("Exception e  2");
			}

		}

		//アンドロイド側に実行結果を返す
		//********************************************
		

		//*******************************************
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

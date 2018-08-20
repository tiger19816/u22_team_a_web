
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.tools.Contact;
import hal.u22.works.team.a.tools.Sql;

/**
 * Servlet implementation class ContactGetServlet
 */
@WebServlet("/ContactGetServlet")
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ContactServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		//お問い合わせの内容と名前を受け取る



		//仮の値*******************************************
		int member_no = 12345;
		String content = "内容";
		String date = "2018-07-24"; //今の日付
		//****************************************************

		//値をContactクラスに入れる
		Contact c = new Contact();
		c.setMember_no(member_no);
		c.setContent(content);
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


		//JSPファイルにDB登録成功の結果を渡す
		//****************************************:

		request.setAttribute("result", "true");


	RequestDispatcher rd = request.getRequestDispatcher("loginJson.jsp");
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

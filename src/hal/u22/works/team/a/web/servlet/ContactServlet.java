package hal.u22.works.team.a.web.servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.tools.Contact;
import hal.u22.works.team.a.web.tools.Sql;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/ContactServlet")
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        //お問い合わせの内容と名前を受け取る

        System.out.println("サーバー");

        //仮の値*******************************************
        int member_no = 12345;
        //String content = "内容";
        //String date = "2018-08-24"; //今の日付
        //****************************************************

        String content = (String) request.getParameter("content");

        System.out.println(content);

        //今日の日付の取得
        Calendar cal = Calendar.getInstance();
        int yearInt = cal.get(Calendar.YEAR);
        int monthInt = cal.get(Calendar.MONTH) + 1;
        int dateInt = cal.get(Calendar.DATE);

        String yearStr = String.valueOf(yearInt);
        String monthStr = String.valueOf(monthInt);
        String dateStr = String.valueOf(dateInt);

        String date = yearStr + "-" + monthStr + "-" + dateStr;
        System.out.println(date);

        //値をContactクラスに入れる
        Contact c = new Contact();

        c.setMember_no(member_no);
        c.setContent(content);
        c.setDate(date);

        System.out.println(c.getContent());
        System.out.println(c.getDate());

        //true,falseの格納用
        Boolean dbSuccess = false;

        //DBに入力
        Sql s = null;

        try {

            s = new Sql();
            System.out.println("sql");

            s.insertContentNew(c);
            dbSuccess = true;
        } catch (Exception e) {

            System.out.println("Exception e");

        } finally {
            try {
                if (s != null) {
                    s.close();
                }
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

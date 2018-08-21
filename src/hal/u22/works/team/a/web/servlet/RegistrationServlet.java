package hal.u22.works.team.a.web.servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.tools.Dao;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("utf-8");

		//*** ユーザー情報の取得(android:NewRegistration.java)
		String userName = request.getParameter("name");		//ユーザー名
		String userBirthdate = request.getParameter("birthday");	//生年月日
		String userAddress = request.getParameter("address");	//住所
		String userPhone = request.getParameter("phoneNumber");	//電話番号
		String userSex = request.getParameter("sex");	//性別
		String userCredit = request.getParameter("creditNumber");	//クレジットカード番号
		String userCreditSecurityCode = request.getParameter("creditSecurityCode");		//クレジットカードセキュリティコード
		String userCreditExpirationDate = request.getParameter("creditExpirationDate");		//クレジットカード有効期限
		String userMail = request.getParameter("mail");		//メールアドレス
		String userPassword = request.getParameter("password");		//パスワード

		int userCreditNo = 0;
		int count = 0;
		int securityCode = Integer.parseInt(userCreditSecurityCode);

		System.out.println("ユーザー名 = "+ userName);
		System.out.println("生年月日 = "+userBirthdate);
		System.out.println("住所 = "+userAddress);
		System.out.println("電話番号 = "+userPhone);
		System.out.println("性別 = "+userSex);
		System.out.println("クレジットカード番号 = "+userCredit);
		System.out.println("セキュリティコード = "+securityCode);
		System.out.println("有効期限 = "+userCreditExpirationDate);
		System.out.println("メールアドレス = "+userMail);
		System.out.println("パスワード  = "+userPassword);



		//ユーザー情報の有無を取得SQL
		String user_retrieval_sql = "select count(*) from members where mail_address = '" + userMail + "' AND password = '" + userPassword + "';";

		//ユーザークレジットカード登録SQL
		String user_credit_card_sql ="INSERT INTO cards (no, number, security_code, expiration_date) ";
		user_credit_card_sql += "VALUES (NULL, '"+ userCredit +"', '"+ securityCode +"', '"+ userCreditExpirationDate +"');";

		//ユーザークレジットカードno取得SQL
		String user_credit_no_sql = "select no from cards where number = '"+ userCredit +"' and security_code = "+ securityCode +"";


		//DB接続
		Dao  dao = null;
		ResultSet rs = null;
		try {
			dao = new Dao();
			rs = dao.execute(user_retrieval_sql);
			while(rs.next()){
				count = rs.getInt("count(*)");
			}

			System.out.println("ユーザー情報が既にあるかどうか = " + count );
			if(count == 0){		//ユーザー登録が新規の場合
				dao.executeUpdate(user_credit_card_sql);	//クレジットカード登録
				System.out.println("↑クレジットカード登録完了");

				rs = dao.execute(user_credit_no_sql);	//登録されたクレジットNOを検索
				System.out.println("登録されたクレジットNO検索 = "+user_credit_no_sql);
				while(rs.next()) {
					userCreditNo = rs.getInt("no");	//登録されたクレジットNOを取得
				}
				//ユーザー登録SQL
				String user_information_sql = "INSERT INTO members (";
				user_information_sql += "no, mail_address, name, sex, address, birthdate, password, phone, card_no) ";
				user_information_sql += "VALUES (";
				user_information_sql += "null,'"+ userMail +"','"+ userName +"',"+ userSex +",'"+ userAddress +"',";
				user_information_sql += "'"+ userBirthdate +"','"+ userPassword +"','"+ userPhone +"',"+ userCreditNo +");";

				dao.executeUpdate(user_information_sql);	//ユーザー情報登録
				System.out.println("ユーザー登録完了");

				request.setAttribute("result", "true");
			}else{
				System.out.println("既に登録されてました");
				request.setAttribute("result", "false");
			}

		} catch (Exception e) {
		} finally {
			if(dao != null) {
				try {
					dao.close();
				} catch (Exception e) {
			}
		}
		}
		RequestDispatcher rd = request.getRequestDispatcher("RegistrationJson.jsp");
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

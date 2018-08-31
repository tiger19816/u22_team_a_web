package hal.u22.works.team.a.administrator;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.entities.Page;
import hal.u22.works.team.a.web.tools.DataAccess;

/**
 * Servlet implementation class AdminstratorInquiryServlet
 */
@WebServlet("/AdminstratorInquiryServlet")
public class AdminstratorInquiryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminstratorInquiryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		//--------------文字化け対策-----------------------
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");

		//変数宣言
		int max = 0;

		String flagNum ="";
		if(null != request.getParameter("flagNum")) {
			flagNum = request.getParameter("flagNum");
		}else {
			flagNum = (String)request.getAttribute("flagNum");
		}
    	ArrayList<AdminstratorInquiryInfo> arrayInquiry = new ArrayList<AdminstratorInquiryInfo>();
    	String strJspName = "AdminstratorInquiryDetails.jsp";
    	Page p = new Page();

		try {
			//DAOのコンストラクタ呼び出し
			DataAccess da = new DataAccess();
			max = da.Max();
			p.setPageNum(max);
			String page = (String)request.getParameter("id");
			if(page == null) {
				page = "1";
			}
			p.setNowPage(page);
			//array*クラスの値を格納
			arrayInquiry = da.getInquiryAllTable(p.getFirstRecode());

			if("1".equals(flagNum)) {
				strJspName ="AdminstratorInquiry.jsp" ;
			}
			else if("10".equals(flagNum)) {
				AdminstratorInquiryInfo inquiry = new AdminstratorInquiryInfo();
				String no = request.getParameter("no");
				inquiry = da.getInquiryTable(no);
				request.setAttribute("inquiry", inquiry);
			}
		} catch (Exception e) {

	}


		request.setAttribute("PAGE",p);
		request.setAttribute("arrayInquiry",arrayInquiry);
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

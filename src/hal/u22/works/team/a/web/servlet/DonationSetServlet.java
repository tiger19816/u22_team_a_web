package hal.u22.works.team.a.web.servlet;

import src.hal.u22.works.team.a.web.tools.ProjectInfoDao;

/**
 * Servlet implementation class DonationSetServlet
 */
@WebServlet("/DonationSetServlet")
public class DonationSetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonationSetServlet() {
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

		String projectNo = request.getParameter("projectNo");
		String memberNo = request.getParameter("memberNo");
		String donation = request.getParameter("donationMoney");
		ProjectInfoDao dao = null;

		try {
			dao = new ProjectInfoDao();
			dao.setDonation(projectNo, memberNo, donation);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("ResultJSON.jsp");
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

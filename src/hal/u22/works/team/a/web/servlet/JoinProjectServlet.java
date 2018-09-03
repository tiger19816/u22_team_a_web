package hal.u22.works.team.a.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.entities.Posts;
import hal.u22.works.team.a.web.tools.DataAccess;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //文字化け対策
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //会員NO取得
        int judge = Integer.parseInt(request.getParameter("flag"));
        int memberNo = Integer.parseInt(request.getParameter("id"));
        String strJsp = "myposts_list_json.jsp";
        //投稿情報を格納する配列
        ArrayList<Posts> posts = new ArrayList<Posts>();
        //DBに接続
        DataAccess da = null;
        try {
            da = new DataAccess();
            //投稿情報抽出
            if (judge == 1) {
                posts = da.MyPostSelect(memberNo);
            } else {
                posts = da.MyAssistSelect(memberNo);
                strJsp = "myassists_list_json.jsp";
            }
            da.close();
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (Exception e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        request.setAttribute("LIST", posts);
        RequestDispatcher rd = request.getRequestDispatcher(strJsp);
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

package hal.u22.works.team.a.web.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.newProject.ImageSave;
import hal.u22.works.team.a.web.tools.ProjectInfoDao;

/**
 * Servlet implementation class CleanImageUploadServlet
 */
@WebServlet("/CleanImageUploadServlet")
@MultipartConfig(location = "", maxFileSize = 1024 * 1024 * 10) //partを使用する際に書く。maxFileSizeは1024×1024×10で10MB。
public class CleanImageUploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CleanImageUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //画像を保存するtempフォルダのパスを取得
        String tempPath = getServletContext().getRealPath("cleanImage");
        String tempSmallPath = tempPath + "\\small";
        Path path = Paths.get(tempPath);
        Path smallPath = Paths.get(tempSmallPath);

        //tempフォルダが存在しない場合は作成する
        if (!Files.exists(path)) {
            Files.createDirectory(path);
        }
        if (!Files.exists(smallPath)) {
            Files.createDirectory(smallPath);
        }

        //画像を保存する
        try {
            System.out.println(request.getPart("fileName"));
            ImageSave is = new ImageSave();
            ProjectInfoDao dao = new ProjectInfoDao();
            is.imageTempSave(request.getPart("fileName"), tempPath);
            dao.updateData(request.getParameter("supplierNo"), request.getParameter("projectNo"), is.getFileName());
            request.setAttribute("imgPath", "./temp/" + is.getFileName());
        } catch (ClassNotFoundException | SQLException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        RequestDispatcher rd = request.getRequestDispatcher("CleanImageUploadResult.jsp");
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

package hal.u22.works.team.a.web.servlet;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.u22.works.team.a.web.newProject.ImageSave;
import hal.u22.works.team.a.web.newProject.NewProjectPostsConfirmationScreenActivityInfo;
import hal.u22.works.team.a.web.tools.DataAccess;

/**
 * Servlet implementation class NewProjectPostsConfirmationScreenActivityServlet
 */
@WebServlet("/NewProjectPostsConfirmationScreenActivityServlet")
@MultipartConfig(location = "", maxFileSize = 1024 * 1024 * 10) //partを使用する際に書く。maxFileSizeは1024×1024×10で10MB。
public class NewProjectPostsConfirmationScreenActivityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewProjectPostsConfirmationScreenActivityServlet() {
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
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //変数宣言
        int money = 3000;			//目標金額の指定
        //クラス宣言
        NewProjectPostsConfirmationScreenActivityInfo info = new NewProjectPostsConfirmationScreenActivityInfo();
        //クラスにAndroidの値を格納1
        System.out.println("from Android!!");

        info.setTitle(request.getParameter("title"));
        info.setPhoto(request.getParameter("imgName"));
        info.setPlace(request.getParameter("place"));
        info.setCategoryNo(request.getParameter("category"));
        info.setContent(request.getParameter("content"));
        info.setPostMoney(request.getParameter("InvestmentAmount"));
        info.setMemberNo(request.getParameter("userId"));
        info.setLatitude(request.getParameter("latitude"));
        info.setLongitude(request.getParameter("longitude"));

        //画像を保存するtempフォルダのパスを取得
        String tempPath = getServletContext().getRealPath("temp");
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

        if (request.getPart("filename") != null) {
            ImageSave is = new ImageSave();
            is.imageTempSave(request.getPart("filename"), tempPath);
            info.setPhoto(is.getFileName());
        }

        //データベース接続
        DataAccess da = null;
        //データベースへの登録
        try {
            da = new DataAccess();
            da.InsertPosts(info, money);
            da.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    /**
    * イメージ→バイト列に変換
    * @param img イメージデータ
    * @param format フォーマット名
    * @return バイト列
    */
    public static byte[] getBytesFromImage(BufferedImage img, String format) throws IOException {

        if (format == null) {
            format = "png";
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(img, format, baos);
        return baos.toByteArray();
    }

    /**

    * バイト列→イメージを作成
    * @param bytes
    * @return イメージデータ
    */
    public static BufferedImage getImageFromBytes(byte[] bytes) throws IOException {
        ByteArrayInputStream baos = new ByteArrayInputStream(bytes);
        BufferedImage img = ImageIO.read(baos);
        return img;
    }

    private Object File(String tempPath) {
        // TODO Auto-generated method stub
        return null;
    }

}

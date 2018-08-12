

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.File;

import DAO.DataAccess;
import hal.u22.works.team.a.NewProjectPostsConfirmationScreenActivityInfo.NewProjectPostsConfirmationScreenActivityInfo;
import hal.u22.works.team.a.NewProjectPostsConfirmationScreenActivityInfo.ImageSave;

/**
 * Servlet implementation class NewProjectPostsConfirmationScreenActivityServlet
 */
@WebServlet("/NewProjectPostsConfirmationScreenActivityServlet")
@MultipartConfig(location = "", maxFileSize = 1024 * 1024 * 10)	//partを使用する際に書く。maxFileSizeは1024×1024×10で10MB。

public class NewProjectPostsConfirmationScreenActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	* イメージ→バイト列に変換
	* @param img イメージデータ
	* @param format フォーマット名
	* @return バイト列
	*/
	public static byte[] getBytesFromImage(BufferedImage img, String format) throws IOException{

	if(format == null) {
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
	public static BufferedImage getImageFromBytes(byte[] bytes) throws IOException{
	ByteArrayInputStream baos = new ByteArrayInputStream(bytes);
	BufferedImage img = ImageIO.read(baos);
	return img;
	}
	
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//文字化け対策
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//クラス宣言
		NewProjectPostsConfirmationScreenActivityInfo info = new NewProjectPostsConfirmationScreenActivityInfo();
		//クラスにAndroidの値を格納1
		System.out.println("from Android!!");
		System.out.println(request.getParameter("title"));
		
		info.setTitle(request.getParameter("title"));
		info.setPhoto(request.getParameter("imgName"));
		info.setPlace(request.getParameter("place"));
		info.setCategoryNo(request.getParameter("category"));
		info.setContent(request.getParameter("content"));
		info.setPostMoney(request.getParameter("InvestmentAmount"));
////		//画像のbyte[]取得と変換
//		String ImgFile = request.getParameter("ImgFile");
//		byte[] byteImg  = ImgFile.getBytes(StandardCharsets.UTF_8);
//		BufferedImage img = getImageFromBytes(byteImg);


		//画像を保存するtempフォルダのパスを取得
		String tempPath = getServletContext().getRealPath("temp");
		String tempSmallPath = tempPath + "\\small";
		Path path = Paths.get(tempPath);
		Path smallPath = Paths.get(tempSmallPath);	

		System.out.println("フォルダー作成");
		//tempフォルダが存在しない場合は作成する
		if(!Files.exists(path)) {
			Files.createDirectory(path);
		}
		if(!Files.exists(smallPath)) {
			Files.createDirectory(smallPath);
		}
		
		System.out.println("画像保存");
		//画像を保存する
		
		if(request.getPart("filename")!= null ) {
			System.out.println("in the ImageSave");
//パターン１
//		    try{
//		    	
//		        OutputStream out=new FileOutputStream(tempPath);//ファイルとアプリを繋ぐ
//		        ImageIO.write(img, "Test.jpg", out);//指定の形式で出力
//		      }catch(IOException e){
//		        //例外処理が発生したらエラーをコンソールに出して、falseを返す
//		        System.out.println("Err="+e);//エラー出力
//		      }
			
//パターン２	
			
			ImageSave is = new ImageSave();
			is.imageTempSave(request.getPart("filename"), tempPath);
			
		}else {
			
			System.out.println("failure of the ImageSave");
		}
		
		
		DataAccess da = null;
		
		try {
			da = new DataAccess();
			da.InsertTest(info);
			da.close();
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}

	private Object File(String tempPath) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

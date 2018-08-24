package hal.u22.works.team.a.web.newProject;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileUploadBase.FileSizeLimitExceededException;

@MultipartConfig(location = "", maxFileSize = 1024 * 1024 * 10) //partを使用する際に書く。maxFileSizeは1024×1024×10で10MB。
public class ImageSave {

    private String fileName;

    public ImageSave() {
        this.fileName = "";
    }

    public void imageTempSave(Part part, String path) {

        //画像を保存してファイル名を取得
        try {
            String strFileName = this.photoSave(part, path);
            this.fileName = strFileName;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("画像の保存に失敗。サイズは10MB以内。");
            return;
        }
    }

    private String photoSave(Part part, String path)
            throws ServletException, IOException, FileSizeLimitExceededException {

        // HTTPヘッダの値を取得
        String contentDisposition = part.getHeader("content-disposition");
        String contentType = part.getHeader("content-type");

        /* アップロードしたファイル名の取得 */
        // 変数contentDispositionから"filename="以降を抜き出す
        int filenamePosition = contentDisposition.indexOf("filename=");
        String filename = contentDisposition.substring(filenamePosition);

        // "filename="と"を除く
        filename = filename.replace("filename=", "");
        filename = filename.replace("\"", "");

        // 絶対パスからファイル名のみ取り出す
        filename = new java.io.File(filename).getName();

        //ファイルの拡張子を取得
        String fileType = "";
        int point = filename.lastIndexOf(".");
        if (point != -1) {
            fileType = filename.substring(point + 1);
        }

//		boolean isJpegFile = false;
        // JPEG形式のチェック
        if ((contentType.equals("image/jpeg")) || (contentType.equals("image/pjpeg"))
                || (contentType.equals("image/png"))) {
            //現在日付の取得
            Date date = new Date();
            SimpleDateFormat fDate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String strDate = fDate.format(date);

            //画像名を"ユーザー名_現在日時.拡張子に変更"
            filename = /*userId + "_" +*/ strDate + "." + fileType;

            // 画像ファイルをpath+filenameとして保存
            part.write(path + "\\" + filename);
            //			isJpegFile = true;

            // サムネイル画像の作成
            createThumbnail(path + "\\" + filename, path + "\\small\\" + filename, fileType, 512);
        }
        return filename;
    }

    private void createThumbnail(String originFile, String thumbFile, String fileType, int width) {
        try {
        	// 元画像の読み込み
            BufferedImage image = ImageIO.read(new File(originFile));

            // 元画像の情報を取得
            int originWidth = image.getWidth();
            int originHeight = image.getHeight();
            int type = image.getType();

            // 縮小画像の高さを計算
            int height = originHeight * width / originWidth;
            if (height > 512) {
                height = 512;
                width = originWidth * height / originHeight;
            }

            // 縮小画像の作成
            BufferedImage smallImage = new BufferedImage(width, height, type);
            Graphics2D g2 = smallImage.createGraphics();

            // 描画アルゴリズムの設定(品質優先、アンチエイリアスON)
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_DEFAULT);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 元画像の縮小&保存
            g2.drawImage(image, 0, 0, width, height, null);
            ImageIO.write(smallImage, fileType, new File(thumbFile));
        } catch (Exception e) {
            //log("画像の縮小に失敗: " + e);
            System.out.println("画像の縮小に失敗");
        }
    }

    public String getFileName() {
        return this.fileName;
    }
}
package hal.u22.works.team.a.NewProjectPostsConfirmationScreenActivityInfo;

public class NewProjectPostsConfirmationScreenActivityInfo {
	private String no;		//プロジェクト番号
	private String memberNo;	//会員番号
	private String categoryNo;	//カテゴリー番号
	private String postDate;	//プロジェクト投稿日
	private String postMoney;	//プロジェクト初期投資
	private String place;		//場所
	private String latitude;	//緯度
	private String longitude;	//経度
	private String title;		//タイトル
	private String content;		//内容
	private String photo;		//写真の名前
	private String targetMoney;	//集計金額
	private String cleaningFlag;//掃除フラグ

	//----------コンストラクト
	public NewProjectPostsConfirmationScreenActivityInfo(){
		no = "";
		memberNo = "";
		categoryNo = "";
		postDate = "";
		postMoney = "";
		place = "";
		latitude = "";
		longitude = "";
		title = "";
		content = "";
		photo = "";
		targetMoney = "";
		cleaningFlag = "";
	}
	
	//---------Set
	public void setNo(String val) {
		no = val;
	}
	
	public void setMemberNo(String val) {
		memberNo = val;
	}
	
	public void setCategoryNo(String val) {
		categoryNo = val;
	}
	
	public void setPostDate(String val) {
		postDate = val;
	}
	
	public void setPostMoney(String val) {
		postMoney = val;
	}
	
	public void setPlace(String val) {
		place = val;
	}
	
	public void setLatitude(String val) {
		latitude = val;
	}
	
	public void setLongitude(String val) {
		longitude = val;
	}
	
	public void setTitle(String val) {
		title = val;
	}
	
	public void setContent(String val) {
		content = val;
	}
	
	public void setPhoto(String val) {
		photo = val;
	}
	
	public void setTargetMoney(String val) {
		targetMoney = val;
	}
	
	public void setCleaningFlag(String val) {
		cleaningFlag = val;
	}
	
	//---------------get
	
	public String getNo() {
		return no;
	}
	
	public String getMemberNo() {
		return memberNo;
	}

	public String getCategoryNo() {
		return categoryNo;
	}
	
	public String getPostDate() {
		return postDate;
	}
	
	public String getPostMoney() {
		return postMoney;
	}
	
	public String getPlace() {
		return place;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public String getTargetMoney() {
		return targetMoney;
	}
	
	public String getCleaningFlag() {
		return cleaningFlag;
	}
	
	
}

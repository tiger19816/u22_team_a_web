package entities;

public class Posts {
	/**
	 * フィールド
	 */
	private int _no;
	private String _title;
	private String _photo;
	private String _status;
	public Posts(){
		this._no = 0;
		this._title = "";
		this._photo = "";
		this._status = "";
	}

	/**
	 * 投稿Noのセッター
	 * @param no
	 */
	public void setNo(int no) {
		this._no = no;
	}
	/**
	 * 投稿タイトルのセッター
	 * @param title
	 */
	public void setTitle(String title) {
		this._title = title;
	}
	/**
	 * 投稿写真のセッター
	 * @param photo
	 */
	public void setPhoto(String photo) {
		this._photo = photo;
	}
	/**
	 * 投稿状態のセッター
	 * @param flag
	 */
	public void setStatus(int flag) {
		if(flag == 0) {
			this._status = "集金中（金額未設定）";
		}else if(flag == 1) {
			this._status = "集金中（金額設定完了）";
		}else if(flag == 2) {
			this._status = "依頼中";
		}else if(flag == 3) {
			this._status = "完了";
		}else if(flag == 4) {
			this._status = "再検討";
		}
	}

	/**
	 * 投稿Noのゲッター
	 * @return noのゲッター
	 */
	public int getNo() {
		return this._no;
	}
	/**
	 * 投稿タイトルのゲッター
	 * @return titleのゲッター
	 */
	public String getTitle() {
		return this._title;
	}
	/**
	 * 投稿写真のゲッター
	 * @return photoのゲッター
	 */
	public String getPhoto() {
		return this._photo;
	}
	/**
	 * 投稿状態のゲッター
	 * @return statusのゲッター
	 */
	public String getStatus() {
		return this._status;
	}
}

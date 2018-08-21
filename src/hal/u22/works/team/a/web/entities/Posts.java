package hal.u22.works.team.a.web.entities;

public class Posts {
	/**
	 * フィールド
	 */
	private int _no;
	private String _title;
	private String _photo;
	private int _money;
	private String _date;
	private String _status;
	public Posts(){
		this._no = 0;
		this._title = "";
		this._photo = "";
		this._money = 0;
		this._date = "";
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
	 * 投稿金額のセッター
	 * @param money
	 */
	public void setMoney(int money) {
		this._money = money;
	}
	/**
	 * 日付のセッター
	 * @param date
	 */
	public void setDate(String date) {
		this._date = date;
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
	 * 投稿金額のゲッター
	 * @return moneyのゲッター
	 */
	public int getMoney() {
		return this._money;
	}
	/**
	 * 投稿日付のゲッター
	 * @return dateのゲッター
	 */
	public String getDate() {
		return this._date;
	}
	/**
	 * 投稿状態のゲッター
	 * @return statusのゲッター
	 */
	public String getStatus() {
		return this._status;
	}
}
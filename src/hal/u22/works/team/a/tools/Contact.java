package hal.u22.works.team.a.tools;

/**
 * お問い合わせ内容テーブルの中身を入れるクラス
 * @author ayaka
 *
 */

public class Contact {
	/**
	 * お問い合わせした人のID
	 */
	public int member_no;
	/**
	 * お問い合わせの内容
	 */
	public String content;
	/**
	 * お問い合わせの日付
	 */
	public String date;

	/**
	 * 初期値の設定
	 */
	public Contact() {
		this.member_no = 0;
		this.content = "";
		this.date = "";
	}

	/**
	 * IDの取得（ゲッター）
	 * @return
	 */
	public int getMember_no() {
		return member_no;
	}

	/**
	 * IDの設定（セッター）
	 * @param member_no
	 */
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	/**
	 * お問い合わせ内容の取得（ゲッター）
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * お問い合わせ内容の設定（セッター）
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 日付の取得（ゲッター）
	 * @return
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 日付の設定（セッター)
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}



}

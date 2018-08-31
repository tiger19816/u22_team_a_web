package hal.u22.works.team.a.administrator;

public class AdminstratorInquiryInfo {
	private String sequence; //問い合わせ番号
	private String memberNo; //会員番号
	private String memberName; //会員名
	private String mailAddress; //メールアドレス
	private String content; //問い合わせ内容
	private String sendDate; //問い合わせ日付

	//コンストラクタ
	public AdminstratorInquiryInfo() {
		sequence = "";
		memberNo = "";
		memberName = "";
		mailAddress = "";
		content = "";
		sendDate = "";
	}

	//setter
	public void setSequence(String val) {
		sequence = val;
	}

	public void setMemberNo(String val) {
		memberNo = val;
	}

	public void setMemberName(String val) {
		memberName = val;
	}

	public void setMailAddress(String val) {
		mailAddress = val;
	}

	public void setContent(String val) {
		content = val;
	}

	public void setSendData(String val) {
		sendDate = val;
	}

	//getter
	public String getSequence() {
		return sequence;
	}

	public String getMemberNo() {
		return memberNo;
	}

	public String getMemberName() {
		return memberName;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public String getContent() {
		return content;
	}

	public String getSendDate() {
		return sendDate;
	}
}

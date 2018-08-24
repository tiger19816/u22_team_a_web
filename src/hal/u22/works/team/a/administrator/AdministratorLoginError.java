package hal.u22.works.team.a.administrator;

public class AdministratorLoginError {
	private String errorLog;
	private String id;
	private String pass;
	
	public AdministratorLoginError() {
		errorLog = "";
		id = "";
		pass = "";
	}
	
	public void SetId(String id) {
		this.id = id;
	}
	
	public void SetPass(String pass) {
		this.pass = pass;
	}
	
	public void SetErrorLog() {
		this.errorLog = "IDもしくはパスワードが正しく入力されていません。";
	}
	
	public void SetErrorLog(String val) {
		this.errorLog = val;
	}
	
	public void SetAll(String id, String pass) {
		this.SetId(id);
		this.SetPass(pass);
		this.SetErrorLog();
	}
	
	public String GetId() {
		return id;
	}
	
	public String GetErrorLog() {
		return errorLog;
	}
}
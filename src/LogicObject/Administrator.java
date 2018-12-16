package LogicObject;

public class Administrator {
	private String adminid;
	private String name;
	private String password;
	
	Administrator(String adminid,String name,String password){
		this.adminid=adminid;
		this.name=name;
		this.password=password;
		
		
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

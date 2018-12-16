package LogicObject;

public class Librarian {
	private String librarianid;
	private String name;
	private String password;
	
	Librarian(String lid,String nm,String pwd){
		this.librarianid=lid;
		this.name=nm;
		this.password=pwd;
	}

	public String getLibrarianid() {
		return librarianid;
	}

	public void setLibrarianid(String librarianid) {
		this.librarianid = librarianid;
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

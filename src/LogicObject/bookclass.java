package LogicObject;

public class bookclass {
	private String bookclassid;		//书类号
	private String classname;		//书类名
	
	bookclass(String bcid,String cn)
	{
		this.bookclassid=bcid;
		this.classname=cn;
	}
	
	public String getBookclassid() {
		return bookclassid;
	}
	public void setBookclassid(String bookclassid) {
		this.bookclassid = bookclassid;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	
	public String Info() {
		String Info="书类信息：\n"+
					"书类号："+bookclassid+"\n"+
					"书类名："+classname+"\n";
		return Info;
	}
}

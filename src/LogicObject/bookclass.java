package LogicObject;

public class bookclass {
	private String bookclassid;		//�����
	private String classname;		//������
	
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
		String Info="������Ϣ��\n"+
					"����ţ�"+bookclassid+"\n"+
					"��������"+classname+"\n";
		return Info;
	}
}

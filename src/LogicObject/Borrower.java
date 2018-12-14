package LogicObject;

public abstract class Borrower {
	private String borrowerid;	//借书者ID
	private String cardno;		//借书卡号
	private String department;	//系院
	private String name;		//姓名
	private boolean type;		//类型（研究生or本科生）
	private String password;	//密码
	Borrower(String borrowerid,String cardno,String department,String name,boolean type,String password){
		this.borrowerid=borrowerid;
		this.cardno=cardno;
		this.department=department;
		this.name=name;
		this.type=type;
		this.password=password;
	}
	public String getBorrowerID()
	{
		return borrowerid;
	}
	public void setBorrowerID(String id)
	{
		this.borrowerid=id;
	}
	public String getCardNo()
	{
		return cardno;
	}
	public void setCardNo(String no)
	{
		cardno=no;
	}
	public String getDepartment()
	{
		return department;
	}
	public void setDepartment(String dep)
	{
		department=dep;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public boolean getType()
	{
		return type;
	}
	public void setType(boolean Type)
	{
		type=Type;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String Password)
	{
		password=Password;
	}
	public String GetAllInfo()
	{
		String info="借阅者信息:\n"+
					"ID:"+borrowerid+"\n"+
					"姓名:"+name+"\n"+
					"借书卡号:"+cardno+"\n"+
					"学院:"+department+"\n";
		return info;
					
	}
}

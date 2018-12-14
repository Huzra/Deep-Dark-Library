package LogicObject;

public abstract class Borrower {
	private String borrowerid;	//������ID
	private String cardno;		//���鿨��
	private String department;	//ϵԺ
	private String name;		//����
	private boolean type;		//���ͣ��о���or��������
	private String password;	//����
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
		String info="��������Ϣ:\n"+
					"ID:"+borrowerid+"\n"+
					"����:"+name+"\n"+
					"���鿨��:"+cardno+"\n"+
					"ѧԺ:"+department+"\n";
		return info;
					
	}
}

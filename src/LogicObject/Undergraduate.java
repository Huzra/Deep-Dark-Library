package LogicObject;

public class Undergraduate extends Borrower{
	Undergraduate(String a,String b,String c,String d,boolean e,String f,String major){
		super(a,b,c,d,e,f);
		this.major=major;
	}
	private String major;		//����
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String Major)
	{
		this.major=Major;
	}
	public String getAllInfo()
	{
		String info=super.GetAllInfo()+
					"רҵ:"+major;
	return info;
	}
}

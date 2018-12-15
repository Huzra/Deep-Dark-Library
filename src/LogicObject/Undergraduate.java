package LogicObject;

public class Undergraduate extends Borrower{
	Undergraduate(String a,String b,String c,boolean e,String f,String major){
		super(a,b,c,e,f);
		this.major=major;
	}
	private String major;		//主修
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String Major)
	{
		this.major=Major;
	}
	public String GetAllInfo()
	{
		String info=super.GetAllInfo()+
					"类别:本科生\n"+
					"专业:"+major;
	return info;
	}
}

package LogicObject;

public class Undergraduate extends Borrower{
	Undergraduate(String a,String b,String c,boolean e,String f,String major){
		super(a,b,c,e,f);
		this.major=major;
	}
	private String major;		//Ö÷ÐÞ
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
					"×¨Òµ:"+major;
	return info;
	}
}

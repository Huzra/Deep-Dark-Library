package LogicObject;

public class GraduatedStu extends Borrower {
	GraduatedStu(String a,String b,String c,boolean e,String f,String major,String director){
		super(a,b,c,e,f);
		this.major=major;
		this.director=director;
	}
	private String major;	//主修
	private String director;//导师
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String Major)
	{
		major=Major;
	}
	public String getDirector()
	{
		return director;
	}
	public void setDirector(String Director)
	{
		director=Director;
	}
	public String GetAllInfo()
	{
		String info=super.GetAllInfo()+
					"类别:研究生\n"+
					"专业:"+major+"\n"+
					"导师:"+director;
		return info;
	}
}

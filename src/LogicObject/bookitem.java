package LogicObject;

public class bookitem {
	private String bookitemid;		//馆内书号
	private String bookisbn;		//isbn
	private String bookname;		//书名
	private double price;			//书价
	private String author;			//作者
	private String publishdate;		//出版日期
	
	bookitem(String itid,String isbn,String bn,double p,String a,String pd)
	{
		this.bookitemid=itid;
		this.bookisbn=isbn;
		this.bookname=bn;
		this.price=p;
		this.author=a;
		this.publishdate=pd;
	}

	public String getBookitemid() {
		return bookitemid;
	}

	public void setBookitemid(String bookitemid) {
		this.bookitemid = bookitemid;
	}

	public String getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}


	public String getAllInfo() {
		String Info="书本信息：\n"+
					"isbn："+bookisbn+"\n"+
					"书名："+bookname+"\n"+

					"书价："+price+"\n"+
					"作者："+author+"\n"+
					"出版日期："+publishdate+"\n";

		return Info;
	}
	public Object[] getObject()
	{
		Object[] ans= {bookitemid,bookisbn,bookname,author,price,publishdate};
		return ans;
	}
}

package LogicObject;

public class bookitem {
	private String bookitemid;		//馆内书号
	private String bookisbn;		//isbn
	private String bookname;		//书名
	private String bookclassid;		//书类号
	private double price;			//书价
	private String author;			//作者
	private String publishdate;		//出版日期
	private int bookamount;			//书数量
	
	bookitem(String itid,String isbn,String bn,String bcid,double p,String a,String pd,int ba)
	{
		this.bookitemid=itid;
		this.bookisbn=isbn;
		this.bookname=bn;
		this.bookclassid=bcid;
		this.price=p;
		this.author=a;
		this.publishdate=pd;
		this.bookamount=ba;
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

	public String getBookclassid() {
		return bookclassid;
	}

	public void setBookclassid(String bookclassid) {
		this.bookclassid = bookclassid;
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

	public int getBookamount() {
		return bookamount;
	}

	public void setBookamount(int bookamount) {
		this.bookamount = bookamount;
	}
	
	public String getAllInfo() {
		String Info="书本信息：\n"+
					"isbn："+bookisbn+"\n"+
					"书名："+bookname+"\n"+
					"书类号："+bookclassid+"\n"+
					"书价："+price+"\n"+
					"作者："+author+"\n"+
					"出版日期："+publishdate+"\n"+
					"书数量："+bookamount+"\n";
		return Info;
	}
}

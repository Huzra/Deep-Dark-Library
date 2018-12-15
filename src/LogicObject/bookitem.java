package LogicObject;

public class bookitem {
	private String bookitemid;		//�������
	private String bookisbn;		//isbn
	private String bookname;		//����
	private double price;			//���
	private String author;			//����
	private String publishdate;		//��������
	
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
		String Info="�鱾��Ϣ��\n"+
					"isbn��"+bookisbn+"\n"+
					"������"+bookname+"\n"+

					"��ۣ�"+price+"\n"+
					"���ߣ�"+author+"\n"+
					"�������ڣ�"+publishdate+"\n";

		return Info;
	}
	public Object[] getObject()
	{
		Object[] ans= {bookitemid,bookisbn,bookname,author,price,publishdate};
		return ans;
	}
}

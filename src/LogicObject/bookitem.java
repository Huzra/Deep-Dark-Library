package LogicObject;

public class bookitem {
	private String bookitemid;		//�������
	private String bookisbn;		//isbn
	private String bookname;		//����
	private String bookclassid;		//�����
	private double price;			//���
	private String author;			//����
	private String publishdate;		//��������
	private int bookamount;			//������
	
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
		String Info="�鱾��Ϣ��\n"+
					"isbn��"+bookisbn+"\n"+
					"������"+bookname+"\n"+
					"����ţ�"+bookclassid+"\n"+
					"��ۣ�"+price+"\n"+
					"���ߣ�"+author+"\n"+
					"�������ڣ�"+publishdate+"\n"+
					"��������"+bookamount+"\n";
		return Info;
	}
}

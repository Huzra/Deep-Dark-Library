package LogicObject;

public class loan {
	private String loanid;
	private String borrowerid;
	private String loandate;
	private String duedate;
	private String bookisbn;
	private boolean isreturned=false;
	private String bookitemid;
	
	loan(String lid,String bid,String ld,String dd,String isbn,boolean ir,String boid)
	{
		this.loanid=lid;		//���ĺ�	
		this.borrowerid=bid;	//�����ߺ�
		this.loandate=ld;		//��������
		this.duedate=dd;		//Ӧ������
		this.bookisbn=isbn;		//isbn
		this.isreturned=ir;		//�Ƿ��ѹ黹��falseΪ��
		this.bookitemid=boid;	//�������
	}

	public String getLoanid() {
		return loanid;
	}

	public void setLoanid(String loanid) {
		this.loanid = loanid;
	}

	public String getBorrowerid() {
		return borrowerid;
	}

	public void setBorrowerid(String borrowerid) {
		this.borrowerid = borrowerid;
	}

	public String getLoandate() {
		return loandate;
	}

	public void setLoandate(String loandate) {
		this.loandate = loandate;
	}

	public String getDuedate() {
		return duedate;
	}

	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}

	public String getBookisbn() {
		return bookisbn;
	}

	public void setBookisbn(String bookisbn) {
		this.bookisbn = bookisbn;
	}

	public boolean isIsreturned() {
		return isreturned;
	}

	public void setIsreturned(boolean isreturned) {
		this.isreturned = isreturned;
	}

	public String getBookitemid() {
		return bookitemid;
	}

	public void setBookitemid(String bookitemid) {
		this.bookitemid = bookitemid;
	}
	
	public String getAllInfo() {
		String Info="������Ϣ��\n"+
					"���ĺţ�"+loanid+"\n"+
					"�����ߺţ�"+borrowerid+"\n"+
					"�������ڣ�"+loandate+"\n"+
					"Ӧ�����ڣ�"+duedate+"\n"+
					"isbn��"+bookisbn+"\n"+
					"�Ƿ��ѹ黹����falseΪ��"+isreturned+"\n"+
					"������ţ�"+bookitemid+"\n\n";
		return Info;
	}
	
	
	
	
}

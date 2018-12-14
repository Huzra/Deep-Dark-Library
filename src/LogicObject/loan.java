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
		this.loanid=lid;		//借阅号	
		this.borrowerid=bid;	//借阅者号
		this.loandate=ld;		//借阅日期
		this.duedate=dd;		//应还日期
		this.bookisbn=isbn;		//isbn
		this.isreturned=ir;		//是否已归还，false为否
		this.bookitemid=boid;	//馆内书号
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
		String Info="借阅信息：\n"+
					"借阅号："+loanid+"\n"+
					"借阅者号："+borrowerid+"\n"+
					"借阅日期："+loandate+"\n"+
					"应还日期："+duedate+"\n"+
					"isbn："+bookisbn+"\n"+
					"是否已归还：（false为否）"+isreturned+"\n"+
					"馆内书号："+bookitemid+"\n\n";
		return Info;
	}
	
	
	
	
}

package LogicObject;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JOptionPane;


public class DataProcessing {
	public static void main(String[] args) {
		
	}
	private static int creloanid;
	private static Connection connection;
	private static Statement statement;
	private static Statement statement_1;
	private static ResultSet resultSet;
	private static ResultSet resultSet_1;
	private static boolean connectedToDB=false;
	static String driverName="com.mysql.jdbc.Driver";               // 加载数据库驱动类
	static String url="jdbc:mysql://localhost:3306/dblm";       // 声明数据库的URL
	static String user="root";                                      // 数据库用户
	static String password="123456";
	static Hashtable<String, Borrower> borrowers;
	static Hashtable<String, bookitem> bookitems;
	static Hashtable<String, ArrayList<loan>> loans;
	static {
		borrowers = new Hashtable<String, Borrower>();
		bookitems = new Hashtable<String, bookitem>();
		loans=new Hashtable<String,ArrayList<loan>>();
		try {
			init();
		} catch (ClassNotFoundException e) {
			System.out.println("数据驱动错误");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("数据库错误");
			e.printStackTrace();
		}
	}
	public static void init() throws ClassNotFoundException, SQLException
	{
		connectToDB(driverName);
		Borrower temp=null;
		if(!connectedToDB)
			throw new SQLException("无法连接到数据库");
		statement=connection.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		statement_1=connection.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		String sql="select * from borrower";
		String tempsql;
		resultSet = statement.executeQuery(sql);
		while(resultSet.next()){
			String name=resultSet.getString("name");
			String pwd=resultSet.getString("password");
			boolean type=resultSet.getBoolean("type");
			String ID=resultSet.getString("borrowerid");
			String department=resultSet.getString("department");
			if (type)
			{
				tempsql="select * from undergraduate where borrowerid="+"'"+ID+"'";
				resultSet_1 = statement_1.executeQuery(tempsql);
				resultSet_1.next();
				String major=resultSet_1.getString("major");
				temp = new Undergraduate(ID,department,name,type,pwd,major);
			}
			else
			{
				tempsql="select * from graduate where borrowerid="+"'"+ID+"'";
				resultSet_1 = statement_1.executeQuery(tempsql);
				resultSet_1.next();
				String major=resultSet_1.getString("major");
				String director=resultSet_1.getString("director");
				temp = new GraduatedStu(ID,department,name,type,pwd,major,director);
			}
			borrowers.put(ID, temp);
		}
		
		bookitem bitmp= null;			//存入书本信息的hashtable
		sql="select* from bookitem";
		resultSet=statement.executeQuery(sql);
		while(resultSet.next()) {
			String bookitemid=resultSet.getString("bookitemid");
			String bookisbn=resultSet.getString("isbn");
			String bookname=resultSet.getString("bookname");
			double price=resultSet.getDouble("price");
			String author=resultSet.getString("author");
			String publishdate=resultSet.getString("publishdate");			
			bitmp= new bookitem(bookitemid,bookisbn,bookname,price,author,publishdate);
			if(bookitemid != null&&bitmp!= null) {
				bookitems.put(bookitemid, bitmp);				
			}
		}
																//loan的hashtable
		sql="select* from loan";
		resultSet=statement.executeQuery(sql);
		loan ltmp=null;
		while(resultSet.next()) {
			String loanid=resultSet.getString("loanid");
			String borrowerid=resultSet.getString("borrowerid");
			String loandate=resultSet.getString("loandate");
			String duedate=resultSet.getString("duedate");
			String bookisbn=resultSet.getString("bookisbn");
			boolean isreturned=resultSet.getBoolean("isreturned");
			String bookitemid=resultSet.getString("bookitemid");
			
			ltmp= new loan(loanid,borrowerid,loandate,duedate,bookisbn,isreturned,bookitemid);
			if(!loans.containsKey(borrowerid)) {
				ArrayList<loan> list=new ArrayList<loan>();
				list.add(ltmp);
				loans.put(borrowerid, list);
			}
			else
				{
					ArrayList<loan> list=loans.get(borrowerid);
					list.add(ltmp);
					loans.put(borrowerid, list);
				}
			creloanid=Integer.parseInt(loanid)+1;
		}
	}
	public static Enumeration<ArrayList<loan>> getAllLoan()
	{
		Enumeration<ArrayList<loan>> e  = loans.elements();
		return e;
	}
	public static Enumeration<bookitem> getAllBook()
	{
		Enumeration<bookitem> e  = bookitems.elements();
		return e;
	}
	public static Enumeration<Borrower> getAllBorrower()
	{
		Enumeration<Borrower> e  = borrowers.elements();
		return e;
	}
	public static Borrower searchBorrower(String ID, String pwd){
		Borrower temp=null;
		temp=borrowers.get(ID);
		String str=temp.getPassword();
		if(str.equals(pwd))
			return temp;
		else
		{
			JOptionPane.showMessageDialog(null, "账号或密码错误");
		}
		return null;
	}
	public static Borrower searchBorrower(String ID){
		if(borrowers.containsKey(ID))
			return borrowers.get(ID);
		else
			return null;
	}
	public static bookitem searchbookitem(String bitid) {
		bookitem bitmp=null;
		bitmp = bookitems.get(bitid);
		if(bitmp!=null) {
			return bitmp;
		}
		else {
			System.out.println("查无此书号");
			return null;
		}
	}
	public static ArrayList<loan> searchloans(String borrowerid)
	{
		ArrayList<loan> list=loans.get(borrowerid);
		return list;
	}

	public static boolean updateborrow(String browid,String bookid) throws ClassNotFoundException, SQLException
	{
		if(!connectedToDB)
			throw new SQLException("无法连接到数据库");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String LoanDate = formatter.format(date);
		cal.add(Calendar.DATE, 30);
		date = cal.getTime();
		String DueDate = formatter.format(date);
		ArrayList<loan> ls= loans.get(browid);
		bookitem book=bookitems.get(bookid);
		loan ltp=new loan(Integer.toString(creloanid),browid,LoanDate,DueDate,book.getBookisbn(),false,bookid);
		ls.add(ltp);
		loans.put(browid, ls);
		//更新数据库
		String sql1="insert into loan values('"+Integer.toString(creloanid)+"','"+browid+"','"+LoanDate+"','"+DueDate+"',"+"'"+book.getBookisbn()+"'"+",0,'"+bookid+"')";
		creloanid++;	//自增借书记录号
		if(!statement.execute(sql1)) System.out.println("更新loan");
		return true;
	}
	public static boolean returnbook(String id,ArrayList<loan> ln,String loanID) throws SQLException
	{
		if(!connectedToDB)
			throw new SQLException("无法连接到数据库");
		loans.put(id, ln);
		String sql1="UPDATE loan SET isreturned=1 WHERE loanid="+"'"+loanID+"'";
		statement.execute(sql1);
		return true;
	}
	public static boolean insertborrower(String name,String ID,String department,String pas,boolean type,String major) throws SQLException
	{
		if(!connectedToDB)
			throw new SQLException("无法连接到数据库");
		if(borrowers.containsKey(ID))
		{
			return false;
		}
		Undergraduate temp=new Undergraduate(ID,department,name,true,pas,major);
		borrowers.put(ID, temp);
		String sql="insert into borrower values('"+ID+"','"+department+"','"+name+"','"+1+"','"+pas+"')";
		statement.execute(sql);
		sql="insert into Undergraduate values('"+ID+"','"+major+"')";
		statement.execute(sql);
		return true;
	}
	public static boolean insertborrower(String name,String ID,String department,String pas,boolean type,String major,String director) throws SQLException
	{
		if(!connectedToDB)
			throw new SQLException("无法连接到数据库");
		if(borrowers.containsKey(ID))
		{
			return false;
		}
		GraduatedStu temp=new GraduatedStu(ID,department,name,true,pas,major,director);
		borrowers.put(ID, temp);
		String sql="insert into borrower values('"+ID+"','"+department+"','"+name+"','"+0+"','"+pas+"')";
		statement.execute(sql);
		sql="insert into graduate values('"+ID+"','"+director+"','"+major+"')";
		statement.execute(sql);
		return true;
	}
	public static boolean deleteborrower(String ID) throws SQLException
	{
		Borrower temp=DataProcessing.searchBorrower(ID);
		if(temp==null)
		{
			return false;
		}
		String sql="delete from borrower where borrowerid='"+ID+"'";
		statement.execute(sql);
		if(temp.getType())
			sql="delete from Undergraduate where borrowerid='"+ID+"'";
		else
			sql="delete from graduate where borrowerid='"+ID+"'";
		statement.execute(sql);
		borrowers.remove(ID);
		return true;
	}
	public static  void connectToDB(String driverName) throws SQLException, ClassNotFoundException{
		Class.forName(driverName);		
		connection=DriverManager.getConnection(url, user, password);
		connectedToDB=true;
	}
	public static void disconnectFromDB() {
		if(connectedToDB) {
			try {
				resultSet.close();
				statement.close();
			}catch(SQLException sqlException) {
				sqlException.printStackTrace();
			}finally {
				connectedToDB=false;
			}
		}
	}
}

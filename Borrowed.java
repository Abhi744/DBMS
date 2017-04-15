import java.sql.Date;


public class Borrowed {
	private int Borrow_ID, Member_ID,Book_Code;
	private String Borrow_Status ;
	private Date Date_Issued, Date_Returned, Return_Date ;
	
	public Borrowed(int Borrow_ID, int Member_ID, int Book_Code, String Borrow_Status, Date Date_Issued, Date Date_Returned,  Date Return_Date ){
		super();
		this.Date_Issued=Date_Issued;
		this.Return_Date=Return_Date;
		this.Book_Code=Book_Code;
		this.Date_Returned=Date_Returned;
		this.Borrow_ID=Borrow_ID;
		this.Member_ID=Member_ID;
		this.Borrow_Status=Borrow_Status;
	}
	Date getDate_Issued()
	{
		return this.Date_Issued;
	}
	Date getDate_Returned()
	{
		return this.Date_Returned;
	}
	Date getReturn_Date()
	{
		return this.Return_Date;
	}
	String getBorrow_Status()
	{
		return this.Borrow_Status;
	}
	int getBook_Code()
	{
		return this.Book_Code;
	}
	int getMember_ID()
	{
		return this.Member_ID;
	}
	int getBorrow_ID()
	{
		return this.Borrow_ID;
	}
	
	void setBorrow_ID(int x )
	{
		this.Borrow_ID=x;
	}
	void setMember_ID(int x )
	{
		this.Member_ID=x;
	}
	void setBook_Code(int x )
	{
		this.Book_Code=x;
	}	
	void setBorrow_Status(String x )
	{
		this.Borrow_Status=x;
	}
	void setDate_Issued(Date x )
	{
		this.Date_Issued=x;
	}
	void setDate_Returned(Date  x )
	{
		this.Date_Returned=x;
	}
	void setReturn_Date(Date x )
	{
		this.Return_Date=x;
	}
	@Override
	public String toString() {
		return String.format("Borrowed [Book_Code=%d, Borrow_Status=%s, Member_ID=%d, Borrow_ID=%d, Return_Date=%s, Date_Returned=%s, Date_Issued=%s]",
						Book_Code, Borrow_Status, Member_ID, Borrow_ID, Return_Date, Date_Returned, Date_Issued);
	}
	
	
}

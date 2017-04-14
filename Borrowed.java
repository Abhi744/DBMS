import java.sql.Date;


public class Borrowed {
	private int Borrow_ID, Member_ID;
	private String Borrow_Status ;
	private Date Date_Issued, Date_Returned, Return_Date ;
	
	public Borrowed(int Borrow_ID, int Member_ID, String Borrow_Status, Date Date_Issued, Date Date_Returned,  Date Return_Date ){
		super();
		this.Date_Issued=Date_Issued;
		this.Return_Date=Return_Date;
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
	int getBorrow_ID()
	{
		return this.Borrow_ID;
	}
	
	void setBorrow_ID(int x )
	{
		this.Borrow_ID=x;
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
		return String.format("Borrowed [Borrow_Status=%s, Borrow_ID=%d, Return_Date=%s, Date_Returned=%s, Date_Issued=%s]",
						 Borrow_Status, Borrow_ID, Return_Date, Date_Returned, Date_Issued);
	}
	
	
}

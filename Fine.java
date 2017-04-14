import java.sql.Date;

public class Fine {
	private int Borrow_ID, Fine_Rate, Fine_Amount;
	private Date Date_Issued, Return_Date;
	
	public Fine(int Borrow_ID, int Fine_Rate, int Fine_Amount , Date Date_Issued, Date Return_Date){
		super();
		this.Borrow_ID=Borrow_ID;
		this.Fine_Rate=Fine_Rate;
		this.Fine_Amount=Fine_Amount;
		this.Date_Issued=Date_Issued;
		this.Return_Date=Return_Date;
	}
	int getBorrow_ID()
	{
		return this.Borrow_ID;
	}
	int getFine_Rate(){
		return this.Fine_Rate;
	}
	int getFine_Amount()
	{
		return this.Fine_Amount;
	}
	Date getDate_Issued()
	{
		return this.Date_Issued;
	}
	Date getReturn_Date()
	{
		return this.Return_Date;
	}
	
	void setBorrow_ID(int x)
	{
		this.Borrow_ID=x;
	}
	void setFine_Rate(int x){
		this.Fine_Rate=x;
	}
	void setFine_Amount(int x)
	{
		this.Fine_Amount=x;
	}
	void setDate_Issued(Date x)
	{
		Date_Issued=x;
	}
	void setReturn_Date( Date x)
	{
		this.Return_Date=x;
	}
	
	@Override
	public String toString() {
		return String.format("Fine [Borrow_ID=%d, Fine_Rate=%d, Fine_Amount=%d, Date_Issued=%s, Return_Date=%s]",
				Borrow_ID, Fine_Rate, Fine_Amount, Date_Issued, Return_Date);
	}
	
	
}

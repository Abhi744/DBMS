import java.sql.Date;

public class Fine {
	private int Borrow_ID, Fine_Rate, Fine_Amount;
	
	public Fine(int Borrow_ID, int Fine_Rate, int Fine_Amount){
		super();
		this.Borrow_ID=Borrow_ID;
		this.Fine_Rate=Fine_Rate;
		this.Fine_Amount=Fine_Amount;
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
	
	@Override
	public String toString() {
		return String.format("Fine [Borrow_ID=%d, Fine_Rate=%d, Fine_Amount=%d]",
				Borrow_ID, Fine_Rate, Fine_Amount);
	}
	
	
}

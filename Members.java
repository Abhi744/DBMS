import java.sql.Date;

public class Members {
	private int Member_ID;
	private String Member_Name, Member_Status, Address, Email, Contact ;
	private Date Expiry_Date, Registered_Date;
	
	public Members(int Member_ID, String Member_Name ,String Member_Status, String Address, String Email, String Contact, Date Registered_Date, Date Expiry_Date){
		super();
		this.Member_ID=Member_ID;
		this.Member_Name=Member_Name;
		this.Member_Status=Member_Status;
		this.Address=Address;
		this.Email=Email;
		this.Contact=Contact;
		this.Registered_Date=Registered_Date;
		this.Expiry_Date=Expiry_Date;
	}
	int getMember_ID()
	{
		return this.Member_ID;
	}
	String getMember_Name()
	{
		return this.Member_Name;
	}
	String getMember_Status()
	{
		return this.Member_Status;
	}
	String getAddress()
	{
		return this.Address;
	}
	String getEmail()
	{
		return this.Email;
	}
	String getContact()
	{
		return this.Contact;
	}
	Date getRegistered_Date()
	{
		return this.Registered_Date;
	}
	Date getExpiry_Date()
	{
		return this.Expiry_Date;
	}
	
	void setMember_ID(int x)
	{
		this.Member_ID=x;
	}
	void setMember_Name(String x)
	{
		this.Member_Name=x;
	}
	void setAddress(String x)
	{
		this.Address=x;
	}
	void setEmail(String x)
	{
		this.Email=x;
	}
	void setContact(String x)
	{
		this.Contact=x;
	}
	void setRegistered_Date(Date x)
	{
		this.Registered_Date= x;
	}
	void setExpiry_Date(Date x)
	{
		this.Expiry_Date=x;	
	}
	@Override
	public String toString() {
		return String.format("Members [Member_ID=%d, Member_Name=%s, Address=%s, Email=%s, Contact=%s]",
				Member_ID, Member_Name, Address, Email, Contact);
	}
	
	
}


public class Staff {
	private int Staff_ID, Working_Hours;
	private String Staff_Name, Address, Email, Contact ;
	
	public Staff(int Staff_ID, int Working_Hours, String Staff_Name ,String Address, String Email, String Contact ){
		super();
		this.Staff_ID=Staff_ID;
		this.Working_Hours=Working_Hours;
		this.Staff_Name=Staff_Name;
		this.Address=Address;
		this.Email=Email;
		this.Contact=Contact;

	}
	int getStaff_ID()
	{
		return this.Staff_ID;
	}
	int getWorking_Hours(){
		return this.Working_Hours;
	}
	String getStaff_Name()
	{
		return this.Staff_Name;
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

	
	void setStaff_ID(int x)
	{
		this.Staff_ID=x;
	}
	void setStaff_Name(String x)
	{
		this.Staff_Name=x;
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

	void setWorking_Hours( int x)
	{
		this.Working_Hours=x;
	}
	
	@Override
	public String toString() {
		return String.format("Staff [Staff_ID=%d, Staff_Name=%s, Address=%s, Email=%s, Contact=%s, Working_Hours=%d, =%s]",
				Staff_ID, Staff_Name, Address, Email, Contact,Working_Hours);
	}
	
	
}

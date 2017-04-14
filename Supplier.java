
public class Supplier {
	private int Supplier_ID;
	private String Supplier_Name, Address, Email, Contact ;
	
	public Supplier(int Supplier_ID, String Supplier_Name ,String Address, String Email, String Contact){
		super();
		this.Supplier_ID=Supplier_ID;
		this.Supplier_Name=Supplier_Name;
		this.Address=Address;
		this.Email=Email;
		this.Contact=Contact;
	}
	int getSupplier_ID()
	{
		return this.Supplier_ID;
	}
	String getSupplier_Name()
	{
		return this.Supplier_Name;
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
	
	void setSupplier_ID(int x)
	{
		this.Supplier_ID=x;
	}
	void setSupplier_Name(String x)
	{
		this.Supplier_Name=x;
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
	@Override
	public String toString() {
		return String.format("Supplier [Supplier_ID=%d, Supplier_Name=%s, Address=%s, Email=%s, Contact=%s]",
				Supplier_ID, Supplier_Name, Address, Email, Contact);
	}
	
	
}

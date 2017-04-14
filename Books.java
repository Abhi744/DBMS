import java.sql.Date;


public class Books {
	private int Book_Code ,Shelf_Number ;
	private String Book_Title,Publication,Book_Genre,Author ;
	private Date Arrival_Date ;
	
	public Books(int Book_Code,int Shelf_Number,String Book_Title,String Publication,String Book_Genre,String Author,Date Arrival_Date ){
		super();
		this.Arrival_Date=Arrival_Date;
		this.Author=Author;
		this.Book_Code=Book_Code;
		this.Book_Genre=Book_Genre;
		this.Book_Title=Book_Title;
		this.Publication=Publication;
		this.Shelf_Number=Shelf_Number;
		
	}
	Date getArrivalDate()
	{
		return this.Arrival_Date;
	}
	String getAuthor()
	{
		return this.Author;
	}
	String getBook_Title()
	{
		return this.Book_Title;
	}
	String getPublication()
	{
		return this.Publication;
	}
	String getBook_Genre()
	{
		return this.Book_Genre;
	}
	int getBook_Code()
	{
		return this.Book_Code;
	}
	int getShelf_Number()
	{
		return this.Shelf_Number;
	}

	
	
	

	void setBook_Code(int x )
	{
		this.Book_Code=x;
	}
	void setShelf_Number(int x )
	{
		this.Shelf_Number=x;
	}
	void setAuthor(String x )
	{
		this.Author=x;
	}
	void setBook_Title(String x )
	{
		this.Book_Title=x;
	}
	void setPublication(String  x )
	{
		this.Publication=x;
	}
	void setBook_Genre(String x )
	{
		this.Book_Genre=x;
	}
	void setArrival_Date(Date x )
	{
		this.Arrival_Date=x;
	}
	@Override
	public String toString() {
		return String.format("Books [Book_Code=%d, Book_Title=%s, Author=%s, Publication=%s, Book_Genre=%s, =%d,  =%d, Shelf_Number=%d, Arrival_Date =%s]",
						Book_Code, Book_Title, Author, Publication, Book_Genre,Shelf_Number,Arrival_Date);
	}
	
	
}

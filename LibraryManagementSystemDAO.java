import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class LibraryManagementSystemDAO {
	
	private Connection MyConnection;
	
	public LibraryManagementSystemDAO() throws Exception{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		MyConnection = DriverManager.getConnection(dburl,user,password);
		
		System.out.println("Database Connection succesful to: "+dburl);
	}
	
	public List<Books> getAllBooks() throws Exception
	{
		List<Books> list = new ArrayList<Books>();
		Statement myStatement = null;
		ResultSet MyResult = null;
		
		try {
			myStatement = MyConnection.createStatement();
			MyResult = myStatement.executeQuery("select * from Books");
			
			while(MyResult.next())
			{
				Books tempBooks = convertRowToBooks(MyResult);
				list.add(tempBooks);
			}
			return list;
			
		}
		finally {close(myStatement,MyResult);}
	}
	private Books convertRowToBooks(ResultSet myrs) throws SQLException
	{
		int Book_Code = myrs.getInt("Book_Code");
		int Shelf_Number = myrs.getInt("Shelf_Number");
		String Author = myrs.getString("Author");
		String Book_Title = myrs.getString("Book_Title");
		String Publication = myrs.getString("Publication");
		String Book_Genre = myrs.getString("Book_Genre");
		Date Arrival_Date = myrs.getDate("Arrival_Date");
		
		Books tempEmployee = new Books(Book_Code, Shelf_Number, Book_Title,Publication,Book_Genre,Author,Arrival_Date);
		
		return tempEmployee;
	}
	
	public List<Members> getAllMembers() throws Exception
	{
		List<Members> list = new ArrayList<Members>();
		Statement myStatement = null;
		ResultSet MyResult = null;
		
		try {
			myStatement = MyConnection.createStatement();
			MyResult = myStatement.executeQuery("select * from Members");
			
			while(MyResult.next())
			{
				Members tempBooks = convertRowToMembers(MyResult);
				list.add(tempBooks);
			}
			return list;
			
		}
		finally {close(myStatement,MyResult);}
	}
	private Members convertRowToMembers(ResultSet myrs) throws SQLException
	{
		int Member_ID = myrs.getInt("Member_ID");
		String Contact = myrs.getString("Contact");
		String Address = myrs.getString("Address");
		String Member_Name = myrs.getString("Member_Name");
		String Email = myrs.getString("Email");
		String Member_Status = myrs.getString("Member_Status");
		Date Registered_Date = myrs.getDate("Registered_Date");
		Date Expiry_Date = myrs.getDate("Expiry_Date");
		Members tempEmployee = new Members(Member_ID, Member_Name, Member_Status, Address,Email, Contact,Registered_Date,Expiry_Date);
		
		return tempEmployee;
	}
	
	public void addMembers(String name,String email,String status,String address ,String contact) throws Exception{
		PreparedStatement myStmt = null;
		try{
			myStmt = MyConnection.prepareStatement("insert into Members" + "(Member_Name, Address,Registered_Date,Expiry_Date,Member_Status,Contact,Email)"+"(?,?,curDate(),DATE_ADD(date, INTERVAL 2 YEAR),?,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			myStmt.setString(1,name);
			myStmt.setString(2,address);
//			myStmt.setDate(3,contact);
//			myStmt.setDate(4,theMembers.getExpiry_Date());
			myStmt.setString(5,status);
			myStmt.setString(6,contact);
			myStmt.setString(7,email);
			
			myStmt.executeUpdate();
		}finally{close(myStmt);}
	}
	
	public List<Fine> getAllFine() throws Exception
	    {
	        List<Fine> list = new ArrayList<Fine>();
	        Statement myStatement = null;
	        ResultSet MyResult = null;
	       
	        try {
	            myStatement = MyConnection.createStatement();
	            MyResult = myStatement.executeQuery("select * from Fine");
	           
	            while(MyResult.next())
	            {
	                Fine tempFine = convertRowToFine(MyResult);
	                list.add(tempFine);
	            }
	            return list;
	           
	        }
	        finally {close(myStatement,MyResult);}
	    }
	 private Fine convertRowToFine(ResultSet myrs) throws SQLException
	    {
	        int Borrow_ID = myrs.getInt("Borrow_ID");
	        int Fine_Rate = myrs.getInt("Fine_Rate");
	        int Fine_Amount = myrs.getInt("Address");
	        Date Date_Issued = myrs.getDate("Date_Issued");
	        Date Return_Date = myrs.getDate("Return_Date");
	        Fine tempEmployee = new Fine(Borrow_ID, Fine_Rate,Fine_Amount,Date_Issued,Return_Date);
	       
	        return tempEmployee;
	    }
	 
	 public List<Staff> getAllStaff() throws Exception
	    {
	        List<Staff> list = new ArrayList<Staff>();
	        Statement myStatement = null;
	        ResultSet MyResult = null;
	       
	        try {
	            myStatement = MyConnection.createStatement();
	            MyResult = myStatement.executeQuery("select * from Staff");
	           
	            while(MyResult.next())
	            {
	                Staff tempFine = convertRowToStaff(MyResult);
	                list.add(tempFine);
	            }
	            return list;
	           
	        }
	        finally {close(myStatement,MyResult);}
	    }
	  private Staff convertRowToStaff(ResultSet myrs) throws SQLException
	    {
	        int Staff_ID = myrs.getInt("Staff_ID");
	        int Working_Hours = myrs.getInt("Working_Hours");
	        String Staff_Name = myrs.getString("Staff_Name");
	        String Address = myrs.getString("Address");
	        String Email = myrs.getString("Email");
	        String Contact = myrs.getString("Contact");
	        Staff tempEmployee = new Staff(Staff_ID, Working_Hours,Staff_Name,Address,Email, Contact);
	       
	        return tempEmployee;
	   }
	  
	  public List<Borrowed> getAllBorrowed() throws Exception
	    {
	        List<Borrowed> list = new ArrayList<Borrowed>();
	        Statement myStatement = null;
	        ResultSet MyResult = null;
	       
	        try {
	            myStatement = MyConnection.createStatement();
	            MyResult = myStatement.executeQuery("select * from Borrowed");
	           
	            while(MyResult.next())
	            {
	                Borrowed tempBorrowed = convertRowToBorrowed(MyResult);
	                list.add(tempBorrowed);
	            }
	            return list;
	           
	        }
	        finally {close(myStatement,MyResult);}
	    }
	    private Borrowed convertRowToBorrowed(ResultSet myrs) throws SQLException
	    {
	        int Borrow_ID = myrs.getInt("Borrow_ID");
	        int Member_ID = myrs.getInt("Member_ID");
	        int Book_Code = myrs.getInt("Address");
	        String Borrow_Status = myrs.getString("Borrow_Status");
	        Date Date_Issued = myrs.getDate("Date_Issued");
	        Date Date_Returned = myrs.getDate("Date_Returned");
	        Date Return_Date = myrs.getDate("Return_Date");
	        Borrowed tempEmployee = new Borrowed(Borrow_ID, Member_ID,Book_Code,Borrow_Status,Date_Issued,Return_Date, Date_Returned);
	       
	        return tempEmployee;
	    }
	    public List<Borrowed> searchBorrowed(int x) throws Exception {
	        List<Borrowed> list = new ArrayList<Borrowed>();

	        PreparedStatement myStmt = null;
	        ResultSet myRs = null;

	        try {
//	            Book_Code += "%";
	            myStmt = MyConnection.prepareStatement("select * from Borrowed where Book_Code=?");
	           
	            myStmt.setInt(1, x);
	           
	            myRs = myStmt.executeQuery();
	           
	            while (myRs.next()) {
	                Borrowed tempEmployee = convertRowToBorrowed(myRs);
	                list.add(tempEmployee);
	            }
	           
	            return list;
	        }
	        finally {
	            close(myStmt, myRs);
	        }
	    }
	  
	  public List<Staff> searchStaff(String Staff_Name) throws Exception {
	        List<Staff> list = new ArrayList<Staff>();

	        PreparedStatement myStmt = null;
	        ResultSet myRs = null;

	        try {
	            Staff_Name += "%";
	            myStmt = MyConnection.prepareStatement("select * from Staff where Staff_Name like ?");
	           
	            myStmt.setString(1, Staff_Name);
	           
	            myRs = myStmt.executeQuery();
	           
	            while (myRs.next()) {
	                Staff tempEmployee = convertRowToStaff(myRs);
	                list.add(tempEmployee);
	            }
	           
	            return list;
	        }
	        finally {
	            close(myStmt, myRs);
	        }
	    }
	  
	    public List<Supplier> getAllSupplier() throws Exception
	    {
	        List<Supplier> list = new ArrayList<Supplier>();
	        Statement myStatement = null;
	        ResultSet MyResult = null;
	       
	        try {
	            myStatement = MyConnection.createStatement();
	            MyResult = myStatement.executeQuery("select * from Supplier");
	           
	            while(MyResult.next())
	            {
	                Supplier tempBorrowed = convertRowToSupplier(MyResult);
	                list.add(tempBorrowed);
	            }
	            return list;
	           
	        }
	        finally {close(myStatement,MyResult);}
	    }
	    private Supplier convertRowToSupplier(ResultSet myrs) throws SQLException
	    {
	        int Supplier_ID = myrs.getInt("Supplier_ID");
	        String Supplier_Name = myrs.getString("Supplier_Name");
	        String Address = myrs.getString("Address");
	        String Email = myrs.getString("Email");
	        String Contact = myrs.getString("Contact");
	       
	        Supplier tempEmployee = new Supplier(Supplier_ID, Supplier_Name,Address,Email,Contact);
	       
	        return tempEmployee;
	    }
	    public List<Supplier> searchSupplier(String Supplier_Name) throws Exception {
	        List<Supplier> list = new ArrayList<Supplier>();

	        PreparedStatement myStmt = null;
	        ResultSet myRs = null;

	        try {
	            Supplier_Name += "%";
	            myStmt = MyConnection.prepareStatement("select * from Supplier where Supplier_Name like ?");
	           
	            myStmt.setString(1, Supplier_Name);
	           
	            myRs = myStmt.executeQuery();
	           
	            while (myRs.next()) {
	                Supplier tempEmployee = convertRowToSupplier(myRs);
	                list.add(tempEmployee);
	            }
	           
	            return list;
	        }
	        finally {
	            close(myStmt, myRs);
	        }
	    }
	    
	    
	                
	 
	 public List<Fine> searchMembers(int x) throws Exception {
	        List<Fine> list = new ArrayList<Fine>();

	        PreparedStatement myStmt = null;
	        ResultSet myRs = null;

	        try {
//	            Fine_Amount += "%";
	            myStmt = MyConnection.prepareStatement("select * from Fine where Fine_Amount=?");
	           
	            myStmt.setInt(1, x);
	           
	            myRs = myStmt.executeQuery();
	           
	            while (myRs.next()) {
	                Fine tempEmployee = convertRowToFine(myRs);
	                list.add(tempEmployee);
	            }
	           
	            return list;
	        }
	        finally {
	            close(myStmt, myRs);
	        }
	    }
	private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
			throws SQLException {

		if (myRs != null) {
			myRs.close();
		}

		if (myStmt != null) {
			
		}
		
		if (myConn != null) {
			myConn.close();
		}
	}
	public List<Members> searchMembers(String Member_Name) throws Exception {
		List<Members> list = new ArrayList<Members>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			Member_Name += "%";
			myStmt = MyConnection.prepareStatement("select * from Members where Member_Name like ?");
			
			myStmt.setString(1, Member_Name);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Members tempEmployee = convertRowToMembers(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);
		}
	}

	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}
	public List<Books> searchBooks(String Book_Title) throws Exception {
		List<Books> list = new ArrayList<Books>();

		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			Book_Title += "%";
			myStmt = MyConnection.prepareStatement("select * from Books where Book_Title like ?");
			
			myStmt.setString(1, Book_Title);
			
			myRs = myStmt.executeQuery();
			
			while (myRs.next()) {
				Books tempEmployee = convertRowToBooks(myRs);
				list.add(tempEmployee);
			}
			
			return list;
		}
		finally {
			close(myStmt, myRs);	
		}
	}
	String CheckAvailable(String book) throws SQLException
	{
		String answer="Available";
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<Integer> list = new ArrayList<Integer>();
		try {
			
			myStmt = MyConnection.prepareStatement("select Book_Code from Books natural join Borrowed where Book_Title =? and Borrow_Status='Borrowed'");
			
			myStmt.setString(1, book);
			
			myRs = myStmt.executeQuery();
			
			if(myRs.next())	
			{
				int h = myRs.getInt("Book_Code");
				list.add(h);
			}
			if(list.size()==0)
				answer = "Not Available";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close(null, myStmt, myRs);	
		}
		return answer;
		
	}
	List<String> currentbooks(String sname) throws SQLException
	{
		List<String> list = new ArrayList<String>();
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			myStmt = MyConnection.prepareStatement("select Book_Title from Books,Supplier,Borrowed where Books.Supplier_ID=Supplier.Supplier_ID and Borrowed.Book_Code=Books.Book_Code and Supplier_Name=? and extract(month from Arrival_Date)=extract(month from curdate()) and extract(month from Date_Issued)=extract(month from curdate())") ;
			
			myStmt.setString(1, sname);
			
			myRs = myStmt.executeQuery();
			
			while(myRs.next())	
			{
				String tempEmployee = myRs.getString("Book_Title");
				list.add(tempEmployee);
			}
			
			return list;
		} 
		finally {
			close( myStmt, myRs);	
		}
		
		
	}
	public static void main(String[] args) throws Exception {
		
		LibraryManagementSystemDAO dao= new LibraryManagementSystemDAO();
//		Scanner sc = new Scanner(System.in);
//		String i1 = sc.nextLine();
//		String i2 = sc.nextLine();
//		String i3 = sc.nextLine();
//		String i4 = sc.nextLine();
//		String i5 = sc.nextLine();
//		String i6 = sc.nextLine();
//		String i7 = sc.nextLine();
		
		
		
		//List<String> result = dao.currentbooks(input);
		//System.out.println(result);
//		List<Books> list = dao.getAllBooks();
//		
//		for(int i=0;i<list.size();i++)
//		{
//			System.out.println(list.get(i));
//		}
//		List<Books> wlist = dao.searchBooks("The Pilgrimage");
//		
//		for(int i=0;i<wlist.size();i++)
//		{
//			System.out.println(wlist.get(i));
//		}
//		
	
	}

}


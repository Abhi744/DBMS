import java.awt.BorderLayout;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class LibraryManagementSystemDAO {
	
	public Connection MyConnection;
	public PreparedStatement myStmt;
	 JFrame frame = new JFrame();
	    JTable table;
	
	public LibraryManagementSystemDAO() throws Exception{
		Properties props = new Properties();
		props.load(new FileInputStream("demo.properties"));
		
		String user = props.getProperty("user");
		String password = props.getProperty("password");
		String dburl = props.getProperty("dburl");
		MyConnection = DriverManager.getConnection(dburl,user,password);
		
		System.out.println("Database Connection succesful to: "+dburl);
	}

	public void query1(int i,String userinput,String userinput1) throws Exception
	{
		
		PreparedStatement myStmt = null;
		System.out.print(i);
		ResultSet myRs = null;
		
		try {
	
			if(i==1)
				myStmt =  MyConnection.prepareStatement("select distinct Book_Title from Books,Borrowed,Borrowed_Books,Members,Member_Borrowed where Books.Book_Code=Borrowed_Books.Book_Code and Borrowed.Borrow_ID=Borrowed_Books.Borrow_ID and Members.Member_ID=Member_Borrowed.Member_ID and Borrowed.Borrow_ID=Member_Borrowed.Borrow_ID and Books.Publication= ? and Members.Address=?");
			else if(i==2)
				myStmt =  MyConnection.prepareStatement("select distinct Book_Title from Books,Borrowed,Borrowed_Books,Members,Member_Borrowed where Books.Book_Code=Borrowed_Books.Book_Code and Borrowed.Borrow_ID=Borrowed_Books.Borrow_ID and Members.Member_ID=Member_Borrowed.Member_ID and Borrowed.Borrow_ID=Member_Borrowed.Borrow_ID and Books.Author=? and Members.Address=?");
			else if(i==3)
				myStmt = MyConnection.prepareStatement("select distinct Book_Title from Books natural join Borrowed natural join Borrowed_Books natural join Members natural join Member_Borrowed where Books.Book_Genre= ? and Members.Address=?");
			
            myStmt.setString(1, userinput);
            myStmt.setString(2, userinput1);
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][1];
            Object columnNames[]={"Book Title"};
            int row=0;
			while(myRs.next())
			{
				/*Books tempBooks = convertRowToBooks(MyResult);
				list.add(tempBooks);*/
				
				rowData[row][0] = myRs.getString("Book_Title");
				row++;
			}
			//createTable c = new createTable(1,list);
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);
//			return list;
			
		}
		finally { close(myStmt, myRs);}
	}
	public void query2(String userinput) throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select Book_Title,Date_Issued from Borrowed,Books,Borrowed_Books,Members,Member_Borrowed where  Books.Book_Code=Borrowed_Books.Book_Code and Borrowed.Borrow_ID=Borrowed_Books.Borrow_ID and Members.Member_ID=Member_Borrowed.Member_ID and Borrowed.Borrow_ID=Member_Borrowed.Borrow_ID and Member_Name=?");
			
            myStmt.setString(1, userinput);
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][2];
            Object columnNames[]={"Book Title","Date Issued"};
            int row=0;
			while(myRs.next())
			{
				/*Books tempBooks = convertRowToBooks(MyResult);
				list.add(tempBooks);*/
				
				rowData[row][0] = myRs.getString("Book_Title");
				rowData[row][1] = myRs.getString("Date_Issued");
				row++;
			}
			//createTable c = new createTable(1,list);
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);
//			return list;
			
		}
		finally { close(myStmt, myRs);}
	}
	public void query3(String userinput) throws Exception
	{
		String answer="Not Available";
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		List<Integer> list = new ArrayList<Integer>();
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select Book_Code from Books natural join Borrowed natural join Borrowed_Books where Book_Title =? and Borrow_Status='Borrowed'");
			
            myStmt.setString(1, userinput);
            myRs = myStmt.executeQuery();

			while(myRs.next())
			{
				int h = myRs.getInt("Book_Code");
				list.add(h);
			}
			//createTable c = new createTable(1,list);
			if(list.size()==0)
				answer = "Available";
			JOptionPane.showMessageDialog(frame,answer);
			
		}
		finally { close(myStmt, myRs);}
	}
	public void query4(String userinput) throws Exception
	{
		
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select Book_Title from Books natural join Borrowed natural join Borrowed_Books natural join Supplier natural join Books_Supplied where Supplier_Name =? and extract(month from curdate())=extract(month from Date_Issued) and extract(month from curdate())=extract(month from Arrival_Date)");
			
            myStmt.setString(1, userinput);
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][1];
            Object columnNames[]={"Book Title"};
            int row=0;
			while(myRs.next())
			{
				/*Books tempBooks = convertRowToBooks(MyResult);
				list.add(tempBooks);*/
				
				rowData[row][0] = myRs.getString("Book_Title");
				row++;
			}
			//createTable c = new createTable(1,list);
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);
//			return list;
			
		}
		finally { close(myStmt, myRs);}
	}
	public void query5(String userinput) throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select distinct Member_Name from Books,Borrowed,Borrowed_Books,Members,Member_Borrowed,Supplier,Books_Supplied where Books.Book_Code=Borrowed_Books.Book_Code and Borrowed.Borrow_ID=Borrowed_Books.Borrow_ID and Members.Member_ID=Member_Borrowed.Member_ID and Borrowed.Borrow_ID=Member_Borrowed.Borrow_ID and Supplier.Supplier_ID=Books_Supplied.Supplier_ID and Books_Supplied.Book_Code=Books.Book_Code and Supplier.Address=?");
			
            myStmt.setString(1, userinput);
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][1];
            Object columnNames[]={"Member Name"};
            int row=0;
			while(myRs.next())
			{
				/*Books tempBooks = convertRowToBooks(MyResult);
				list.add(tempBooks);*/
				
				rowData[row][0] = myRs.getString("Member_Name");
				row++;
			}
			//createTable c = new createTable(1,list);
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);
//			return list;
			
		}
		finally { close(myStmt, myRs);}
	}
	public void query6() throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select Member_Name,Fine_Amount from Members,Member_Borrowed,Borrowed,Fine_Details where Members.Member_ID=Member_Borrowed.Member_ID and Member_Borrowed.Borrow_ID=Borrowed.Borrow_ID and Borrowed.Borrow_ID=Fine_Details.Borrow_ID and datediff(Date_Returned,Return_Date)>0");
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][2];
            Object columnNames[]={"Member Name","Fine Amount"};
            int row=0;
			while(myRs.next())
			{
				/*Books tempBooks = convertRowToBooks(MyResult);
				list.add(tempBooks);*/
				
				rowData[row][0] = myRs.getString("Member_Name");
				rowData[row][1] = myRs.getString("Fine_Amount");
				row++;
			}
			//createTable c = new createTable(1,list);
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);
//			return list;
			
		}
		finally { close(myStmt, myRs);}
	}
	public void query7(int price,int count) throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {	
			
			myStmt =  MyConnection.prepareStatement("select distinct  Supplier_Name from Supplier,Books_Supplied,Borrowed,Borrowed_Books,Books where Supplier.Supplier_ID=Books_Supplied.Supplier_ID and Books_Supplied.Book_Code=Books.Book_Code and Borrowed.Borrow_ID=Borrowed_Books.Borrow_ID and Borrowed_Books.Book_Code=Books.Book_Code and price<? group by Books.Book_Code having count(Books.Book_Code) >= ?");
			 myStmt.setInt(1, price);
			 myStmt.setInt(2, count);
           
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][1];
            Object columnNames[]={"Supplier Name"};
            int row=0;
			while(myRs.next())
			{
				/*Books tempBooks = convertRowToBooks(MyResult);
				list.add(tempBooks);*/
				
				rowData[row][0] = myRs.getString("Supplier_Name");
				row++;
			}
			//createTable c = new createTable(1,list);
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);
//			return list;
			
		}
		finally { close(myStmt, myRs);}
	}
	public void query9(int shelf,int type) throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {	
			if(type==1)
				myStmt =  MyConnection.prepareStatement("select Member_Name from Supplier,Books_Supplied,Books,Borrowed_Books,Members,Member_Borrowed where Supplier.Supplier_ID=Books_Supplied.Supplier_ID and Books_Supplied.Book_Code=Books.Book_Code and Members.Member_ID=Member_Borrowed.Member_ID and Member_Borrowed.Borrow_ID=Borrowed_Books.Borrow_ID and Borrowed_Books.Book_Code=Books.Book_Code and Shelf_Number=? and Member_Status='Permanent'");
			else if(type==2)
				myStmt =  MyConnection.prepareStatement("select Member_Name from Supplier,Books_Supplied,Books,Borrowed_Books,Members,Member_Borrowed where Supplier.Supplier_ID=Books_Supplied.Supplier_ID and Books_Supplied.Book_Code=Books.Book_Code and Members.Member_ID=Member_Borrowed.Member_ID and Member_Borrowed.Borrow_ID=Borrowed_Books.Borrow_ID and Borrowed_Books.Book_Code=Books.Book_Code and Shelf_Number=? and Member_Status='Temporary'");
            myStmt.setInt(1, shelf);
           
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][1];
            Object columnNames[]={"Member Name"};
            int row=0;
			while(myRs.next())
			{
				/*Books tempBooks = convertRowToBooks(MyResult);
				list.add(tempBooks);*/
				
				rowData[row][0] = myRs.getString("Member_Name");
				row++;
			}
			//createTable c = new createTable(1,list);
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);
//			return list;
			
		}
		finally { close(myStmt, myRs);}
	}
	public void query10(String userinput) throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select Member_Name from Members,Member_Borrowed,Borrowed,Borrowed_Books,Books where Members.Member_ID=Member_Borrowed.Member_ID and Member_Borrowed.Borrow_ID=Borrowed.Borrow_ID and Borrowed.Borrow_ID=Borrowed_Books.Borrow_ID and Borrowed_Books.Book_Code=Books.Book_Code and Books.Author= ? and extract(month from Registered_Date)=extract(month from curdate())");
			
            myStmt.setString(1, userinput);
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][1];
            Object columnNames[]={"Member Name"};
            int row=0;
			while(myRs.next())
			{
				/*Books tempBooks = convertRowToBooks(MyResult);
				list.add(tempBooks);*/
				
				rowData[row][0] = myRs.getString("Member_Name");
				row++;
			}
			//createTable c = new createTable(1,list);
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);
//			return list;
			
		}
		finally { close(myStmt, myRs);}
	}
	public void showMembers() throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select * from Members");
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][8];
            Object columnNames[]={"Member ID","Member Name","Address","Registered Date","Expiry Date","Member Status","Contact","Email"};
            int row=0;
			while(myRs.next())
			{
				rowData[row][0] = myRs.getString("Member_ID");
				rowData[row][1] = myRs.getString("Member_Name");
				rowData[row][2] = myRs.getString("Address");
				rowData[row][3] = myRs.getString("Registered_Date");
				rowData[row][4] = myRs.getString("Expiry_Date");
				rowData[row][5] = myRs.getString("Member_Status");
				rowData[row][6] = myRs.getString("Contact");
				rowData[row][7] = myRs.getString("Email");
				row++;
			}
			//createTable c = new createTable(1,list);
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);
//			return list;
			
		}
		finally { close(myStmt, myRs);}
	}
	public void AddMember(String userinput,String add,int send,String Cont,String em) throws Exception
	{
		
            String answer="Member Added Succesfully";
            
    		PreparedStatement myStmt = null;
    		ResultSet myRs = null;
    		try {
    	
    			if(send==1)
    			myStmt =  MyConnection.prepareStatement("insert into Members (Member_Name,Address,Member_Status,Contact,Email,Registered_Date,Expiry_Date) values (?,?,'Temporary',?,?,curdate(),date_add(curdate(), interval 2 year))");
    			else if(send==2)
    			myStmt =  MyConnection.prepareStatement("insert into Members (Member_Name,Address,Member_Status,Contact,Email,Registered_Date) values (?,?,'Permanent',?,?,curdate()");
    			
                myStmt.setString(1, userinput);
                myStmt.setString(2, add);
                myStmt.setString(3, Cont);
                myStmt.setString(4, em);
                 myStmt.executeUpdate();

    			
    			JOptionPane.showMessageDialog(frame,answer);
    			
    		}
    		finally { close(myStmt, myRs);}
			

	}
	

	public void updateMembers(Members theMembers) throws SQLException {
		PreparedStatement myStmt = null;

		try {
			// prepare statement
			myStmt = myConn.prepareStatement("update members"
					+ " set name=?, status=?, email=?, contact=?, address=?"
					+ " where id=?");
			
			// set params
			myStmt.setString(1, theMembers.getMember_Name());
			myStmt.setString(2, theMembers.getMember_Status());
			myStmt.setString(3, theMembers.getEmail());
			myStmt.setString(4, theMembers.getContact());
			myStmt.setString(5, theMembers.getAddress());
			
			// execute SQL
			myStmt.executeUpdate();			
		}
		finally {
			close(myStmt);
		}
		
	}
	
	public void AddStaff(String userinput,String em,String Cont,String add,int wh) throws SQLException
	{
		
            String answer="Staff Added Succesfully";
            
    		PreparedStatement myStmt = null;
    		ResultSet myRs = null;
    		try {
    	
    			myStmt =  MyConnection.prepareStatement("insert into Staff (Staff_Name,Email,Contact,Address,Working_Hours) values (?,?,?,?,?)");
    		
                myStmt.setString(1, userinput);
                myStmt.setString(2, em);
                myStmt.setString(3, Cont);
                myStmt.setString(4, add);
                myStmt.setInt(5, wh);
                 myStmt.executeUpdate();

    			
    			JOptionPane.showMessageDialog(frame,answer);
    			
    		}catch(SQLException e){
    			JOptionPane.showMessageDialog(frame,"Error");
    		}
    		finally { close(myStmt, myRs);}
			

	}
	public void AddBook(String userinput,String em,String Cont,String add,int wh) throws SQLException
	{
		
            String answer="Staff Added Succesfully";
            
    		PreparedStatement myStmt = null;
    		ResultSet myRs = null;
    		try {
    	
    			myStmt =  MyConnection.prepareStatement("insert into Staff (Staff_Name,Email,Contact,Address,Working_Hours) values (?,?,?,?,?)");
    		
                myStmt.setString(1, userinput);
                myStmt.setString(2, em);
                myStmt.setString(3, Cont);
                myStmt.setString(4, add);
                myStmt.setInt(5, wh);
                 myStmt.executeUpdate();

    			
    			JOptionPane.showMessageDialog(frame,answer);
    			
    		}catch(SQLException e){
    			JOptionPane.showMessageDialog(frame,"Error");
    		}
    		finally { close(myStmt, myRs);}
			

	}
	public void showBorrowed() throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select * from Borrowed");
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][5];
            Object columnNames[]={"Borrow ID","Borrow Status","Date Issued","Return Date","Date Returned"};
            int row=0;
			while(myRs.next())
			{
				rowData[row][0] = myRs.getString("Borrow_ID");
				rowData[row][1] = myRs.getString("Borrow_Status");
				rowData[row][2] = myRs.getString("Date_Issued");
				rowData[row][3] = myRs.getString("Return_Date");
				rowData[row][4] = myRs.getString("Date_Returned");
				
				row++;
			}
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);

			
		}
		finally { close(myStmt, myRs);}
	}
	
	public void showSupplier() throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select * from Supplier");
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][5];
            Object columnNames[]={"Supplier ID","Supplier Name","Address","Email","Contact"};
            int row=0;
			while(myRs.next())
			{
				rowData[row][0] = myRs.getString("Supplier_ID");
				rowData[row][1] = myRs.getString("Supplier_Name");
				rowData[row][2] = myRs.getString("Address");
				rowData[row][3] = myRs.getString("Email");
				rowData[row][4] = myRs.getString("Contact");
				
				row++;
			}
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);

			
		}
		finally { close(myStmt, myRs);}
	}
	public void showStaff() throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select * from Staff");
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][6];
            Object columnNames[]={"Staff ID","Staff Name","Working Hours","Email","Contact","Address"};
            int row=0;
			while(myRs.next())
			{
				rowData[row][0] = myRs.getString("Staff_ID");
				rowData[row][1] = myRs.getString("Staff_Name");
				rowData[row][2] = myRs.getString("Working_Hours");
				rowData[row][3] = myRs.getString("Email");
				rowData[row][4] = myRs.getString("Contact");
				rowData[row][5] = myRs.getString("Address");
				
				row++;
			}
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);

			
		}
		finally { close(myStmt, myRs);}
	}
	public void showFine() throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select * from Fine_Details");
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][6];
            Object columnNames[]={"Borrow ID","Fine Rate","Fine Amount"};
            int row=0;
			while(myRs.next())
			{
				rowData[row][0] = myRs.getString("Borrow_ID");
				rowData[row][1] = myRs.getString("Fine_Rate");
				rowData[row][2] = myRs.getString("Fine_Amount");
				
				row++;
			}
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);

			
		}
		finally { close(myStmt, myRs);}
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

	public void showBooks() throws Exception
	{
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
	
			
			myStmt =  MyConnection.prepareStatement("select * from Books");
            myRs = myStmt.executeQuery();
            Object[][] rowData = new Object[100][8];
            Object columnNames[]={"Book Code","Book Title","Arrival Date","Publication","Genre","Shelf Number","Author","Price"};
            int row=0;
			while(myRs.next())
			{
				rowData[row][0] = myRs.getString("Book_Code");
				rowData[row][1] = myRs.getString("Book_Title");
				rowData[row][2] = myRs.getString("Arrival_Date");
				rowData[row][3] = myRs.getString("Publication");
				rowData[row][4] = myRs.getString("Book_Genre");
				rowData[row][5] = myRs.getString("Shelf_Number");
				rowData[row][6] = myRs.getString("Author");
				rowData[row][7] = myRs.getString("Publication");
				row++;
			}
			//createTable c = new createTable(1,list);
			
			  table = new JTable(rowData, columnNames);
	          JScrollPane scrollPane = new JScrollPane(table);
	          frame.add(scrollPane, BorderLayout.CENTER);
	          frame.setSize(300, 150);
	          frame.setVisible(true);
//			return list;
			
		}
		finally { close(myStmt, myRs);}
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


	private void close(Statement myStmt, ResultSet myRs) throws SQLException {
		close(null, myStmt, myRs);		
	}

	private void close(Statement myStmt) throws SQLException {
		close(null, myStmt, null);		
	}


}


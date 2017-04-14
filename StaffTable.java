import java.util.*;
import javax.swing.table.*;

public class StaffTable extends AbstractTableModel {
	
	private static final int StaffIDCol = 0;
	private static final int ContactCol = 3;
	private static final int WorkingHoursCol = 2;
	private static final int StaffNameCol = 1;
	private static final int AddressCol = 4;
	private static final int EmailCol = 5;
//	private static final int ContactCol = 4;
//	private static final int WorkingHoursCol = 5;
//	private static final int BookGenreAssignedCol = 6;
//	
	private String[] ColumnNames = {"Staff ID","Staff Name", "Working Hours","Contact","Address","Email"};
//	private String[] ColumnNames = {"Staff ID","Staff Name","Address","Email","Contact", "Working Hours", "Book Genre Assigned"};
	
	private List<Staff> staff;
	
	public StaffTable(List<Staff> theStaff) {
		staff = theStaff;
	}

	public int getColumnCount(){
		return ColumnNames.length;
	}

	public int getRowCount() {
		return staff.size();
	}

	public String getColumnName(int col) {
		return ColumnNames[col];
	}

	public Object getValueAt(int row, int col) {

		Staff tempEmployee = staff.get(row);

		switch (col) {
		case StaffIDCol:
			return tempEmployee.getStaff_ID();
		case StaffNameCol:
			return tempEmployee.getStaff_Name();
		case AddressCol:
			return tempEmployee.getAddress();
		case WorkingHoursCol:
			return tempEmployee.getWorking_Hours();
		case ContactCol:
			return tempEmployee.getContact();
		case EmailCol:
			return tempEmployee.getEmail();
		
//		case BookGenreAssignedCol:
//			return tempEmployee.getBook_Genre_Assigned();
		default:
			return tempEmployee.getStaff_ID();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}


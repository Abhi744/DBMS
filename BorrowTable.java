import java.util.*;
import javax.swing.table.*;

public class BorrowTable extends AbstractTableModel {
	
	//private static final int BookCodeCol = 0;
	private static final int BorrowIDCol = 0;
	//private static final int MemberIDCol = 2;
	private static final int BorrowStatusCol = 1;
	private static final int DateIssuedCol = 2;
	private static final int DateReturnedCol = 3;
	private static final int ReturnDateCol = 4;
	
	private String[] ColumnNames = {"Borrow ID","Borrow Status","Date Issued","Date Returned","Return Date"};
	
	private List<Borrowed> borrowed;
	
	public BorrowTable(List<Borrowed> theBorrowed) {
		borrowed = theBorrowed;
	}

	public int getColumnCount(){
		return ColumnNames.length;
	}

	public int getRowCount() {
		return borrowed.size();
	}

	public String getColumnName(int col) {
		return ColumnNames[col];
	}

	public Object getValueAt(int row, int col) {

		Borrowed tempEmployee = borrowed.get(row);

		switch (col) {
		case BorrowIDCol:
			return tempEmployee.getBorrow_ID();
		case BorrowStatusCol:
			return tempEmployee.getBorrow_Status();
		case DateIssuedCol:
			return tempEmployee.getDate_Issued();
		case DateReturnedCol:
			return tempEmployee.getDate_Returned();
		case ReturnDateCol:
			return tempEmployee.getReturn_Date();
		default:
			return tempEmployee.getBorrow_ID();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}


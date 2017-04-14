import java.util.*;
import javax.swing.table.*;

public class MemberTable extends AbstractTableModel {
	
	private static final int MemberIDCol = 0;
	private static final int MemberNameCol = 1;
	private static final int MemberStatusCol = 2;
	private static final int AddressCol = 3;
	private static final int EmailCol = 4;
	private static final int ContactCol = 5;
	private static final int RegisteredDateCol= 6;
	private static final int ExpiryDateCol = 7;
	
	private String[] ColumnNames = {"Member ID","Member Name","Member Status","Address","Email","Contact","Expiry Date","Registered Date"};
	
	private List< Members > members;
	
	public MemberTable(List<Members> theMembers) {
		members = theMembers;
	}

	public int getColumnCount(){
		return ColumnNames.length;
	}

	public int getRowCount() {
		return members.size();
	}

	public String getColumnName(int col) {
		return ColumnNames[col];
	}

	public Object getValueAt(int row, int col) {

		Members tempEmployee = members.get(row);

		switch (col) {
		case MemberIDCol:
			return tempEmployee.getMember_ID();
		case MemberNameCol:
			return tempEmployee.getMember_Name();
		case MemberStatusCol:
			return tempEmployee.getMember_Status();
		case AddressCol:
			return tempEmployee.getAddress();
		case ContactCol:
			return tempEmployee.getContact();
		case EmailCol:
			return tempEmployee.getEmail();
		case RegisteredDateCol:
			return tempEmployee.getRegistered_Date();
		case ExpiryDateCol:
			return tempEmployee.getExpiry_Date();
		default:
			return tempEmployee.getMember_ID();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}

	
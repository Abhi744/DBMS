import java.util.*;
import javax.swing.table.*;

public class SupplierTable extends AbstractTableModel {
	
	private static final int SupplierIDCol = 0;
	private static final int SupplierNameCol = 1;
	private static final int AddressCol = 2;
	private static final int EmailCol = 3;
	private static final int ContactCol = 4;
	
	private String[] ColumnNames = {"Supplier ID","Supplier Name","Address","Email","Contact"};
	
	private List<Supplier> supplier;
	
	public SupplierTable(List<Supplier> theSupplier) {
		supplier = theSupplier;
	}

	public int getColumnCount(){
		return ColumnNames.length;
	}

	public int getRowCount() {
		return supplier.size();
	}

	public String getColumnName(int col) {
		return ColumnNames[col];
	}

	public Object getValueAt(int row, int col) {

		Supplier tempEmployee = supplier.get(row);

		switch (col) {
		case SupplierIDCol:
			return tempEmployee.getSupplier_ID();
		case SupplierNameCol:
			return tempEmployee.getSupplier_Name();
		case AddressCol:
			return tempEmployee.getAddress();
		case ContactCol:
			return tempEmployee.getContact();
		case EmailCol:
			return tempEmployee.getEmail();
		default:
			return tempEmployee.getSupplier_ID();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}


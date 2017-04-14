import java.util.*;
import javax.swing.table.*;

public class FineTable extends AbstractTableModel {
	
	private static final int BorrowIDCol = 0;
	private static final int FineRateCol = 1;
	private static final int FineAmountCol = 2;
	
	private String[] ColumnNames = {"Borrow ID","Fine Rate","Fine Amount"};
	
	private List<Fine> fine;
	
	public FineTable(List<Fine> theFine) {
		fine = theFine;
	}

	public int getColumnCount(){
		return ColumnNames.length;
	}

	public int getRowCount() {
		return fine.size();
	}

	public String getColumnName(int col) {
		return ColumnNames[col];
	}

	public Object getValueAt(int row, int col) {

		Fine tempEmployee = fine.get(row);

		switch (col) {
		case BorrowIDCol:
			return tempEmployee.getBorrow_ID();
		case FineRateCol:
			return tempEmployee.getFine_Rate();
		case FineAmountCol:
			return tempEmployee.getFine_Amount();
		default:
			return tempEmployee.getBorrow_ID();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}


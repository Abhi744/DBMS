import java.util.*;
import javax.swing.table.*;

public class BookTable extends AbstractTableModel {
	
	private static final int BookCodeCol = 0;
	private static final int BookTitleCol = 1;
	private static final int AuthorCol = 2;
	private static final int PublisherCol = 3;
	private static final int BookGenreCol = 4;
	private static final int ArrivalDateCol = 5;
	private static final int ShelfNumberCol = 6;
	
	private String[] ColumnNames = {"Book Code","Book Title","Author","Publication","Genre","Arrival Date","Shelf Number"};
	
	private List<Books> books;
	
	public BookTable(List<Books> theBooks) {
		books = theBooks;
	}

	public int getColumnCount(){
		return ColumnNames.length;
	}

	public int getRowCount() {
		return books.size();
	}

	public String getColumnName(int col) {
		return ColumnNames[col];
	}

	public Object getValueAt(int row, int col) {

		Books tempEmployee = books.get(row);

		switch (col) {
		case BookCodeCol:
			return tempEmployee.getBook_Code();
		case BookTitleCol:
			return tempEmployee.getBook_Title();
		case AuthorCol:
			return tempEmployee.getAuthor();
		case PublisherCol:
			return tempEmployee.getPublication();
		case BookGenreCol:
			return tempEmployee.getBook_Genre();
		case ArrivalDateCol:
			return tempEmployee.getArrivalDate();
		case ShelfNumberCol:
			return tempEmployee.getShelf_Number();
		default:
			return tempEmployee.getBook_Code();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class All_Books extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	private LibraryManagementSystemDAO lmsDAO;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					All_Books frame = new All_Books();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public All_Books() {
		try {
			lmsDAO = new LibraryManagementSystemDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		setTitle("Books");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblEnterBookTitle = new JLabel("Enter Book Title");
		panel.add(lblEnterBookTitle);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);
		
		JButton btnGo = new JButton("Go!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String Book_Title = textField.getText();
					List<Books> books = null;
					
					if(Book_Title !=null && Book_Title.trim().length()>0)
					{
						books = lmsDAO.searchBooks(Book_Title);
					}
					else
					{
						books = lmsDAO.getAllBooks();
					}
					BookTable model = new BookTable(books);
					
					table.setModel(model);
					
//					for(Books temp : books)
//					{
//						System.out.println(temp);
//					}
				}catch(Exception exc)
				{
					JOptionPane.showMessageDialog(All_Books. this,"Error:"+exc,"Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel.add(btnGo);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAddBook = new JButton("Add Book");
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create dialog
				AddBookDialog dialog = new AddBookDialog(All_Books.this, lmsDAO);

				// show dialog
				dialog.setVisible(true);
			}
		});
		panel_1.add(btnAddBook);
		
		JButton btnDeleteBook = new JButton("Delete Book");
		panel_1.add(btnDeleteBook);
		
		JButton btnUpdateBook = new JButton("Update Book");
		panel_1.add(btnUpdateBook);
	}

	public void refreshBooksView() {

		try {
			List<Books> employees = lmsDAO.getAllBooks();

			// create the model and update the "table"
			BookTable model = new BookTable(employees);

			table.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	}



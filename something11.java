import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class something11 extends JFrame {

	private JPanel contentPane;
	
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					something11 frame = new something11();
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
	public something11() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Books");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				LibraryManagementSystemDAO lms = new LibraryManagementSystemDAO();
					lms.showBooks();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnAddBooks);
		
		JButton btnDeleteBooks = new JButton("Delete Books");
		btnDeleteBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnDeleteBooks);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton_1 = new JButton("Staff");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LibraryManagementSystemDAO lms = new LibraryManagementSystemDAO();
						lms.showStaff();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_6 = new JButton("Add Staff");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					addStaffForm form = new addStaffForm();
					 form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					form.setVisible(true);
			
			}
		});
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Delete Staff");
		panel_1.add(btnNewButton_7);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton btnNewButton_2 = new JButton("Supplier");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LibraryManagementSystemDAO lms = new LibraryManagementSystemDAO();
						lms.showSupplier();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel_2.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel_2.add(btnNewButton_9);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnNewButton_3 = new JButton("Borrowed Books");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LibraryManagementSystemDAO lms = new LibraryManagementSystemDAO();
						lms.showBorrowed();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
		panel_3.add(btnNewButton_3);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel_3.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("New button");
		panel_3.add(btnNewButton_11);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnNewButton_4 = new JButton("Fine Details");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LibraryManagementSystemDAO lms = new LibraryManagementSystemDAO();
						lms.showFine();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		panel_4.add(btnNewButton_4);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		
		JButton btnNewButton_5 = new JButton("Members");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					LibraryManagementSystemDAO lms = new LibraryManagementSystemDAO();
						lms.showMembers();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		panel_5.add(btnNewButton_5);
		
		JButton btnNewButton_12 = new JButton("Add Member");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addMemForm form = new addMemForm();
				 form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				form.setVisible(true);
			}
		});
		
		panel_5.add(btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("Delete Member");
		panel_5.add(btnNewButton_13);
	}

}

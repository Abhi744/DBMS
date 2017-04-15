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


public class All_Members extends JFrame {

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
					All_Members frame = new All_Members();
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
	public All_Members() {
		try {
			lmsDAO = new LibraryManagementSystemDAO();
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error", JOptionPane.ERROR_MESSAGE); 
		}
		setTitle("Members");
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
		
		JLabel lblEnterMemberTitle = new JLabel("Enter Member Name");
		panel.add(lblEnterMemberTitle);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);
		
		JButton btnGo = new JButton("Go!");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{
					String Member_Name = textField.getText();
					List<Members> members = null;
					
					if(Member_Name !=null && Member_Name.trim().length()>0)
					{
						members = lmsDAO.searchMembers(Member_Name);
					}
					else
					{
						members = lmsDAO.getAllMembers();
					}
					MemberTable model= new MemberTable(members);
					
					table.setModel(model);
					
//					for(Members temp : books)
//					{
//						System.out.println(temp);
//					}
				}catch(Exception exc)
				{
					JOptionPane.showMessageDialog(All_Members. this,"Error:"+exc,"Error",JOptionPane.ERROR_MESSAGE);
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
		
		JButton btnAddMember = new JButton("Add Member");
		btnAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create dialog
				AddMemberDialog dialog = new AddMemberDialog(All_Members.this, lmsDAO);

				// show dialog
				dialog.setVisible(true);
			}
		});
		panel_1.add(btnAddMember);
		
		JButton btnDeleteMember = new JButton("Delete Member");
		panel_1.add(btnDeleteMember);
		
		JButton btnUpdateMember = new JButton("Update Member");
		panel_1.add(btnUpdateMember);
	}

	public void refreshMembersView() {

		try {
			List<Members> employees = lmsDAO.getAllMembers();

			// create the model and update the "table"
			MemberTable model = new MemberTable(employees);

			table.setModel(model);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(this, "Error: " + exc, "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	}



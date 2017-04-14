import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;


public class AddMembers extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	private LibraryManagementSystemDAO membersDAO;
	
	private MemberSearchApp membersSearchApp;
	
	public AddMembers(MemberSearchApp theMembersSearchApp,LibraryManagementSystemDAO theLibraryManagementSystemDAO){
		this();
		membersDAO = theLibraryManagementSystemDAO;
		membersSearchApp = theMembersSearchApp;
	}

	/**
	 * Create the dialog.
	 */
	public AddMembers() {
		setTitle("Add Members");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("Name");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 2;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblMemberstatus = new JLabel("Member_Status");
			GridBagConstraints gbc_lblMemberstatus = new GridBagConstraints();
			gbc_lblMemberstatus.insets = new Insets(0, 0, 5, 5);
			gbc_lblMemberstatus.gridx = 1;
			gbc_lblMemberstatus.gridy = 4;
			contentPanel.add(lblMemberstatus, gbc_lblMemberstatus);
		}
		{
			textField_5 = new JTextField();
			GridBagConstraints gbc_textField_5 = new GridBagConstraints();
			gbc_textField_5.insets = new Insets(0, 0, 5, 0);
			gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_5.gridx = 2;
			gbc_textField_5.gridy = 4;
			contentPanel.add(textField_5, gbc_textField_5);
			textField_5.setColumns(10);
		}
		{
			JLabel lblAddress = new JLabel("Address");
			GridBagConstraints gbc_lblAddress = new GridBagConstraints();
			gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
			gbc_lblAddress.gridx = 1;
			gbc_lblAddress.gridy = 7;
			contentPanel.add(lblAddress, gbc_lblAddress);
		}
		{
			textField_4 = new JTextField();
			GridBagConstraints gbc_textField_4 = new GridBagConstraints();
			gbc_textField_4.insets = new Insets(0, 0, 5, 0);
			gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_4.gridx = 2;
			gbc_textField_4.gridy = 7;
			contentPanel.add(textField_4, gbc_textField_4);
			textField_4.setColumns(10);
		}
		{
			JLabel lblContact = new JLabel("Contact");
			GridBagConstraints gbc_lblContact = new GridBagConstraints();
			gbc_lblContact.insets = new Insets(0, 0, 5, 5);
			gbc_lblContact.gridx = 1;
			gbc_lblContact.gridy = 10;
			contentPanel.add(lblContact, gbc_lblContact);
		}
		
		{
			textField_6 = new JTextField();
			GridBagConstraints gbc_textField_6 = new GridBagConstraints();
			gbc_textField_6.insets = new Insets(0, 0, 5, 0);
			gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_6.gridx = 2;
			gbc_textField_6.gridy = 10;
			contentPanel.add(textField_6, gbc_textField_6);
			textField_6.setColumns(10);
		}
	
		{
			JLabel lblEmail = new JLabel("Email");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
			gbc_lblEmail.gridx = 1;
			gbc_lblEmail.gridy = 14;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			textField_3 = new JTextField();
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_3.gridx = 2;
			gbc_textField_3.gridy = 14;
			contentPanel.add(textField_3, gbc_textField_3);
			textField_3.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						saveMembers();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	protected void saveMembers(){
		// get the employee info from gui
				String name = textField.getText();
				String email = textField_3.getText();
				String memberstatus = textField_4.getText();
				String address = textField_5.getText();
				String contact = textField_6.getText();


				java.util.Date date = new java.util.Date();
			


//				Members tempEmployee = new Members(1,name,memberstatus, address, email,contact,date);
				
				try {
					// save to the database
					membersDAO.addMembers(name,email,memberstatus,address,contact);

					// close dialog
					setVisible(false);
					dispose();

					// refresh gui list
					membersSearchApp.refreshMemberssView();
					
					// show success message
					JOptionPane.showMessageDialog(membersSearchApp,"Member added succesfully.","Member Added",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception exc) {
					JOptionPane.showMessageDialog(membersSearchApp,"Error saving member: "+ exc.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
				}
	}

}

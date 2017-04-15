import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateMembers extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nametextField;
	private JTextField statustextField;
	private JTextField addresstextfield;
	private JTextField emailtextfield;
	private JTextField contacttextfield;

	private Employee previousEmployee = null;
	private boolean updateMode = false;

	public UpdateMembers(MemberSearchApp theMemberSearchApp,
			LibraryManagementSystemDAO theLibraryManagementSystemDAO, Members thePreviousMembers, boolean theUpdateMode) {
		this();
		membersDAO = theMembersDAO;
		MemberSearchApp = theMemberSearchApp;

		previousMembers = thePreviousMembers;
		
		updateMode = theUpdateMode;

		if (updateMode) {
			setTitle("Update Members");
			
			populateGui(previousMembers);
		}
	}

	private void populateGui(Members theMembers) {

		nametextField.setText(theMembers.getMember_Name());
		statustextField.setText(theMembers.getMember_Status());
		addresstextfield.setText(theMembers.getAddress());
		emailtextfield.setText(theMembers.getEmail());
		contacttextfield.setText(theMembers.getContact());
	}

	public UpdateMembers(MemberSearchApp theMemberSearchApp,
			LibraryManagementSystemDAO theLibraryManagementSystemDAO) {
		this(theMemberSearchApp, theLibraryManagementSystemDAO, null, false);
	}
	/**
	 * Create the dialog.
	 */
	public UpdateMembers() {
		setBounds(100, 100, 450, 300);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{265, 35, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagConstraints gbc_contentPanel = new GridBagConstraints();
		gbc_contentPanel.fill = GridBagConstraints.BOTH;
		gbc_contentPanel.insets = new Insets(0, 0, 5, 0);
		gbc_contentPanel.gridx = 0;
		gbc_contentPanel.gridy = 0;
		getContentPane().add(contentPanel, gbc_contentPanel);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblMemberName = new JLabel("Member Name");
			GridBagConstraints gbc_lblMemberName = new GridBagConstraints();
			gbc_lblMemberName.insets = new Insets(0, 0, 5, 5);
			gbc_lblMemberName.anchor = GridBagConstraints.EAST;
			gbc_lblMemberName.gridx = 0;
			gbc_lblMemberName.gridy = 1;
			contentPanel.add(lblMemberName, gbc_lblMemberName);
		}
		{
			nametextField = new JTextField();
			GridBagConstraints gbc_nametextField = new GridBagConstraints();
			gbc_nametextField.insets = new Insets(0, 0, 5, 0);
			gbc_nametextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_nametextField.gridx = 1;
			gbc_nametextField.gridy = 1;
			contentPanel.add(nametextField, gbc_nametextField);
			nametextField.setColumns(10);
		}
		{
			JLabel lblMemberStatus = new JLabel("Member Status");
			GridBagConstraints gbc_lblMemberStatus = new GridBagConstraints();
			gbc_lblMemberStatus.anchor = GridBagConstraints.EAST;
			gbc_lblMemberStatus.insets = new Insets(0, 0, 5, 5);
			gbc_lblMemberStatus.gridx = 0;
			gbc_lblMemberStatus.gridy = 2;
			contentPanel.add(lblMemberStatus, gbc_lblMemberStatus);
		}
		{
			statustextField = new JTextField();
			GridBagConstraints gbc_statustextField = new GridBagConstraints();
			gbc_statustextField.insets = new Insets(0, 0, 5, 0);
			gbc_statustextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_statustextField.gridx = 1;
			gbc_statustextField.gridy = 2;
			contentPanel.add(statustextField, gbc_statustextField);
			statustextField.setColumns(10);
		}
		{
			JLabel lblAddress = new JLabel("Address");
			GridBagConstraints gbc_lblAddress = new GridBagConstraints();
			gbc_lblAddress.anchor = GridBagConstraints.EAST;
			gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
			gbc_lblAddress.gridx = 0;
			gbc_lblAddress.gridy = 3;
			contentPanel.add(lblAddress, gbc_lblAddress);
		}
		{
			addresstextfield = new JTextField();
			GridBagConstraints gbc_addresstextfield = new GridBagConstraints();
			gbc_addresstextfield.insets = new Insets(0, 0, 5, 0);
			gbc_addresstextfield.fill = GridBagConstraints.HORIZONTAL;
			gbc_addresstextfield.gridx = 1;
			gbc_addresstextfield.gridy = 3;
			contentPanel.add(addresstextfield, gbc_addresstextfield);
			addresstextfield.setColumns(10);
		}
		{
			JLabel lblEmail = new JLabel("Email");
			GridBagConstraints gbc_lblEmail = new GridBagConstraints();
			gbc_lblEmail.anchor = GridBagConstraints.EAST;
			gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
			gbc_lblEmail.gridx = 0;
			gbc_lblEmail.gridy = 4;
			contentPanel.add(lblEmail, gbc_lblEmail);
		}
		{
			emailtextfield = new JTextField();
			GridBagConstraints gbc_emailtextfield = new GridBagConstraints();
			gbc_emailtextfield.insets = new Insets(0, 0, 5, 0);
			gbc_emailtextfield.fill = GridBagConstraints.HORIZONTAL;
			gbc_emailtextfield.gridx = 1;
			gbc_emailtextfield.gridy = 4;
			contentPanel.add(emailtextfield, gbc_emailtextfield);
			emailtextfield.setColumns(10);
		}
		{
			JLabel lblContact = new JLabel("Contact");
			GridBagConstraints gbc_lblContact = new GridBagConstraints();
			gbc_lblContact.anchor = GridBagConstraints.EAST;
			gbc_lblContact.insets = new Insets(0, 0, 5, 5);
			gbc_lblContact.gridx = 0;
			gbc_lblContact.gridy = 5;
			contentPanel.add(lblContact, gbc_lblContact);
		}
		{
			contacttextfield = new JTextField();
			GridBagConstraints gbc_contacttextfield = new GridBagConstraints();
			gbc_contacttextfield.insets = new Insets(0, 0, 5, 0);
			gbc_contacttextfield.fill = GridBagConstraints.HORIZONTAL;
			gbc_contacttextfield.gridx = 1;
			gbc_contacttextfield.gridy = 5;
			contentPanel.add(contacttextfield, gbc_contacttextfield);
			contacttextfield.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPane = new GridBagConstraints();
			gbc_buttonPane.anchor = GridBagConstraints.NORTH;
			gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
			gbc_buttonPane.gridx = 0;
			gbc_buttonPane.gridy = 1;
			getContentPane().add(buttonPane, gbc_buttonPane);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
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
		
		protected void saveEmployee() {

			// get the employee info from gui
			String Member_Name = nametextField.getText();
			String Member_Status = statustextField.getText();
			String Address = addresstextfield.getText();
			String Email = emailtextfield.getText();
			String Contact = contacttextfield.getText();

			Members tempMembers = null;

			if (updateMode) {
				tempMembers = previousMembers;
				
				tempMembers.setMember_Status(Member_Status);
				tempMembers.setMember_Name(Member_Name);
				tempMembers.setAddress(Address);
				tempMembers.setEmail(Email);
				tempMembers.setContact(Contact);
				
			} else {
				tempMembers = new Members(Member_Status, Member_Name, Address, Email, Contact);
			}

			try {
				// save to the database
				if (updateMode) {
					LibraryManagementSystemDAO.updateEmployee(tempMembers);
				} else {
					LibraryManagementSystemDAO.addMembers(tempMembers);
				}

				// close dialog
				setVisible(false);
				dispose();

				// refresh gui list
				MemberSearchApp.refreshMembersView();

				// show success message
				JOptionPane.showMessageDialog(MemberSearchApp,
						"Employee saved succesfully.", "Members Saved",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception exc) {
				JOptionPane.showMessageDialog(MemberSearchApp,
						"Error saving Members: " + exc.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}
}
	



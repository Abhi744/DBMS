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
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddMemberDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private LibraryManagementSystemDAO lmsDAO;

	private All_Members bookapp;
	/**
	 * Launch the application.
	 */
	public AddMemberDialog(All_Members theMembersSearchApp, LibraryManagementSystemDAO theMembersDAO) {
		this();
		theMembersDAO = theMembersDAO;
		theMembersSearchApp = theMembersSearchApp;
	}
	/**
	 * Create the dialog.
	 */
	public AddMemberDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblMemberTitle = new JLabel("Member Title ");
			GridBagConstraints gbc_lblMemberTitle = new GridBagConstraints();
			gbc_lblMemberTitle.insets = new Insets(0, 0, 5, 5);
			gbc_lblMemberTitle.gridx = 0;
			gbc_lblMemberTitle.gridy = 0;
			contentPanel.add(lblMemberTitle, gbc_lblMemberTitle);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 1;
			gbc_textField.gridy = 0;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblAuthor = new JLabel("Author");
			GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
			gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
			gbc_lblAuthor.gridx = 0;
			gbc_lblAuthor.gridy = 1;
			contentPanel.add(lblAuthor, gbc_lblAuthor);
		}
		{
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 1;
			gbc_textField_1.gridy = 1;
			contentPanel.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblPublication = new JLabel("Publication");
			GridBagConstraints gbc_lblPublication = new GridBagConstraints();
			gbc_lblPublication.anchor = GridBagConstraints.EAST;
			gbc_lblPublication.insets = new Insets(0, 0, 5, 5);
			gbc_lblPublication.gridx = 0;
			gbc_lblPublication.gridy = 2;
			contentPanel.add(lblPublication, gbc_lblPublication);
		}
		{
			textField_2 = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 1;
			gbc_textField_2.gridy = 2;
			contentPanel.add(textField_2, gbc_textField_2);
			textField_2.setColumns(10);
		}
		{
			JLabel lblNewLabel = new JLabel("Shelf Number");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 3;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			textField_3 = new JTextField();
			GridBagConstraints gbc_textField_3 = new GridBagConstraints();
			gbc_textField_3.insets = new Insets(0, 0, 5, 0);
			gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_3.gridx = 1;
			gbc_textField_3.gridy = 3;
			contentPanel.add(textField_3, gbc_textField_3);
			textField_3.setColumns(10);
		}
		{
			JLabel lblMemberGenre = new JLabel("Member Genre");
			GridBagConstraints gbc_lblMemberGenre = new GridBagConstraints();
			gbc_lblMemberGenre.anchor = GridBagConstraints.EAST;
			gbc_lblMemberGenre.insets = new Insets(0, 0, 0, 5);
			gbc_lblMemberGenre.gridx = 0;
			gbc_lblMemberGenre.gridy = 4;
			contentPanel.add(lblMemberGenre, gbc_lblMemberGenre);
		}
		{
			textField_4 = new JTextField();
			GridBagConstraints gbc_textField_4 = new GridBagConstraints();
			gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_4.gridx = 1;
			gbc_textField_4.gridy = 4;
			contentPanel.add(textField_4, gbc_textField_4);
			textField_4.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {	
						saveMember();
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
	protected void saveMember() {

		String title = textField.getText();
		String author = textField_1.getText();
		String pub = textField_2.getText();
		String genre = textField_4.getText();
		int jml = Integer.parseInt(textField_3.getText());
		 Date dNow = new Date( );
	     
		//Members tempEmployee = new Members(jml,title ,author, pub, genre,genre,dNow, dNow);

		try {
			// save to the database
			//lmsDAO.addMembers(tempEmployee);

			// close dialog
			setVisible(false);
			dispose();

			// refresh gui list
			bookapp.refreshMembersView();
			
			// show success message
			JOptionPane.showMessageDialog(bookapp,"Members added succesfully.","Members Added",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(
					bookapp,
					"Error saving book: "+ exc.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}

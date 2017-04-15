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


public class AddBookDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private LibraryManagementSystemDAO lmsDAO;

	private All_Books bookapp;
	/**
	 * Launch the application.
	 */
	public AddBookDialog(All_Books theBooksSearchApp, LibraryManagementSystemDAO theBooksDAO) {
		this();
		theBooksDAO = theBooksDAO;
		theBooksSearchApp = theBooksSearchApp;
	}
	/**
	 * Create the dialog.
	 */
	public AddBookDialog() {
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
			JLabel lblBookTitle = new JLabel("Book Title ");
			GridBagConstraints gbc_lblBookTitle = new GridBagConstraints();
			gbc_lblBookTitle.insets = new Insets(0, 0, 5, 5);
			gbc_lblBookTitle.gridx = 0;
			gbc_lblBookTitle.gridy = 0;
			contentPanel.add(lblBookTitle, gbc_lblBookTitle);
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
			JLabel lblBookGenre = new JLabel("Book Genre");
			GridBagConstraints gbc_lblBookGenre = new GridBagConstraints();
			gbc_lblBookGenre.anchor = GridBagConstraints.EAST;
			gbc_lblBookGenre.insets = new Insets(0, 0, 0, 5);
			gbc_lblBookGenre.gridx = 0;
			gbc_lblBookGenre.gridy = 4;
			contentPanel.add(lblBookGenre, gbc_lblBookGenre);
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
						saveBook();
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
	protected void saveBook() {

		String title = textField.getText();
		String author = textField_1.getText();
		String pub = textField_2.getText();
		String genre = textField_4.getText();
		int jml = Integer.parseInt(textField_3.getText());
		 Date dNow = new Date( );
	     
		Books tempEmployee = new Books(1,jml,title,pub,genre,author,dNow);

		try {
			// save to the database
			lmsDAO.addBooks(tempEmployee);

			// close dialog
			setVisible(false);
			dispose();

			// refresh gui list
			bookapp.refreshBooksView();
			
			// show success message
			JOptionPane.showMessageDialog(bookapp,"Books added succesfully.","Books Added",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception exc) {
			JOptionPane.showMessageDialog(
					bookapp,
					"Error saving book: "+ exc.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class something extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField;
    private JTextField textField_1;
    public int send;
    /**
     * Launch the application.
     */

    /**
     * Create the dialog.
     */
    public something() {
        // LibraryManagementSystem dao;
    	
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        {
            ButtonGroup group = new ButtonGroup();
            JPanel panel = new JPanel();
            contentPanel.add(panel);
            {
                JLabel lblSearchBy = new JLabel("Search By");
                panel.add(lblSearchBy);
            }
            {
                JRadioButton rdbtnTitle = new JRadioButton("Publication");
                rdbtnTitle.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        send =1;
                    }
                });
                group.add(rdbtnTitle);
                panel.add(rdbtnTitle);
            }
            {
                JRadioButton rdbtnAuthor = new JRadioButton("Author");
                rdbtnAuthor.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        send=2;
                    }
                });
                group.add(rdbtnAuthor);
                panel.add(rdbtnAuthor);
            }
            {
                JRadioButton rdbtnGenre = new JRadioButton("Genre");
                rdbtnGenre.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        send =3;
                    }
                });
                group.add(rdbtnGenre);
                panel.add(rdbtnGenre);
            }
            
            {
                textField = new JTextField();
                panel.add(textField);
                textField.setColumns(10);
                
            }
        }
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel);
            {
                JLabel lblEnterMemberAddress = new JLabel("Enter Member Address");
                panel.add(lblEnterMemberAddress);
            }
            {
                textField_1 = new JTextField();
                panel.add(textField_1);
                textField_1.setColumns(10);
            }
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("Search");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        try {
							LibraryManagementSystemDAO lms = new LibraryManagementSystemDAO();
							lms.query1(send, textField.getText(),textField_1.getText());
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                });
                okButton.setActionCommand("Search");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancel");
                buttonPane.add(cancelButton);
            }
        }
    }

}
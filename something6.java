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

public class something6 extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private JTextField textField_2;
    private JTextField textField_1;
    public int send;
    /**
     * Launch the application.
     */
   

    /**
     * Create the dialog.
     */
    public something6() {
        // LibraryManagementSystem dao;
    	
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        {
            
            JPanel panel = new JPanel();
            contentPanel.add(panel);
           
        }
        {
            JPanel panel = new JPanel();
            contentPanel.add(panel);
            {
                JLabel lblEnterMemberAddress = new JLabel("Enter Price (Less than)");
                panel.add(lblEnterMemberAddress);
            }
            {
                textField_1 = new JTextField();
                panel.add(textField_1);
                textField_1.setColumns(10);
            }
            {
                JLabel lblEnterMemberAddress = new JLabel("Enter Numble (Book Borrowed Atleast)");
                panel.add(lblEnterMemberAddress);
            }
            {
                textField_2 = new JTextField();
                panel.add(textField_2);
                textField_2.setColumns(10);
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
							lms.query7(Integer.parseInt(textField_1.getText()),Integer.parseInt(textField_2.getText()));
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
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SearchBooks extends JFrame {

	private JPanel contentPane;
	 String hey="Nothing";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBooks frame = new SearchBooks();
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
	public SearchBooks() {
		getContentPane().setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblSearchBy = new JLabel("Search By");
		panel.add(lblSearchBy);
		
		
		String[] options = {"Book Title","Author","Genre","Sheld Number","Publication"};
		final JComboBox comboBox = new JComboBox(options);
		JButton btnGo = new JButton("Go!");
		
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				{EventQueue.invokeLater(new Runnable() {
					
					public void run() {
						
						try {
							String s = comboBox.getSelectedItem().toString();
							if(s=="Book Title")
							{All_Books frame1 = new All_Books();
							frame1.setVisible(true);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});}
			}
		});
		panel.add(comboBox);
		panel.add(btnGo);
		
		
		
	}

}

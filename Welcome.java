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


public class Welcome extends JFrame {

	private JPanel contentPane;
	LibraryManagementSystemDAO dao;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome frame = new Welcome();
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
	public Welcome() {
		
		try {
			dao = new LibraryManagementSystemDAO();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnNewButton = new JButton("Query 1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					something s = new something();
					s.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			        s.setVisible(true);
				}
		});
		panel.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		
		JButton btnNewButton_1 = new JButton("Query 2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				something1 s = new something1();
				 s.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		            s.setVisible(true);
			}
		});
		panel_2.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		JButton btnNewButton_2 = new JButton("Query 3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				something2 s = new something2();
				s.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		        s.setVisible(true);
			}
		});
		panel_1.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3);
		
		JButton btnNewButton_3 = new JButton("Query 4");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				something3 s = new something3();
				s.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		        s.setVisible(true);
			}
		});
		panel_3.add(btnNewButton_3);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4);
		
		JButton btnNewButton_4 = new JButton("Query 5");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				something4 s = new something4();
				s.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		        s.setVisible(true);
			}
		});
		panel_4.add(btnNewButton_4);
		
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5);
		
		JButton btnNewButton_5 = new JButton("Query 6");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dao.query6();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel_5.add(btnNewButton_5);
		
		JPanel panel_6 = new JPanel();
		contentPane.add(panel_6);
		
		JButton btnNewButton_6 = new JButton("Query 7");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				something6 s = new something6();
				s.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		        s.setVisible(true);
				
			}
		});
		panel_6.add(btnNewButton_6);
		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7);
		
		JButton btnNewButton_7 = new JButton("Query 8");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				All_Staff staff = new All_Staff();
				staff.setVisible(true);
			}
		});
		panel_7.add(btnNewButton_7);
		
		JPanel panel_8 = new JPanel();
		contentPane.add(panel_8);
		
		JButton btnNewButton_8 = new JButton("Query 9");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				something8 s = new something8();
				 s.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		            s.setVisible(true);
			}
		});
		panel_8.add(btnNewButton_8);
		
		JPanel panel_9 = new JPanel();
		contentPane.add(panel_9);
		
		JButton btnNewButton_9 = new JButton("Query 10");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				something9 s = new something9();
				 s.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		            s.setVisible(true);
			}
		});
		panel_9.add(btnNewButton_9);
		
		JPanel panel_10 = new JPanel();
		contentPane.add(panel_10);
		
		JButton btnNewButton_10 = new JButton("Tables");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				something11 s = new something11();
				s.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				s.setVisible(true);
			}
		});
		panel_10.add(btnNewButton_10);
	}

}

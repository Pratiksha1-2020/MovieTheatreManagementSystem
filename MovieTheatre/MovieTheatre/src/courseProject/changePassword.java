package courseProject;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class changePassword extends JFrame {

	static JFrame frame1;
	static JFrame errorFrame;
	private JPanel contentPane;
	private JTextField TF_rePass;
	private JTextField TF_Pass;
	static Connection con;
	static ResultSet rs ;
	static PreparedStatement stmt;
	static String newPass_entered="";
	static String rePass_entered= "";
	static changePassword framec;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
								
				//login frame call
				try {
					framec = new changePassword();
					framec.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public changePassword() {
		
		// object
		LogIN lobj=new LogIN();
		forgottenPassword fobj=new forgottenPassword();
		
		//database connection
		try {

			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
			
			
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(frame1, e.getMessage());
        }
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 593, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel rePass = new JLabel("Re-Enter Password");
		rePass.setFont(new Font("Calibri", Font.BOLD, 22));
		rePass.setBounds(43, 171, 182, 30);
		contentPane.add(rePass);
		
		JLabel Password = new JLabel("New Password");
		Password.setFont(new Font("Calibri", Font.BOLD, 22));
		Password.setBounds(42, 115, 147, 30);
		contentPane.add(Password);
		
		JLabel lblNewLabel = new JLabel("Change Password");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(207, 11, 193, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the new password and confirm it.");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(178, 52, 250, 30);
		contentPane.add(lblNewLabel_1);
		
		TF_rePass = new JTextField();
		TF_rePass.setFont(new Font("Calibri", Font.PLAIN, 14));
		TF_rePass.setBounds(261, 171, 256, 30);
		contentPane.add(TF_rePass);
		TF_rePass.setColumns(10);
		
		TF_Pass = new JTextField();
		TF_Pass.setFont(new Font("Calibri", Font.PLAIN, 14));
		TF_Pass.setColumns(10);
		TF_Pass.setBounds(261, 115, 256, 30);
		contentPane.add(TF_Pass);
		
		JButton change_1 = new JButton("Change");
		change_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//taking data from the frame 
				//String UserName = fobj.Username_entered;
				
				newPass_entered= TF_Pass.getText();
				rePass_entered=TF_rePass.getText();
				
				
				if (newPass_entered.equals(rePass_entered))
				{
					try {
						
						String query = "UPDATE movietheater.login SET Password = '"+newPass_entered+"' WHERE Username = '"+forgottenPassword.Username_entered+"';";
						stmt = con.prepareStatement(query);
						stmt.executeUpdate() ;
						
						//call to login
						framec.setVisible(false);
				        new LogIN().setVisible(true);
				        
				        
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(errorFrame, "Password Mismatch");
				}
							
			}
		});
		change_1.setFont(new Font("Calibri", Font.BOLD, 21));
		change_1.setBounds(220, 250, 117, 35);
		contentPane.add(change_1);
	}
}

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

public class forgottenPassword extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JFrame frame1;
	static JFrame errorFrame;
	private JPanel contentPane;
	private JTextField textField_Username;
	private JTextField num;
	static Connection conn;
	static ResultSet rs ;
	static Statement stmt;
	static String Username_entered="";
	static String Num_entered= "";
	static String userCheck="";
	long numCheck;
	int flag=0;
	static forgottenPassword frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				
				
				
				
				//login frame call
				try {
					frame = new forgottenPassword();
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
	public forgottenPassword() {
		
		LogIN obj=new LogIN();
		//database connection
		try {

			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
			
			
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(frame1, e.getMessage());
        }
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Calibri", Font.BOLD, 22));
		Username.setBounds(42, 106, 112, 30);
		contentPane.add(Username);
		
		JLabel number = new JLabel("Mobile Number");
		number.setFont(new Font("Calibri", Font.BOLD, 22));
		number.setBounds(42, 166, 154, 30);
		contentPane.add(number);
		
		JLabel lblNewLabel_1 = new JLabel("Enter your username and mobile number for confirmation");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 17));
		lblNewLabel_1.setBounds(42, 29, 417, 39);
		contentPane.add(lblNewLabel_1);
		
		textField_Username = new JTextField();
		textField_Username.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_Username.setBounds(206, 107, 222, 30);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);
		
		num = new JTextField();
		num.setFont(new Font("Calibri", Font.PLAIN, 14));
		num.setColumns(10);
		num.setBounds(206, 167, 222, 30);
		contentPane.add(num);
		
		JButton confirm = new JButton("Confirm");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//taking data from the login frame 
				 Username_entered=textField_Username.getText();
				 Num_entered= num.getText();
				 
				// comparing with data in data base
				try {
					stmt = conn.createStatement();
				
				int found=0;
				
				
				String query = "SELECT * FROM movietheater.user Where Username ='"+Username_entered+"';" ;
				rs = stmt.executeQuery(query) ;
				
				if(rs.next())
				{
					numCheck= rs.getLong("Phone");
					long num1=Long.valueOf(Num_entered);
					
						if(num1==numCheck)
						{
							//call to change password
							//frame.setVisible(false);
							changePassword.framec=new changePassword();
							changePassword.framec.setVisible(true);
						}
						else
						{
							flag++;
							JOptionPane.showMessageDialog(errorFrame, "Incorrect Details");
						}
						
				}
				else
				{
					JOptionPane.showMessageDialog(errorFrame, "Incorrect Details");
				}
						
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		confirm.setFont(new Font("Calibri", Font.BOLD, 18));
		confirm.setBounds(183, 232, 103, 30);
		contentPane.add(confirm);
	}
}

package courseProject;
import java.sql.*;


/*
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
*/

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class LogIN extends JFrame {

	
	private static final long serialVersionUID = 1L;
	static JFrame frame1;
	static JFrame errorFrame;
	private JPanel contentPane;
	private JTextField textField_Username;
	private JPasswordField textField_Password;
	static Connection con;
	static ResultSet rs ;
	static Statement stmt;
	static String Username_entered="";
	static String Password_entered= "";
	String userCheck="";
	String passCheck="";
	int flag=0;
	static LogIN frame;  
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
								
				//login frame call
				try {
					frame = new LogIN();
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
	public LogIN() {
		//database connection
		try {

			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
			
			
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(frame1, e.getMessage());
        }
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Calibri", Font.BOLD, 22));
		Username.setBounds(42, 155, 112, 30);
		contentPane.add(Username);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Calibri", Font.BOLD, 22));
		Password.setBounds(42, 196, 112, 30);
		contentPane.add(Password);
		
		JLabel lblNewLabel = new JLabel("Welcome to Movie Bookings.");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(102, 28, 320, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter you Username and  Password to log in .");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(112, 69, 298, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_Username = new JTextField();
		textField_Username.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_Username.setBounds(178, 154, 222, 30);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);
		
		 
		textField_Password = new JPasswordField();
		textField_Password.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_Password.setColumns(10);
		textField_Password.setBounds(178, 195, 222, 30);
		textField_Password.setEchoChar('*');
		contentPane.add(textField_Password);
		
		JLabel lblNewLabel_2 = new JLabel("New User ? Click here to Register.");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//call to register class
				frame.setVisible(false);
				Register.frame=new Register();
				Register.frame.setVisible(true);
			}
		});
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel_2.setBounds(134, 337, 197, 30);
		contentPane.add(lblNewLabel_2);
		
		JButton login_1 = new JButton("Login");
		login_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//taking data from the login frame 
				
				 Username_entered=textField_Username.getText();
				 Password_entered= new String(textField_Password.getPassword());
				 
				// comparing with data in data base
				try {
					stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
				int found=0;
				String query = "SELECT * FROM movietheater.login ;" ;
				
				rs = stmt.executeQuery(query) ;
				
					while(rs.next())
					{
						
						userCheck=rs.getString("Username");
						passCheck= rs.getString("Password");
						//checking if user exists
							if(Username_entered.equals(userCheck))
							{
								if(Password_entered.equals(passCheck))
								{
									found=1;
								}
								else
								{
									JOptionPane.showMessageDialog(errorFrame, "Incorrect Password");
									
								}
							}
							else
							{
								JOptionPane.showMessageDialog(errorFrame, "Incorrect Username");
							}
							
							
						}
					if(found==1)
					{
						JOptionPane.showMessageDialog(errorFrame, "Logged in");
						//after login in home page display
						frame.setVisible(false);
						HomePage.frame=new HomePage();
						HomePage.frame.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(errorFrame, "Not Logged in");
					}
						
						
						
					
				
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		login_1.setFont(new Font("Calibri", Font.BOLD, 18));
		login_1.setBounds(178, 260, 103, 30);
		contentPane.add(login_1);
		
		JLabel frgtPass = new JLabel("Forget Password?");
		frgtPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//call to forgot pass function
				//frame.setVisible(false);
				forgottenPassword.frame=new forgottenPassword();
				forgottenPassword.frame.setVisible(true);
			}
		});
		frgtPass.setFont(new Font("Calibri", Font.PLAIN, 13));
		frgtPass.setBounds(178, 301, 103, 14);
		contentPane.add(frgtPass);
	}
}

package courseProject;

import java.awt.BorderLayout;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;


//for validation
import java.util.regex.*;  

public class Register extends JFrame {

	static Register frame;
	private JPanel contentPane;
	private JTextField textField_Username;
	private JTextField textField_Password;
	private JTextField reEnterPass;
	private JTextField name;
	private JTextField age;
	private JTextField email;
	private JTextField phone;
	private JTextField houseN;
	private JTextField street;
	private JTextField city;
	private JTextField state;
	private JTextField country;
	private JTextField pincode;
	
	static String Username_entered;
	static String Password_entered;
	static String reEnterPass_entered;
	static String name_entered;
	static int age_entered;
	static java.util.Date dob_entered;
	static String email_entered;
	static long phone_entered;
	static String houseN_entered;
	static String street_entered;
	static String city_entered;
	static String state_entered;
	static String country_entered;
	static int pincode_entered;
	static String strDate;
	static int loginId;
	//databse variables
	static Connection con;
	static ResultSet rs;
	static PreparedStatement stmt;
	static Statement stmt1;
	 JFrame frame1;
	/**
	 * Launch the application.
	 */
	
	 //for number validation
	 public static boolean isValidMobileNo(long str1)  
	 {  
		 String str=Long.toString(str1);
		 //(0/91): number starts with (0/91)  
		 //[7-9]: starting of the number may contain a digit between 0 to 9  
		 //[0-9]: then contains digits 0 to 9  
		 Pattern ptrn = Pattern.compile("(0/91)?[6-9][0-9]{9}");  
		 //the matcher() method creates a matcher that will match the given input against this pattern  
		 Matcher match = ptrn.matcher(str);  
		 //returns a boolean value  
		 return (match.find() && match.group().equals(str));  
	 }  
	 
	 //main class
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Register();
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
	public Register() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel DOB = new JLabel("Date Of Birth");
		DOB.setFont(new Font("Calibri", Font.BOLD, 22));
		DOB.setBounds(27, 140, 168, 30);
		contentPane.add(DOB);
		
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Calibri", Font.BOLD, 22));
		Password.setBounds(27, 436, 112, 30);
		contentPane.add(Password);
		
		
		JLabel lblNewLabel = new JLabel("Welcome to Movie Bookings.");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		lblNewLabel.setBounds(311, 11, 320, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the required details to Register.");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(344, 52, 298, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_Username = new JTextField();
		textField_Username.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_Username.setBounds(202, 386, 222, 30);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);
		
		textField_Password = new JTextField();
		textField_Password.setFont(new Font("Calibri", Font.PLAIN, 14));
		textField_Password.setColumns(10);
		textField_Password.setBounds(202, 437, 222, 30);
		contentPane.add(textField_Password);
		
		JLabel lblNewLabel_2 = new JLabel("Existing User ? Click the button to Login");
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(367, 541, 276, 30);
		contentPane.add(lblNewLabel_2);
		
		JButton login_1 = new JButton("Login");
		login_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//call to login frame
				frame.setVisible(false);
				LogIN.frame=new LogIN();
				LogIN.frame.setVisible(true);
				
			}
		});
		login_1.setFont(new Font("Calibri", Font.BOLD, 14));
		login_1.setBounds(420, 582, 89, 30);
		contentPane.add(login_1);
		
		JLabel Name = new JLabel("Name");
		Name.setFont(new Font("Calibri", Font.BOLD, 22));
		Name.setBounds(27, 99, 112, 30);
		contentPane.add(Name);
		
		JLabel Username_2 = new JLabel("Username");
		Username_2.setFont(new Font("Calibri", Font.BOLD, 22));
		Username_2.setBounds(27, 385, 112, 30);
		contentPane.add(Username_2);
		
		JLabel Age = new JLabel("Age");
		Age.setFont(new Font("Calibri", Font.BOLD, 22));
		Age.setBounds(508, 140, 112, 30);
		contentPane.add(Age);
		
		JLabel Email = new JLabel("Email");
		Email.setFont(new Font("Calibri", Font.BOLD, 22));
		Email.setBounds(27, 180, 112, 30);
		contentPane.add(Email);
		
		JLabel Phone = new JLabel("Phone Number");
		Phone.setFont(new Font("Calibri", Font.BOLD, 22));
		Phone.setBounds(508, 180, 168, 30);
		contentPane.add(Phone);
		
		JLabel house = new JLabel("House # / Name");
		house.setFont(new Font("Calibri", Font.BOLD, 22));
		house.setBounds(27, 220, 168, 30);
		contentPane.add(house);
		
		JLabel Street = new JLabel("Street");
		Street.setFont(new Font("Calibri", Font.BOLD, 22));
		Street.setBounds(508, 220, 112, 30);
		contentPane.add(Street);
		
		JLabel City = new JLabel("City");
		City.setFont(new Font("Calibri", Font.BOLD, 22));
		City.setBounds(27, 260, 112, 30);
		contentPane.add(City);
		
		JLabel State = new JLabel("State");
		State.setFont(new Font("Calibri", Font.BOLD, 22));
		State.setBounds(508, 260, 112, 30);
		contentPane.add(State);
		
		JLabel Country = new JLabel("Country");
		Country.setFont(new Font("Calibri", Font.BOLD, 22));
		Country.setBounds(27, 300, 112, 30);
		contentPane.add(Country);
		
		JLabel Pincode = new JLabel("Pincode");
		Pincode.setFont(new Font("Calibri", Font.BOLD, 22));
		Pincode.setBounds(508, 300, 112, 30);
		contentPane.add(Pincode);
		
		reEnterPass = new JTextField();
		reEnterPass.setFont(new Font("Calibri", Font.PLAIN, 14));
		reEnterPass.setColumns(10);
		reEnterPass.setBounds(676, 436, 222, 30);
		contentPane.add(reEnterPass);
		
		JLabel lblReenterPassword = new JLabel("Re-Enter Password");
		lblReenterPassword.setFont(new Font("Calibri", Font.BOLD, 22));
		lblReenterPassword.setBounds(481, 436, 180, 30);
		contentPane.add(lblReenterPassword);
		
		name = new JTextField();
		name.setFont(new Font("Calibri", Font.PLAIN, 14));
		name.setColumns(10);
		name.setBounds(202, 100, 479, 30);
		contentPane.add(name);
		
		age = new JTextField();
		age.setEditable(false);
		age.setFont(new Font("Calibri", Font.PLAIN, 14));
		age.setColumns(10);
		age.setBounds(676, 141, 222, 30);
		contentPane.add(age);
		
		email = new JTextField();
		email.setFont(new Font("Calibri", Font.PLAIN, 14));
		email.setColumns(10);
		email.setBounds(202, 180, 222, 30);
		contentPane.add(email);
		
		phone = new JTextField();
		phone.setFont(new Font("Calibri", Font.PLAIN, 14));
		phone.setColumns(10);
		phone.setBounds(676, 180, 222, 30);
		contentPane.add(phone);
		
		houseN = new JTextField();
		houseN.setFont(new Font("Calibri", Font.PLAIN, 14));
		houseN.setColumns(10);
		houseN.setBounds(202, 220, 222, 30);
		contentPane.add(houseN);
		
		street = new JTextField();
		street.setFont(new Font("Calibri", Font.PLAIN, 14));
		street.setColumns(10);
		street.setBounds(676, 220, 222, 30);
		contentPane.add(street);
		
		city = new JTextField();
		city.setFont(new Font("Calibri", Font.PLAIN, 14));
		city.setColumns(10);
		city.setBounds(202, 260, 222, 30);
		contentPane.add(city);
		
		state = new JTextField();
		state.setFont(new Font("Calibri", Font.PLAIN, 14));
		state.setColumns(10);
		state.setBounds(676, 260, 222, 30);
		contentPane.add(state);
		
		country = new JTextField();
		country.setFont(new Font("Calibri", Font.PLAIN, 14));
		country.setColumns(10);
		country.setBounds(202, 300, 222, 30);
		contentPane.add(country);
		
		pincode = new JTextField();
		pincode.setFont(new Font("Calibri", Font.PLAIN, 14));
		pincode.setColumns(10);
		pincode.setBounds(676, 300, 222, 30);
		contentPane.add(pincode);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(202, 140, 222, 30);
		contentPane.add(dateChooser);
		
		   
		JButton Register = new JButton("Register");
		Register.setFont(new Font("Calibri", Font.BOLD, 20));
		Register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//database connect and adding details
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
					stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
					
					//details entered by user for username and login table entry
					
					Username_entered=textField_Username.getText();
					Password_entered=textField_Password.getText();
					reEnterPass_entered=reEnterPass.getText();
					
					
					//rs=stmt.executeQuery(query1);
					
					
					
					
					name_entered=name.getText();
					
					//dob_entered=dob.getText();
					  
					
					dob_entered= dateChooser.getDate();					 
					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 		
					strDate = dateFormat.format(dob_entered); 
					
					//JOptionPane.showMessageDialog(errorFrame, strDate);
					
					
					email_entered=email.getText();
					phone_entered=Long.valueOf(phone.getText());
					houseN_entered=houseN.getText();
					street_entered=street.getText();
					city_entered=city.getText();
					state_entered=state.getText();
					country_entered=country.getText();
					pincode_entered=Integer.valueOf(pincode.getText());
					
					
					//to check for valid age and date of birth
					//Converting String to Date
					 SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
					 String strDate1 = formatter.format(dob_entered);  
				      java.util.Date date = null;
					try {
						date = formatter.parse(strDate1);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				      //Converting obtained Date object to LocalDate object
				      Instant instant = date.toInstant();
				      ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
				      LocalDate givenDate = zone.toLocalDate();
				      //Calculating the difference between given date to current date.
				      Period period = Period.between(givenDate, LocalDate.now());
				      age_entered=period.getYears();
				      age.setText(Integer.toString(age_entered));
				      //|| age_entered==period.getYears()
					if (isValidMobileNo(phone_entered))  
					{
						String query1="INSERT INTO movietheater.login (Username,Password) VALUES ('"+Username_entered+"', '"+Password_entered+"');";
						stmt=con.prepareStatement(query1);
						stmt.execute();
						
						//System.out.println("It is a valid mobile number.");  
						String query2="INSERT INTO movietheater.user (Name,dob,age,Email,Phone,houseName,Street,City,State,Country,Pincode,Username) VALUES ('"+name_entered+"','"+strDate+"',"+age_entered+",'"+ email_entered +"',"+phone_entered+",'"+houseN_entered+"','"+street_entered+"','"+city_entered+"','"+state_entered+"','"+country_entered+"',"+pincode_entered+",'"+Username_entered+"');";
						stmt=con.prepareStatement(query2);
						stmt.execute();
					}
					else  
					{
						//System.out.println("Entered mobile number is invalid.");    
						if (!isValidMobileNo(phone_entered))  
						{
							JOptionPane.showMessageDialog(frame1, "The entered mobile number is invalid.");
						}
						//if(age_entered!=period.getYears())
						//{
						//	JOptionPane.showMessageDialog(frame1, "The age entered and Date of birth do not match. Please enter correct data.");
						//}
					}  
									
					
					
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(frame1, ex.getMessage());
				}
				
			}
		});
		Register.setBounds(408, 490, 112, 40);
		contentPane.add(Register);
		
		
		
		
		
		
	}
}

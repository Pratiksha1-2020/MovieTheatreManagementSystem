package courseProject;
//chaneg username in the query
import java.awt.BorderLayout;




import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;  

public class ProfilePage extends JFrame {

	static ProfilePage frame;
	private JPanel contentPane;
	JButton[] btn=new JButton[10];
	
	static int ticketIDSelected;
	static String Username_entered;
	static String Password;
	static String reEnterPass;
	static String name;
	static String age;
	static String dob_entered;
	static String email_entered;
	static String phone_entered;
	static String houseN_entered;
	static String street_entered;
	static String city_entered;
	static String state_entered;
	static String country_entered;
	static String pincode_entered;
	
	static int userID;
	
	static String strDate;
	static String time;
	static String ticketID;
	static String ticketIDforRow;
	static String movieName;
	static String Theater;
	
	int flag=0;
	int track=0;
	
	
	static int loginId;
	//databse variables
	static Connection con;
	static ResultSet rs;
	static ResultSet rs2;
	static PreparedStatement stmt;
	static Statement stmt1;
	 JFrame frame1;
	 private JTable table;
	/**
	 * Launch the application.
	 */
	
	
	 
	 //main class
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ProfilePage();
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
	public ProfilePage() {
		//database connection
				try {

					
					Class.forName("com.mysql.cj.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
					
					
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(frame1, e.getMessage());
		        }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 938, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel DOB = new JLabel("Date Of Birth");
		DOB.setBounds(27, 134, 139, 30);
		DOB.setFont(new Font("Calibri", Font.BOLD, 22));
		contentPane.add(DOB);
		
		
		JLabel Password = new JLabel("Change Password");
		Password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
				changePassword.framec=new changePassword();
				changePassword.framec.setVisible(true);
			}
		});
		Password.setBounds(27, 335, 162, 30);
		Password.setFont(new Font("Calibri", Font.PLAIN, 18));
		contentPane.add(Password);
		
		
		JLabel lblNewLabel = new JLabel("User Details");
		lblNewLabel.setBounds(384, 11, 139, 30);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 25));
		contentPane.add(lblNewLabel);
		
		JLabel Name = new JLabel("Name");
		Name.setBounds(27, 93, 112, 30);
		Name.setFont(new Font("Calibri", Font.BOLD, 22));
		contentPane.add(Name);
		
		JLabel Username_2 = new JLabel("Username");
		Username_2.setBounds(27, 307, 112, 30);
		Username_2.setFont(new Font("Calibri", Font.BOLD, 22));
		contentPane.add(Username_2);
		
		JLabel Age = new JLabel("Age");
		Age.setBounds(471, 134, 112, 30);
		Age.setFont(new Font("Calibri", Font.BOLD, 22));
		contentPane.add(Age);
		
		JLabel Email = new JLabel("Email");
		Email.setBounds(27, 175, 112, 30);
		Email.setFont(new Font("Calibri", Font.BOLD, 22));
		contentPane.add(Email);
		
		JLabel Phone = new JLabel("Phone Number");
		Phone.setBounds(471, 175, 168, 30);
		Phone.setFont(new Font("Calibri", Font.BOLD, 22));
		contentPane.add(Phone);
		
		JLabel Address = new JLabel("Address");
		Address.setBounds(27, 216, 180, 30);
		Address.setFont(new Font("Calibri", Font.BOLD, 22));
		contentPane.add(Address);
		
		JLabel Name_1 = new JLabel("Name");
		Name_1.setBounds(180, 93, 248, 30);
		Name_1.setFont(new Font("Calibri", Font.PLAIN, 22));
		contentPane.add(Name_1);
		
		JLabel DOB_1 = new JLabel("Date Of Birth");
		DOB_1.setBounds(176, 134, 131, 30);
		DOB_1.setFont(new Font("Calibri", Font.PLAIN, 22));
		contentPane.add(DOB_1);
		
		JLabel Email_1 = new JLabel("Email");
		Email_1.setBounds(180, 175, 215, 30);
		Email_1.setFont(new Font("Calibri", Font.PLAIN, 22));
		contentPane.add(Email_1);
		
		JLabel Address_1 = new JLabel("Address");
		Address_1.setBounds(27, 266, 796, 30);
		Address_1.setFont(new Font("Calibri", Font.PLAIN, 22));
		contentPane.add(Address_1);
		
		JLabel Phone_1 = new JLabel("Phone Number");
		Phone_1.setBounds(655, 175, 168, 30);
		Phone_1.setFont(new Font("Calibri", Font.PLAIN, 22));
		contentPane.add(Phone_1);
		
		JLabel Age_1 = new JLabel("Age");
		Age_1.setBounds(655, 134, 112, 30);
		Age_1.setFont(new Font("Calibri", Font.PLAIN, 22));
		contentPane.add(Age_1);
		
		JLabel Username_2_1 = new JLabel("Username");
		Username_2_1.setBounds(177, 307, 112, 30);
		Username_2_1.setFont(new Font("Calibri", Font.PLAIN, 22));
		contentPane.add(Username_2_1);
		
		JLabel lblBookingDetails = new JLabel("Booking Details");
		lblBookingDetails.setBounds(28, 395, 206, 30);
		lblBookingDetails.setFont(new Font("Calibri", Font.BOLD, 25));
		contentPane.add(lblBookingDetails);
		
		
		DefaultTableModel model=new DefaultTableModel(
				new Object[][] {
					{"Ticket ID ", "Movie Name", "Date", "Time", "Theatre"},
				},
				new String[] {
					"Ticket ID ", "Movie Name", "Date", "Time", "Theatre"
				}
				);
		String col[]= {"Ticket ID ", "Movie Name", "Date", "Time", "Theatre"};
		model.setColumnIdentifiers(col);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBounds(27, 30, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				HomePage.frame=new HomePage();
				HomePage.frame.setVisible(true);
			}
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Select the ticket ID and click on view ticket");
		lblNewLabel_1.setBounds(27, 423, 260, 14);
		contentPane.add(lblNewLabel_1);
		
		/*btn[i]=new JButton("Click Here");
				btn[i].setBounds(810, y, 112, 30);
				btn[i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
						flag=i;
						rs2.next();
						for(int j=0;j<flag;j++)
						{
							
								rs2.next();
							
						}
						ticketIDforRow=rs.getString("ticketID");
						//call the ticket page
						//frame.setVisible(false);
						Ticket.frame=new Ticket();
						Ticket.frame.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
				});
				contentPane.add(btn[i]);*/
		JButton btnNewButton_1 = new JButton("View Ticket");
		btnNewButton_1.setBounds(796, 598, 118, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket.frame=new Ticket();
				Ticket.frame.setVisible(true);
				
				
			}
		});
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 466, 756, 144);
		contentPane.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable target = (JTable)e.getSource();
                
                int selectedRow = target.getSelectedRow();
                 int selectedColumn = target.getSelectedColumn();
                 String t=(String)table.getValueAt(selectedRow, selectedColumn);
                 ticketIDSelected = Integer.valueOf(t) ;
                
			}
		});
		
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Calibri", Font.BOLD, 14));
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setModel(model);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.getColumnModel().getColumn(2).setMinWidth(30);
		table.getColumnModel().getColumn(3).setMinWidth(30);
		table.getColumnModel().getColumn(4).setMinWidth(30);
		table.setRowHeight(30);
		
		//taking details about movie
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("SELECT DISTINCT UserID,movietheater.login.Username,Name,age,dob,Email,Phone,houseName,movietheater.user.Street,movietheater.user.City,movietheater.user.State,movietheater.user.Country,movietheater.user.Pincode,date,time,movietheater.tickets.ticketID,MovName,TName FROM movietheater.login, movietheater.books  ,movietheater.user ,movietheater.tickets ,movietheater.movie, movietheater.theatre Where movietheater.books.UserID_B = movietheater.user.UserID AND movietheater.books.ticketID= movietheater.tickets.ticketID AND movietheater.tickets.movieID= movietheater.movie.Movie_License AND  movietheater.login.Username=movietheater.user.Username AND      movietheater.tickets.theatre_ID=movietheater.theatre.theatreID AND login.Username='"+LogIN.Username_entered+"';");
		
			rs=statement.executeQuery();
			
			
			//fro ticket id
			stmt = con.prepareStatement("SELECT DISTINCT UserID,movietheater.login.Username,Name,age,dob,Email,Phone,houseName,movietheater.user.Street,movietheater.user.City,movietheater.user.State,movietheater.user.Country,movietheater.user.Pincode,date,time,movietheater.tickets.ticketID,MovName,TName FROM movietheater.login, movietheater.books  ,movietheater.user ,movietheater.tickets ,movietheater.movie, movietheater.theatre Where movietheater.books.UserID_B = movietheater.user.UserID AND movietheater.books.ticketID= movietheater.tickets.ticketID AND movietheater.tickets.movieID= movietheater.movie.Movie_License AND  movietheater.login.Username=movietheater.user.Username AND      movietheater.tickets.theatre_ID=movietheater.theatre.theatreID AND login.Username='"+LogIN.Username_entered+"';");
			
			rs2=stmt.executeQuery();
			int y = 450;
			int i=0;
			while (rs.next()) {
				
				userID=Integer.valueOf(rs.getString("UserID"));
				Username_entered=rs.getString("Username");
				name=rs.getString("Name");
				age=rs.getString("age");
				dob_entered=rs.getString("dob");
				email_entered=rs.getString("Email");
				phone_entered=rs.getString("Phone");
				houseN_entered=rs.getString("houseName");
				street_entered=rs.getString("Street");
				city_entered=rs.getString("City");
				state_entered=rs.getString("State");
				country_entered=rs.getString("Country");
				pincode_entered=rs.getString("Pincode");
				
				strDate=rs.getString("date");
				time=rs.getString("time");
				ticketID=rs.getString("ticketID");
				movieName=rs.getString("MovName");
				Theater=rs.getString("TName");
				
				Name_1.setText(name);
				DOB_1.setText(dob_entered);
				Email_1.setText(email_entered);
				String addr=houseN_entered+","+street_entered+","+city_entered+","+state_entered+","+country_entered+"-"+pincode_entered+".";
				Address_1.setText(addr);
				Phone_1.setText(phone_entered);
				Age_1.setText(age);
				Username_2_1.setText(Username_entered);
				
				model.addRow(new Object[]{ticketID,movieName,strDate,time,Theater});
				
			}
			
			
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
}

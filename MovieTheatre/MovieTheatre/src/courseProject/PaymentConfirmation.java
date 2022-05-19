package courseProject;

import java.awt.BorderLayout;

import java.util.Date;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class PaymentConfirmation extends JFrame {

	private JPanel contentPane;
	static PaymentConfirmation frame;
	JFrame confirmFrame;
	JFrame frame1;
	static int ticketId;

	static String MovieName;
	static String Date;
	static String Time;
	static String SeatNumbers;
	static String Amount;
	static String BookDate;
	static int TheatreID;
	
	static Connection con;
	static ResultSet rs ;
	static ResultSet rs2 ;
	static PreparedStatement stmt;
	static PreparedStatement statement;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new PaymentConfirmation();
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
	public PaymentConfirmation() {
		//database connection
				try {

					
					Class.forName("com.mysql.cj.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
					
					
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(frame1, e.getMessage());
		        }
				
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Confirmation");
		l1.setFont(new Font("Calibri", Font.BOLD, 20));
        JLabel l2 = new JLabel("Movie Name");
        l2.setFont(new Font("Calibri", Font.PLAIN, 14));
        JLabel l3 = new JLabel("Date");
        l3.setFont(new Font("Calibri", Font.PLAIN, 14));
        JLabel l4 = new JLabel("Time");
        l4.setFont(new Font("Calibri", Font.PLAIN, 14));
        JLabel l5 = new JLabel("Seat Numbers");
        l5.setFont(new Font("Calibri", Font.PLAIN, 14));
        JLabel l6 = new JLabel("Amount");
        l6.setFont(new Font("Calibri", Font.PLAIN, 14));
        JLabel l7 = new JLabel("---");
        JLabel l8 = new JLabel("---");
        JLabel l9 = new JLabel("---");
        JLabel l10 = new JLabel("---");
        JLabel l11 = new JLabel("---");
        JButton b1=new JButton("Back");
        JButton b2=new JButton("Pay");
        
        l7.setFont(new Font("Calibri", Font.PLAIN, 14));
        l8.setFont(new Font("Calibri", Font.PLAIN, 14));
        l9.setFont(new Font("Calibri", Font.PLAIN, 14));
        l10.setFont(new Font("Calibri", Font.PLAIN, 14));
        l11.setFont(new Font("Calibri", Font.PLAIN, 14));
        
        b1.setFont(new Font("Calibri", Font.PLAIN, 14));
        b2.setFont(new Font("Calibri", Font.PLAIN, 14));
        l1.setBounds(145, 5, 136, 24);
        l2.setBounds(30, 40, 100, 20);
        l3.setBounds(30, 70, 100, 20);
        l4.setBounds(30, 100, 100, 20);
        l5.setBounds(30, 130, 100, 20);
        l6.setBounds(30, 160, 100, 20);
        l7.setBounds(200, 40, 201, 20);
        l8.setBounds(200, 70, 100, 20);
        l9.setBounds(200, 100, 100, 20);
        l10.setBounds(200, 130, 100, 20);
        l11.setBounds(200, 160, 100, 20);
        
        
      

        
      b1.setBounds(70, 210, 80, 27);
      b2.setBounds(230, 209, 90, 28);
        contentPane.setLayout(null);
        
        
        getContentPane().add(l1);
        getContentPane().add(l2);
        getContentPane().add(l3);
        getContentPane().add(l4);
        getContentPane().add(l5);
        getContentPane().add(l6);
        getContentPane().add(l7);
        getContentPane().add(l8);
        getContentPane().add(l9);
        getContentPane().add(l10);
        getContentPane().add(l11);
        
        getContentPane().add(b1);
        getContentPane().add(b2);
        
        
      setVisible(true);
      //to set the labels
      
       MovieName=MovieDetails.name;
       Date=Seats.seatBookDate;
       Time=Seats.seatBookTime;
       SeatNumbers="";
       for(int i=0;i<Seats.numSeats;i++)
       {
    	   SeatNumbers=SeatNumbers+Seats.bookedSeats[i]+"   ";
       }
       
       Amount=Float.toString(Seats.totalAmount);
  	
           
       l7.setText(MovieName);
       l8.setText(Date);
       l9.setText(Time);
       l10.setText(SeatNumbers);
       l11.setText(Amount);
       
       
  	
      b1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
        	  int check = JOptionPane.showConfirmDialog(confirmFrame,"Are you sure you want to cancel booking.If yes you will be redirected to home Page..", "Confirm Cancellation.",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				//call to payments
				//yes =0 , no=1
				if(check==0)
				{
					//add call to homepage
					frame.setVisible(false);
					HomePage.frame=new HomePage();
					HomePage.frame.setVisible(true);

				}
				
             
          }
          });
      
      b2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
        	  JOptionPane.showMessageDialog(confirmFrame,"Payment Succesful.View your ticket in Profile Page");
        	  //adding details of the ticket in the db
        	  try {
        		  //to generate random 6 digit number
        		  
        		  String query="SELECT theatreID FROM movietheater.theatre WHERE TName='"+Theatre.theatreName+"';";
        		  statement=con.prepareStatement(query);
        		  rs2=statement.executeQuery();
        		  rs2.next();
        		  TheatreID=Integer.valueOf(rs2.getString("theatreID"));
        		  
        		  Time=Time+":00";
        		  
        		  String query1="INSERT INTO movietheater.tickets (date,time,movieID,SeatNum,theatre_ID) VALUES ('"+Date+"','"+Time+"',"+HomePage.movID+",'"+SeatNumbers+"',"+TheatreID+");";
        			
        				stmt=con.prepareStatement(query1);
        				stmt.execute();
        				
        				String query2="SELECT * FROM movietheater.tickets WHERE date='"+Date+"' AND time='"+Time+"' AND movieID="+HomePage.movID+" AND SeatNum='"+SeatNumbers+"' AND theatre_ID="+TheatreID+";";
        				stmt=con.prepareStatement(query2);
        				rs=stmt.executeQuery();
        				rs.next();
        				ticketId=Integer.valueOf(rs.getString("ticketID"));
        				
        				
        				
        				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        				Date date = new Date();
        				BookDate=formatter.format(date);
        				
        				String query4="SELECT UserID FROM movietheater.login, movietheater.user WHERE movietheater.login.Username = movietheater.user.Username AND movietheater.login.Username='"+LogIN.Username_entered+"';";
        				stmt=con.prepareStatement(query4);
        				rs=stmt.executeQuery();
        				rs.next();
        				int userID=Integer.valueOf(rs.getString("UserID"));
        				String query3="INSERT INTO movietheater.books (UserID_B,ticketID,bookingDate) VALUES ("+userID+","+ticketId+",'"+BookDate+"');";
            			
        				stmt=con.prepareStatement(query3);
        				stmt.execute();
        				
        				
        			} catch (SQLException e1) {
        				// TODO Auto-generated catch block
        				e1.printStackTrace();
        			}
        	 frame.setVisible(false);
        	 ProfilePage.frame=new ProfilePage();
        	 ProfilePage.frame.setVisible(true);
          }
          });
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

public class Ticket extends JFrame {

	private JPanel contentPane;
	static Ticket frame;
	JFrame frame1;
	
	static Connection con;
	static ResultSet rs ;
	static PreparedStatement stmt;
	static PreparedStatement statement;
	
	int ScreenNo;
	
	Random rand = new Random();
	
	String MovieName2;
	String Date2;
	String Time2;
	String SeatNumbers2;
	String Type2;
	String Venue2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Ticket();
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
	public Ticket() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Ticket");
		
		//database connection
		try {

			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
			
			
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(frame1, e.getMessage());
        }
		setBounds(100, 100, 450, 603);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel poster = new JLabel("");
		poster.setBounds(10, 11, 416, 186);
		contentPane.add(poster);
		
		
	      
	      JLabel MovieName = new JLabel("MovieName");
	      MovieName.setFont(new Font("Calibri", Font.BOLD, 25));
	      MovieName.setBounds(30, 208, 396, 47);
	      contentPane.add(MovieName);
	      
	      JLabel type = new JLabel("type");
	      type.setFont(new Font("Calibri", Font.PLAIN, 16));
	      type.setBounds(40, 247, 49, 33);
	      contentPane.add(type);
	      
	      JLabel date = new JLabel("Date");
	      date.setFont(new Font("Calibri", Font.PLAIN, 15));
	      date.setBounds(27, 300, 62, 14);
	      contentPane.add(date);
	      
	      JLabel time = new JLabel("Time");
	      time.setFont(new Font("Calibri", Font.PLAIN, 15));
	      time.setBounds(243, 300, 62, 14);
	      contentPane.add(time);
	      
	      JLabel d = new JLabel("label");
	      d.setFont(new Font("Calibri", Font.BOLD, 17));
	      d.setBounds(30, 325, 170, 33);
	      contentPane.add(d);
	      
	      JLabel t = new JLabel("label");
	      t.setFont(new Font("Calibri", Font.BOLD, 17));
	      t.setBounds(236, 325, 170, 33);
	      contentPane.add(t);
	      
	      JLabel venue = new JLabel("Venue");
	      venue.setFont(new Font("Calibri", Font.PLAIN, 15));
	      venue.setBounds(30, 390, 62, 14);
	      contentPane.add(venue);
	      
	      JLabel v = new JLabel("label");
	      v.setFont(new Font("Calibri", Font.BOLD, 17));
	      v.setBounds(30, 415, 396, 33);
	      contentPane.add(v);
	      
	      JLabel lblSeats = new JLabel("Seats");
	      lblSeats.setFont(new Font("Calibri", Font.PLAIN, 15));
	      lblSeats.setBounds(27, 478, 62, 14);
	      contentPane.add(lblSeats);
	      
	      JLabel s = new JLabel("label");
	      s.setFont(new Font("Calibri", Font.BOLD, 17));
	      s.setBounds(30, 503, 316, 33);
	      contentPane.add(s);
	      
	      //to add details
	      try
			{
			String query="SELECT DISTINCT movietheater.tickets.ticketID,movietheater.movie.MovName,movietheater.movie.Type,movietheater.movie.WidePoster,movietheater.theatre.TName,movietheater.theatre.Street,movietheater.theatre.City,movietheater.theatre.State,movietheater.tickets.date,movietheater.tickets.time,movietheater.tickets.SeatNum FROM movietheater.books ,movietheater.movie,movietheater.tickets,movietheater.theatre,movietheater.user,movietheater.showing WHERE movietheater.books.UserID_B=movietheater.user.UserID AND movietheater.books.ticketID=movietheater.tickets.ticketID AND movietheater.tickets.movieID=movietheater.movie.Movie_license AND   movietheater.tickets.theatre_ID=movietheater.theatre.theatreID AND movietheater.tickets.ticketID="+ProfilePage.ticketIDSelected+";";
			
			stmt=con.prepareStatement(query);
			rs=stmt.executeQuery();
			byte[] image = null;
			while (rs.next()) {
				 MovieName2=rs.getString("MovName");
				 Date2=rs.getString("date");
				 Time2=rs.getString("time");
				 SeatNumbers2=rs.getString("SeatNum");
				 
			      
				 Type2=rs.getString("Type");
				 Venue2=rs.getString("TName")+","+rs.getString("Street")+","+rs.getString("City")+".";
				
				image = rs.getBytes("WidePoster");
			}
	      //create the image 
		      Image img = Toolkit.getDefaultToolkit().createImage(image);
		     
		      ImageIcon icone = new ImageIcon(img.getScaledInstance(450, 220, Image.SCALE_SMOOTH));
		      poster.setIcon(icone);
		      
		      
		      //to set the labels
		      MovieName.setText(MovieName2);
		      type.setText(Type2);
		      d.setText(Date2);
		      t.setText(Time2);
		      v.setText(Venue2);
		      s.setText(SeatNumbers2);
		      
		     
		      int max=4;
		      int min=1;
		      ScreenNo=rand.nextInt(max - min + 1) + min;
		      String ScreenNoS=Integer.toString(ScreenNo);
		      JLabel lblScreenNo = new JLabel("Screen No ");
		      lblScreenNo.setFont(new Font("Calibri", Font.PLAIN, 16));
		      lblScreenNo.setBounds(243, 247, 83, 33);
		      contentPane.add(lblScreenNo);
		      
		      
		      
		      JLabel lblScreenNo_1 = new JLabel("Screen No ");
		      lblScreenNo_1.setFont(new Font("Calibri", Font.PLAIN, 16));
		      lblScreenNo_1.setBounds(343, 247, 83, 33);
		      contentPane.add(lblScreenNo_1);
		      
		      lblScreenNo_1.setText(ScreenNoS);
		      
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}
}

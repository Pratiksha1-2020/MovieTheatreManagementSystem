package courseProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
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
import javax.swing.border.EmptyBorder;


public class MovieDetails extends JFrame {

	static MovieDetails frame;
	
	static Connection con;
	static ResultSet rs ;
	static Statement stmt;
	static JFrame frame1;
	static JFrame inputFrame;
	static JFrame errorFrame;
	static int movID;
	private JPanel contentPane;
	
	static JLabel MovieName;
	static JLabel Poster;
	static JLabel MaleLead;
	static JLabel FemaleLead;
	static JLabel director;
	static JLabel ml;
	static JLabel fl;
	static JLabel d;
	private JButton btnNewButton_1;
	private JLabel Producer;
	private JLabel p;
	private JLabel reldate;
	private JLabel Type;
	private JLabel r;
	private JLabel t;
	
	static String name;
	static String type;
	static String date;
	static String direc;
	static String femalelead;
	static String maleLead;
	static String  prod;
	static  int numSeats;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MovieDetails();
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
	public MovieDetails() {
		
		//database connection
		try {

			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
			
			
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(frame1, e.getMessage());
        }
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 749, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		MovieName = new JLabel("Movie Name");
		MovieName.setForeground(new Color(153, 50, 204));
		MovieName.setFont(new Font("Calibri", Font.BOLD, 27));
		MovieName.setBounds(263, 52, 278, 39);
		contentPane.add(MovieName);
		
		Poster = new JLabel("");
		
		Poster.setBounds(451, 128, 250, 307);
		contentPane.add(Poster);
		
	    MaleLead = new JLabel("Male Lead");
	    MaleLead.setFont(new Font("Calibri", Font.PLAIN, 20));
	    MaleLead.setForeground(Color.BLACK);
		MaleLead.setBounds(69, 146, 107, 39);
		contentPane.add(MaleLead);
		
		FemaleLead = new JLabel("Female Lead");
		FemaleLead.setFont(new Font("Calibri", Font.PLAIN, 20));
		FemaleLead.setForeground(Color.BLACK);
		FemaleLead.setBounds(69, 204, 107, 39);
		contentPane.add(FemaleLead);
		
		director = new JLabel("Director");
		director.setFont(new Font("Calibri", Font.PLAIN, 20));
		director.setForeground(Color.BLACK);
		director.setBounds(69, 265, 127, 31);
		contentPane.add(director);
		
		ml = new JLabel("New label");
		ml.setFont(new Font("Calibri", Font.PLAIN, 20));
		ml.setForeground(Color.BLUE);
		ml.setBackground(Color.WHITE);
		ml.setBounds(228, 150, 181, 31);
		contentPane.add(ml);
		
		fl = new JLabel("New label");
		fl.setFont(new Font("Calibri", Font.PLAIN, 20));
		fl.setForeground(Color.BLUE);
		fl.setBounds(228, 204, 181, 39);
		contentPane.add(fl);
		
		d = new JLabel("New label");
		d.setFont(new Font("Calibri", Font.PLAIN, 20));
		d.setForeground(Color.BLUE);
		d.setBounds(228, 265, 174, 31);
		contentPane.add(d);
		
		Producer = new JLabel("Producer");
		Producer.setForeground(Color.BLACK);
		Producer.setFont(new Font("Calibri", Font.PLAIN, 20));
		Producer.setBounds(69, 325, 127, 31);
		contentPane.add(Producer);
		
		p = new JLabel("New label");
		p.setForeground(Color.BLUE);
		p.setFont(new Font("Calibri", Font.PLAIN, 20));
		p.setBounds(228, 325, 181, 31);
		contentPane.add(p);
		
		reldate = new JLabel("Release Date");
		reldate.setForeground(Color.BLACK);
		reldate.setFont(new Font("Calibri", Font.PLAIN, 20));
		reldate.setBounds(69, 378, 127, 31);
		contentPane.add(reldate);
		
		Type = new JLabel("Type");
		Type.setForeground(Color.BLACK);
		Type.setFont(new Font("Calibri", Font.PLAIN, 20));
		Type.setBounds(69, 437, 127, 31);
		contentPane.add(Type);
		
		r = new JLabel("New label");
		r.setForeground(Color.BLUE);
		r.setFont(new Font("Calibri", Font.PLAIN, 20));
		r.setBounds(228, 378, 181, 31);
		contentPane.add(r);
		
		t = new JLabel("New label");
		t.setForeground(Color.BLUE);
		t.setFont(new Font("Calibri", Font.PLAIN, 20));
		t.setBounds(228, 437, 181, 31);
		contentPane.add(t);
		
		//taking details about movie
				PreparedStatement statement;
				try {
					
				statement = con.prepareStatement("SELECT * FROM movietheater.movie WHERE Movie_License = '"+HomePage.movID+"';");
					rs=statement.executeQuery();
					byte[] image = null;
					while (rs.next()) {
						name=rs.getString("MovName");
						type=rs.getString("Type");
						date=rs.getString("Release_date");
						direc=rs.getString("Director");
						femalelead=rs.getString("FemaleLead");
						maleLead=rs.getString("MaleLead");
						prod=rs.getString("Producer");
						image = rs.getBytes("Poster");
					}
					
					MovieName.setText(name);
					ml.setText(maleLead);
					fl.setText(femalelead);
					d.setText(direc);
					p.setText(prod);
					t.setText(type);
					r.setText(date);
					//create the image 
				      Image img = Toolkit.getDefaultToolkit().createImage(image);
				     
				      ImageIcon icone = new ImageIcon(img.getScaledInstance(180, 360, Image.SCALE_SMOOTH));
				      Poster.setIcon(icone);
				      
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		
		
		
		JButton btnNewButton_2 = new JButton("Book show");
		btnNewButton_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String seatsNo=JOptionPane.showInputDialog(inputFrame,"Enter Number Of Seats");    
				 numSeats=Integer.valueOf(seatsNo);
				 
				 //call to seats
				 frame.setVisible(false);
				Theatre.frame=new Theatre();
				Theatre.frame.setVisible(true);
				
			}
		});
		btnNewButton_2.setForeground(new Color(205, 92, 92));
		btnNewButton_2.setBackground(new Color(255, 182, 193));
		btnNewButton_2.setBounds(287, 504, 135, 39);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("Home Page");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add call to homepage
				frame.setVisible(false);
				HomePage.frame=new HomePage();
				HomePage.frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setForeground(new Color(205, 92, 92));
		btnNewButton_1.setBackground(new Color(255, 182, 193));
		btnNewButton_1.setBounds(29, 30, 127, 23);
		contentPane.add(btnNewButton_1);
		
		
	}

}

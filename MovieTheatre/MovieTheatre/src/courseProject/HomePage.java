package courseProject;
import java.sql.*;

/*
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
*/

import java.awt.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class HomePage extends JFrame {
	
	static Connection con;
	static ResultSet rs ;
	static Statement stmt;
	static JFrame frame1;
	static JFrame errorFrame;
	static int movID;
	static HomePage frame;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new HomePage();
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
	public HomePage() {
		
		//database connection
				try {

					
					Class.forName("com.mysql.cj.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
					
					
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(frame1, e.getMessage());
		        }
				
				
		//JScrollPane scpane=new JScrollPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 838);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	
		contentPane.setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("Currently Showing");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel.setBounds(248, 11, 193, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
				 
				frame.setVisible(false);
				ProfilePage.frame=new ProfilePage();
				ProfilePage.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(39, 23, 89, 23);
		contentPane.add(btnNewButton);
		
		//first movie
		JLabel avengers = new JLabel("Avengers Endgame");
		avengers.setFont(new Font("Calibri", Font.PLAIN, 18));
		avengers.setBounds(138, 83, 179, 36);
		contentPane.add(avengers);
		
		JLabel aven = new JLabel("");
		aven.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//calling movie details
				movID=234567;
				frame.setVisible(false);
				MovieDetails.frame=new MovieDetails();
				MovieDetails.frame.setVisible(true);
			}
		});
		
		aven.setBounds(108, 111, 229, 297);
		contentPane.add(aven);
		
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("SELECT Poster FROM movietheater.movie WHERE Movie_License = 234567;");
		
			rs=statement.executeQuery();
			byte[] image = null;
			while (rs.next()) {
				image = rs.getBytes("Poster");
			}
	      //create the image 
		      Image img = Toolkit.getDefaultToolkit().createImage(image);
		     
		      ImageIcon icone = new ImageIcon(img.getScaledInstance(180, 360, Image.SCALE_SMOOTH));
		      aven.setIcon(icone);
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel blackpanther = new JLabel("Black Panther");
		blackpanther.setFont(new Font("Calibri", Font.PLAIN, 18));
		blackpanther.setBounds(441, 86, 135, 30);
		contentPane.add(blackpanther);
		
		String[] cMessages={"Choose Theatre","INOX cinemas","Nucleus Mall"};
        
       
		
		JLabel blk = new JLabel("");
		blk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//calling movie details
				movID=345678;
				frame.setVisible(false);
				MovieDetails.frame=new MovieDetails();
				MovieDetails.frame.setVisible(true);
			}
		});
		blk.setBounds(403, 111, 229, 297);
		contentPane.add(blk);
		
		
		try {
			statement = con.prepareStatement("SELECT Poster FROM movietheater.movie WHERE Movie_License = 345678;");
		
			rs=statement.executeQuery();
			byte[] image = null;
			while (rs.next()) {
				image = rs.getBytes("Poster");
			}
	      //create the image 
		      Image img = Toolkit.getDefaultToolkit().createImage(image);
		     
		      ImageIcon icone = new ImageIcon(img.getScaledInstance(180, 360, Image.SCALE_SMOOTH));
		      blk.setIcon(icone);
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JLabel shangchi = new JLabel("Shang-chi");
		shangchi.setFont(new Font("Calibri", Font.PLAIN, 18));
		shangchi.setBounds(161, 443, 135, 36);
		contentPane.add(shangchi);
		
		
		JLabel shn = new JLabel("");
		shn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//calling movie details
				movID=123456;
				frame.setVisible(false);
				MovieDetails.frame=new MovieDetails();
				MovieDetails.frame.setVisible(true);
			}
		});
		shn.setBounds(108, 471, 229, 297);
		contentPane.add(shn);
		
		try {
			statement = con.prepareStatement("SELECT Poster FROM movietheater.movie WHERE Movie_License = 123456;");
		
			rs=statement.executeQuery();
			byte[] image = null;
			while (rs.next()) {
				image = rs.getBytes("Poster");
			}
	      //create the image 
		      Image img = Toolkit.getDefaultToolkit().createImage(image);
		     
		      ImageIcon icone = new ImageIcon(img.getScaledInstance(180, 360, Image.SCALE_SMOOTH));
		      shn.setIcon(icone);
		      
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

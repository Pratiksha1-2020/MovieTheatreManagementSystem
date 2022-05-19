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





public class test {
	public static void main(String args[])
	{
		java.sql.Connection con;
		ResultSet rs;
		JFrame errorFrame;
		Statement stmt;
		try {

			
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
			stmt = con.createStatement();
			String newPass_entered="preethi";
			String Username_entered="Preethi";
			String query = "UPDATE movietheater.login SET Password = '"+newPass_entered+"' WHERE Username = '"+Username_entered+"';";
			
			String query2="INSERT INTO movietheater.user (Name,dob,age,Email,Phone,houseName,Street,City,State,Country,Pincode,Username) VALUES ('Preethi',TO_DATE('2017-12-12',12,'pre',1234567890,'f','f','f','f','f',12,'f');";
			stmt=con.prepareStatement(query);
			stmt.executeUpdate(query);
		
			System.out.println(PaymentConfirmation.Time);
			
    } catch (Exception e) {
    	System.out.println(e);
		
    }
		
		
		
	}

}


/*

package courseProject;
import java.sql.*;


import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;


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


	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public HomePage() {
		
		//database connection
				try {

					
					Class.forName("com.mysql.cj.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
					
					
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(frame1, e.getMessage());
		        }
				
				
		JScrollPane scpane=new JScrollPane();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 758, 851);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
	
		contentPane.setLayout(null);
		

		
		JLabel lblNewLabel = new JLabel("Currently Showing");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel.setBounds(248, 11, 193, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.setBounds(39, 23, 89, 23);
		contentPane.add(btnNewButton);
		
		//first movie
		JLabel avengers = new JLabel("Avengers Endgame");
		avengers.setFont(new Font("Calibri", Font.PLAIN, 18));
		avengers.setBounds(123, 83, 179, 36);
		contentPane.add(avengers);
		
		JLabel aven = new JLabel("");
		
		aven.setBounds(88, 130, 229, 297);
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
		blackpanther.setBounds(458, 86, 135, 30);
		contentPane.add(blackpanther);
		
		JLabel blk = new JLabel("");
		blk.setBounds(417, 131, 229, 297);
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
		shangchi.setBounds(137, 463, 135, 36);
		contentPane.add(shangchi);
		
		
		JLabel shn = new JLabel("");
		shn.setBounds(88, 506, 229, 297);
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

*/
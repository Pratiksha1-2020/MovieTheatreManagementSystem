package courseProject;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;


public class creditCardAdd extends JFrame {

	private JPanel contentPane;
	static creditCardAdd frame;
	static JFrame frame1;
	static java.util.Date Expiry_entered;
	String strDate;
	String cardHolderName;
	long CardNum;
	
	static Connection con;
	static ResultSet rs ;
	static PreparedStatement stmt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new creditCardAdd();
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
	public creditCardAdd() {
		
		//database connection
				try {

					
					Class.forName("com.mysql.cj.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
					
					
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(frame1, e.getMessage());
		        }
				
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(202, 125, 150, 25);
		contentPane.add(dateChooser);
		
		
		JLabel l1 = new JLabel("Credit Card");
		l1.setFont(new Font("Calibri", Font.BOLD, 20));
        JLabel l2 = new JLabel("Card Number");
        l2.setFont(new Font("Calibri", Font.PLAIN, 15));
        JLabel l3 = new JLabel("Card Holder Name");
        l3.setFont(new Font("Calibri", Font.PLAIN, 15));
        JLabel l4 = new JLabel("Expiry Date");
        l4.setFont(new Font("Calibri", Font.PLAIN, 15));
        JTextField t1=new JTextField("");
        t1.setFont(new Font("Calibri", Font.PLAIN, 15));
        JTextField t2=new JTextField("");
        t2.setFont(new Font("Calibri", Font.PLAIN, 15));
        
        JButton b1=new JButton("Back");
        JButton b2=new JButton("Add");
        
        l1.setBounds(128,11,136,20);
        l2.setBounds(40, 45, 100, 20);
        l3.setBounds(40, 85, 118, 20);
        l4.setBounds(40, 125, 100, 20);
        
        t1.setBounds(202,40,150, 25);
        t2.setBounds(202,85,150, 25);
        
        b1.setBounds(70,180,70,20);
        b2.setBounds(230,180,70,20);
        
        
        contentPane.add(b1);
        contentPane.add(b2);
        
        contentPane.add(l1);
        contentPane.add(l2);
        contentPane.add(l3);
        contentPane.add(l4);
        
        contentPane.add(t1);
        contentPane.add(t2);
        
        
        
        
        b1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
        	  frame.setVisible(false);
				creditCard.frame=new creditCard();
				creditCard.frame.setVisible(true);
          }
          });
        
        b2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
             //to get data
        	  try {
        	  CardNum=Long.valueOf(t1.getText());
        	  System.out.printf("%d",CardNum);
        	  cardHolderName=t2.getText();
        	  Expiry_entered= dateChooser.getDate();					 
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 		
				strDate = dateFormat.format(Expiry_entered); 
        	  
        	  String query="INSERT INTO movietheater.creditcard (CardNumberC,CardHolderNameC,ExpiryDateC) VALUES ("+CardNum+",'"+cardHolderName+"','"+strDate+"');";
				
					stmt=con.prepareStatement(query);
					stmt.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
          }
          });
        
      setBounds(200,200,400,250);
      setVisible(true);
        
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
	}

}

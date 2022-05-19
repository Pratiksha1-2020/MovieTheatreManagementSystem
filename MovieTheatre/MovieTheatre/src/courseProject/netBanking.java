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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

public class netBanking extends JFrame {

	private JPanel contentPane;
	static netBanking frame;
	JFrame frame1;
	static Connection con;
	static ResultSet rs ;
	static PreparedStatement stmt;
	
	String netBankUser;
	String netBankUserCheck;
	String netBankPass;
	String netBankPassCheck;
	int flagN;
	int flagP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new netBanking();
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
	public netBanking() {
		
		//database connection
				try {

					
					Class.forName("com.mysql.cj.jdbc.Driver");  
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/movietheater","Preethi","preethi2310");  
					
					
		        } catch (Exception e) {
		        	JOptionPane.showMessageDialog(frame1, e.getMessage());
		        }
				
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l3 = new JLabel("Net Banking");
		l3.setFont(new Font("Calibri", Font.BOLD, 20));
        JLabel l4 = new JLabel("Username");
        l4.setFont(new Font("Calibri", Font.PLAIN, 14));
        JLabel l5 = new JLabel("Password");
        l5.setFont(new Font("Calibri", Font.PLAIN, 14));
       
        JTextField t1=new JTextField("");
        t1.setFont(new Font("Calibri", Font.PLAIN, 14));
        JPasswordField t2=new JPasswordField("");
        t2.setFont(new Font("Calibri", Font.PLAIN, 14));
        t2.setEchoChar('*');
        
        JButton b1=new JButton("Back");
        JButton b2=new JButton("Make Payment");
        
        t1.setBounds(170, 60, 132, 20);
        t2.setBounds(170,100,132,20);
        
        l3.setBounds(127, 11, 119, 33);
        l4.setBounds(50, 60, 100, 20);
        l5.setBounds(50,100, 100, 20);
       
        b1.setBounds(62, 152, 70, 20);
        b2.setBounds(170, 152, 132, 20);
        
        getContentPane().add(l3);
        getContentPane().add(l4);
        getContentPane().add(l5);
        
        getContentPane().add(t1);
        getContentPane().add(t2);
        
        getContentPane().add(b1);
        getContentPane().add(b2);
        
        setBounds(200,200,400,250);
        setVisible(true);
        
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	 //call to payment
          	  frame.setVisible(false);
  				Payments.frame=new Payments();
  				Payments.frame.setVisible(true);
            }
            });
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	 //to get data
            	  try {
            		  
            		  String query= "SELECT * FROM movietheater.netbanking ;";
            		  stmt=con.prepareStatement(query);
          			rs=stmt.executeQuery();
          			 while(rs.next())
             		  {
             			 netBankUser=t1.getText();
             			 netBankUserCheck=rs.getString("NetBankUsername");
             			  if(netBankUserCheck.equals(netBankUser))
             			  {
             				  flagN=1;
             				  netBankPass=new String(t2.getPassword());
             				  netBankPassCheck=rs.getString("netBankingPass");
             				 
             				 if(netBankPassCheck.equals(netBankPass))
             				  {
             					 flagP=1;
             					frame.setVisible(false);
              	        	  PaymentConfirmation.frame=new PaymentConfirmation();
              	        	  PaymentConfirmation.frame.setVisible(true);
               	        	  break;
             				  }
             				 
             				  //to display the details and confirm payment
             				  
             			  }  
             			  }
             			  
             		  
             		  if(flagN==0)
             		  {
             			  JOptionPane.showMessageDialog(frame1, "Incorrect Username.");
             		  }
             		 if(flagP==0)
            		  {
            			  JOptionPane.showMessageDialog(frame1, "Incorrect Password.");
            		  }
             		
            	  
          				
          			} catch (SQLException e1) {
          				// TODO Auto-generated catch block
          				e1.printStackTrace();
          			}
              //final pay
            	
            }
            });
		
	}

}

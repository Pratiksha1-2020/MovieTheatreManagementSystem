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

import com.toedter.calendar.JDateChooser;

public class debitCard extends JFrame {
	
	private JPanel contentPane;
	
	static JFrame frame1;
	static java.util.Date Expiry_entered;
	String strDate;
	String cardHolderName;
	long CardNum;
	long CardNumCheck;
	int cvv;
	int cvvCheck;
	int flagN=0;
	int flagC=0;
	
	static Connection con;
	static ResultSet rs ;
	static PreparedStatement stmt;

	static debitCard frame ;
	private JPasswordField t4;
	private JTextField t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new debitCard();
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
	public debitCard() {
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


JLabel l1 = new JLabel("Debit Card");
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
t2.setEditable(false);
t2.setFont(new Font("Calibri", Font.PLAIN, 15));

JButton b1=new JButton("Back");
JButton b2=new JButton("Make Payment");

l1.setBounds(128,11,136,20);
l2.setBounds(40, 45, 100, 20);
l3.setBounds(40, 85, 118, 20);
l4.setBounds(40, 125, 100, 20);

t1.setBounds(202,40,150, 25);
t2.setBounds(202,85,150, 25);

b1.setBounds(10,230,70,20);
b2.setBounds(98,230,136,20);


contentPane.add(b1);
contentPane.add(b2);

contentPane.add(l1);
contentPane.add(l2);
contentPane.add(l3);
contentPane.add(l4);

contentPane.add(t1);
contentPane.add(t2);

JLabel l5 = new JLabel("CVV");
l5.setFont(new Font("Calibri", Font.PLAIN, 15));
l5.setBounds(40, 160, 100, 20);
contentPane.add(l5);
t4 = new JPasswordField("");
t4.setFont(new Font("Calibri", Font.PLAIN, 15));
t4.setEchoChar('*');
t4.setBounds(202, 160, 150, 25);
contentPane.add(t4);
t3 = new JTextField("");
t3.setEditable(false);
t3.setFont(new Font("Calibri", Font.PLAIN, 15));
t3.setBounds(202, 123, 150, 25);
contentPane.add(t3);
JButton btnAddNewCard = new JButton("Add New Card");
btnAddNewCard.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		frame.setVisible(false);
		debitCardAdd.frame=new debitCardAdd();
		debitCardAdd.frame.setVisible(true);
	}
});
btnAddNewCard.setBounds(256, 229, 118, 20);
contentPane.add(btnAddNewCard);




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
  		  
  		  String query= "SELECT * FROM movietheater.debitcard ;";
  		  stmt=con.prepareStatement(query);
			rs=stmt.executeQuery();
			 while(rs.next())
   		  {
   			  CardNum=Long.valueOf(t1.getText());
   			  CardNumCheck=rs.getLong("CardNumberd");
   			  if(CardNum==CardNumCheck)
   			  {
   				  flagN=1;
   				  cvv=Integer.valueOf(new String(t4.getPassword()));
   				  cvvCheck=Integer.valueOf(rs.getString("CVV"));
   				  if(cvv==cvvCheck)
   				  {
   					cardHolderName=rs.getString("CardHolderNameD");
     	        	  strDate = rs.getString("ExpiryDateD"); 
     	        	  
     	        	  t2.setText(cardHolderName);
     	        	  t3.setText(strDate);
     	        	  flagC=1;
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
   			  JOptionPane.showMessageDialog(frame1, "Card Number Does not exist. Enter Valid card or add the new card.");
   		  }
   		if(flagC==0)
 		  {
 			  JOptionPane.showMessageDialog(frame1, "Incorrect CVV entered.Enter Valid CVV.");
 		  }
  	  
  	  
  	  
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
  	// **********
	  //final pay page
    }
    });
setBounds(200,200,438,322);
setVisible(true);

  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

}
}

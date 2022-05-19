package courseProject;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import java.awt.Font;
import java.util.HashMap;
import java.util.Random;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;

public class Seats extends JFrame {

	private JPanel contentPane;
	static JPanel panel;
	private JTextField txtScreen;
	private JButton[][] btn = new JButton[13][20];
	private JLabel[] lbl = new JLabel[13];
	static int Random_Color_for_Seat_Booked;
	Random rand = new Random();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static Seats frame;
	
	static String seatBookTime;
	static String seatBookDate;
	
	static float totalAmount=0;
	static JFrame errorFrame;
	static JFrame confirmFrame;
	HashMap<String, JButton> buttonIDs = new HashMap<>();

	//number of seats to be booked
	static int numSeats=MovieDetails.numSeats;
	//static int numSeats=2;
	static String bookedSeats[]=new String[10];
	int flagN=0;
	int flagDT=0;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Seats();
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
	public Seats() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 805, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int x,y;
		//16 20
		panel = new JPanel();
		panel.setBounds(10, 2, 771, 555);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//JButton[][] btn = new JButton[16][20];
		String seatAplha[]= {"A","B","C","D","E","F","G","H","I","J","K","L","M"};
		
		//variables for hasmapping 
		// HashMap<String, JButton> buttonIDs = new HashMap<>();
		
		 JButton addBtnToHashmap;
		 
		 //to set seat numbers
		 String[] prefix = {"A","B","C","D","E","F","G","H","I","J","K","L","M"};
		 String[] postfix = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
		 String[][] seatNumber = new String[13][20];
		 for (int i = 0; i < 13; i++) {
	            for (int j = 0; j < 20; j++) {
	                seatNumber[i][j] = prefix[i] + postfix[j];
	            }
	        }
		 
		 JLabel l1=new JLabel("Platinum : 350 Rs");
		 JLabel l2=new JLabel("Gold : 240 Rs");
		 JLabel l3=new JLabel("Silver : 180 Rs");
		
		 
		l1.setBounds(70, 5, 120, 40);
		panel.add(l1);
		
		y=40;
			
		for (int i=0;i<5;i++)//A B C D E Platinum=350
		{
			x=70;
			lbl[i]=new JLabel(seatAplha[i]);
			lbl[i].setBounds(45, y, 24, 23);
			panel.add(lbl[i]);
			for (int j=0;j<20;j++)
			{
				btn[i][j]=new JButton("");
				addBtnToHashmap = btn[i][j];
                buttonIDs.put(seatNumber[i][j], addBtnToHashmap);
				btn[i][j].setBounds(x, y, 24, 23);
				Random_Color_for_Seat_Booked = rand.nextInt(2);
                if (Random_Color_for_Seat_Booked == 0) {
                    btn[i][j].setBackground(new Color(128, 0, 0));

                } else {
                    btn[i][j].setBackground(SystemColor.activeCaption);
                }
				panel.add(btn[i][j]);
				x=x+34;
			}
			y=y+31;
			
		}
		y=y+5;
		l2.setBounds(70, y, 120, 40);
		panel.add(l2);
		
		y=y+40;
		for (int i=5;i<9;i++)// F G H I  Gold = 220 
		{
			x=70;
			lbl[i]=new JLabel(seatAplha[i]);
			
			lbl[i].setBounds(45, y, 24, 23);
			panel.add(lbl[i]);
			for (int j=0;j<20;j++)
			{
				btn[i][j]=new JButton("");
				addBtnToHashmap = btn[i][j];
                buttonIDs.put(seatNumber[i][j], addBtnToHashmap);
				btn[i][j].setBounds(x, y, 24, 23);
				Random_Color_for_Seat_Booked = rand.nextInt(2);
                if (Random_Color_for_Seat_Booked == 0) {
                    btn[i][j].setBackground(new Color(128, 0, 0));

                } else {
                    btn[i][j].setBackground(SystemColor.activeCaption);
                }
				panel.add(btn[i][j]);
				x=x+34;
			}
			y=y+31;
			
		}
		
		y=y+5;
		l3.setBounds(70, y, 120, 40);
		panel.add(l3);
		
		 y = y+40;
		for (int i=9;i<13;i++)// J K L M  silver = 150 
		{
			x=70;
			lbl[i]=new JLabel(seatAplha[i]);
			lbl[i].setBounds(45, y, 24, 23);
			panel.add(lbl[i]);
			for (int j=0;j<20;j++)
			{
				btn[i][j]=new JButton("");
				addBtnToHashmap = btn[i][j];
                buttonIDs.put(seatNumber[i][j], addBtnToHashmap);
				btn[i][j].setBounds(x, y, 24, 23);
				Random_Color_for_Seat_Booked = rand.nextInt(2);
                if (Random_Color_for_Seat_Booked == 0) {
                    btn[i][j].setBackground(new Color(128, 0, 0));

                } else {
                    btn[i][j].setBackground(SystemColor.activeCaption);
                }
				panel.add(btn[i][j]);
				x=x+34;
			}
			y=y+31;
			
		}
		
		
		
		
		txtScreen = new JTextField();
		txtScreen.setEditable(false);
		txtScreen.setBackground(Color.GRAY);
		txtScreen.setFont(new Font("Calibri", Font.BOLD, 11));
		txtScreen.setText("                                                                                                                                                   ");
		txtScreen.setBounds(79, 570, 659, 20);
		contentPane.add(txtScreen);
		txtScreen.setColumns(1);
		
		textField = new JTextField();
		textField.setBackground(new Color(128, 0, 0));
		textField.setBounds(21, 620, 24, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.activeCaption);
		textField_1.setColumns(10);
		textField_1.setBounds(172, 620, 24, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Booked Seats");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 14));
		lblNewLabel.setBounds(55, 620, 98, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblAvailableSeats = new JLabel("Available Seats");
		lblAvailableSeats.setFont(new Font("Calibri", Font.BOLD, 14));
		lblAvailableSeats.setBounds(206, 620, 98, 20);
		contentPane.add(lblAvailableSeats);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.GREEN);
		textField_2.setColumns(10);
		textField_2.setBounds(314, 620, 24, 20);
		contentPane.add(textField_2);
		
		JLabel lblSelectedSeat = new JLabel("Selected Seat");
		lblSelectedSeat.setFont(new Font("Calibri", Font.BOLD, 14));
		lblSelectedSeat.setBounds(348, 620, 98, 20);
		contentPane.add(lblSelectedSeat);
		
		String[] cMessages={"Select Time","11.15","15.20","19.10","22.30"};
        JComboBox c1=new JComboBox(cMessages);
        c1.setModel(new DefaultComboBoxModel(new String[] {"Select Time", "11:15", "15:20", "19:10", "22:30"}));
        c1.setFont(new Font("Calibri", Font.PLAIN, 14));
        c1.setBounds(658, 620, 110, 23);
        contentPane.add(c1);
        
        String[] cMessages2={"Select Date","2022-02-03","2022-02-04","2022-02-05","2022-02-06"};
        JComboBox c2=new JComboBox(cMessages2);
        c2.setFont(new Font("Calibri", Font.PLAIN, 14));
        c2.setBounds(479, 620, 150, 23);
        contentPane.add(c2);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 frame.setVisible(false);
					MovieDetails.frame=new MovieDetails();
					MovieDetails.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton_1.setBounds(10, 655, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Book Seats");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//to check if all seats are selected
				if(flagN==numSeats)
				{
					
					
					
					//int check=JOptionPane.showConfirmDialog(confirmFrame,"Are you sure these is(are) your Seat(s).");
					int check = JOptionPane.showConfirmDialog(confirmFrame,"Are you sure these is(are) your Seat(s).", "Confirm Selection.",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					//call to payments
					//yes =0 , no=1
					if(check==0)
					{
						for(int i =0;i<numSeats;i++)
						{
							//to compute amount
							// J K L M  silver = 150 F G H I  Gold = 220 A B C D E Platinum=350
							if(bookedSeats[i].charAt(0)=='A'||bookedSeats[i].charAt(0)=='B'||bookedSeats[i].charAt(0)=='C'||bookedSeats[i].charAt(0)=='D'||bookedSeats[i].charAt(0)=='E')
							{
								totalAmount=totalAmount+350;
							}
							else if(bookedSeats[i].charAt(0)=='F'||bookedSeats[i].charAt(0)=='G'||bookedSeats[i].charAt(0)=='H'||bookedSeats[i].charAt(0)=='I')
							{
								totalAmount=totalAmount+220;
							}
							else if(bookedSeats[i].charAt(0)=='J'||bookedSeats[i].charAt(0)=='K'||bookedSeats[i].charAt(0)=='L'||bookedSeats[i].charAt(0)=='M')
							{
								totalAmount=totalAmount+180;
							}
						}
						String amt="Total amount is : "+totalAmount+". Confirm booking?";
						int check2 = JOptionPane.showConfirmDialog(confirmFrame,amt, "Confirm Payment.",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
						//call to payments
						//yes =0 , no=1
						if(check2==0)
						{
							//to get date and time 
							seatBookTime =(String) c1.getItemAt(c1.getSelectedIndex());
							seatBookDate =(String) c2.getItemAt(c2.getSelectedIndex());
							
							if(seatBookTime.equals("Select Time"))
							{
								JOptionPane.showMessageDialog(errorFrame,"Select The time for the show.");
							}
							else if (seatBookDate.equals("Select Date"))
							{
								JOptionPane.showMessageDialog(errorFrame,"Select The date for the show.");
							}
							else
							{
								frame.setVisible(false);
								Payments.frame=new Payments();
								Payments.frame.setVisible(true);
							}
								
								
							
							
							
						}
					}
					
					
					          
				}
				else
				{
					int temp=numSeats-flagN;
					String t="Select "+temp+" more Seat(s) before booking.";
					JOptionPane.showMessageDialog(errorFrame,t );
				}
				
			}
		});
		btnNewButton_1_1.setFont(new Font("Calibri", Font.BOLD, 14));
		btnNewButton_1_1.setBounds(642, 654, 139, 23);
		contentPane.add(btnNewButton_1_1);
		
		seatClicked();
	}
	
	//for the function after the seat is selected
	public void seatClicked() {
        Component[] components = panel.getComponents();
        JButton btn1;

        for (Component comp : components) {
            if (comp instanceof JButton ) {
                btn1 = (JButton) comp;
                
                btn1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	//to check if the seat selected is booked
                    	if(comp.getBackground().equals(new Color(128, 0, 0)))
                    	{
                    		JOptionPane.showMessageDialog(errorFrame, "This seat is already booked.");
                    	}
                    	//changed comp to btn
                    	//to check it is available and book it and check if the number of seats selected is less than entered
	                    else if (comp.getBackground().equals(SystemColor.activeCaption)) 
	                    {
	                    	if(flagN<numSeats)
	                    	{
	                    		comp.setBackground(Color.GREEN);
		                    	bookedSeats[flagN]=getSeatNumber((JButton)comp);
		                    	flagN++;
	                    	}
	                    	else
	                    	{
	                    		int temp=numSeats;
	        					String t="Select only "+temp+" Seat(s) for booking.";
	                    		JOptionPane.showMessageDialog(errorFrame, t);
	                    	}
	                    	
	                    	
	                    	
	                    }
                    	//to unselect the seats 
	                    else if (comp.getBackground().equals(Color.GREEN) ) 
	                    {
	                    	comp.setBackground(SystemColor.activeCaption);
	                    	for(int i=0;i<numSeats;i++)
	                    	{
	                    		if(bookedSeats[i].equals(getSeatNumber((JButton)comp)))
	                    		{
	                    			bookedSeats[i]=null;
	                    		}
	                    	}	                    	
	                    	flagN--;
	                    }
	                    
                        

                        //  System.out.println("BUTTON CLICKED : " + buttonIDs.);
                    }
                });
            }
            
            
        }
    }
	
	
	// to get seat number
	public String getSeatNumber(JButton btn) {
        Object[] tempKeyArray = new Object[buttonIDs.size()];
        tempKeyArray = buttonIDs.keySet().toArray();
        for (int i = 0; i < buttonIDs.size(); i++) {

            if (btn == buttonIDs.get(tempKeyArray[i])) {
                return (String) tempKeyArray[i];

            }

        }
        return null;
    }
}

package courseProject;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
/*
import movieBackup.creditCard;
import movieBackup.debitCard;
import movieBackup.netBanking;
*/

public class Payments extends JFrame {

	private JPanel contentPane;
	static Payments frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Payments();
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
	public Payments() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Payment");
		l1.setFont(new Font("Calibri", Font.BOLD, 20));
        JLabel l2 = new JLabel("Select a Method for Payment");
        l2.setFont(new Font("Calibri", Font.PLAIN, 14));
        JButton b1=new JButton("Back");
        JButton b2=new JButton("Next");
        String[] cMessages={"Select","Netbanking","Debit Card","Credit Card"};
        JComboBox c1=new JComboBox(cMessages);
        c1.setFont(new Font("Calibri", Font.PLAIN, 14));
        
        
        l1.setBounds(147, 21, 100, 20);
        l2.setBounds(28, 70, 175, 20);
        b1.setBounds(74,128,100,20);
        b2.setBounds(194,128,100,20);
        c1.setBounds(227, 70, 100, 20);
        
        getContentPane().add(l1);
        getContentPane().add(l2);
        getContentPane().add(b1);
        getContentPane().add(b2);
        getContentPane().add(c1);
        
        setBounds(200,200,400,250);
        setVisible(true);
        
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String data=(String) c1.getItemAt(c1.getSelectedIndex());
                if("Netbanking".equals(data))
                {
                    frame.setVisible(false);
            		netBanking.frame=new netBanking();
            		netBanking.frame.setVisible(true);
                }
                else if("Debit Card".equals(data))
                {
                	frame.setVisible(false);
            		debitCard.frame=new debitCard();
            		debitCard.frame.setVisible(true);
                }
                else if("Credit Card".equals(data))
                {
                   
                	frame.setVisible(false);
    				creditCard.frame=new creditCard();
    				creditCard.frame.setVisible(true);
                	
                }
            }
            });
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

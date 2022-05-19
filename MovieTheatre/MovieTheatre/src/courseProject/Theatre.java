package courseProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Theatre extends JFrame {

	private JPanel contentPane;
	static Theatre frame;
	static String theatreName="INOX cinemas";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Theatre();
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
	public Theatre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Theatre");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 22));
		lblNewLabel.setBounds(172, 11, 92, 28);
		contentPane.add(lblNewLabel);
		
		String[] cMessages={"Select","Inox","Nucleus"};
        JComboBox c1=new JComboBox(cMessages);
        c1.setFont(new Font("Calibri", Font.PLAIN, 14));
        c1.setBounds(254, 64, 110, 23);
        contentPane.add(c1);
        
        JLabel lblNewLabel_1 = new JLabel("Select Theatre");
        lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(69, 66, 110, 21);
        contentPane.add(lblNewLabel_1);
        
        JButton btnNewButton = new JButton("Select Seats");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String t =(String) c1.getItemAt(c1.getSelectedIndex());
        		
        		if(t.equals("Inox"))
        			{
        				theatreName="INOX cinemas";
        			}
        		else if(t.equals("Nucleus"))
        		{
        			theatreName="Nucleus Mall";
        		}
        		 frame.setVisible(false);
 				Seats.frame=new Seats();
 				Seats.frame.setVisible(true);
        	}
        });
        btnNewButton.setFont(new Font("Calibri", Font.BOLD, 17));
        btnNewButton.setBounds(136, 116, 137, 23);
        contentPane.add(btnNewButton);
	}
}

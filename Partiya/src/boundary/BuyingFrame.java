package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

public class BuyingFrame {

	private JFrame frame;
	private JTextField nametf;
	private JTextField idtf;
	private JTextField cardnumtf;
	private JTextField CVVtf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyingFrame window = new BuyingFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BuyingFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 468);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelname = new JLabel("Your Name:");
		labelname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelname.setBounds(41, 113, 90, 25);
		frame.getContentPane().add(labelname);
		
		JLabel labelid = new JLabel("Id:");
		labelid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelid.setBounds(41, 148, 77, 25);
		frame.getContentPane().add(labelid);
		
		JLabel lblCardNumber = new JLabel("Card number:");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCardNumber.setBounds(41, 183, 101, 25);
		frame.getContentPane().add(lblCardNumber);
		
		JLabel lblExpirtedDate = new JLabel("Expirted date:");
		lblExpirtedDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExpirtedDate.setBounds(41, 218, 101, 25);
		frame.getContentPane().add(lblExpirtedDate);
		
		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCvv.setBounds(41, 253, 77, 25);
		frame.getContentPane().add(lblCvv);
		
		nametf = new JTextField();
		nametf.setBounds(138, 118, 96, 19);
		frame.getContentPane().add(nametf);
		nametf.setColumns(10);
		
		idtf = new JTextField();
		idtf.setColumns(10);
		idtf.setBounds(138, 153, 96, 19);
		frame.getContentPane().add(idtf);
		
		cardnumtf = new JTextField();
		cardnumtf.setColumns(10);
		cardnumtf.setBounds(138, 188, 96, 19);
		frame.getContentPane().add(cardnumtf);
		
		CVVtf = new JTextField();
		CVVtf.setColumns(10);
		CVVtf.setBounds(138, 258, 96, 19);
		frame.getContentPane().add(CVVtf);
		
		JLabel lblNewLabel = new JLabel("Safety Buy");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(182, 25, 174, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(194, 314, 142, 45);
		frame.getContentPane().add(btnNewButton);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(138, 218, 96, 19);
		frame.getContentPane().add(dateChooser);
	}
}

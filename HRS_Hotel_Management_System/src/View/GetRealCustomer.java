package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Customer;
import model.Hotel;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
/*   Samar Amoun 212247431  */
public class GetRealCustomer {

	private JFrame frame;
	private JTextField IDtxtF;
	private JLabel EnterLabel;
	private JLabel FNameLabel;
	private JTextField fnametxt;
	private JLabel LNameLabel;
	private JTextField lnametxt;
	private JLabel PhoneLabel;
	private JTextField phonetxt;
	private JTextField JoiningTxt;
	private JTextField YearTxt;
	private JTextField GenderTxt;
	private JTextField AreaTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetRealCustomer window = new GetRealCustomer();
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
	public GetRealCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);

		EnterLabel = new JLabel("Please provide the ID of the customer you're seeking:");
		EnterLabel.setForeground(Color.WHITE);
		EnterLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		EnterLabel.setBounds(33, 75, 354, 41);
		frame.getContentPane().add(EnterLabel);

		IDtxtF = new JTextField();
		IDtxtF.setBounds(378, 80, 111, 28);
		frame.getContentPane().add(IDtxtF);
		IDtxtF.setColumns(10);

		JButton EnterBtn = new JButton("enter");
		EnterBtn.setBackground(Color.WHITE);
		EnterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Customer c = Hotel.getInstance().getRealCustomer(IDtxtF.getText());
				if (c != null) {
					
					fnametxt.setText(c.getFirstName());
					lnametxt.setText(c.getLastName());
					phonetxt.setText(c.getPhoneNumber());
					GenderTxt.setText(c.getGender() + "");
					AreaTxt.setText(c.getArea() + "");
					YearTxt.setText(c.getYearOfBirth() + "");
					JoiningTxt.setText(c.getDateOfJoining() + "");
				
				}
				else
					JOptionPane.showMessageDialog(frame, " invalid data or the Customer not found!");

			}
		});
		EnterBtn.setBounds(507, 85, 85, 21);
		frame.getContentPane().add(EnterBtn);

		FNameLabel = new JLabel("First Name:");
		FNameLabel.setForeground(Color.WHITE);
		FNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		FNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		FNameLabel.setBounds(33, 177, 95, 13);
		frame.getContentPane().add(FNameLabel);

		fnametxt = new JTextField();
		fnametxt.setEditable(false);
		fnametxt.setColumns(10);
		fnametxt.setBounds(159, 173, 110, 25);
		frame.getContentPane().add(fnametxt);

		LNameLabel = new JLabel("Last Name:");
		LNameLabel.setForeground(Color.WHITE);
		LNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		LNameLabel.setBounds(10, 228, 130, 20);
		frame.getContentPane().add(LNameLabel);

		lnametxt = new JTextField();
		lnametxt.setEditable(false);
		lnametxt.setColumns(10);
		lnametxt.setBounds(159, 228, 110, 25);
		frame.getContentPane().add(lnametxt);

		PhoneLabel = new JLabel("Phone Number:");
		PhoneLabel.setForeground(Color.WHITE);
		PhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		PhoneLabel.setBounds(24, 289, 116, 13);
		frame.getContentPane().add(PhoneLabel);

		phonetxt = new JTextField();
		phonetxt.setEditable(false);
		phonetxt.setText("");
		phonetxt.setColumns(10);
		phonetxt.setBounds(159, 285, 110, 25);
		frame.getContentPane().add(phonetxt);

		JLabel GenderLabel = new JLabel("Gender:");
		GenderLabel.setForeground(Color.WHITE);
		GenderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GenderLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		GenderLabel.setBounds(39, 350, 89, 13);
		frame.getContentPane().add(GenderLabel);

		JLabel AreaLabel = new JLabel("Area:");
		AreaLabel.setForeground(Color.WHITE);
		AreaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AreaLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		AreaLabel.setBounds(33, 397, 89, 13);
		frame.getContentPane().add(AreaLabel);

		JLabel BirthYLabel = new JLabel("Year of birth:");
		BirthYLabel.setForeground(Color.WHITE);
		BirthYLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BirthYLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		BirthYLabel.setBounds(378, 173, 110, 25);
		frame.getContentPane().add(BirthYLabel);

		JLabel DateJoinLabel = new JLabel("Date of joining:");
		DateJoinLabel.setForeground(Color.WHITE);
		DateJoinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DateJoinLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		DateJoinLabel.setBounds(378, 228, 120, 25);
		frame.getContentPane().add(DateJoinLabel);

		JoiningTxt = new JTextField();
		JoiningTxt.setEditable(false);
		JoiningTxt.setColumns(10);
		JoiningTxt.setBounds(522, 223, 174, 25);
		frame.getContentPane().add(JoiningTxt);

		YearTxt = new JTextField();
		YearTxt.setEditable(false);
		YearTxt.setColumns(10);
		YearTxt.setBounds(522, 173, 110, 25);
		frame.getContentPane().add(YearTxt);

		GenderTxt = new JTextField();
		GenderTxt.setEditable(false);
		GenderTxt.setColumns(10);
		GenderTxt.setBounds(159, 345, 110, 25);
		frame.getContentPane().add(GenderTxt);

		AreaTxt = new JTextField();
		AreaTxt.setEditable(false);
		AreaTxt.setColumns(10);
		AreaTxt.setBounds(159, 396, 110, 25);
		frame.getContentPane().add(AreaTxt);
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/s.jpg"));
			JPanel panel = new JPanel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
				}
			};
			panel.setBounds(0, 0, 950, 500);
			panel.setLayout(null);
			
			frame.getContentPane().add(panel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package View;

import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import Exceptions.MyExeption;
import model.Customer;
import model.Hotel;
import model.Person;
import model.PersonAlreadyExistException;
import model.VIPCustomer;
import utils.Service;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JYearChooser;
import java.awt.Color;

/*   Samar Amoun 212247431   */
public class AddCustomer {

	private JFrame frame;
	private JTextField IDtextF;
	private JTextField FNametextF;
	private JTextField PhonetextF;
	private JTextField LNametextF;
	private Choice GenderCh;
	private JLabel FNameLabel;
	private JLabel IdLabel;
	private JLabel LNameLabel;
	private JLabel PhoneLabel;
	private JLabel GenderLabel;
	private JLabel AreaLabel;
	private Choice AreaCh;
	private JLabel BirthYLabel;
	private JButton SubmitBtn_1;
	private JLabel DateJoinLabel;
	private JLabel VipLabel;
	private Choice VipCh;
	private JTextField DiscountTxtF;
	private JLabel DiscountLabel;
	private JDateChooser dateofjoin;
	private JYearChooser Birthday;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer window = new AddCustomer();
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
	public AddCustomer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);

		IDtextF = new JTextField();
		IDtextF.setBounds(135, 90, 110, 25);
		frame.getContentPane().add(IDtextF);
		IDtextF.setColumns(10);

		FNametextF = new JTextField();
		FNametextF.setBounds(135, 140, 110, 25);
		frame.getContentPane().add(FNametextF);
		FNametextF.setColumns(10);

		PhonetextF = new JTextField();
		PhonetextF.setText("");
		PhonetextF.setColumns(10);
		PhonetextF.setBounds(135, 240, 110, 25);
		frame.getContentPane().add(PhonetextF);

		LNametextF = new JTextField();
		LNametextF.setText("");
		LNametextF.setColumns(10);
		LNametextF.setBounds(135, 190, 110, 25);
		frame.getContentPane().add(LNametextF);

		GenderCh = new Choice();
		GenderCh.setBounds(135, 291, 110, 18);
		frame.getContentPane().add(GenderCh);
		GenderCh.add("-");
		GenderCh.add("F");
		GenderCh.add("M");

		FNameLabel = new JLabel("First Name:");
		FNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		FNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		FNameLabel.setBounds(12, 145, 95, 13);
		frame.getContentPane().add(FNameLabel);

		IdLabel = new JLabel("ID:");
		IdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IdLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		IdLabel.setBounds(41, 95, 45, 13);
		frame.getContentPane().add(IdLabel);

		LNameLabel = new JLabel(" Last Name:");
		LNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		LNameLabel.setBounds(10, 195, 100, 13);
		frame.getContentPane().add(LNameLabel);

		PhoneLabel = new JLabel("Phone Number:");
		PhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		PhoneLabel.setBounds(10, 245, 116, 13);
		frame.getContentPane().add(PhoneLabel);

		GenderLabel = new JLabel("Gender:");
		GenderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GenderLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		GenderLabel.setBounds(18, 295, 89, 13);
		frame.getContentPane().add(GenderLabel);

		AreaLabel = new JLabel("Area:");
		AreaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AreaLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		AreaLabel.setBounds(300, 95, 89, 13);
		frame.getContentPane().add(AreaLabel);

		AreaCh = new Choice();
		AreaCh.setBounds(420, 91, 110, 18);
		frame.getContentPane().add(AreaCh);
		AreaCh.add("-");
		AreaCh.add("Jerusalem");
		AreaCh.add("Northern");
		AreaCh.add("Haifa");
		AreaCh.add("Central");
		AreaCh.add("TelAviv");
		AreaCh.add("Southern");
		AreaCh.add("JudeaAndSamaria");

		BirthYLabel = new JLabel("Year of birth:");
		BirthYLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BirthYLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		BirthYLabel.setBounds(289, 138, 110, 25);
		frame.getContentPane().add(BirthYLabel);

		SubmitBtn_1 = new JButton("Add!");
		SubmitBtn_1.setBackground(Color.WHITE);
		SubmitBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addTheCustomer();
					
				} catch (MyExeption e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(frame, e2.getMessage());	
				}

			}
		});
		SubmitBtn_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		SubmitBtn_1.setBounds(380, 385, 150, 40);
		frame.getContentPane().add(SubmitBtn_1);

		DateJoinLabel = new JLabel("Date of joining:");
		DateJoinLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DateJoinLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		DateJoinLabel.setBounds(563, 88, 120, 25);
		frame.getContentPane().add(DateJoinLabel);

		VipLabel = new JLabel("is the customer vip?");
		VipLabel.setHorizontalAlignment(SwingConstants.CENTER);
		VipLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		VipLabel.setBounds(266, 188, 150, 25);
		frame.getContentPane().add(VipLabel);

		VipCh = new Choice();
		VipCh.setBounds(420, 190, 110, 18);
		frame.getContentPane().add(VipCh);
		VipCh.add("-");
		VipCh.add("Yes");
		VipCh.add("No");
		VipCh.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (VipCh.getSelectedItem().equals("Yes")) {
					DiscountLabel.setVisible(true);
					DiscountTxtF.setVisible(true);
				} else {
					DiscountLabel.setVisible(false);
					DiscountTxtF.setVisible(false);
				}

			}
		});

		DiscountTxtF = new JTextField();
		DiscountTxtF.setText("");
		DiscountTxtF.setColumns(10);
		DiscountTxtF.setBounds(420, 240, 110, 25);
		frame.getContentPane().add(DiscountTxtF);
		DiscountTxtF.setVisible(false); // must change to true when VipCh is true

		DiscountLabel = new JLabel("Discount percentage:");
		DiscountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DiscountLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		DiscountLabel.setBounds(255, 238, 159, 25);
		frame.getContentPane().add(DiscountLabel);
		
		dateofjoin = new JDateChooser();
		dateofjoin.setBounds(688, 96, 110, 19);
		frame.getContentPane().add(dateofjoin);
		
		Birthday = new JYearChooser();
		Birthday.setBounds(424, 139, 106, 19);
		frame.getContentPane().add(Birthday);
		DiscountLabel.setVisible(false);
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/10.jpg"));
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
	
	//get details and checks them if they're right
	public Customer gettheCustomer() throws MyExeption {
		Person p = Service.getTheperson(IDtextF, FNametextF, LNametextF, PhonetextF, GenderCh, AreaCh, Birthday);
		
		Date doj = dateofjoin.getDate();
		Customer c = null;		
		try {
			if (Service.isNum(p.getId()) && !p.getFirstName().isEmpty() && !p.getLastName().isEmpty() && Service.isNum(p.getPhoneNumber()) && p.getArea() != null
					&& p.getGender() != null && p.getYearOfBirth()<java.time.LocalDate.now().getYear() && p.getYearOfBirth()!=0 && (Service.isGoodDate(doj)==-1 ||Service.isGoodDate(doj)==0) ) {
				c = new Customer(p.getId(),p.getFirstName(),p.getLastName(),p.getPhoneNumber(),p.getArea(),p.getGender(),p.getYearOfBirth(), doj);
			} else
				throw new MyExeption("Something wrong,Please fill right data!!!");
		} catch (MyExeption e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}

		return c;

	}
	
	//adds the customer to the hash of customers
	public void addTheCustomer() throws MyExeption {
		Customer c = gettheCustomer();
		if (c != null) {
			if (VipCh.getSelectedItem().equals("No") || VipCh.getSelectedItem().equals("-")) {
				try {
					if (Hotel.getInstance().addCustomer(c)) {
						JOptionPane.showMessageDialog(frame, "The Customer has been added successfully");
						emptyFeilds();

					}
				} catch (PersonAlreadyExistException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			} else {
				String distxt = DiscountTxtF.getText();
				double disc = -1;
				if (Service.isNum(distxt)) {
					disc = Double.valueOf(DiscountTxtF.getText());
					VIPCustomer vc = new VIPCustomer(c.getId(), c.getFirstName(), c.getLastName(), c.getPhoneNumber(),
							c.getArea(), c.getGender(), c.getYearOfBirth(), c.getDateOfJoining(), disc);
					try {
						if (Hotel.getInstance().addVIPCustomer(vc)) {
							JOptionPane.showMessageDialog(frame, "The Customer has been added successfully");
							emptyFeilds();
							VipCh.select(0);
							DiscountTxtF.setText("");
							DiscountTxtF.setVisible(false);
						}
					} catch (PersonAlreadyExistException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(frame, e.getMessage());
					}

				} else
					JOptionPane.showMessageDialog(frame, "Please enter right value!!");

			}

		}

	}
	
	//help method to empty the fields right after adding one 
	void emptyFeilds(){
		IDtextF.setText("");
		FNametextF.setText("");
		LNametextF.setText("");
		PhonetextF.setText("");
		Birthday.setYear(Year.now().getValue());
		dateofjoin.setDate(null);
		AreaCh.select(0);
		GenderCh.select(0);
		
	}
}

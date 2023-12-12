package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;

import Exceptions.MyExeption;
import model.Booking;
import model.Customer;
import model.Hotel;
import model.Room;
import utils.Service;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import java.awt.Color;

/*   Samar Amoun  212247431  */

public class AddBooking {

	private JFrame frame;
	private JTextField NumDaysTxt;
	private JTextField totalPTxt;
	private JDateChooser dateChooser;
	private JComboBox<model.Customer> CustomerscomboBox;
	private Choice RoomNumch;
	ArrayList<Customer> allcus;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooking window = new AddBooking();
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
	public AddBooking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);
		
		JLabel RoomNumLabel = new JLabel("Room number:");
		RoomNumLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RoomNumLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		RoomNumLabel.setBounds(10, 145, 130, 20);
		frame.getContentPane().add(RoomNumLabel);
		
		JLabel CustomerLabel = new JLabel("Customer:");
		CustomerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CustomerLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		CustomerLabel.setBounds(10, 195, 109, 20);
		frame.getContentPane().add(CustomerLabel);
		
		JLabel InDateLabel = new JLabel("Chech-in date:");
		InDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		InDateLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		InDateLabel.setBounds(369, 105, 130, 20);
		frame.getContentPane().add(InDateLabel);
		
		JLabel DaysLabel = new JLabel("Number of days:");
		DaysLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DaysLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		DaysLabel.setBounds(369, 155, 130, 20);
		frame.getContentPane().add(DaysLabel);
		
		JLabel TotalPLabel = new JLabel("Total price:");
		TotalPLabel.setHorizontalAlignment(SwingConstants.CENTER);
		TotalPLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		TotalPLabel.setBounds(293, 269, 130, 20);
		frame.getContentPane().add(TotalPLabel);
		
		NumDaysTxt = new JTextField();
		NumDaysTxt.setColumns(10);
		NumDaysTxt.setBounds(509, 155, 110, 25);
		frame.getContentPane().add(NumDaysTxt);
		
		totalPTxt = new JTextField();
		totalPTxt.setColumns(10);
		totalPTxt.setBounds(424, 269, 110, 25);
		totalPTxt.setEditable(false);
		frame.getContentPane().add(totalPTxt);
		
		CustomerscomboBox = new JComboBox<model.Customer>();
		CustomerscomboBox.setBounds(130, 195, 668, 25);
		frame.getContentPane().add(CustomerscomboBox);
		allcus  = new ArrayList<Customer>();
		for(model.Customer c:Hotel.getInstance().getAllCustomers().values()) {
			allcus.add(c);
		}
		CustomerscomboBox.setModel(new DefaultComboBoxModel(allcus.toArray()));
		CustomerscomboBox.setVisible(true);
		
		JButton SubmitBtn_1 = new JButton("Add Booking!");
		SubmitBtn_1.setBackground(Color.WHITE);
		SubmitBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addthebooking();
				dateChooser.setDate(null);
				NumDaysTxt.setText("");
				totalPTxt.setText("");
			}
		});
		SubmitBtn_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		SubmitBtn_1.setBounds(355, 385, 179, 40);
		frame.getContentPane().add(SubmitBtn_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(509, 105, 110, 19);
		frame.getContentPane().add(dateChooser);
		
		JButton Calc = new JButton("Show price");
		Calc.setFont(new Font("Tahoma", Font.ITALIC, 11));
		Calc.setBackground(Color.WHITE);
		Calc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				try {
					Booking b = getTheBooking();
					totalPTxt.setText(b.getTotalCost()+"");
				} catch (MyExeption e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e1.getMessage());
					
				}
			}
		});
		Calc.setBounds(560, 265, 130, 32);
		frame.getContentPane().add(Calc);
		
		RoomNumch = new Choice();
		RoomNumch.setBounds(146, 147, 119, 18);
		frame.getContentPane().add(RoomNumch);
		HashMap<String,Room> allr = Hotel.getInstance().getAllRooms();
		for(Room r:allr.values()) {
			RoomNumch.add(r.getRoomNumber());
		}
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/6.jpg"));
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
	
	//this method gets the details and checks them 
	public Booking getTheBooking() throws MyExeption {
		String roomnum = RoomNumch.getSelectedItem();
		Customer c = (Customer) CustomerscomboBox.getSelectedItem();
		Date d= dateChooser.getDate();
		String numofdays = NumDaysTxt.getText();
		Booking b = null;
		if(!roomnum.equals("") && d!=null && !numofdays.equals("") && !roomnum.isEmpty() && !numofdays.isEmpty() && Service.isGoodDate(d)<0){
			Integer nod = Integer.parseInt(numofdays);
			b= new Booking(roomnum, c, d,nod);
			
		}
		else
			throw new MyExeption("Something wrong,Please fill right data!!!");
		return b;
		
	}
	
	
	//this method helps us to add a booking to the data base
	public void addthebooking() {
		Booking b;
		try {
			b = getTheBooking();
				if(Hotel.getInstance().addBooking(b)) {
					JOptionPane.showMessageDialog(frame, "The Booking has been adden successfully");
					
				}
		} catch (MyExeption e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(frame, e.getMessage());	
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(frame, e.getMessage());	
		}
	}
}

package View;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Hotel;
import model.Room;
import utils.Service;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.Color;
/* Samar Amoun  212247431*/

public class MainMeun {

	private JFrame frame;
	static JFrame intenal = new JFrame();
	private JMenuBar getDeatils;
	private JMenuItem User;
	private JMenuItem User_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMeun window = new MainMeun();

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
	public MainMeun() {
		initialize();
		Hotel.getInstance().readser();
		Room.readserNum();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 760, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton sound = new JButton("sound on");
		sound.setBackground(Color.WHITE);
		sound.setSize(110, 80);
		sound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Service.flag == false) {
					Service.clip.start();
					Service.flag = true;
					sound.setText("sound on");

				} else {
					Service.clip.stop();
					Service.flag = false;
					sound.setText("sound off");
				}
			}
		});
		
		Service.playAudio("MediaNSounds/sun.wav");

		frame.setVisible(true);
		getDeatils = new JMenuBar();
		frame.setJMenuBar(getDeatils);

		JMenu File = new JMenu("File");
		getDeatils.add(File);

		JMenuItem Savedata = new JMenuItem("Save");
		File.add(Savedata);
		Savedata.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Hotel.getInstance().writeser();
					Room.writeserNum();
					JOptionPane.showMessageDialog(frame, "The data has been seved successfully");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}

			}
		});

		JMenuItem wordDoc = new JMenuItem("Export as a Document");
		File.add(wordDoc);

		JMenuItem Exit = new JMenuItem("Exit");
		File.add(Exit);
		Exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				Service.clip.stop();

			}
		});
		wordDoc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				WordDocument.main(null);

			}
		});

		JMenu addM = new JMenu("Add");
		getDeatils.add(addM);

		JMenu AddrMenu = new JMenu("Room");
		addM.add(AddrMenu);

		JMenuItem StandRoom = new JMenuItem("Standard Room");
		AddrMenu.add(StandRoom);
		StandRoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddStanRoom.main(null);

			}
		});

		JMenuItem SupRoom = new JMenuItem("Superior Room");
		AddrMenu.add(SupRoom);
		SupRoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddSupRoom.main(null);

			}
		});

		JMenuItem SuitRoom = new JMenuItem("Suite Room");
		AddrMenu.add(SuitRoom);
		SuitRoom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddSuite.main(null);

			}
		});

		JMenuItem Customer = new JMenuItem("Regular/Vip customer");
		addM.add(Customer);
		Customer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddCustomer.main(null);
			}
		});

		User = new JMenuItem("Employee or Manager");
		addM.add(User);
		User.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AddEmployee.main(null);

			}
		});

		JMenuItem Department = new JMenuItem("Department");
		addM.add(Department);
		Department.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddDepartment.main(null);

			}
		});

		JMenuItem Booking = new JMenuItem("Booking");
		addM.add(Booking);
		Booking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddBooking.main(null);

			}
		});

		JMenu removeM = new JMenu("Remove");
		getDeatils.add(removeM);

		JMenu RemoverMenu = new JMenu("Room");
		removeM.add(RemoverMenu);

		JMenuItem StandRoom_1 = new JMenuItem("Standard Room");
		RemoverMenu.add(StandRoom_1);
		StandRoom_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RemoveStanRoom.main(null);

			}
		});

		JMenuItem SupRoom_1 = new JMenuItem("Superior Room");
		RemoverMenu.add(SupRoom_1);
		SupRoom_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RemoveSupRoom.main(null);

			}
		});

		JMenuItem SuitRoom_1 = new JMenuItem("Suite Room");
		RemoverMenu.add(SuitRoom_1);
		SuitRoom_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RemoveSuite.main(null);

			}
		});

		JMenuItem Customer_1 = new JMenuItem("Regular/Vip customer");
		removeM.add(Customer_1);
		Customer_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RemoveCustomer.main(null);

			}
		});

		User_1 = new JMenuItem("Employee or Manager");
		removeM.add(User_1);
		User_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RemoveEmployee.main(null);

			}
		});

		JMenuItem Department_1 = new JMenuItem("Department");
		removeM.add(Department_1);
		Department_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RemoveDepartment.main(null);

			}
		});

		JMenuItem Booking_1 = new JMenuItem("Booking");
		removeM.add(Booking_1);
		Booking_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RemoveBooking.main(null);

			}
		});

		JMenu getReal = new JMenu("Get Deatils");
		getDeatils.add(getReal);

		JMenu RoomsDetais = new JMenu("Rooms Details");
		getReal.add(RoomsDetais);

		JMenuItem RoomDetails = new JMenuItem("Room Details");
		RoomsDetais.add(RoomDetails);
		RoomDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GetRealRoom.main(null);

			}
		});

		JMenuItem StanDetails = new JMenuItem("Standard Room Details");
		RoomsDetais.add(StanDetails);
		StanDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GetRealStanRoom.main(null);

			}
		});

		JMenuItem SupRoomDetails = new JMenuItem("Suoerior Room Details");
		RoomsDetais.add(SupRoomDetails);
		SupRoomDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GetRealSupRoom.main(null);

			}
		});

		JMenuItem SuiteDetails = new JMenuItem("Suite Details");
		RoomsDetais.add(SuiteDetails);
		SuiteDetails.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GetRealSuite.main(null);

			}
		});

		JMenu CustomerReal = new JMenu("Customer Details");
		getReal.add(CustomerReal);

		JMenuItem RegReal = new JMenuItem("Regular Customer");
		CustomerReal.add(RegReal);
		RegReal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GetRealCustomer.main(null);

			}
		});

		JMenuItem VIPCus = new JMenuItem("VIP Customer");
		CustomerReal.add(VIPCus);
		VIPCus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GetRealVIPCustomer.main(null);

			}
		});

		JMenu empReal = new JMenu("Employee Details");
		getReal.add(empReal);

		JMenuItem RegEmp = new JMenuItem("Employee");
		empReal.add(RegEmp);
		RegEmp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GetRealEmployee.main(null);

			}
		});

		JMenuItem Managreal = new JMenuItem("DepartmentManager");
		empReal.add(Managreal);
		Managreal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GetRealDepManager.main(null);

			}
		});

		JMenuItem DepReal = new JMenuItem("Department Deatils");
		getReal.add(DepReal);
		DepReal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GetRealDepartment.main(null);

			}
		});

		JMenuItem BookingReal = new JMenuItem("Booking Deatils");
		getReal.add(BookingReal);
		BookingReal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GetRealBooking.main(null);

			}
		});

		JMenu Functions = new JMenu("Hotel Functions");
		getDeatils.add(Functions);

		JMenuItem kemp = new JMenuItem("K employees");
		Functions.add(kemp);

		JMenuItem SortedC = new JMenuItem("Sorted Customer");
		Functions.add(SortedC);

		JMenuItem SBooking = new JMenuItem("Sorted Booking");
		Functions.add(SBooking);

		JMenuItem sortedcus2 = new JMenuItem("Sorted Customer By Booking and Name");
		Functions.add(sortedcus2);

		JMenuItem profit = new JMenuItem("Total profit");
		Functions.add(profit);

		JMenuItem CusBooking = new JMenuItem("Customer Booking");
		Functions.add(CusBooking);

		JMenuItem mostCustomer = new JMenuItem("The Most Booked Customer");
		Functions.add(mostCustomer);
		SortedC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SortedCustomer.main(null);

			}
		});
		kemp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Kemp.main(null);

			}
		});

		SBooking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SortedBookings.main(null);

			}
		});
		sortedcus2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SortedCustomerByBAndN.main(null);

			}
		});

		profit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(frame, "The total profit is : " + Hotel.getInstance().totalProfit());

			}
		});
		CusBooking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CustomerBookings.main(null);

			}
		});
		mostCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model.Customer c = Hotel.getInstance().customerBookedTheMostRooms();
				JOptionPane.showMessageDialog(frame,
						"The Most Bookes Customer is : " + "id: " + c.getId() + ", " + "First Name:" + c.getFirstName()
								+ ", " + "Last Name" + c.getLastName() + ", " + "Phone Num" + c.getPhoneNumber());

			}
		});
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/main.jpg"));
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
			panel.setBounds(0, 0, 750, 500);
			panel.setLayout(null);
			panel.add(sound);
			sound.setBounds(600, 400, 100, 21);
			frame.getContentPane().add(panel);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public JMenuBar getGetDeatils() {
		return getDeatils;
	}

	public void setGetDeatils(JMenuBar getDeatils) {
		this.getDeatils = getDeatils;
	}

	public JMenuItem getUser() {
		return User;
	}

	public void setUser(JMenuItem user) {
		User = user;
	}

	public JMenuItem getUser_1() {
		return User_1;
	}

	public void setUser_1(JMenuItem user_1) {
		User_1 = user_1;
	}
}

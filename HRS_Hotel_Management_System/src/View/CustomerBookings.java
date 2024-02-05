package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import model.Booking;
import model.Customer;
import model.Hotel;
import utils.Service;
/* Samar Amoun  212247431*/

public class CustomerBookings {

	private JFrame frame;
	private JTextField idtxt;
	private JList<Booking> list;
	private DefaultListModel<Booking> bookingModel;
	private JScrollPane eScrollPane;
	private JButton sub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerBookings window = new CustomerBookings();
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
	public CustomerBookings() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);

		JLabel Customerid = new JLabel("Enter Customer id: ");
		Customerid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Customerid.setBounds(50, 26, 152, 26);
		frame.getContentPane().add(Customerid);

		idtxt = new JTextField();
		idtxt.setBounds(190, 32, 105, 19);
		frame.getContentPane().add(idtxt);
		idtxt.setColumns(10);

		bookingModel = new DefaultListModel<Booking>();
		eScrollPane = new JScrollPane();
		eScrollPane.setBounds(204, 62, 350, 350);

		frame.getContentPane().add(eScrollPane);
		list = new JList<Booking>(bookingModel);
		eScrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		sub = new JButton("Submit");
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idtxt.getText();
				if (Service.isNum(id)) {
					Customer c = Hotel.getInstance().getRealCustomer(id);
					if (c != null) {

						bookingModel.removeAllElements();
						List<Booking> li = Hotel.getInstance().allBookingsOfSpecCustomer(id);
						if (!li.isEmpty()) {
							for (Booking e1 : li) {
								bookingModel.addElement(e1);
							}
						}else {
							JOptionPane.showMessageDialog(frame, "Customer hasnt Bookings yet");
						}
					} else
						JOptionPane.showMessageDialog(frame, "Customer not found");
				} else
					JOptionPane.showMessageDialog(frame, "Invalid Input!!");

			}
		});
		sub.setBounds(315, 28, 99, 26);
		frame.getContentPane().add(sub);
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/sa.jpg"));
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

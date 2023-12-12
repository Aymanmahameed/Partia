package View;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Customer;
import model.Hotel;

/* Samar Amoun  212247431*/

public class SortedCustomerByBAndN {

	private JFrame frame;
	private JList<Customer> list;
	private DefaultListModel<Customer> empModel;
	private JScrollPane eScrollPane;
	private JButton sub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortedCustomerByBAndN window = new SortedCustomerByBAndN();
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
	public SortedCustomerByBAndN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);

		empModel = new DefaultListModel<Customer>();
		eScrollPane = new JScrollPane();
		eScrollPane.setBounds(10, 26, 843, 350);

		frame.getContentPane().add(eScrollPane);
		list = new JList<Customer>(empModel);
		eScrollPane.setViewportView(list);
		

		sub = new JButton("Show");
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				empModel.removeAllElements();
				TreeSet<Customer> li = Hotel.getInstance().allCustomersCmp();
				for (Customer c : li) {
					empModel.addElement(c);
				}

			}
		});
		sub.setBounds(351, 386, 99, 26);
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

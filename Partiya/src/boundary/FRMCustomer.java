package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;

import entity.Costumer;


import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FRMCustomer {

	static JFrame frameCustomer;

	/**
	 * Launch the application.
	 */
	private static Costumer c;
	
	
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					FRMCustomer.frameCustomer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @wbp.parser.entryPoint
	 */
	public FRMCustomer(Costumer c) {
		FRMCustomer.c = c;
		initialize();
		freindsItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameCustomer.setVisible(false);
				new FRMfriendship(c);

			}
		});

		showsitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameCustomer.setVisible(false);
				new FRMorder(c);

			}
		});
		logoutitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameCustomer.setVisible(false);
				new FRMLogin();

			}
		});
		ticketitem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new FRMTickets(c);

			}
		});
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameCustomer = new JFrame();
		frameCustomer.setBounds(500, 200, 791, 463);
		frameCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCustomer.getContentPane().setLayout(null);
		frameCustomer.setVisible(true);
		JLabel lblNewLabel = new JLabel("Hello " + FRMCustomer.c.getFirstName() + " " + c.getLastName());
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(261, 10, 276, 32);
		frameCustomer.getContentPane().add(lblNewLabel);

		menuBar = new JMenuBar();
		frameCustomer.setJMenuBar(menuBar);

		ticketitem = new JMenuItem("My tickets");
		menuBar.add(ticketitem);

		freindsItem = new JMenuItem("Friends");
		menuBar.add(freindsItem);

		showsitem = new JMenuItem("Parties And shows");
		menuBar.add(showsitem);

		Report = new JMenuItem("Reports");
		menuBar.add(Report);

		logoutitem = new JMenuItem("Log out");
		menuBar.add(logoutitem);
	}

	private JMenuBar menuBar;
	private JMenuItem showsitem;
	private JMenuItem logoutitem;
	private JMenuItem freindsItem;
	private JMenuItem ticketitem;
	private JMenuItem Report;

}

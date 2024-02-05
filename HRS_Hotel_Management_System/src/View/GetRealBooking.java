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

import model.Booking;
import model.Hotel;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
/*   Samar Amoun 212247431  */
public class GetRealBooking {

	private JFrame frame;
	private JTextField IDtxtF;
	private JLabel EnterLabel; 
	private JLabel InDateLabel;
	private JLabel DaysLabel;
	private JLabel TotalPLabel;
	private JTextField PriceTxtF;
	private JTextField DaysTxtF;
	private JTextField DateTxtF;
	private JTextField IDCusTxtF;
	private JTextField FNameTxtF;
	private JTextField LNameTxtF;
	private JLabel RoomLabel;
	private JTextField RoomNumTxt;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetRealBooking window = new GetRealBooking();
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
	public GetRealBooking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);
		
	    EnterLabel = new JLabel("Please provide the ID of the booking you're seeking:");
	    EnterLabel.setForeground(Color.WHITE);
		EnterLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		EnterLabel.setBounds(33, 120, 354, 41);
		frame.getContentPane().add(EnterLabel);
		
		IDtxtF = new JTextField();
		IDtxtF.setBounds(384, 120, 111, 28);
		frame.getContentPane().add(IDtxtF);
		IDtxtF.setColumns(10);
        
        JButton EnterBtn = new JButton("enter");
        EnterBtn.setBackground(Color.WHITE);
        EnterBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Booking b =Hotel.getInstance().getRealBooking(IDtxtF.getText());
        		if(b!=null) {
        			RoomNumTxt.setText(b.getRoomNumber()+"");
        			DaysTxtF.setText(b.getNumberOfDays()+"");
        			PriceTxtF.setText(b.getTotalCost()+"");
        			 
        			DateTxtF.setText(b.getCheckInDate()+"");
        			IDCusTxtF.setText(b.getCustomer().getId()+"");
        			FNameTxtF.setText(b.getCustomer().getFirstName());
        			LNameTxtF.setText(b.getCustomer().getLastName());
        		}
        		else
        		{
        			JOptionPane.showMessageDialog(frame, "Invalid data or Booking not found");
        		}
        	}
        });
        EnterBtn.setBounds(507, 125, 85, 21);
        frame.getContentPane().add(EnterBtn);
        
        InDateLabel = new JLabel("Chech-in date:");
        InDateLabel.setForeground(Color.WHITE);
        InDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        InDateLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        InDateLabel.setBounds(33, 369, 130, 20);
        frame.getContentPane().add(InDateLabel);
        
        DaysLabel = new JLabel("Number of days:");
        DaysLabel.setForeground(Color.WHITE);
        DaysLabel.setHorizontalAlignment(SwingConstants.CENTER);
        DaysLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        DaysLabel.setBounds(33, 255, 130, 20);
        frame.getContentPane().add(DaysLabel);
        
        TotalPLabel = new JLabel("Total price:");
        TotalPLabel.setForeground(Color.WHITE);
        TotalPLabel.setHorizontalAlignment(SwingConstants.CENTER);
        TotalPLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        TotalPLabel.setBounds(33, 313, 130, 20);
        frame.getContentPane().add(TotalPLabel);
        
        PriceTxtF = new JTextField();
        PriceTxtF.setEditable(false);
        PriceTxtF.setColumns(10);
        PriceTxtF.setBounds(173, 313, 110, 25);
        frame.getContentPane().add(PriceTxtF);
        
        DaysTxtF = new JTextField();
        DaysTxtF.setEditable(false);
        DaysTxtF.setColumns(10);
        DaysTxtF.setBounds(173, 255, 110, 25);
        frame.getContentPane().add(DaysTxtF);
        
        DateTxtF = new JTextField();
        DateTxtF.setEditable(false);
        DateTxtF.setColumns(10);
        DateTxtF.setBounds(173, 369, 180, 25);
        frame.getContentPane().add(DateTxtF);
        
        IDCusTxtF = new JTextField();
        IDCusTxtF.setEditable(false);
        IDCusTxtF.setColumns(10);
        IDCusTxtF.setBounds(549, 238, 110, 25);
        frame.getContentPane().add(IDCusTxtF);
        
        FNameTxtF = new JTextField();
        FNameTxtF.setEditable(false);
        FNameTxtF.setColumns(10);
        FNameTxtF.setBounds(549, 294, 110, 25);
        frame.getContentPane().add(FNameTxtF);
        
        LNameTxtF = new JTextField();
        LNameTxtF.setEditable(false);
        LNameTxtF.setColumns(10);
        LNameTxtF.setBounds(549, 347, 110, 25);
        frame.getContentPane().add(LNameTxtF);
        
        JLabel IDLabel = new JLabel("ID:");
        IDLabel.setForeground(Color.WHITE);
        IDLabel.setHorizontalAlignment(SwingConstants.CENTER);
        IDLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        IDLabel.setBounds(409, 238, 130, 20);
        frame.getContentPane().add(IDLabel);
        
        JLabel FNameLabel = new JLabel("First Name:");
        FNameLabel.setForeground(Color.WHITE);
        FNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        FNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        FNameLabel.setBounds(409, 294, 130, 20);
        frame.getContentPane().add(FNameLabel);
        
        JLabel LNameLabel = new JLabel("Last Name:");
        LNameLabel.setForeground(Color.WHITE);
        LNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        LNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        LNameLabel.setBounds(409, 347, 130, 20);
        frame.getContentPane().add(LNameLabel);
        
        JLabel CustomerLbl = new JLabel("Customer's Details:");
        CustomerLbl.setForeground(Color.WHITE);
        CustomerLbl.setHorizontalAlignment(SwingConstants.CENTER);
        CustomerLbl.setFont(new Font("Tahoma", Font.ITALIC, 16));
        CustomerLbl.setBounds(345, 196, 174, 20);
        frame.getContentPane().add(CustomerLbl);
        
        RoomLabel = new JLabel("Room Number:");
        RoomLabel.setForeground(Color.WHITE);
        RoomLabel.setHorizontalAlignment(SwingConstants.CENTER);
        RoomLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        RoomLabel.setBounds(33, 196, 130, 20);
        frame.getContentPane().add(RoomLabel);
        
        RoomNumTxt = new JTextField();
        RoomNumTxt.setEditable(false);
        RoomNumTxt.setColumns(10);
        RoomNumTxt.setBounds(173, 191, 110, 25);
        frame.getContentPane().add(RoomNumTxt);
        
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

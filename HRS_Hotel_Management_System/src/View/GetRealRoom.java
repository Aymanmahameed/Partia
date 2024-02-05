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

import model.Hotel;
import model.Room;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;


/*   Samar Amoun  212247431  */
public class GetRealRoom {

	private JFrame frame;
	private JTextField IDtxtF;
	private JLabel EnterLabel;
	private JLabel FloorLabel;
	private JTextField FloorTxt;
	private JLabel RGradeLabel;
	private JTextField RoomGradeTxt;
	private JLabel SizeLabel;
	private JTextField SizeTxt;
	private JLabel DPriceLabel;
	private JTextField PriceTxt;
	private JLabel AvgDCostLabel;
	private JTextField CostTxt;
	private JLabel lblMaximum;
	private JTextField PopulationTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetRealRoom window = new GetRealRoom();
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
	public GetRealRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);
		
		 EnterLabel = new JLabel("Please provide the ID of the room you're seeking:");
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
        		Room m = Hotel.getInstance().getAllRooms().get(IDtxtF.getText());
        		if(m!=null) {
        			FloorTxt.setText(m.getFloor()+"");
        			RoomGradeTxt.setText(m.getRoomGrade()+"");
        			SizeTxt.setText(m.getSize()+"");
        			PriceTxt.setText(m.getDailyPrice()+"");
        			CostTxt.setText(m.getAvgDailyCost()+"");
        			PopulationTxt.setText(m.getMaxPopulationCapacity()+"");
        			
        			
        		}else {
        			JOptionPane.showMessageDialog(frame, "The Room is not found or you enter valid data");
        		}
        	}
        });
        EnterBtn.setBounds(507, 85, 85, 21);
        frame.getContentPane().add(EnterBtn);
        
        FloorLabel = new JLabel("Floor:");
        FloorLabel.setForeground(Color.WHITE);
        FloorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        FloorLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        FloorLabel.setBounds(41, 173, 45, 20);
        frame.getContentPane().add(FloorLabel);
        
        FloorTxt = new JTextField();
        FloorTxt.setEditable(false);
        FloorTxt.setColumns(10);
        FloorTxt.setBounds(127, 173, 110, 25);
        frame.getContentPane().add(FloorTxt);
        
        RGradeLabel = new JLabel("Room Grade:");
        RGradeLabel.setForeground(Color.WHITE);
        RGradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        RGradeLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        RGradeLabel.setBounds(10, 225, 94, 20);
        frame.getContentPane().add(RGradeLabel);
        
        RoomGradeTxt = new JTextField();
        RoomGradeTxt.setEditable(false);
        RoomGradeTxt.setColumns(10);
        RoomGradeTxt.setBounds(127, 225, 110, 25);
        frame.getContentPane().add(RoomGradeTxt);
        
        SizeLabel = new JLabel("Size:");
        SizeLabel.setForeground(Color.WHITE);
        SizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        SizeLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        SizeLabel.setBounds(33, 267, 45, 20);
        frame.getContentPane().add(SizeLabel);
        
        SizeTxt = new JTextField();
        SizeTxt.setEditable(false);
        SizeTxt.setColumns(10);
        SizeTxt.setBounds(127, 270, 110, 25);
        frame.getContentPane().add(SizeTxt);
        
        DPriceLabel = new JLabel("Daily Price:");
        DPriceLabel.setForeground(Color.WHITE);
        DPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        DPriceLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        DPriceLabel.setBounds(23, 318, 81, 20);
        frame.getContentPane().add(DPriceLabel);
        
        PriceTxt = new JTextField();
        PriceTxt.setEditable(false);
        PriceTxt.setColumns(10);
        PriceTxt.setBounds(127, 318, 110, 25);
        frame.getContentPane().add(PriceTxt);
        
        AvgDCostLabel = new JLabel("Average Daily Cost:");
        AvgDCostLabel.setForeground(Color.WHITE);
        AvgDCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
        AvgDCostLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
        AvgDCostLabel.setBounds(327, 179, 149, 20);
        frame.getContentPane().add(AvgDCostLabel);
        
        CostTxt = new JTextField();
        CostTxt.setEditable(false);
        CostTxt.setColumns(10);
        CostTxt.setBounds(535, 173, 110, 25);
        frame.getContentPane().add(CostTxt);
        
        lblMaximum = new JLabel("Maximum population capacity:");
        lblMaximum.setForeground(Color.WHITE);
        lblMaximum.setHorizontalAlignment(SwingConstants.CENTER);
        lblMaximum.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblMaximum.setBounds(302, 231, 218, 20);
        frame.getContentPane().add(lblMaximum);
        
        PopulationTxt = new JTextField();
        PopulationTxt.setEditable(false);
        PopulationTxt.setColumns(10);
        PopulationTxt.setBounds(535, 228, 110, 25);
        frame.getContentPane().add(PopulationTxt);
        
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

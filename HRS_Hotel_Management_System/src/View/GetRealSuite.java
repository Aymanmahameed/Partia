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
import model.Suite;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*   Samar Amoun 212247431  */
public class GetRealSuite {

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
	private JLabel ViewLabel1;
	private JTextField ViewTxt;
	private JLabel ViewLabel2;
	private JLabel JaccoziLabel1;
	private JTextField JaccoziTxt;
	private JLabel JaccoziLabel2;
	private JLabel lblTheBalconySize;
	private JTextField BalconyTxt;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetRealSuite window = new GetRealSuite();
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
	public GetRealSuite() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);
		
		EnterLabel = new JLabel("Please provide the ID of the suite you're seeking:");
		EnterLabel.setForeground(Color.WHITE);
		EnterLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		EnterLabel.setBounds(33, 75, 411, 41);
		frame.getContentPane().add(EnterLabel);
		
		IDtxtF = new JTextField();
		IDtxtF.setBounds(413, 80, 111, 28);
		frame.getContentPane().add(IDtxtF);
		IDtxtF.setColumns(10);
		IDtxtF.setText("Suite");
        
        JButton EnterBtn = new JButton("enter");
        EnterBtn.setBackground(Color.WHITE);
        EnterBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Room m = Hotel.getInstance().getRealSuite(IDtxtF.getText());
				if (m != null) {
					if (m instanceof Suite) {
						FloorTxt.setText(m.getFloor() + "");
						RoomGradeTxt.setText(m.getRoomGrade() + "");
						SizeTxt.setText(m.getSize() + "");
						PriceTxt.setText(m.getDailyPrice() + "");
						CostTxt.setText(m.getAvgDailyCost() + "");
						PopulationTxt.setText(m.getMaxPopulationCapacity() + "");
						Boolean flag = ((Suite)m).isHasView();
						if(flag) {
							ViewTxt.setText("has");
						}
						else
							ViewTxt.setText("hasn`t");
						Boolean flag2 = ((Suite)m).isHasJaccozi();
						if(flag2) {
							JaccoziTxt.setText("has");
						}
						else
							JaccoziTxt.setText("hasn`t");
						BalconyTxt.setText(((Suite)m).getBalconySize()+"");
					}else {
						JOptionPane.showMessageDialog(frame, "The Room is not a Suite");
					}

				} else {
					JOptionPane.showMessageDialog(frame, "The Room is not found or you enter valid data");
				}
        	}
        });
        EnterBtn.setBounds(551, 85, 85, 21);
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
        
        ViewLabel1 = new JLabel("The room ");
        ViewLabel1.setForeground(Color.WHITE);
        ViewLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        ViewLabel1.setFont(new Font("Tahoma", Font.ITALIC, 16));
        ViewLabel1.setBounds(343, 270, 105, 20);
        frame.getContentPane().add(ViewLabel1);
        
        ViewTxt = new JTextField();
        ViewTxt.setEditable(false);
        ViewTxt.setColumns(10);
        ViewTxt.setBounds(454, 267, 85, 25);
        frame.getContentPane().add(ViewTxt);
        
        ViewLabel2 = new JLabel("a view");
        ViewLabel2.setForeground(Color.WHITE);
        ViewLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        ViewLabel2.setFont(new Font("Tahoma", Font.ITALIC, 16));
        ViewLabel2.setBounds(551, 270, 105, 20);
        frame.getContentPane().add(ViewLabel2);
        
        JaccoziLabel1 = new JLabel("The room ");
        JaccoziLabel1.setForeground(Color.WHITE);
        JaccoziLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        JaccoziLabel1.setFont(new Font("Tahoma", Font.ITALIC, 16));
        JaccoziLabel1.setBounds(343, 324, 105, 20);
        frame.getContentPane().add(JaccoziLabel1);
        
        JaccoziTxt = new JTextField();
        JaccoziTxt.setEditable(false);
        JaccoziTxt.setColumns(10);
        JaccoziTxt.setBounds(454, 321, 85, 25);
        frame.getContentPane().add(JaccoziTxt);
        
        JaccoziLabel2 = new JLabel("a jaccozi");
        JaccoziLabel2.setForeground(Color.WHITE);
        JaccoziLabel2.setHorizontalAlignment(SwingConstants.LEFT);
        JaccoziLabel2.setFont(new Font("Tahoma", Font.ITALIC, 16));
        JaccoziLabel2.setBounds(551, 324, 105, 20);
        frame.getContentPane().add(JaccoziLabel2);
        
        lblTheBalconySize = new JLabel("The balcony size:");
        lblTheBalconySize.setForeground(Color.WHITE);
        lblTheBalconySize.setHorizontalAlignment(SwingConstants.CENTER);
        lblTheBalconySize.setFont(new Font("Tahoma", Font.ITALIC, 16));
        lblTheBalconySize.setBounds(307, 369, 169, 20);
        frame.getContentPane().add(lblTheBalconySize);
        
        BalconyTxt = new JTextField();
        BalconyTxt.setEditable(false);
        BalconyTxt.setColumns(10);
        BalconyTxt.setBounds(486, 369, 110, 25);
        frame.getContentPane().add(BalconyTxt);
        
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

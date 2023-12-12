package View;

import java.awt.Choice;
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

import Exceptions.MyExeption;
import model.Hotel;
import model.MaxPopulationCapacityException;
import model.Room;
import model.StandardRoom;
import model.Suite;
import utils.Service;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*   Samar Amoun 212247431   */ 
public class AddSuite {

	private JFrame frame;
	private JTextField FloorTxtF;
	private JTextField RGradeTxtF;
	private JTextField SizeTxtF;
	private JTextField DPriceTxtF;
	private JTextField AvgCostTxtF;
	private JTextField BalconyTxtF;
	private Choice CapacityCh;
	private Choice JaccoziCh;
	private Choice ViewCh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSuite window = new AddSuite();
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
	public AddSuite() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);		
		JLabel FloorLabel = new JLabel("Floor:");
		FloorLabel.setBounds(41, 95, 45, 20);
		FloorLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		FloorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel RGradeLabel = new JLabel("Room Grade:");
		RGradeLabel.setBounds(23, 145, 94, 20);
		RGradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RGradeLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		
		JLabel SizeLabel = new JLabel("Size:");
		SizeLabel.setBounds(41, 195, 45, 20);
		SizeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SizeLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(FloorLabel);
		frame.getContentPane().add(SizeLabel);
		frame.getContentPane().add(RGradeLabel);
		
		FloorTxtF = new JTextField();
		FloorTxtF.setBounds(135, 90, 110, 25);
		frame.getContentPane().add(FloorTxtF);
		FloorTxtF.setColumns(10);
		
		RGradeTxtF = new JTextField();
		RGradeTxtF.setColumns(10);
		RGradeTxtF.setBounds(135, 140, 110, 25);
		frame.getContentPane().add(RGradeTxtF);
		
		SizeTxtF = new JTextField();
		SizeTxtF.setColumns(10);
		SizeTxtF.setBounds(135, 190, 110, 25);
		frame.getContentPane().add(SizeTxtF);
		
		JLabel DPriceLabel = new JLabel("Daily Price:");
		DPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DPriceLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		DPriceLabel.setBounds(36, 245, 81, 20);
		frame.getContentPane().add(DPriceLabel);
		
		JLabel AvgDCostLabel = new JLabel("Average Daily Cost:");
		AvgDCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AvgDCostLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		AvgDCostLabel.setBounds(359, 95, 149, 20);
		frame.getContentPane().add(AvgDCostLabel);
		
		JLabel lblMaximum = new JLabel("Maximum population capacity:");
		lblMaximum.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaximum.setFont(new Font("Tahoma", Font.ITALIC, 16));
		lblMaximum.setBounds(323, 145, 218, 20);
		frame.getContentPane().add(lblMaximum);
		
		JLabel ViewLabel = new JLabel("Does it has a view?");
		ViewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ViewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		ViewLabel.setBounds(359, 195, 138, 20);
		frame.getContentPane().add(ViewLabel);
		
		DPriceTxtF = new JTextField();
		DPriceTxtF.setColumns(10);
		DPriceTxtF.setBounds(135, 245, 110, 25);
		frame.getContentPane().add(DPriceTxtF);
		
		AvgCostTxtF = new JTextField();
		AvgCostTxtF.setColumns(10);
		AvgCostTxtF.setBounds(580, 90, 110, 25);
		frame.getContentPane().add(AvgCostTxtF);
		
		ViewCh = new Choice();
		ViewCh.setBounds(580, 190, 110, 18);
		frame.getContentPane().add(ViewCh);
		ViewCh.add("Yes");
		ViewCh.add("No");
		
		CapacityCh = new Choice();
		CapacityCh.setBounds(580, 140, 110, 18);
		frame.getContentPane().add(CapacityCh);
		CapacityCh.add("-");
		CapacityCh.add("1");
		CapacityCh.add("2");
		CapacityCh.add("3");
		CapacityCh.add("4");
		CapacityCh.add("5");
		CapacityCh.add("6");
		CapacityCh.add("7");
		
		JButton SubmitBtn = new JButton("Add suite!");
		SubmitBtn.setBackground(Color.WHITE);
		SubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addTheSuite();
				} catch (MyExeption e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e1.getMessage());
				}catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(frame, e2.getMessage());	
				}
				
			}
		});
		SubmitBtn.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		SubmitBtn.setBounds(320, 385, 237, 40);
		frame.getContentPane().add(SubmitBtn);
		
		JLabel JaccoziLabel = new JLabel("Does it has a Jaccozi?");
		JaccoziLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JaccoziLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		JaccoziLabel.setBounds(348, 245, 160, 20);
		frame.getContentPane().add(JaccoziLabel);
		
		JaccoziCh = new Choice();
		JaccoziCh.setBounds(580, 240, 110, 18);
		frame.getContentPane().add(JaccoziCh);
		
		JLabel BalconyLabel = new JLabel("whats the balcony size?");
		BalconyLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BalconyLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		BalconyLabel.setBounds(339, 300, 169, 20);
		frame.getContentPane().add(BalconyLabel);
		
		BalconyTxtF = new JTextField();
		BalconyTxtF.setColumns(10);
		BalconyTxtF.setBounds(580, 295, 110, 25);
		frame.getContentPane().add(BalconyTxtF);
		JaccoziCh.add("Yes");
		JaccoziCh.add("No");
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/5.jpg"));
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
	
	//gets the details and checks if they're right or not 
	public Room getSuite() throws MyExeption {
		Room m = Service.getTheRoom(FloorTxtF,RGradeTxtF, SizeTxtF,DPriceTxtF, AvgCostTxtF, CapacityCh, ViewCh);
		Suite Suite=null;
		Boolean jacozi = null;
		Double balcsize = null;
		if(JaccoziCh.getSelectedItem().equals("Yes")) {
			jacozi = true;
		}
		String blsize = BalconyTxtF.getText();
		if(!blsize.equals("") || !blsize.isEmpty()) {
			balcsize = Double.parseDouble(blsize);
		}
		
		try {
			if (m.getAvgDailyCost()>0 && m.getDailyPrice()>0 && m.getSize()>0 && m.getFloor()>0 &&m.getMaxPopulationCapacity()>0 &&m.getRoomGrade()>0 && jacozi!=null && balcsize!=null){
				
				Suite = new Suite(m.getDailyPrice(),m.getFloor(),m.getAvgDailyCost(),m.getRoomGrade(), m.getMaxPopulationCapacity(), m.getSize(),((StandardRoom)m).isHasView(),jacozi, balcsize);
			} else
				throw new MyExeption("Something wrong,Please fill right data!!!");
		} catch (MyExeption e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
		return Suite;
	}
	
	//adds the suite to the hash in the hotel
	public void addTheSuite() throws MyExeption {
		Room m = getSuite();
		if(m!=null) {
			try {
				if(Hotel.getInstance().addSuite((Suite)m)) {
					JOptionPane.showMessageDialog(frame, "The Room has been added successfully");
					Service.emptytxtfRoom(FloorTxtF, RGradeTxtF, SizeTxtF, DPriceTxtF, AvgCostTxtF, CapacityCh, ViewCh);
					JaccoziCh.select(0);
					BalconyTxtF.setText("");
				}
			} catch (MaxPopulationCapacityException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(frame, e.getMessage());
			}
		}
		
	}

}

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
import model.SuperiorRoom;
import utils.Service;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*   Samar Amoun 212247431   */
public class AddSupRoom {

	private JFrame frame;
	private JTextField FloorTxtF;
	private JTextField RGradeTxtF;
	private JTextField sizetxt;
	private JTextField DPriceTxtF;
	private JTextField AvgCostTxtF;
	private Choice ViewCh;
	private Choice CapacityCh;
	private Choice JaccoziCh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddSupRoom window = new AddSupRoom();
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
	public AddSupRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);		
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/3.jpg"));
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
			panel.add(FloorLabel);
			panel.add(SizeLabel);
			panel.add(RGradeLabel);
			
			FloorTxtF = new JTextField();
			FloorTxtF.setBounds(135, 90, 110, 25);
			panel.add(FloorTxtF);
			FloorTxtF.setColumns(10);
			
			RGradeTxtF = new JTextField();
			RGradeTxtF.setColumns(10);
			RGradeTxtF.setBounds(135, 140, 110, 25);
			panel.add(RGradeTxtF);
			
			sizetxt = new JTextField();
			sizetxt.setColumns(10);
			sizetxt.setBounds(135, 190, 110, 25);
			panel.add(sizetxt);
			
			JLabel DPriceLabel = new JLabel("Daily Price:");
			DPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			DPriceLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
			DPriceLabel.setBounds(36, 245, 81, 20);
			panel.add(DPriceLabel);
			
			JLabel AvgDCostLabel = new JLabel("Average Daily Cost:");
			AvgDCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
			AvgDCostLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
			AvgDCostLabel.setBounds(359, 95, 149, 20);
			panel.add(AvgDCostLabel);
			
			JLabel lblMaximum = new JLabel("Maximum population capacity:");
			lblMaximum.setHorizontalAlignment(SwingConstants.CENTER);
			lblMaximum.setFont(new Font("Tahoma", Font.ITALIC, 16));
			lblMaximum.setBounds(323, 145, 218, 20);
			panel.add(lblMaximum);
			
			JLabel ViewLabel = new JLabel("Does it has a view?");
			ViewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			ViewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
			ViewLabel.setBounds(359, 195, 138, 20);
			panel.add(ViewLabel);
			
			DPriceTxtF = new JTextField();
			DPriceTxtF.setColumns(10);
			DPriceTxtF.setBounds(135, 245, 110, 25);
			panel.add(DPriceTxtF);
			
			AvgCostTxtF = new JTextField();
			AvgCostTxtF.setColumns(10);
			AvgCostTxtF.setBounds(580, 90, 110, 25);
			panel.add(AvgCostTxtF);
			
			ViewCh = new Choice();
			ViewCh.setBounds(580, 190, 110, 18);
			panel.add(ViewCh);
			ViewCh.add("-");
			ViewCh.add("Yes");
			ViewCh.add("No");
			
			CapacityCh = new Choice();
			CapacityCh.setBounds(580, 140, 110, 18);
			panel.add(CapacityCh);
			CapacityCh.add("-");
			CapacityCh.add("3");
			CapacityCh.add("4");
			CapacityCh.add("5");
			
			JButton SubmitBtn = new JButton("Add superior room!");
			SubmitBtn.setBackground(Color.WHITE);
			SubmitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						addTheSupRoom();
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
			panel.add(SubmitBtn);
			
			JLabel JaccoziLabel = new JLabel("Does it has a Jaccozi?");
			JaccoziLabel.setHorizontalAlignment(SwingConstants.CENTER);
			JaccoziLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
			JaccoziLabel.setBounds(348, 245, 160, 20);
			panel.add(JaccoziLabel);
			
			JaccoziCh = new Choice();
			JaccoziCh.setBounds(580, 240, 110, 18);
			panel.add(JaccoziCh);
			JaccoziCh.add("-");
			JaccoziCh.add("Yes");
			JaccoziCh.add("No");
			
			frame.getContentPane().add(panel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	//gets details and checks them 
	public Room getSupRoom() throws MyExeption {
		Room m = Service.getTheRoom(FloorTxtF,RGradeTxtF, sizetxt,DPriceTxtF, AvgCostTxtF, CapacityCh, ViewCh);
		SuperiorRoom supr=null;
		Boolean jacozi = null;
		if(JaccoziCh.getSelectedItem().equals("Yes")) {
			jacozi = true;
		}
		
		try {
			if (m.getAvgDailyCost()>0 && m.getDailyPrice()>0 && m.getSize()>0 && m.getFloor()>0 &&m.getMaxPopulationCapacity()>0 &&m.getRoomGrade()>0 && jacozi!=null){
				
				supr = new SuperiorRoom(m.getDailyPrice(),m.getFloor(), m.getAvgDailyCost(),m.getRoomGrade(),m.getMaxPopulationCapacity(),m.getSize(),((StandardRoom)m).isHasView(), jacozi);
				
				
			} else
				throw new MyExeption("Something wrong,Please fill right data!!!");
		} catch (MyExeption e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
		return supr;
	}
	
	//this method add the superior room to the relevant hash
	public void addTheSupRoom() throws MyExeption {
		Room m = getSupRoom();
		if(m!=null) {
			try {
				if(Hotel.getInstance().addSuperiorRoom((SuperiorRoom)m)) {
					JOptionPane.showMessageDialog(frame, "The Room has been added successfully");
					Service.emptytxtfRoom(FloorTxtF, RGradeTxtF, sizetxt, DPriceTxtF, AvgCostTxtF, CapacityCh, ViewCh);
					JaccoziCh.select(0);
				}
			} catch (MaxPopulationCapacityException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(frame, e.getMessage());
			}
		}
		
	}

}

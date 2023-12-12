package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Choice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Exceptions.MyExeption;
import model.Hotel;
import model.MaxPopulationCapacityException;
import model.Room;
import model.StandardRoom;
import utils.Service;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

/*   Samar Amoun 212247431   */
public class AddStanRoom {

	private JFrame frame;
	
	private JTextField FloorTxtF;
	private JTextField RGradeTxtF;
	private JTextField SizeTxt;
	private JTextField DPriceTxtF;
	private JTextField AvgCostTxtF;
	private Choice CapacityCh;
	private Choice ViewCh;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStanRoom window = new AddStanRoom();
					window.frame.setVisible(true);
					 
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JFrame getTheFrame() {
		return frame;
		
	}

	/**
	 * Create the application.
	 */
	public AddStanRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
	
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/2.jpg"));
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
			FloorLabel.setForeground(Color.WHITE);
			FloorLabel.setBounds(41, 95, 45, 20);
			FloorLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
			FloorLabel.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel RGradeLabel = new JLabel("Room Grade:");
			RGradeLabel.setForeground(Color.WHITE);
			RGradeLabel.setBounds(23, 145, 94, 20);
			RGradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			RGradeLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
			
			JLabel SizeLabel = new JLabel("Size:");
			SizeLabel.setForeground(Color.WHITE);
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
			
			SizeTxt = new JTextField();
			SizeTxt.setColumns(10);
			SizeTxt.setBounds(135, 190, 110, 25);
			panel.add(SizeTxt);
			
			JLabel DPriceLabel = new JLabel("Daily Price:");
			DPriceLabel.setForeground(Color.WHITE);
			DPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			DPriceLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
			DPriceLabel.setBounds(24, 240, 81, 20);
			panel.add(DPriceLabel);
			
			JLabel AvgDCostLabel = new JLabel("Average Daily Cost:");
			AvgDCostLabel.setForeground(Color.WHITE);
			AvgDCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
			AvgDCostLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
			AvgDCostLabel.setBounds(323, 95, 149, 20);
			panel.add(AvgDCostLabel);
			
			JLabel lblMaximum = new JLabel("Maximum population capacity:");
			lblMaximum.setForeground(Color.WHITE);
			lblMaximum.setHorizontalAlignment(SwingConstants.CENTER);
			lblMaximum.setFont(new Font("Tahoma", Font.ITALIC, 16));
			lblMaximum.setBounds(323, 145, 218, 20);
			panel.add(lblMaximum);
			
			JLabel ViewLabel = new JLabel("Does it has a view?");
			ViewLabel.setForeground(Color.WHITE);
			ViewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			ViewLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
			ViewLabel.setBounds(359, 195, 138, 20);
			panel.add(ViewLabel);
			
			DPriceTxtF = new JTextField();
			DPriceTxtF.setColumns(10);
			DPriceTxtF.setBounds(135, 240, 110, 25);
			panel.add(DPriceTxtF);
			
			AvgCostTxtF = new JTextField();
			AvgCostTxtF.setColumns(10);
			AvgCostTxtF.setBounds(482, 95, 110, 25);
			panel.add(AvgCostTxtF);
			
			ViewCh = new Choice();
			ViewCh.setBounds(547, 197, 110, 18);
			panel.add(ViewCh);
			ViewCh.add("-");
			ViewCh.add("Yes");
			ViewCh.add("No");
			
			CapacityCh = new Choice();
			CapacityCh.setBounds(547, 147, 110, 18);
			panel.add(CapacityCh);
			
			JButton SubmitBtn = new JButton("Add standard room!");
			SubmitBtn.setBackground(Color.WHITE);
			SubmitBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						addTheStanRoom();
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
			SubmitBtn.setBounds(303, 333, 237, 40);
			panel.add(SubmitBtn);
			CapacityCh.add("-");
			CapacityCh.add("1");
			CapacityCh.add("2");
			
			frame.getContentPane().add(panel);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	// gets the details from the customer and checks them 
	public Room getStanRoom() throws MyExeption {
		Room m = Service.getTheRoom(FloorTxtF,RGradeTxtF, SizeTxt,DPriceTxtF, AvgCostTxtF, CapacityCh, ViewCh);
		try {
			if (m.getAvgDailyCost()>0 && m.getDailyPrice()>0 && m.getSize()>0 && m.getFloor()>0 &&m.getMaxPopulationCapacity()>0 &&m.getRoomGrade()>0){
				return m;
				
			} else
				throw new MyExeption("Something wrong,Please fill right data!!!");
		} catch (MyExeption e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
		return null;
	}
	
	//add the standard room to the hashmap that holds all the rooms
	public void addTheStanRoom() throws MyExeption {
		Room m = getStanRoom();
		if(m!=null) {
			try {
				if(Hotel.getInstance().addStandardRoom((StandardRoom)m)) {
					JOptionPane.showMessageDialog(frame, "The Room has been added successfully");
					Service.emptytxtfRoom(FloorTxtF, RGradeTxtF, SizeTxt, DPriceTxtF, AvgCostTxtF, CapacityCh, ViewCh);
				}
			} catch (MaxPopulationCapacityException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(frame, e.getMessage());
			}
		}
		
	}
	
	
	
	
}

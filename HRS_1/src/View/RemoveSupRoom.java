package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Hotel;
import model.Room;
import model.Suite;
import model.SuperiorRoom;
import utils.Service;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class RemoveSupRoom {

	private JFrame frame;
	private JButton SubmitBtn_1;
	private JComboBox<SuperiorRoom> SupRoomscomboBox ;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveSupRoom window = new RemoveSupRoom();
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
	public RemoveSupRoom() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);
		
		SubmitBtn_1 = new JButton("Remove!");
		SubmitBtn_1.setBackground(Color.WHITE);
		SubmitBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Hotel.getInstance().removeSuperiorRoom((SuperiorRoom)SupRoomscomboBox.getSelectedItem())) {
					JOptionPane.showMessageDialog(frame, "The selected Suite room has been deleted successfully ");
					SupRoomscomboBox.removeItem(SupRoomscomboBox.getSelectedItem());
				}
				else 
					JOptionPane.showMessageDialog(frame, "Oops, something wrong!!!!");
			}
		});
		SubmitBtn_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		SubmitBtn_1.setBounds(346, 185, 150, 40);
		frame.getContentPane().add(SubmitBtn_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 117, 766, 40);
		frame.getContentPane().add(scrollPane);
		
		SupRoomscomboBox = new JComboBox<SuperiorRoom>();
		scrollPane.setViewportView(SupRoomscomboBox);
		HashMap<String,Room> hash = Hotel.getInstance().getAllRooms();
		HashMap<String, SuperiorRoom> suphash= new HashMap<String, SuperiorRoom>();
		for(Map.Entry<String, Room> map:hash.entrySet()) {
			if(map.getValue() instanceof SuperiorRoom && !(map.getValue() instanceof Suite) ) {
				suphash.put(map.getKey(), (SuperiorRoom)map.getValue());
			}
		}
		
		Service.fillcombo(SupRoomscomboBox,suphash);
		
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

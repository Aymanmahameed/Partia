package View;

import java.awt.EventQueue;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import model.Employee;
import model.Hotel;
import utils.Service;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
/* Samar Amoun  212247431*/

public class Kemp {

	private JFrame frame;
	private JTextField kemptxt;
	private JList<Employee> list ;
	private DefaultListModel<Employee> empModel;
	private JScrollPane eScrollPane;
	private JButton sub;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Kemp window = new Kemp();
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
	public Kemp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);
		
		JLabel Kemp = new JLabel("Enter the number to get the first k employes:");
		Kemp.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Kemp.setBounds(50, 26, 335, 26);
		frame.getContentPane().add(Kemp);
		
		kemptxt = new JTextField();
		kemptxt.setBounds(393, 32, 105, 19);
		frame.getContentPane().add(kemptxt);
		kemptxt.setColumns(10);
		
		empModel = new DefaultListModel<Employee>();
	    eScrollPane = new JScrollPane();
		eScrollPane.setBounds(204, 62, 350, 350);
		
		
		

		frame.getContentPane().add(eScrollPane);
		list = new JList<Employee>(empModel);
		eScrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		sub = new JButton("Submit");
		sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ktxt =kemptxt.getText();
				if(Service.isNum(ktxt)) {
					int k = Integer.parseInt(ktxt);
					if(k<Hotel.getInstance().getAllEmployees().size()) {
						empModel.removeAllElements();
						List<Employee> li = Hotel.getInstance().KEmployees(k);
						for(Employee e1 :li) {
								empModel.addElement(e1);
						}
					}
					else
						JOptionPane.showMessageDialog(frame,"Its to big number!!!");
				}
				else
					JOptionPane.showMessageDialog(frame,"Invalid Input!!");
				
				
			}
		});
		sub.setBounds(508, 28, 99, 26);
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

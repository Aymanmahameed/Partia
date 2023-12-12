package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import model.Employee;
import model.Hotel;
import utils.Service;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

import java.awt.Graphics;
import java.awt.Image;

/*   Samar Amoun 212247431   */
public class Login {

	private JFrame frame;
	private JTextField usernametf;
	private JPasswordField passwordtf;
	private String userName;
	private String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 150, 500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		 try {
	            Image backgroundImage = ImageIO.read(new File("MediaNSounds/1.jpg"));
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
	            panel.setBounds(0, 0,495, 596);
	            panel.setLayout(null);
		usernametf = new JTextField();
		usernametf.setBounds(185, 174, 107, 19);
		panel.add(usernametf);
		usernametf.setColumns(10);

		passwordtf = new JPasswordField();
		passwordtf.setColumns(10);
		passwordtf.setBounds(185, 213, 107, 19);
		panel.add(passwordtf);

		JLabel userNameLab = new JLabel("Username");
		userNameLab.setBounds(113, 174, 62, 19);
		panel.add(userNameLab);

		JLabel passwordLab = new JLabel("Password");
		passwordLab.setBounds(113, 213, 62, 19);
		panel.add(passwordLab);

		JButton SubButton = new JButton("Login");
		SubButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				userName = usernametf.getText();
				password = passwordtf.getText();
				Hotel.getInstance().readser();
				HashMap<String, Employee> hash = Hotel.getInstance().getAllEmployees();
 				Employee em = null;
				for(Map.Entry<String, Employee> map:hash.entrySet()) {
					if(userName.equals(map.getValue().getUsername())&& password.equals(map.getValue().getPassword())) {
						em=map.getValue();
						System.out.println(map.getValue().getUsername());
						System.out.println(map.getValue().getPassword());
					}
				}
				if (userName.equals("admin") && password.equals("admin")) {
					Service.playAudioLogin("MediaNSounds/micro.wav");
					
						new MainMeun();
						frame.setVisible(false);
					
					
		
				}else if(em!=null) {
					Service.playAudioLogin("MediaNSounds/micro.wav");
					MainMeun m =  new MainMeun();
					m.getUser().setVisible(false);
					m.getUser_1().setVisible(false);
					frame.setVisible(false);
				}
				else {
					Service.playAudioLogin("MediaNSounds/userNotFound.wav");
					JOptionPane.showMessageDialog(null, "User Not Found!");
				}

			}
		});
		SubButton.setBounds(185, 254, 107, 31);
		panel.add(SubButton);
		 frame.getContentPane().add(panel);

		 }
		 catch (IOException e) {
	            e.printStackTrace();
	        }
	        frame.setVisible(true);
	}
}

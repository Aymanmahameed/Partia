import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Login extends JFrame implements ActionListener{
	
	JTextField name = new JTextField();
	JPasswordField pass = new JPasswordField();
	JLabel userName= new JLabel("Username: ");
	JLabel password= new JLabel("Password: ");
	JLabel welcome= new JLabel("Welcome to the system");
	JButton login = new JButton("Login");
	JPanel pa = new JPanel();
	
	static Tafret  t;
	private SystemDataBase db;
	
	public SystemDataBase getDb() {
		return db;
	}


	public void setDb(SystemDataBase db) {
		this.db = db;
	}


	public Login(SystemDataBase db) throws HeadlessException {
		super();
		this.db = db;
	}
	

	public Login() throws HeadlessException {
		super("Admin Login");
		// designing the page
		setLayout(null);
		welcome.setBounds(170,30, 150, 50);
		welcome.setForeground(Color.BLUE);
		add(welcome);
		userName.setBounds(130,83, 70, 50);
		add(userName);
		
		
		name.setBounds(200, 100,100, 20);
		add(name);
		
		
		password.setBounds(130, 123, 70, 50);
		add(password);
		pass.setBounds(200, 140,100, 20);
		add(pass);
		login.setBounds(200, 180, 100, 30);
		add(login);
		login.addActionListener(this);
		
		setBounds(500, 200, 500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource() == login) {
			if(name.getText().equals(db.getMainManager().getUserName()) && pass.getText().equals(db.getMainManager().getPassword())){
				new ImporintData(getDb());
				this.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(this, "The username or password are invalid\nPlease try again");
			}
			
		}			
	}
	
	
	

}

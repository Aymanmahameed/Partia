package boundary;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import entity.Costumer;

import control.CostomerLogic;

public class FRMLogin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	JTextField customerPhome = new JTextField();
	JLabel labPhpne = new JLabel("Enter your Phone Number: ");
	JButton Find = new JButton("Submit");

	public FRMLogin() throws HeadlessException {
		super();
		// designing the page
		setTitle("Customer Login");
		setBounds(500, 200, 500, 500);
		labPhpne.setBounds(50, 83, 160, 50);
		customerPhome.setBounds(210, 100, 100, 20);
		Find.setBounds(150, 130, 150, 30);
		add(labPhpne);
		add(customerPhome);
		add(Find);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		Find.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == Find) {
			Costumer c= CostomerLogic.getInstance().IsExsit(customerPhome.getText());
			if(c!=null) {
				this.setVisible(false);
				new FRMCustomer(c);
			}
			else
				JOptionPane.showMessageDialog(this, "The phone is not exist!");
		}

	}

}

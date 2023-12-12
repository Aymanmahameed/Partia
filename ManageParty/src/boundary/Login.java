package boundary;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.AgentLogic;
import control.MusicianLogic;
import entity.Agent;
import entity.Musician;

public class Login extends JFrame implements ActionListener {

	/**
	 * 
	 */
	JTextField id = new JTextField();
	JLabel labPhpne = new JLabel("Enter your identfy: ");
	JButton Find = new JButton("Submit");
	private static final long serialVersionUID = 1L;

	public Login() throws HeadlessException {
		super();
		// designing the page
		setLayout(null);
		setTitle("Login");
		setBounds(700, 200, 500, 500);
		labPhpne.setBounds(100, 83, 160, 50);
		id.setBounds(220, 100, 100, 20);
		Find.setBounds(150, 130, 150, 30);
		add(labPhpne);
		add(id);
		add(Find);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setVisible(true);
		Find.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == Find) {
			if (!id.getText().equals("")) {
				Agent a = AgentLogic.getInstance().isExsit(id.getText());
				Musician m = MusicianLogic.getInstance().isExis(id.getText());
				if (a != null) {
					this.setVisible(false);
					new FrmReportMenu(a);

				} else if (id.getText().equals("Admin")) {
					this.setVisible(false);
					new ManagerFrm();
				} else if (m != null) {
					this.setVisible(false);
					new MusicianFrm(m);
				} else
					JOptionPane.showMessageDialog(this, "failed! the id doesn't exist.");
			}
			else
				JOptionPane.showMessageDialog(this, "Please enter your identfy");
		}

	}

}

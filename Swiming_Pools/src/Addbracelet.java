import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Addbracelet extends Login{

	JTextField customerName = new JTextField();
	JLabel name = new JLabel("Enter customer name: ");
	JButton Add = new JButton("Add Customer");
	JButton Home = new JButton("Back to menu");
	BufferedWriter addingtoFile;

	public Addbracelet(SystemDataBase db) throws HeadlessException {
		super(db);
		// designing the page
		setTitle("Add new Customer");
		setBounds(500, 200, 500, 500);
		name.setBounds(120, 83, 150, 50);
		customerName.setBounds(250, 100, 100, 20);
		Add.setBounds(170, 130, 150, 30);
		Home.setBounds(20, 420, 150, 30);
		add(name);
		add(customerName);
		add(Add);
		add(Home);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);

		Add.addActionListener(this);
		Home.addActionListener(this);
	}

	public Addbracelet() throws HeadlessException {

	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == Home) {
			this.setVisible(false);
			Login.t.setVisible(true);
		} else if (ev.getSource() == Add) {
			//check if the customer did not enter any name
			if (!customerName.getText().equals("")) {
				if (this.getDb() != null) {
					try {
						Bracelet B = new Bracelet(customerName.getText());
						this.getDb().addBracelet(B);
						//Adding to to Bracelets file new customer
						addingtoFile = new BufferedWriter(new FileWriter("src/Bracelets.txt",true));
						addingtoFile.write(B.getcustomerName());
						addingtoFile.newLine();
						addingtoFile.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(this, "customer added successfully!");
				}
			}

			else {
				JOptionPane.showMessageDialog(this, "You did not enter any name, please try again");
			}
		}
	}

}

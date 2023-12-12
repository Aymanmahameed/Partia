import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Addmanager extends Login {

	JTextField nameField = new JTextField();
	JTextField ageField = new JTextField();
	JTextField salaryField = new JTextField();

	JLabel nameLabel = new JLabel("Enter manager name: ");
	JLabel ageLabel = new JLabel("Enter manager age: ");
	JLabel salaeyLabel = new JLabel("Enter manager salery: ");
	JButton Home = new JButton("Back to menu");
	JButton Add = new JButton("Add Manager");
	JButton clear = new JButton("Clear fields");
	BufferedWriter writetoManagersf;

	public Addmanager(SystemDataBase db) throws HeadlessException {
		super(db);
		// designing the page
		setTitle("Add new manager");
		setLayout(null);
		nameLabel.setBounds(120, 83, 200, 50);
		ageLabel.setBounds(120, 123, 240, 50);
		salaeyLabel.setBounds(120, 163, 200, 50);
		nameField.setBounds(250, 100, 100, 20);
		ageField.setBounds(250, 140, 100, 20);
		salaryField.setBounds(250, 180, 100, 20);
		Home.setBounds(20, 420, 150, 30);
		clear.setBounds(180, 280, 150, 30);
		Add.setBounds(180, 220, 150, 30);
		this.add(nameLabel);
		this.add(ageLabel);
		this.add(salaeyLabel);
		this.add(ageField);
		this.add(salaryField);
		this.add(nameField);
		this.add(Home);
		this.add(clear);
		this.add(Add);
		this.setBounds(500, 200, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Home.addActionListener(this);
		Add.addActionListener(this);
		clear.addActionListener(this);

	}

	public void actionPerformed(ActionEvent ev) {
		//back to tafret
		if (ev.getSource() == Home) {
			this.setVisible(false);
			Login.t.setVisible(true);
		} else if (ev.getSource() == Add) {
			Boolean flag = false;
			//check if any field is empty
			if (nameField.getText().equals("") || ageField.getText().equals("") || salaryField.getText().equals("")) {
				flag = true;
			}
			if(nameField.getText().equals(" ") || ageField.getText().equals(" ") || salaryField.getText().equals(" ")) {
				flag = true;
			}
			

			if (!flag) {
				String name = nameField.getText();
				Integer age = Integer.parseInt(ageField.getText());
				Integer salary = Integer.parseInt(salaryField.getText());
				if (!name.isEmpty() && age >= 16) {
					try {
						
						Manager m = new Manager(name, age, salary);
						if (this.getDb().addManagers(m)) {
							writetoManagersf = new BufferedWriter(new FileWriter("src/Managers.txt"));
							for(Manager i:this.getDb().getAllManagers()) {
								//add manager id and his name
								writetoManagersf.write(i.getID() + " " + i.getName());
								writetoManagersf.newLine();
							}
							JOptionPane.showMessageDialog(this, "manager added successfully!");
						} else
							JOptionPane.showMessageDialog(this, "Something went wrong!");
						writetoManagersf.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					

				}

			} else
				JOptionPane.showMessageDialog(this, "You did not enter all details, please try again");
		} else if (ev.getSource() == clear) {
			nameField.setText("");
			ageField.setText("");
			salaryField.setText("");
		}

	}

}

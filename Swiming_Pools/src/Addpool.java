import java.awt.Choice;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

public class Addpool extends Login implements ItemListener {

	Choice pools = new Choice();
	Choice isNeed = new Choice();
	JTextField DepthField = new JTextField();
	JTextField widthField = new JTextField();
	JTextField lengthField = new JTextField();

	JTextField swimlanesField = new JTextField();
	JTextField MaximumAge = new JTextField();

	JLabel DepthLabel = new JLabel("Enter pool depth:");
	JLabel widthLabel = new JLabel("Enter pool width: ");
	JLabel lengthLabel = new JLabel("Enter pool length: ");
	JLabel swimlanesLabel = new JLabel("Enter number of swimming lanes:");
	JLabel options = new JLabel("Please choose the kind of the pool: ");
	JLabel age = new JLabel("Enter a maximum age in the pool:");
	JLabel needed = new JLabel("Do the kids need a chaperone?");
	JButton clear = new JButton("Clear fields");
	JButton setSizesforPool = new JButton("Set dimensions");
	JButton Home = new JButton("Back to menu");
	JButton Add = new JButton("Add pool");
	BufferedWriter addingtofile;

	public Addpool(SystemDataBase db) throws HeadlessException {
		super(db);
		// designing the page
		setTitle("Add new pool");
		setLayout(null);
		DepthLabel.setBounds(130, 83, 100, 50);
		widthLabel.setBounds(130, 123, 100, 50);
		lengthLabel.setBounds(130, 163, 110, 50);
		setSizesforPool.setBounds(180, 220, 150, 30);
		DepthField.setBounds(250, 100, 100, 20);
		widthField.setBounds(250, 140, 100, 20);
		lengthField.setBounds(250, 180, 100, 20);
		swimlanesField.setBounds(247, 177, 100, 20);
		swimlanesLabel.setBounds(55, 160, 200, 50);
		Home.setBounds(20, 420, 150, 30);
		Add.setBounds(180, 220, 150, 30);
		clear.setBounds(180, 280, 150, 30);

		add(DepthField);
		add(widthField);
		add(lengthField);
		add(DepthLabel);
		add(widthLabel);
		add(lengthLabel);
		add(setSizesforPool);
		add(swimlanesField);
		add(swimlanesLabel);
		add(Home);
		add(Add);
		add(swimlanesField);
		add(swimlanesLabel);
		add(isNeed);
		add(age);
		add(MaximumAge);
		add(needed);
		add(clear);

		swimlanesField.setVisible(false);
		swimlanesLabel.setVisible(false);
		Add.setVisible(false);
		isNeed.setVisible(false);
		age.setVisible(false);
		Add.addActionListener(this);
		setSizesforPool.addActionListener(this);

		Home.addActionListener(this);
		pools.addItemListener(this);
		isNeed.addItemListener(this);
		MaximumAge.setVisible(false);
		needed.setVisible(false);
		clear.addActionListener(this);
		pools.add("Choose");
		pools.add("Regular pool");
		pools.add("Proffesional pool");
		pools.add("Kids pool");

		isNeed.add("Yes");
		isNeed.add("No");

		setBounds(500, 200, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == Home) {
			this.setVisible(false);
			Login.t.setVisible(true);
		}

		else if (ev.getSource() == setSizesforPool) {

			Boolean flag = false;
			//if the at least one of the text fields in not fill
			if (DepthField.getText().equals("") || widthField.getText().equals("") || lengthField.getText().equals(""))
				flag = true;

			if (!flag) {
				DepthField.setVisible(false);
				DepthLabel.setVisible(false);
				widthField.setVisible(false);
				widthLabel.setVisible(false);
				lengthField.setVisible(false);
				lengthLabel.setVisible(false);
				setSizesforPool.setVisible(false);
				clear.setVisible(false);
				options.setBounds(150, 60, 210, 60);
				pools.setBounds(200, 120, 100, 50);
				add(options);
				add(pools);
			} else
				JOptionPane.showMessageDialog(this, "You did not enter all dimensions, please try again");

		}

		else if (ev.getSource() == Add) {
			String str = pools.getSelectedItem();
			Double d = Double.parseDouble(DepthField.getText());
			Double w = Double.parseDouble(lengthField.getText());
			Double l = Double.parseDouble(lengthField.getText());
			if (str.equals("Regular pool")) {
				Pool p = new Pool(d, w, l);
				if (this.getDb().addPool(p)) {
					try {
						//add the pool to the file
						addingtofile = new BufferedWriter(new FileWriter("src/Pools.txt", true));
						addingtofile.write(d + " " + w + " " + l);
						addingtofile.newLine();
						addingtofile.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					JOptionPane.showMessageDialog(this, "Pool added successfully!");
				} else
					JOptionPane.showMessageDialog(this, "Something went wrong, please try again!");
			} else if (str.equals("Proffesional pool")) {

				Boolean flag = false;
				if (swimlanesField.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "You did not enter any number!");
					flag = true;
				}
				if (!flag) {
					Integer lanes = Integer.parseInt(swimlanesField.getText());
					Pool newPP = new ProffesionalPool(d, w, l, lanes);
					if (this.getDb().addPool(newPP)) {
						try {
							//add the pool to the file
							addingtofile = new BufferedWriter(new FileWriter("src/Pools.txt", true));
							addingtofile.write(d + " " + w + " " + l +" "+lanes);
							addingtofile.newLine();
							addingtofile.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(this, "Pool added successfully!");
					} else
						JOptionPane.showMessageDialog(this, "Something went wrong, please try again!");
				}
			} else if (str.equals("Kids pool")) {
				Boolean flag = false;
				if (MaximumAge.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "You did not enter any age!");
					flag = true;
				}
				if (!flag) {
					Integer maxage = Integer.parseInt(MaximumAge.getText());
					boolean isneed = false;
					if (isNeed.getSelectedItem().equals("Yes"))
						isneed = true;
					else if (isNeed.getSelectedItem().equals("No"))
						isneed = false;
					Pool kp = new KidsPool(d, w, l, maxage, isneed);
					if (this.getDb().addPool(kp)) {
						try {
							//add the pool to the file
							addingtofile =new BufferedWriter(new FileWriter("src/Pools.txt",true));
							addingtofile.write(d+" " + w + " " +l + " "+ maxage + " "+ isneed);
							addingtofile.newLine();
							addingtofile.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JOptionPane.showMessageDialog(this, "Pool added successfully!");
					}
					else
						JOptionPane.showMessageDialog(this, "Something went wrong, please try again!");
				}

			}

		} else if (ev.getSource() == clear) {
			DepthField.setText("");
			widthField.setText("");
			lengthField.setText("");
		}

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == pools) {
			if (pools.getSelectedItem().equals("Regular pool")) {
				// setting relevant component not visible
				swimlanesField.setVisible(false);
				swimlanesLabel.setVisible(false);
				Add.setVisible(true);
				isNeed.setVisible(false);
				age.setVisible(false);
				MaximumAge.setVisible(false);
				needed.setVisible(false);
				Add.setBounds(180, 150, 150, 30);

			} else if (pools.getSelectedItem().equals("Proffesional pool")) {
				// setting relevant component not visible
				swimlanesField.setVisible(true);
				swimlanesLabel.setVisible(true);
				Add.setVisible(true);
				isNeed.setVisible(false);
				age.setVisible(false);
				MaximumAge.setVisible(false);
				needed.setVisible(false);
				Add.setBounds(180, 220, 150, 30);
			} else if (pools.getSelectedItem().equals("Kids pool")) {
				// setting relevant component not visible
				isNeed.setVisible(true);
				age.setVisible(true);
				Add.setVisible(true);
				swimlanesField.setVisible(false);
				swimlanesLabel.setVisible(false);
				MaximumAge.setVisible(true);
				needed.setVisible(true);
				age.setBounds(150, 140, 210, 60);
				MaximumAge.setBounds(200, 200, 80, 20);
				needed.setBounds(150, 225, 200, 30);
				isNeed.setBounds(200, 250, 100, 50);
				Add.setBounds(180, 300, 150, 30);

			}

		}

	}

}

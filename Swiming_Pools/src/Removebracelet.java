import java.awt.Choice;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Removebracelet extends Login implements ActionListener {

	Exeptions re = new Exeptions();
	Choice bracelets = new Choice();
	JLabel managerlab = new JLabel("Choose bracelet id: ");
	JButton removeBra = new JButton("Remove customer");
	JButton Home = new JButton("Back to menu");
	BufferedWriter writeToPools;
	BufferedWriter writeTocon;

	public Removebracelet(SystemDataBase db) throws HeadlessException {
		super(db);
		setTitle("Remove a customer");
		setLayout(null);
		Hashtable<Integer, Bracelet> Br = this.getDb().getTableCodeBracelet();
		for (Map.Entry<Integer, Bracelet> c : Br.entrySet()) {
			bracelets.add(String.valueOf(c.getKey()) +" "+ c.getValue().getcustomerName());
		}
		bracelets.setBounds(230, 140, 120, 50);
		managerlab.setBounds(110, 123, 120, 50);
		Home.setBounds(20, 420, 150, 30);
		removeBra.setBounds(160, 180, 150, 30);
		add(bracelets);
		add(managerlab);
		add(removeBra);
		add(Home);

		Home.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ev) {
				setVisible(false);
				Login.t.setVisible(true);

			}
		});
		removeBra.addActionListener(this);

		setVisible(true);
		setBounds(500, 200, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == removeBra) {
			
			String line = bracelets.getSelectedItem();
			Integer bid = (line.charAt(0))-'0';
			Bracelet c = getDb().findBraceletbyID(bid);
			//check if the customer is exist in our database
			if (c != null) {
				try {
					// check Exeptions
					re.checkRemoving(c);
					this.getDb().getTableCodeBracelet().remove(bid, c);
					writeToBraceletFile();
					JOptionPane.showMessageDialog(this, "The customer has been deleted");
				} catch (Exception e) {
					int res = JOptionPane.showConfirmDialog(this,
							e.getMessage() + ", do you want to remove his pools?");
					if (res == JOptionPane.YES_OPTION) {
						removeBrafunv(c);
						this.getDb().getTableCodeBracelet().remove(bid, c);
						writeToBraceletFile();
						writeToConFile();
						JOptionPane.showMessageDialog(this, "The customer has been deleted");
					}
					else
						setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			}else
				JOptionPane.showMessageDialog(this, "The customer not found");
		}
	}
	public void removeBrafunv(Bracelet c) {
		List<Pool> cusPool = c.getPoolsOfToday();
		for (Pool p : cusPool) {
			if (p.getCostumersOfToday().contains(c)) {
				p.getCostumersOfToday().remove(c);
			}
		}
		c.setPoolsOfToday(null);
	}
	public void writeToBraceletFile() {
		try {
			writeTocon = new BufferedWriter(new FileWriter("src/Bracelets.txt"));
			for(Map.Entry<Integer, Bracelet> m: this.getDb().getTableCodeBracelet().entrySet()) {
				writeTocon.write(m.getValue().getcustomerName());
				writeTocon.newLine();
			}
			writeTocon.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void writeToConFile() {
		try {
			writeTocon = new BufferedWriter(new FileWriter("src/CustomersAndPools.txt"));
			for(Bracelet c:getDb().getTableCodeBracelet().values()) {
				for(Pool p:c.getPoolsOfToday()) {
					writeTocon.write(c.getCode()+" "+p.getCode());
					writeTocon.newLine();
				}
			}
			writeTocon.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

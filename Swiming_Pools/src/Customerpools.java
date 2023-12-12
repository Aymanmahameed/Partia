import java.awt.Choice;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Customerpools extends Login implements ItemListener {

	Choice braId = new Choice();
	JLabel bralab = new JLabel("Choose customer id: ");
	JButton Home = new JButton("Back to menu");

	String column[] = new String[0];
	String data[][] = new String[0][0];

	public Customerpools(SystemDataBase db) throws HeadlessException {
		super(db);
		// designing the page
		setTitle("Show manager pool");
		setBounds(500, 200, 500, 500);
		setLayout(null);
		add(braId);
		add(bralab);
		add(Home);

		Home.addActionListener(this);
		braId.addItemListener(this);

		braId.add("Choose");
		for (Map.Entry<Integer, Bracelet> map:getDb().getTableCodeBracelet().entrySet()) {
			//add to choice just customers that manages pool
			if (!map.getValue().getPoolsOfToday().isEmpty()) {
				Integer mid = map.getKey();
				braId.add(String.valueOf(mid));
			}
		}

		bralab.setBounds(110, 123, 120, 50);
		braId.setBounds(230, 140, 100, 20);
		Home.setBounds(20, 420, 150, 30);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == braId) {
			String pid = braId.getSelectedItem();
			if (!pid.equals("Choose")) {
				Integer id = Integer.parseInt(pid);
				Bracelet B = this.getDb().findBraceletbyID(id);

				if (B != null) {

					bralab.setBounds(110, 30, 120, 50);
					braId.setBounds(230, 47, 100, 20);
					// create a "table"
					// headers = column array
					column = new String[5];
					column[0] = "Code";
					column[1] = "Depth";
					column[2] = "width";
					column[3] = "lenght";
					column[4] = "customerOfToday";

					// table body = 2d array (rows=persons, columns=fName,lName)
					data = new String[B.getPoolsOfToday().size()][5];
					for (int i = 0; i < B.getPoolsOfToday().size(); i++) {
						String pc = String.valueOf(((Pool) B.getPoolsOfToday().get(i)).getCode());
						String d = String.valueOf(((Pool) B.getPoolsOfToday().get(i)).getDepth());
						String w = String.valueOf(((Pool) B.getPoolsOfToday().get(i)).getWidth());
						String l = String.valueOf(((Pool) B.getPoolsOfToday().get(i)).getLength());
						String cust = ((Pool) B.getPoolsOfToday().get(i)).getCustomersbyString();

						data[i][0] = pc;
						data[i][1] = d;
						data[i][2] = w;
						data[i][3] = l;
						data[i][4] = cust;

					}
					
					JTable jtable = new JTable(data, column);
					JScrollPane sp = new JScrollPane(jtable);
					sp.setBounds(80, 80, 300, 300);
					this.add(sp);

					revalidate();
				} else {
					JOptionPane.showMessageDialog(this, "failed! the manager doesn't exist.");
				}
			}
		}
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == Home) {
			this.setVisible(false);
			Login.t.setVisible(true);

		}
	}
}

import java.awt.Choice;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class Connect_bracelet_and_pool extends Login {

	
	JLabel poolLab = new JLabel("Please enter code of the pool: ");
	JLabel braceletLab = new JLabel("Please enter code of the bracelet: ");
	Choice poolChoice = new Choice();
	Choice braceletchoice = new Choice();
	JButton set = new JButton("Add");
	JButton Home = new JButton("Back to menu");
	BufferedWriter writetofile;
	BufferedReader readfromfile;

	public Connect_bracelet_and_pool(SystemDataBase db) throws HeadlessException {
		super(db);
		// designing the page
		setTitle("Add customer to pool");
		getContentPane().setLayout(null);
		poolLab.setBounds(45, 103, 200, 50);
		poolChoice.setBounds(250, 120, 100, 20);

		braceletLab.setBounds(45, 143, 200, 50);
		braceletchoice.setBounds(250, 160, 100, 20);
		Home.setBounds(20, 420, 150, 30);
		set.setBounds(200, 200, 100, 30);
		Home.addActionListener(this);
		set.addActionListener(this);

		for (Pool p : this.getDb().getAllPools()) {
			poolChoice.add(String.valueOf(p.getCode()));
		}
		for (Bracelet cu : this.getDb().getTableCodeBracelet().values()) {
			braceletchoice.add(String.valueOf(String.valueOf(cu.getCode())));
		}

		getContentPane().add(poolLab);
		getContentPane().add(poolChoice);
		getContentPane().add(braceletLab);
		getContentPane().add(braceletchoice);
		getContentPane().add(Home);
		getContentPane().add(set);
		this.setBounds(500, 200, 500, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent ev) {

		if (ev.getSource() == Home) {
			this.setVisible(false);
			Login.t.setVisible(true);
		} else if (ev.getSource() == set) {
			Boolean flag=false;
			Integer bracId = Integer.parseInt(braceletchoice.getSelectedItem());
			Integer poolId = Integer.parseInt(poolChoice.getSelectedItem());
			Exeptions fun = new Exeptions();
			Pool p = this.getDb().findPoolbyID(poolId);
			Bracelet b = this.getDb().findBraceletbyID(bracId);
			// check if pool or customer are exists
			if (p == null || b == null) {
				JOptionPane.showMessageDialog(this, "failed! pool or bracelet ID doesn't exist!");
			} else {
				try {
					readfromfile = new BufferedReader(new FileReader("src/CustomersAndPools.txt"));
					String line;
					//check if the connection by the selected pool and the customer is exist
					while ((line = readfromfile.readLine()) != null) {
						StringTokenizer st = new StringTokenizer(line);
						if (st.countTokens() == 2) {
							String braid = st.nextToken();
							String poolid = st.nextToken();
							if ((String.valueOf(p.getCode()).equals(poolid))
									&& (String.valueOf(b.getCode())).equals(braid)) {
								flag=true;

							}
						}

					}
					readfromfile.close();
					if(!flag) {
						//adding the connection to the file
						writetofile = new BufferedWriter(new FileWriter("src/CustomersAndPools.txt",true));
						writetofile.write(b.getCode() + " " + p.getCode());
						writetofile.newLine();
						fun.addbracopool(b, p);
						JOptionPane.showMessageDialog(this, "customer added successfully to the pool!");
						writetofile.close();
					}
					else
						JOptionPane.showMessageDialog(this, "The customer has been enterd this pool");
					
				} catch (FileNotFoundException e) {
					System.out.println("Error");
					e.printStackTrace();
				} catch (IOException e) {
					System.out.println("Error");
					e.printStackTrace();
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(this, e.getMessage());
				}
				
			}

		}

	}
}

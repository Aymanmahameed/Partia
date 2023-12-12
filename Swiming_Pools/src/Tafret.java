import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Tafret extends Login {

	JLabel messageForAdmin = new JLabel("Hey admin please choose what do you want to do: ");

	JButton newBracelet = new JButton("Add new bracelet");
	JButton newPool = new JButton("Add new pool");
	JButton connectBracelet = new JButton("Connect bracelet and pool");
	JButton newManager = new JButton("Add new manager");
	JButton showcustomerPools = new JButton("Show customer pools by a table");
	JButton removeBracelet = new JButton("Remove a bracelet");
	JButton cal = new JButton("Calculator");
	

	public Tafret(SystemDataBase db) throws HeadlessException {
		super(db);
		// designing the page
		setTitle("Admin menu");
		setLayout(new GridLayout(0, 1));
		setBounds(500, 200, 500, 500);
		add(messageForAdmin);
		add(newBracelet);
		add(newPool);
		add(connectBracelet);
		add(newManager);
		add(showcustomerPools);	
		add(removeBracelet);
		add(cal);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		newBracelet.addActionListener(this);
		newPool.addActionListener(this);
		showcustomerPools.addActionListener(this);
		connectBracelet.addActionListener(this);
		newManager.addActionListener(this);
		removeBracelet.addActionListener(this);
		cal.addActionListener(this);

	}

	public Tafret() throws HeadlessException {

	}

	public void actionPerformed(ActionEvent ev) {
		//opening relevant frames by constructors
		if(ev.getSource() == newBracelet) {
			setVisible(false);
			new Addbracelet(this.getDb());
		}
		else if(ev.getSource() == newPool) {
			setVisible(false);
			new Addpool(this.getDb());
		}
		else if(ev.getSource() == newManager) {
			setVisible(false);
			new Addmanager(this.getDb());
		}
		else if(ev.getSource() == connectBracelet) {
			setVisible(false);
			new Connect_bracelet_and_pool(this.getDb());
		}
		else if(ev.getSource() == removeBracelet) {
			setVisible(false);
			new Removebracelet(this.getDb());
		}
		else if(ev.getSource() == showcustomerPools) {
			setVisible(false);
			new Customerpools(getDb());
		}
		else if(ev.getSource() == cal) {
			setVisible(false);
			new Calculator();
		}
		/*else if(ev.getSource() == importbra) {
			try {
				new ImportCustomers(this.getDb());
				if(!(this.getDb().getTableCodeBracelet().isEmpty()))
					JOptionPane.showMessageDialog(this, "Importing customers has been successfully ");
				else
					JOptionPane.showMessageDialog(this, "There is no such customers ");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(ev.getSource() == importpools) {
			try {
				new ImportPools(this.getDb());
				if(!(this.getDb().getAllPools().isEmpty()))
					JOptionPane.showMessageDialog(this, "Importing pools has been successfully ");
				else
					JOptionPane.showMessageDialog(this, "There is no such pool ");
					
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
	}

}

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ImporintData extends Login implements ActionListener{
	JButton importbra = new JButton("Import all Customers");
	JButton importpools = new JButton("Import all pools");
	JButton openMenu = new JButton("open Menu");
	JLabel messtoimpor = new JLabel("Please import data by pressing the buttons:");
	boolean flag1 = false,flag2=false;
	
	
	public ImporintData(SystemDataBase db) throws HeadlessException {
		super(db);
		setLayout(new FlowLayout());
		setBounds(500, 300, 550,80);
		messtoimpor.setBounds(120, 83, 150, 50);
		add(messtoimpor);
	    add(importbra);
		add(importpools);
		add(openMenu);
		importpools.setVisible(false);
		importbra.addActionListener(this);
		importpools.addActionListener(this);
		openMenu.addActionListener(this);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public ImporintData() throws HeadlessException {
		
	}
	public void actionPerformed(ActionEvent ev) {
		if(ev.getSource()==importbra) {
			
			try {
				//the customer must first import the data from files to our data structures
				new ImportCustomers(getDb());
				//to check if the manager select just one option
				flag1=true;
				JOptionPane.showMessageDialog(this,"Importing customers has been successfully!");
				importbra.setVisible(false);
				//import first the customers to facilitate the importing of the connections between customers and pools
				importpools.setVisible(true);
			} catch (FileNotFoundException e) {
				System.out.println("Error ");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error ");
				e.printStackTrace();
			}
			
			
			
		}
		else if(ev.getSource()== importpools) {
			try {
				new ImportPools(getDb());
				//to check if the manager select just one option
				flag2=true;
				JOptionPane.showMessageDialog(this,"Importing poosl has been successfully!");
				importpools.setVisible(false);
			} catch (FileNotFoundException e) {
				System.out.println("Error ");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error ");
				e.printStackTrace();
			}
		}
		else if(ev.getSource() == openMenu) {
			if(flag1 && flag2) {
				t = new Tafret(this.getDb());
				this.setVisible(false);
				System.out.println(getDb().getAllPools());
				System.out.println(getDb().getTableCodeBracelet());
			}
			else
				JOptionPane.showMessageDialog(this, "Please import all data");
		}
		
	}
	
	

}

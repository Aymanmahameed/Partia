package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.SwingConstants;

import Exceptions.MyExeption;
import model.Department;
import model.DepartmentManager;
import model.Employee;
import model.Hotel;
import utils.Service;
import utils.Specialization;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.Choice;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

/*   Samar Amoun 212247431  */
public class AddDepartment {

	private JFrame frame;
	private JTextField depIdTxt;
	private JList<Employee> list ;
	private DefaultListModel<Employee> empModel;
	private JScrollPane eScrollPane;
	private JComboBox<DepartmentManager> comboBox;
	private JScrollPane DscrollPane;
	private Choice SpecialCh ;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDepartment window = new AddDepartment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddDepartment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(270, 150, 960, 500);
		JLabel DepIdLabel = new JLabel("Department's Id:");
		DepIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DepIdLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		DepIdLabel.setBounds(10, 95, 130, 20);
		frame.getContentPane().add(DepIdLabel);
		
		depIdTxt = new JTextField();
		depIdTxt.setColumns(10);
		depIdTxt.setBounds(180, 90, 110, 25);
		frame.getContentPane().add(depIdTxt);
		
		JLabel SpecLabel = new JLabel("Specialization:");
		SpecLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SpecLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		SpecLabel.setBounds(0, 145, 130, 20);
		frame.getContentPane().add(SpecLabel);
		
		SpecialCh = new Choice();
		SpecialCh.setBounds(180, 145, 110, 18);
		frame.getContentPane().add(SpecialCh);
		
		JLabel DepManagerLabel = new JLabel("Department manager:");
		DepManagerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DepManagerLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		DepManagerLabel.setBounds(10, 195, 159, 20);
		frame.getContentPane().add(DepManagerLabel);
		
		JLabel AllEmpLabel = new JLabel("Employees in the department:");
		AllEmpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AllEmpLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		AllEmpLabel.setBounds(341, 40, 241, 20);
		frame.getContentPane().add(AllEmpLabel);
		
		
		JButton SubmitBtn_1 = new JButton("Add Department!");
		SubmitBtn_1.setBackground(Color.WHITE);
		SubmitBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(addDep(getTheDepartment())) {
						JOptionPane.showMessageDialog(frame,"The Department has been added successfully");
						depIdTxt.setText("");
						SpecialCh.select(0);
						comboBox.setSelectedIndex(0);
					}
				} catch (HeadlessException | MyExeption e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame,e1.getMessage());				}
				
			}
		});
		SubmitBtn_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		SubmitBtn_1.setBounds(82, 380, 179, 40);
		frame.getContentPane().add(SubmitBtn_1);
		
		
		empModel = new DefaultListModel<Employee>();
	    eScrollPane = new JScrollPane();
		eScrollPane.setBounds(351, 70, 350, 350);
		
		for(Employee e :Hotel.getInstance().getAllEmployees().values()) {
			if(!(e instanceof DepartmentManager))
				empModel.addElement(e);
		}
		

		//list.setBounds(361, 71, 291, 215);
		frame.getContentPane().add(eScrollPane);
		list = new JList<Employee>(empModel);
		eScrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		comboBox = new JComboBox<DepartmentManager>();		
		DscrollPane = new JScrollPane();
		DscrollPane.setBounds(167, 186, 159, 40);
		frame.getContentPane().add(DscrollPane);
		
		DscrollPane.setViewportView(comboBox);
		
		HashMap<String, DepartmentManager> depHash = new HashMap<String, DepartmentManager>();
		HashMap<String, Employee> empHsh = Hotel.getInstance().getAllEmployees();
		for(Map.Entry<String, Employee> map:empHsh.entrySet()) {
			if(map.getValue() instanceof DepartmentManager) {
				depHash.put(map.getKey(),(DepartmentManager)map.getValue());
			}
		}
		
		Service.fillcombo(comboBox,depHash);
		
		
		SpecialCh.add("Finance");
		SpecialCh.add("Advertisement");
		SpecialCh.add("Logistics");
		SpecialCh.add("Administration");
		SpecialCh.add("costumerService");
		
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/8.jpg"));
			JPanel panel = new JPanel() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				protected void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
				}
			};
			panel.setBounds(0, 0, 950, 500);
			panel.setLayout(null);
		
			frame.getContentPane().add(panel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//checks and gets details 
	public Department getTheDepartment() throws MyExeption {
		Department d = null;
		String id = depIdTxt.getText();
		Specialization spec =Specialization.valueOf( SpecialCh.getSelectedItem());
		DepartmentManager depman = (DepartmentManager) comboBox.getSelectedItem();
		List<Employee> selec = (List<Employee>) list.getSelectedValuesList();
		if(Service.isNum(id)  && !selec.isEmpty() && selec!=null ) {
			d = new Department(id, spec);
			HashSet<Employee> hash = new HashSet<>(selec);
			d.setAllEmployees(hash);
			d.setDepManager(depman);
		}
		else
			throw new MyExeption("Please enter right data!!!");
	
		return d;
	}
	
	//adds the department 
	public boolean addDep(Department d) {
		if(d==null) return false;
		
		if(Hotel.getInstance().addDepartment(d)) {
			return true;
		}
		return false;
		
	}
	
	
}

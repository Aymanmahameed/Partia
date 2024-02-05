package View;

import java.awt.Choice;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import model.Department;
import model.DepartmentManager;
import model.Employee;
import model.Hotel;
import model.Person;
import model.PersonAlreadyExistException;
import utils.Service;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JYearChooser;

import Exceptions.MyExeption;
import java.awt.Color;

/*  Samar Amoun 212247431  */
public class AddEmployee {

	private JFrame frame;
	private JTextField IDtextF;
	private JTextField FNametextF;
	private JTextField PhonetextF;
	private JTextField LNametextF;
	private JTextField SalarytextF;
	private Choice GenderCh;
	private Choice ManagerCh;
	private JLabel FNameLabel;
	private JLabel IdLabel;
	private JLabel LNameLabel;
	private JLabel PhoneLabel;
	private JLabel GenderLabel;
	private JLabel AreaLabel;
	private Choice AreaCh;
	private JLabel BirthYLabel;
	private JLabel StartWorkLabel;
	private JLabel SalaryLabel;
	private JLabel DepLabel;
	private JLabel ManagerLabel;
	private JButton SubmitBtn_1;
	private JLabel BonusLabel;
	private JTextField BonusTxtF;
	private JComboBox<Department> DepartcomboBox;
	private ArrayList<Department> alldep;
	private JYearChooser Birthday;
	private JYearChooser sow;
	private JTextField usernametxt;
	private JLabel password;
	private JLabel username_2;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee window = new AddEmployee();
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
	public AddEmployee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		frame.setBounds(270, 150, 960, 500);
		IDtextF = new JTextField();
		IDtextF.setBounds(135, 90, 110, 25);
		frame.getContentPane().add(IDtextF);
		IDtextF.setColumns(10);

		FNametextF = new JTextField();
		FNametextF.setBounds(135, 140, 110, 25);
		frame.getContentPane().add(FNametextF);
		FNametextF.setColumns(10);

		PhonetextF = new JTextField();
		PhonetextF.setText("");
		PhonetextF.setColumns(10);
		PhonetextF.setBounds(135, 240, 110, 25);
		frame.getContentPane().add(PhonetextF);

		LNametextF = new JTextField();
		LNametextF.setText("");
		LNametextF.setColumns(10);
		LNametextF.setBounds(135, 190, 110, 25);
		frame.getContentPane().add(LNametextF);

		SalarytextF = new JTextField();
		SalarytextF.setText("");
		SalarytextF.setColumns(10);
		SalarytextF.setBounds(420, 240, 110, 25);
		frame.getContentPane().add(SalarytextF);

		GenderCh = new Choice();
		GenderCh.setBounds(135, 290, 110, 25);
		frame.getContentPane().add(GenderCh);
		GenderCh.add("-");
		GenderCh.add("F");
		GenderCh.add("M");

		ManagerCh = new Choice();
		ManagerCh.setBounds(638, 223, 110, 25);
		frame.getContentPane().add(ManagerCh);
		ManagerCh.add("-");
		ManagerCh.add("Yes");
		ManagerCh.add("No");
		ManagerCh.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (ManagerCh.getSelectedItem().equals("Yes")) {
					BonusLabel.setVisible(true);
					BonusTxtF.setVisible(true);
				} else {
					BonusLabel.setVisible(false);
					BonusTxtF.setVisible(false);
				}

			}
		});

		FNameLabel = new JLabel("First Name:");
		FNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		FNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		FNameLabel.setBounds(12, 145, 95, 13);
		frame.getContentPane().add(FNameLabel);

		IdLabel = new JLabel("ID:");
		IdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IdLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		IdLabel.setBounds(41, 95, 45, 13);
		frame.getContentPane().add(IdLabel);

		LNameLabel = new JLabel(" Last Name:");
		LNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LNameLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		LNameLabel.setBounds(10, 195, 100, 13);
		frame.getContentPane().add(LNameLabel);

		PhoneLabel = new JLabel("Phone Number:");
		PhoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PhoneLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		PhoneLabel.setBounds(10, 245, 116, 13);
		frame.getContentPane().add(PhoneLabel);

		GenderLabel = new JLabel("Gender:");
		GenderLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GenderLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		GenderLabel.setBounds(18, 295, 89, 13);
		frame.getContentPane().add(GenderLabel);

		AreaLabel = new JLabel("Area:");
		AreaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		AreaLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		AreaLabel.setBounds(300, 95, 89, 13);
		frame.getContentPane().add(AreaLabel);

		AreaCh = new Choice();
		AreaCh.setBounds(420, 90, 110, 18);
		frame.getContentPane().add(AreaCh);
		AreaCh.add("-");
		AreaCh.add("Jerusalem");
		AreaCh.add("Northern");
		AreaCh.add("Haifa");
		AreaCh.add("Central");
		AreaCh.add("TelAviv");
		AreaCh.add("Southern");
		AreaCh.add("JudeaAndSamaria");

		BirthYLabel = new JLabel("Year of birth:");
		BirthYLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BirthYLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		BirthYLabel.setBounds(289, 145, 110, 13);
		frame.getContentPane().add(BirthYLabel);

		StartWorkLabel = new JLabel("Start of work:");
		StartWorkLabel.setHorizontalAlignment(SwingConstants.CENTER);
		StartWorkLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		StartWorkLabel.setBounds(289, 195, 110, 13);
		frame.getContentPane().add(StartWorkLabel);

		SalaryLabel = new JLabel("Salary:");
		SalaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SalaryLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		SalaryLabel.setBounds(300, 245, 89, 19);
		frame.getContentPane().add(SalaryLabel);

		DepLabel = new JLabel("Department:");
		DepLabel.setHorizontalAlignment(SwingConstants.CENTER);
		DepLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		DepLabel.setBounds(18, 349, 110, 18);
		frame.getContentPane().add(DepLabel);

		ManagerLabel = new JLabel("Is the new employee a manager?");
		ManagerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ManagerLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		ManagerLabel.setBounds(539, 190, 275, 21);
		frame.getContentPane().add(ManagerLabel);

		SubmitBtn_1 = new JButton("Add!");
		SubmitBtn_1.setBackground(Color.WHITE);
		SubmitBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addTheEmp();
				} catch (MyExeption e1) {
					// TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(frame, e1.getMessage());
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(frame, e2.getMessage());
				}
			}
		});
		SubmitBtn_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		SubmitBtn_1.setBounds(323, 401, 150, 40);
		frame.getContentPane().add(SubmitBtn_1);

		BonusLabel = new JLabel("Bonus:");
		BonusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BonusLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		BonusLabel.setBounds(539, 264, 89, 19);
		frame.getContentPane().add(BonusLabel);
		BonusLabel.setVisible(false);

		BonusTxtF = new JTextField();
		BonusTxtF.setText("");
		BonusTxtF.setColumns(10);
		BonusTxtF.setBounds(638, 258, 110, 25);
		frame.getContentPane().add(BonusTxtF);
		BonusTxtF.setVisible(false);

		DepartcomboBox = new JComboBox<Department>();
		DepartcomboBox.setBounds(135, 348, 613, 25);
		frame.getContentPane().add(DepartcomboBox);
		alldep = new ArrayList<Department>();
		for (Department d : Hotel.getInstance().getAllDepartments().values()) {
			alldep.add(d);
		}
		DepartcomboBox.setModel(new DefaultComboBoxModel(alldep.toArray()));

		Birthday = new JYearChooser();
		Birthday.setBounds(420, 140, 110, 25);
		frame.getContentPane().add(Birthday);

		sow = new JYearChooser();
		sow.setBounds(420, 190, 110, 25);
		frame.getContentPane().add(sow);

		usernametxt = new JTextField();
		usernametxt.setColumns(10);
		usernametxt.setBounds(666, 93, 110, 25);
		frame.getContentPane().add(usernametxt);

		password = new JLabel("Password:");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Tahoma", Font.ITALIC, 16));
		password.setBounds(567, 144, 89, 13);
		frame.getContentPane().add(password);

		username_2 = new JLabel("UserName:");
		username_2.setHorizontalAlignment(SwingConstants.CENTER);
		username_2.setFont(new Font("Tahoma", Font.ITALIC, 16));
		username_2.setBounds(567, 96, 89, 13);
		frame.getContentPane().add(username_2);

		pass = new JPasswordField();
		pass.setColumns(10);
		pass.setBounds(666, 140, 110, 25);
		frame.getContentPane().add(pass);
		DepartcomboBox.setVisible(true);
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/7.jpg"));
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

	// gets details and checks them
	@SuppressWarnings("deprecation")
	public Employee gettheEmployee() throws MyExeption {
		Person p = Service.getTheperson(IDtextF, FNametextF, LNametextF, PhonetextF, GenderCh, AreaCh, Birthday);
		String sal = SalarytextF.getText();
		Department d = (Department) DepartcomboBox.getSelectedItem();
		int year = sow.getYear();
		Employee emp = null;
		try {
			if (Service.isNum(p.getId()) && !p.getFirstName().isEmpty() && !p.getLastName().isEmpty()
					&& Service.isNum(p.getPhoneNumber()) && p.getArea() != null && p.getGender() != null
					&& p.getYearOfBirth() < java.time.LocalDate.now().getYear() && p.getYearOfBirth() != 0
					&& Service.isNum(sal) && Integer.parseInt(sal) > 0 && year > 0 && d != null
					&& !usernametxt.getText().isEmpty() && !usernametxt.getText().equals("")
					&& !pass.getText().isEmpty() && !pass.getText().equals("") && !usernametxt.getText().equals("admin")
					&& !pass.getText().equals("admin")) {
				emp = new Employee(p.getId(), p.getFirstName(), p.getLastName(), p.getPhoneNumber(), p.getArea(),
						p.getGender(), p.getYearOfBirth(), year, Double.parseDouble(sal), d);
				emp.setUsername(usernametxt.getText());
				emp.setPassword(pass.getText());
			} else
				throw new MyExeption("Something wrong,Please fill right data!!!");
		} catch (MyExeption e) {
			JOptionPane.showMessageDialog(frame, e.getMessage());
		}
		return emp;

	}
	
	//adds the employee to the hash of employees 
	public void addTheEmp() throws MyExeption {
		Employee emp = gettheEmployee();
		if (emp != null) {
			if (ManagerCh.getSelectedItem().equals("No") || ManagerCh.getSelectedItem().equals("-")) {
				try {
					if (Hotel.getInstance().addEmployee(emp)) {
						JOptionPane.showMessageDialog(frame, "The Emplyoee has been added successfully");
						emptyall();

					}
				} catch (PersonAlreadyExistException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(frame, e.getMessage());
				}
			} else {
				String bonostxt = BonusTxtF.getText();
				Double bonos = null;
				if (Service.isNum(bonostxt)) {
					bonos = Double.valueOf(BonusTxtF.getText());

					DepartmentManager man = new DepartmentManager(emp.getId(), emp.getFirstName(), emp.getLastName(),
							emp.getPhoneNumber(), emp.getArea(), emp.getGender(), emp.getYearOfBirth(),
							emp.getStartOfWork(), emp.getSalary(), emp.getDepartment(), bonos);
					try {
						if (Hotel.getInstance().addDepartmentManager(man)) {
							JOptionPane.showMessageDialog(frame, "The Manager has been added successfully");
							emptyall();
							ManagerCh.select(0);
							BonusTxtF.setText("");
							BonusTxtF.setVisible(false);
							
						}
					} catch (PersonAlreadyExistException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(frame, e.getMessage());
					}

				} else
					JOptionPane.showMessageDialog(frame, "Please enter right value!!");

			}

		}
		

	}
	
	//this method empties the fields rigth after adding an employee 
	void emptyall() {
		Service.emptytxtfPerson(IDtextF, FNametextF, LNametextF, PhonetextF, GenderCh, AreaCh, Birthday);
		sow.setYear(Year.now().getValue());
		SalarytextF.setText("");
		usernametxt.setText("");
		pass.setText("");
		DepartcomboBox.setSelectedIndex(0);
	}

}

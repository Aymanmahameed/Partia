package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import model.Department;
import model.DepartmentManager;
import model.Employee;
import model.Hotel;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
/*   Samar Amoun 212247431  */
public class GetRealDepartment {

	private JFrame frame;
	private JTextField IDtxtF;
	private JLabel EnterLabel;
	private JLabel SpecLabel;
	private JTextField SpecialTxt;
	private JList<Employee> list;
	private DefaultListModel<Employee> empModel;
	private JScrollPane eScrollPane;
	private JLabel emplabel;
	private JLabel Depmanlab;
	private JTextField DepMan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetRealDepartment window = new GetRealDepartment();
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
	public GetRealDepartment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(270, 150, 960, 500);
		frame.getContentPane().setLayout(null);

		EnterLabel = new JLabel("Please provide the ID of the department you're seeking:");
		EnterLabel.setForeground(Color.WHITE);
		EnterLabel.setFont(new Font("Tahoma", Font.ITALIC, 14));
		EnterLabel.setBounds(33, 35, 354, 41);
		frame.getContentPane().add(EnterLabel);

		IDtxtF = new JTextField();
		IDtxtF.setBounds(383, 40, 111, 28);
		frame.getContentPane().add(IDtxtF);
		IDtxtF.setColumns(10);

		JButton EnterBtn = new JButton("enter");
		EnterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Department d = Hotel.getInstance().getRealDepartment(IDtxtF.getText());
				if (d != null) {
					SpecialTxt.setText(d.getSpecialization() + "");

					if (d.getDepManager() != null) {
						DepMan.setText(d.getDepManager().getId() + " " + d.getDepManager().getFirstName() + " "
								+ d.getDepManager().getLastName());
					}else
						DepMan.setText("The department has not manager yet");
					for (Employee em : d.getAllEmployees()) {
						if (!(em instanceof DepartmentManager))
							empModel.addElement(em);
					}

				} else {
					JOptionPane.showMessageDialog(frame, "Invalid data or Department not found!!");
					SpecialTxt.setText("");
					DepMan.setText("");
					empModel.removeAllElements();
				}
			}
		});
		EnterBtn.setBounds(509, 45, 85, 21);
		frame.getContentPane().add(EnterBtn);

		SpecLabel = new JLabel("Specialization:");
		SpecLabel.setForeground(Color.WHITE);
		SpecLabel.setHorizontalAlignment(SwingConstants.CENTER);
		SpecLabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		SpecLabel.setBounds(30, 140, 130, 20);
		frame.getContentPane().add(SpecLabel);

		SpecialTxt = new JTextField();
		SpecialTxt.setEditable(false);
		SpecialTxt.setColumns(10);
		SpecialTxt.setBounds(180, 138, 110, 25);
		frame.getContentPane().add(SpecialTxt);

		empModel = new DefaultListModel<Employee>();
		eScrollPane = new JScrollPane();
		eScrollPane.setBounds(451, 116, 350, 302);

		frame.getContentPane().add(eScrollPane);
		list = new JList<Employee>(empModel);
		eScrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		emplabel = new JLabel("Employees in this Department: ");
		emplabel.setForeground(Color.WHITE);
		emplabel.setFont(new Font("Tahoma", Font.ITALIC, 16));
		emplabel.setBounds(350, 95, 233, 28);
		frame.getContentPane().add(emplabel);

		Depmanlab = new JLabel("Department Manager:");
		Depmanlab.setForeground(Color.WHITE);
		Depmanlab.setHorizontalAlignment(SwingConstants.CENTER);
		Depmanlab.setFont(new Font("Tahoma", Font.ITALIC, 16));
		Depmanlab.setBounds(10, 185, 185, 20);
		frame.getContentPane().add(Depmanlab);

		DepMan = new JTextField();
		DepMan.setEditable(false);
		DepMan.setColumns(10);
		DepMan.setBounds(182, 185, 221, 25);
		frame.getContentPane().add(DepMan);
		
		try {
			Image backgroundImage = ImageIO.read(new File("MediaNSounds/s.jpg"));
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

}

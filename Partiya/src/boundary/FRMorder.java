package boundary;

import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JPanel;

import control.MusicianLogic;
import control.PartyLogic;
import entity.Costumer;
import entity.Musicia_In_ConcertArea;
import entity.Musician;
import entity.Parties;

import java.awt.Color;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Date;

import java.awt.event.ActionEvent;

public class FRMorder extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfPartyName;
	private JTextField tfStreet;
	private JTextField tfBuldNum;
	private JTextField tfCity;
	private JTextField tfDistrict;
	private JTextField tfSdate;
	private JTextField tfEdate;
	private JTable table;
	private ArrayList<Parties> parties = PartyLogic.getInstance().getParties();
	private ArrayList<Musicia_In_ConcertArea> shows;
	private JTextField tfPartyId;
	private JPanel panel;
	private Integer currernt = -1;
	private String[][] data;
	private String[] column;
	private JScrollPane scrollPane;
	private JButton payment;
	private JButton HomeBack;
	
	JFrame frame;
	
	private String selcetedShow;
	
	private Costumer c;

	public FRMorder(Costumer c) throws HeadlessException {
		super();
		this.c=c;
		getContentPane().setLayout(null);
		setVisible(true);
		setBounds(500, 200, 1000, 800);
		JLabel lblNewLabel = new JLabel("Parties And Shows");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(320, 10, 175, 40);
		getContentPane().add(lblNewLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel lblNewLabel_1 = new JLabel("Party Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(32, 104, 86, 13);
		getContentPane().add(lblNewLabel_1);

		tfPartyName = new JTextField();
		tfPartyName.setEditable(false);
		tfPartyName.setBounds(128, 103, 96, 19);
		getContentPane().add(tfPartyName);
		tfPartyName.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Street:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(32, 139, 52, 13);
		getContentPane().add(lblNewLabel_1_1);

		tfStreet = new JTextField();
		tfStreet.setEditable(false);
		tfStreet.setColumns(10);
		tfStreet.setBounds(130, 138, 96, 19);
		getContentPane().add(tfStreet);

		JLabel lblNewLabel_1_1_1 = new JLabel("Building Num:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(32, 174, 96, 18);
		getContentPane().add(lblNewLabel_1_1_1);

		tfBuldNum = new JTextField();
		tfBuldNum.setEditable(false);
		tfBuldNum.setColumns(10);
		tfBuldNum.setBounds(130, 173, 96, 19);
		getContentPane().add(tfBuldNum);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("City:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(250, 101, 58, 18);
		getContentPane().add(lblNewLabel_1_1_1_1);

		tfCity = new JTextField();
		tfCity.setEditable(false);
		tfCity.setColumns(10);
		tfCity.setBounds(303, 103, 96, 19);

		getContentPane().add(tfCity);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("District:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(250, 141, 58, 18);
		getContentPane().add(lblNewLabel_1_1_1_1_1);

		tfDistrict = new JTextField();
		tfDistrict.setEditable(false);
		tfDistrict.setColumns(10);
		tfDistrict.setBounds(303, 143, 96, 19);
		getContentPane().add(tfDistrict);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Starting Date:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2.setBounds(426, 104, 96, 18);
		getContentPane().add(lblNewLabel_1_1_1_2);

		tfSdate = new JTextField();
		tfSdate.setEditable(false);
		tfSdate.setColumns(10);
		tfSdate.setBounds(530, 103, 96, 19);
		getContentPane().add(tfSdate);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Ending Date:");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_2_1.setBounds(426, 136, 96, 18);
		getContentPane().add(lblNewLabel_1_1_1_2_1);

		tfEdate = new JTextField();
		tfEdate.setEditable(false);
		tfEdate.setColumns(10);
		tfEdate.setBounds(530, 138, 96, 19);
		getContentPane().add(tfEdate);

		JLabel lblNewLabel_1_1_1_3 = new JLabel("Shows in the party:");
		lblNewLabel_1_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_3.setBounds(32, 237, 154, 18);
		getContentPane().add(lblNewLabel_1_1_1_3);

		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(29, 265, 760, 241);
		getContentPane().add(panel);
		panel.setLayout(null);

		payment = new JButton("Buy ticket");
		payment.setBounds(319, 210, 118, 21);
		payment.setVisible(false);

		panel.add(payment);
		
		

		payment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (utils.Checker.getInstance().isNum(tfPartyId.getText())) {
					Parties p = PartyLogic.getInstance().getPartyById(Long.parseLong(tfPartyId.getText()));
					if (p != null) {
							initialize();
							frame.setVisible(true);
						
					}
				}

			}
		});

		JButton btnNewButton = new JButton(">|");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currernt + 1 < parties.size()) {
					currernt++;
					initTF(currernt);
				}
			}
		});
		btnNewButton.setBounds(436, 521, 106, 21);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("|<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currernt > 0) {
					currernt--;
					initTF(currernt);
				}
			}
		});
		btnNewButton_1.setBounds(218, 521, 106, 21);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1_2 = new JLabel("Party Number:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(32, 70, 106, 13);
		getContentPane().add(lblNewLabel_1_2);

		tfPartyId = new JTextField();
		tfPartyId.setText("<dynamic>");
		tfPartyId.setEditable(false);
		tfPartyId.setColumns(10);
		tfPartyId.setBounds(130, 69, 96, 19);
		getContentPane().add(tfPartyId);
		
		HomeBack = new JButton("Back to Home");
		HomeBack.setBounds(52, 647, 134, 33);
		getContentPane().add(HomeBack);
		HomeBack.addActionListener(this);
		revalidate();

	}

	void initTF(Integer current) {
		refershtf();
		panel.removeAll();
		tfPartyId.setText(String.valueOf(parties.get(current).getPartyId()));
		tfPartyName.setText(String.valueOf(parties.get(current).getPartyName()));
		tfStreet.setText(String.valueOf(parties.get(current).getStreet()));
		tfBuldNum.setText(String.valueOf(parties.get(current).getBuildingNumber()));
		tfCity.setText(String.valueOf(parties.get(current).getCity()));
		tfDistrict.setText(String.valueOf(parties.get(current).getDistrict()));
		tfSdate.setText(String.valueOf(parties.get(current).getStartDate()));
		tfEdate.setText(String.valueOf(parties.get(current).getEndDate()));

		shows = PartyLogic.getInstance().getPartyshow(tfPartyId.getText());

		column = new String[6];
		column[0] = "Show Number";
		column[1] = "Date";
		column[2] = "Start hour";
		column[3] = "End hour";
		column[4] = "Area Name";
		column[5] = "Musician";
		data = new String[shows.size()][6];
		for (int i = 0; i < shows.size(); i++) {
			data[i][0] = String.valueOf(shows.get(i).getConcertId());
			data[i][1] = String.valueOf(shows.get(i).getDate());
			data[i][2] = String.valueOf(shows.get(i).getStartHour());
			data[i][3] = String.valueOf(shows.get(i).getEndHour());
			data[i][4] = String.valueOf(shows.get(i).getAreaName());
			Musician m = MusicianLogic.getInstance().getMusByid(shows.get(i).getArtistid());
			if (m != null) {
				data[i][5] = m.getFirstName() + " " + m.getLastName();
			}

		}

		table = new JTable(data, column);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(56, 22, 621, 181);
		panel.add(scrollPane);
		panel.add(payment);
		payment.setVisible(false);
		if (utils.Checker.getInstance().isNum(tfPartyId.getText())) {
			Parties p = PartyLogic.getInstance().getPartyById(Long.parseLong(tfPartyId.getText()));
			if (p != null) {
				java.util.Date currentDate = new java.util.Date();
				Date sqlDate = new Date(currentDate.getTime());
				Calendar cal1 = Calendar.getInstance();
				cal1.setTime(p.getStartDate());
				Calendar cal2 = Calendar.getInstance();
				cal2.setTime(sqlDate);
				long milliseconds1 = cal1.getTimeInMillis();
				long milliseconds2 = cal2.getTimeInMillis();
				long hourDifference = TimeUnit.MILLISECONDS.toHours(milliseconds1 - milliseconds2);

				if (hourDifference > 48) {
					payment.setVisible(true);
				}
			}
		}

	}

	private void refershtf() {
		tfBuldNum.setText("");
		tfStreet.setText("");
		tfCity.setText("");
		tfDistrict.setText("");
		tfPartyId.setText("");
		tfSdate.setText("");
		tfEdate.setText("");
		tfPartyName.setText("");
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 468);
		frame.getContentPane().setLayout(null);

		frame.setVisible(false);

		JLabel labelname = new JLabel("Your Name:");
		labelname.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelname.setBounds(41, 113, 90, 25);
		frame.getContentPane().add(labelname);

		JLabel labelid = new JLabel("Id:");
		labelid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelid.setBounds(41, 148, 77, 25);
		frame.getContentPane().add(labelid);

		JLabel lblCardNumber = new JLabel("Card number:");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCardNumber.setBounds(41, 183, 101, 25);
		frame.getContentPane().add(lblCardNumber);

		JLabel lblExpirtedDate = new JLabel("Expirted date:");
		lblExpirtedDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblExpirtedDate.setBounds(41, 218, 101, 25);
		frame.getContentPane().add(lblExpirtedDate);

		JLabel lblCvv = new JLabel("CVV:");
		lblCvv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCvv.setBounds(41, 253, 77, 25);
		frame.getContentPane().add(lblCvv);

		nametf = new JTextField();
		nametf.setBounds(138, 118, 96, 19);
		frame.getContentPane().add(nametf);
		nametf.setColumns(10);

		idtf = new JTextField();
		idtf.setColumns(10);
		idtf.setBounds(138, 153, 96, 19);
		frame.getContentPane().add(idtf);

		cardnumtf = new JTextField();
		cardnumtf.setColumns(10);
		cardnumtf.setBounds(138, 188, 96, 19);
		frame.getContentPane().add(cardnumtf);

		CVVtf = new JTextField();
		CVVtf.setColumns(10);
		CVVtf.setBounds(138, 258, 96, 19);
		frame.getContentPane().add(CVVtf);

		JLabel lblNewLabel = new JLabel("Safety Buy");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(182, 25, 174, 53);
		frame.getContentPane().add(lblNewLabel);

		sub = new JButton("Submit");
		sub.setBounds(194, 314, 142, 45);
		frame.getContentPane().add(sub);
		sub.addActionListener(this);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(138, 218, 96, 19);
		frame.getContentPane().add(dateChooser);
	}

	private JTextField nametf;
	private JTextField idtf;
	private JTextField cardnumtf;
	private JTextField CVVtf;
	private JButton sub;
	private JDateChooser dateChooser;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sub) {
			if (table.getSelectedRow() != -1) {
				selcetedShow = data[table.getSelectedRow()][0];
				Boolean f = utils.Checker.getInstance().cardCheck(nametf.getText(), cardnumtf.getText(), idtf.getText(),
						CVVtf.getText());
				if (f && dateChooser.getDate() != null) {
					if(utils.Checker.getInstance().isNum(tfPartyId.getText())) {
						Long pid = Long.parseLong(tfPartyId.getText());
						Integer shid = Integer.parseInt(selcetedShow);
						Parties p =    PartyLogic.getInstance().getPartyById(pid);
						Musicia_In_ConcertArea show = PartyLogic.getInstance().getshowById(shid);
						Long partid = PartyLogic.getInstance().getlastParticipant().getParticipantId()+1;
						PartyLogic.getInstance().InsertToPartInParty(pid, partid, c.getPhoneNumber(), p.getStartDate(), p.getStartDate());
						PartyLogic.getInstance().InsertToPartInLocation(show.getAreaName(), partid, p.getStartDate(), p.getEndDate());
					}

				} else if (!f) {
					JOptionPane.showMessageDialog(frame, "please enter right payment details");
				} else if (dateChooser.getDate() == null) {
					JOptionPane.showMessageDialog(frame, "please fill all the details");
				} else
					JOptionPane.showMessageDialog(frame, "please fill all the details");
			} else
				JOptionPane.showMessageDialog(frame, "please select show first");
		}
		else if(e.getSource() == HomeBack) {
			System.out.println("aaaaa");
			this.setVisible(false);
			FRMCustomer.frameCustomer.setVisible(true);
		}

	}
}

package boundary;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import com.toedter.calendar.JDateChooser;

import control.AreaLogic;
import control.ConcertLogic;
import control.MusicianLogic;

import control.OccursInLogic;
import control.PerformInLogic;
import entity.Concert_Area;
import entity.Musician;
import timeselector.TimeSelectionField;

public class ManagerFrm extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDateChooser dtcDate = new JDateChooser();
	final TimeSelectionField starttime = new TimeSelectionField();
	final TimeSelectionField endtime = new TimeSelectionField();

	JLabel labAdmin = new JLabel("Hello Admin");
	JLabel labDate = new JLabel("Please enter concert date:");
	JLabel labsTime = new JLabel("Please enter concert start time:");
	JLabel labeTime = new JLabel("Please enter concert end time:");
	JLabel labmus = new JLabel("Please choose concert Musicians:");
	JLabel labmus2 = new JLabel("Musicians in the show:");
	JLabel price = new JLabel("Enter Price:");
	JButton Addmus = new JButton("Add Muscian");
	JButton showAreas = new JButton("Show Areas");
	JButton ExportConcert = new JButton("Export Area");
	JComboBox<Concert_Area> Areaslist = new JComboBox<Concert_Area>();
	JComboBox<Musician> muslist = new JComboBox<Musician>();
	//DefaultListModel<Musician> list = new DefaultListModel<Musician>();
	JList<Musician> Musicianlist;

	DefaultListModel<Musician> MusicianModel = new DefaultListModel<>();
	ArrayList<Musician> musicians = MusicianLogic.getInstance().getMusicians();

	ArrayList<Concert_Area> Areas = AreaLogic.getInstance().getConcert_Area();
	ArrayList<Musician> Adding = new ArrayList<Musician>();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ManagerFrm() throws HeadlessException {
		super();
		setLayout(null);

		dtcDate.setVisible(true);
		dtcDate.setBounds(230, 100, 150, 30);
		labDate.setBounds(70, 40, 200, 150);

		labAdmin.setBounds(170, 30, 150, 50);
		this.setBounds(500, 200, 1000, 600);
		starttime.setBounds(220, 160, 150, 30);
		endtime.setBounds(220, 210, 150, 30);
		labsTime.setBounds(40, 130, 200, 100);
		labeTime.setBounds(40, 180, 200, 100);
		labmus.setBounds(120, 220, 200, 100);
		labmus2.setBounds(520, 20, 200, 100);
		muslist.setBounds(50, 290, 370, 20);
		Areaslist.setBounds(50, 320, 370, 20);
		Addmus.setBounds(150, 420, 150, 30);
		showAreas.setBounds(150, 370, 150, 30);
		ExportConcert.setBounds(400, 500, 150, 30);

		labAdmin.setForeground(Color.BLUE);
		this.add(dtcDate);
		this.add(labAdmin);
		this.add(starttime);
		this.add(endtime);
		this.add(labDate);
		this.add(labsTime);
		this.add(labeTime);
		this.add(muslist);
		this.add(labmus);
		this.add(Addmus);
		this.add(showAreas);
		this.add(Areaslist);
		this.add(ExportConcert);
		this.add(labmus2);

		muslist.setModel(new DefaultComboBoxModel(musicians.toArray()));
		this.setVisible(true);
		Areaslist.setVisible(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		showAreas.addActionListener(this);
		Addmus.addActionListener(this);
		ExportConcert.addActionListener(this);

		Musicianlist = new JList<Musician>(MusicianModel);
		Musicianlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane singerScrollPane = new JScrollPane(Musicianlist);
		singerScrollPane.setBounds(520, 80, 400, 400);
		this.add(singerScrollPane);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == showAreas) {
			updatecomb();

		} else if (e.getSource() == Addmus) {
			updateJlist();

		} else if (e.getSource() == ExportConcert) {
			if (dtcDate.getDate() != null && !MusicianModel.isEmpty()) {
				exportConcert();
				JOptionPane.showMessageDialog(this, "Export this show has been succsfully");
			} else
				JOptionPane.showMessageDialog(this, "Please fill the details");
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	void updatecomb() {
		if (!muslist.getSelectedItem().equals("choose")) {
			ArrayList<Concert_Area> al = ConcertLogic.getInstance().getSameGenre((Musician) muslist.getSelectedItem());
			Areaslist.setModel(new DefaultComboBoxModel(al.toArray()));
			Areaslist.setVisible(true);

		}

	}

	void updateJlist() {
		Musician selceted = (Musician) muslist.getSelectedItem();

		if (!Adding.contains(selceted)) {
			if (Adding.size() < 5) {
				Adding.add(selceted);

				MusicianModel.addElement(selceted);

			} else
				JOptionPane.showMessageDialog(this, "You cannot add more than 5 musician");

		} else
			JOptionPane.showMessageDialog(this, "the musician is already exist");

	}

	@SuppressWarnings("deprecation")
	void exportConcert() {
		Long temp = ConcertLogic.getInstance().InsertConcert();
		if (temp > 0) {
			java.util.List<Object> al = Arrays.asList(Musicianlist.getSelectedValues());
			for (Object m : al) {
				if (PerformInLogic.getInstance().InsertPerform(temp, ((Musician) m).getMusician_id())) {
					java.util.Date selectedDate = dtcDate.getDate();
					java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
					java.sql.Time sqlstartTime = new java.sql.Time(starttime.getSelectedTime().getTime());
					java.sql.Time sqlendTime = new java.sql.Time(endtime.getSelectedTime().getTime());
					OccursInLogic.getInstance().InsertOccurIn(
							((Concert_Area) Areaslist.getSelectedItem()).getArea_name(), temp,
							((Musician) m).getMusician_id(), sqlDate, sqlstartTime, sqlendTime);

				}
			}

		}
	}

}

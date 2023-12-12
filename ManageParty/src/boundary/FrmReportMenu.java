package boundary;

import java.awt.Choice;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import control.AgentAndMusicianLogic;
import control.ConcertLogic;
import entity.Agent;
import entity.Musician;

public class FrmReportMenu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JDateChooser dtcDate = new JDateChooser();
	Choice mus = new Choice();
	JButton sub = new JButton("Submit");
	JLabel labAgent = new JLabel("Hello Agent");
	JLabel datelab = new JLabel("Choose a date:");
	JLabel muslab = new JLabel("Choose a Musician:");
	@SuppressWarnings("unused")
	private Agent a;
	ArrayList<Musician> musicains;

	public FrmReportMenu(Agent a) throws HeadlessException {
		super();
		this.a = a;
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 500, 500);
		mus.setBounds(50, 180, 370, 20);
		muslab.setBounds(170, 150, 370, 20);
		sub.setBounds(150, 210, 150, 30);
		dtcDate.setVisible(true);
		dtcDate.setBounds(180, 100, 150, 30);
		labAgent.setBounds(200, -43, 170, 170);
		datelab.setBounds(90, 30, 170, 170);
		labAgent.setForeground(Color.BLUE);
		add(mus);
		add(sub);
		add(labAgent);
		add(dtcDate);
		add(datelab);
		add(muslab);
		musicains = AgentAndMusicianLogic.getInstance().getMusicianbyAgent(a.getAgent_id());
		for (Musician m : musicains) {
			mus.add(m.toString());
		}
		sub.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sub) {
			Musician m = null;
			for (Musician mu : musicains) {
				if (mu.toString().equals(mus.getSelectedItem()))
					m = mu;
			}
			if (dtcDate.getDate() != null) {
				java.util.Date selectedDate = dtcDate.getDate();
				java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
				ConcertLogic.getInstance().compileConcertsByLocationReport(sqlDate, m.getMusician_id())
						.setVisible(true);
			} else
				JOptionPane.showMessageDialog(this, "Please enter a date before");

		}
	}

}

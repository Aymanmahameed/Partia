package boundary;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import control.ConcertLogic;
import control.MusicianLogic;
import control.OccursInLogic;
import control.PerformInLogic;
import entity.Musician;
import entity.Occurs_in;

public class MusicianFrm extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Musician m;
	JLabel welcome = new JLabel("Hello Artist");
	DefaultListModel<Occurs_in> list = new DefaultListModel<Occurs_in>();
	JList<Occurs_in> occurList;
	JButton rej = new JButton("Reject");
	JButton Appr = new JButton("Approve");
	DefaultListModel<Occurs_in> model = new DefaultListModel<Occurs_in>();

	public MusicianFrm(Musician m) throws HeadlessException {
		super();
		this.m = m;
		setLayout(null);
		setVisible(true);
		this.setBounds(700, 200, 500, 500);
		welcome.setBounds(190, 30, 150, 50);
		this.add(welcome);
		Appr.setBounds(100, 400, 150, 30);
		rej.setBounds(260, 400, 150, 30);
		add(rej);
		add(Appr);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcome.setForeground(Color.BLUE);
		occurList = new JList<Occurs_in>(model);
		occurList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane singerScrollPane = new JScrollPane(occurList);
		singerScrollPane.setBounds(100, 80, 300, 300);
		this.add(singerScrollPane);
		ArrayList<Occurs_in> al = MusicianLogic.getInstance().getPerMusicain(this.m);
		for (Occurs_in o : al) {
			model.addElement(o);
		}

		rej.addActionListener(this);
		Appr.addActionListener(this);

	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == Appr) {
			if (!model.isEmpty())
				JOptionPane.showMessageDialog(this, "Thank you it well amazing Shows ,good luck!");
		} else if (e.getSource() == rej) {
			if (!Arrays.asList(occurList.getSelectedValues()).isEmpty()) {
				JOptionPane.showInputDialog(this, "Please tell us the reason");
				java.util.List<Object> al = Arrays.asList(occurList.getSelectedValues());
				for (Object o : al) {
					Occurs_in oc = (Occurs_in) o;
					OccursInLogic.getInstance().removeOccursIn(oc.getArea_name(), oc.getConcert_id(),
							oc.getMusician_id());
					PerformInLogic.getInstance().removePerformIn(oc.getConcert_id(), oc.getMusician_id());
					ConcertLogic.getInstance().removeConcertId(oc.getConcert_id());
					model.removeElement(oc);
				}
			}
		}

	}

}

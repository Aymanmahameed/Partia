package boundary;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;

import control.CostomerLogic;
import entity.Costumer;
import entity.Participant;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class FRMTickets extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Costumer c;
	ArrayList<Participant> myparticipant ;
	DefaultListModel<Participant> list = new DefaultListModel<Participant>();
	JList<Participant> Participantlist;

	
	public FRMTickets(Costumer c) throws HeadlessException {
		super();
		this.c=c;
		getContentPane().setLayout(null);
		this.setBounds(500, 200, 1000, 600);
		this.setVisible(true);
		
		
		
		Participantlist = new JList<Participant>(list);
		Participantlist.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		JScrollPane ScrollPane = new JScrollPane(Participantlist);
		ScrollPane.setBounds(260, 80, 400, 400);
		getContentPane().add(ScrollPane);
		myparticipant = CostomerLogic.getInstance().getParticbantbyphone(this.c.getPhoneNumber());
		for(Participant p:myparticipant) {
			list.addElement(p);
		}
		
	}
}

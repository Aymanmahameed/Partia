package boundary;

import java.awt.Choice;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.CostomerLogic;
import control.FrienshipControl;
import entity.Costumer;
import java.awt.Font;

public class FRMfriendship extends JFrame implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Costumer c;
	Choice list = new Choice();
	Choice list2 = new Choice();
	JTextField enter = new JTextField();
	JTextField toShow = new JTextField();
	JLabel lab = new JLabel("Add a participant by choosing from a list: ");
	JLabel lab1 = new JLabel("Please enter a name without a space after the last digit:");
	JButton search = new JButton("Search: ");
	JButton choose = new JButton("choose: ");
	JButton ShowFriends = new JButton("Show My freinds ");
	JButton Back = new JButton("Back");
	JButton removef = new JButton("Remove Friend");
	JButton HomeBack = new JButton("Back to home");
	JFrame friends = new JFrame();
	Choice ListOfFriends = new Choice();
	ArrayList<Costumer> al;
	ArrayList<Costumer> alf;

	public FRMfriendship(Costumer c) throws HeadlessException {
		super();
		this.setTitle("Frindship");
		this.c = c;
		getContentPane().setLayout(null);
		setBounds(500, 200, 500, 500);
		lab.setBounds(60, 50, 250, 80);
		choose.setFont(new Font("Tahoma", Font.PLAIN, 15));
		choose.setBounds(150, 110, 150, 30);
		enter.setBounds(150, 250, 150, 20);
		friends.setBounds(500, 200, 500, 500);
		Back.setBounds(300, 400, 150, 30);
		list.add("choose");
		friends.getContentPane().add(Back);
		ShowFriends.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ShowFriends.setBounds(300, 400, 150, 30);
		friends.getContentPane().setLayout(null);
		getContentPane().add(ShowFriends);
		friends.setVisible(false);
		removef.setBounds(150, 220, 150, 30);
		friends.getContentPane().add(removef);
		lab1.setBounds(60, 150, 400, 50);
		search.setFont(new Font("Tahoma", Font.PLAIN, 15));
		search.setBounds(150, 200, 150, 30);
		list2.setBounds(150, 280, 150, 20);
		toShow.setBounds(150, 280, 150, 20);
		toShow.setVisible(false);
		toShow.setEditable(false);
		list.setVisible(false);
		getContentPane().add(lab1);
		getContentPane().add(enter);
		getContentPane().add(lab);
		getContentPane().add(list);
		getContentPane().add(search);

		getContentPane().add(list2);
		getContentPane().add(toShow);
		getContentPane().add(choose);
		
		
		
		HomeBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		HomeBack.setBounds(30, 402, 127, 28);
		HomeBack.addActionListener(this);
		getContentPane().add(HomeBack);

		choose.addActionListener(this);
		list2.setVisible(false);
		setVisible(true);
		enter.setVisible(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		friends.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		search.addActionListener(this);
		list.addItemListener(this);
		list2.addItemListener(this);
		ShowFriends.addActionListener(this);
		Back.addActionListener(this);
		al = FrienshipControl.getInstance().getNotFriends(this.c.getPhoneNumber());
		
		ListOfFriends.setBounds(150, 150, 150, 20);
		ListOfFriends.setVisible(true);
		friends.getContentPane().add(ListOfFriends);
		removef.addActionListener(this);

		for (int i = 0; i < al.size(); i++) {
			list.add( al.get(i).getFirstName() + " " + al.get(i).getLastName());
		}
		 
			
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == choose) {
			lab1.setBounds(60, 200, 400, 50);
			search.setBounds(150, 250, 150, 30);
			enter.setBounds(150, 300, 150, 20);
			list.setBounds(150, 150, 150, 20);
			list2.setBounds(150, 325, 150, 20);
			toShow.setBounds(150, 325, 150, 20);
			list.setVisible(true);
			enter.setText("");
			enter.setVisible(false);
			list2.removeAll();
			list2.setVisible(false);
			toShow.setText("");
			toShow.setVisible(false);
			lab.setVisible(true);
		}

		else if (e.getSource() == search) {
			list.setVisible(false);
			enter.setVisible(true);
			list2.setVisible(false);
			toShow.setVisible(false);

			if (!enter.getText().equals("")) {

				StringTokenizer st = new StringTokenizer(enter.getText());
				if (st.countTokens() == 1) {
					ArrayList<Costumer> allofTheName = CostomerLogic.getInstance().findCostumers(enter.getText());
					list2.removeAll();
					list2.add("choose");
					if (!allofTheName.isEmpty()) {
						for (int i = 0; i < allofTheName.size(); i++) {
							list2.add(allofTheName.get(i).getFirstName() + " " + allofTheName.get(i).getLastName());
						}

						toShow.setVisible(false);
						list2.setVisible(true);

					} else
						JOptionPane.showMessageDialog(this, "Faild to find the participant");
				} else if (st.countTokens() == 2) {
					Costumer c = CostomerLogic.getInstance().findOneCostumer(st.nextToken(), st.nextToken());
					if (c != null) {

						toShow.setText(c.getFirstName() + " " + c.getLastName());
						toShow.setVisible(true);

						list2.setVisible(false);
						if (!toShow.getText().equals("")) {
							int temp = FrienshipControl.getInstance().exportNewFriendship(this.c.getPhoneNumber(),
									c.getPhoneNumber());
							if (temp == 1) {

								JOptionPane.showMessageDialog(this, "You are friends");
								updatelist();
							} else if (temp == 2)
								JOptionPane.showMessageDialog(this, "you and " + c.getFirstName() + " "
										+ c.getLastName() + " " + "are friends before");
							else
								JOptionPane.showMessageDialog(this, "error");

						}

					} else
						JOptionPane.showMessageDialog(this, "Faild to find the participant");

				} else
					JOptionPane.showMessageDialog(this, "Faild to find the participant");
			}
		} else if (e.getSource() == ShowFriends) {
			
			
				alf = FrienshipControl.getInstance().getFriends(c.getPhoneNumber());
				if(alf.isEmpty())
					JOptionPane.showMessageDialog(this, "You dont dave any friend");
				ListOfFriends.add("choose");
				for (Costumer cc : alf)
					ListOfFriends.add(cc.getFirstName() + " " + cc.getLastName());
			

			this.setVisible(false);
			friends.setVisible(true);

		} else if (e.getSource() == Back) {
			ListOfFriends.removeAll();
			friends.setVisible(false);
			this.setVisible(true);
		}
		else if( e.getSource() ==removef) {
			if(!ListOfFriends.getSelectedItem().equals("choose")) {
				StringTokenizer st = new StringTokenizer(ListOfFriends.getSelectedItem());
				Costumer tor =  CostomerLogic.getInstance().findOneCostumer(st.nextToken(),st.nextToken());
					list.add(tor.getFirstName()+" "+tor.getLastName());
				if(FrienshipControl.getInstance().removeFriendship(c.getPhoneNumber(),tor.getPhoneNumber())==1) {
					ListOfFriends.remove(ListOfFriends.getSelectedItem());
					JOptionPane.showMessageDialog(this, "Removing "+tor.getFirstName()+" "+tor.getLastName()+" has been succsefully");
				}
				
			}
		}
		else if(e.getSource() == HomeBack) {
			System.out.println("aaaaa");
			this.setVisible(false);
			FRMCustomer.frameCustomer.setVisible(true);
		}

	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == list) {
			if (!list.getSelectedItem().equals("choose")) {
				StringTokenizer st = new StringTokenizer(list.getSelectedItem());
				String fname= st.nextToken();
				String lname= st.nextToken();
				Costumer c = CostomerLogic.getInstance().findOneCostumer(fname,lname);
				System.out.println(c);
				int temp =FrienshipControl.getInstance().exportNewFriendship(this.c.getPhoneNumber(),
						c.getPhoneNumber());
				if ( temp== 1) {
					if (!list.getSelectedItem().equals("choose")) {
						list.remove(list.getSelectedItem());
						JOptionPane.showMessageDialog(this, "You are friends");
					}
					
				}else if (temp == 2)
					JOptionPane.showMessageDialog(this, "you and " + fname + " " + lname + " " + "are friends before");
				else
					JOptionPane.showMessageDialog(this, "error");

			}
		} else if (e.getSource() == list2) {
			if (!list2.getSelectedItem().equals("choose")) {

				String item = list2.getSelectedItem();
				StringTokenizer s = new StringTokenizer(item);
				String fname = s.nextToken();
				String lname = s.nextToken();
				Costumer c = CostomerLogic.getInstance().findOneCostumer(fname, lname);
				int temp = FrienshipControl.getInstance().exportNewFriendship(this.c.getPhoneNumber(),
						c.getPhoneNumber());
				if (temp == 1) {
					if (!list2.getSelectedItem().equals("choose")) {
						list2.remove(list2.getSelectedItem());
						updatelist();
						
		
					}
					JOptionPane.showMessageDialog(this, "You are friends");
				} else if (temp == 2)
					JOptionPane.showMessageDialog(this, "you and " + fname + " " + lname + " " + "are friends before");
				else
					JOptionPane.showMessageDialog(this, "error");

			}

		}
		
	}
	void updatelist() {
		ArrayList<Costumer> arr =FrienshipControl.getInstance().getNotFriends(this.c.getPhoneNumber());
		list.removeAll();
		list.add("choose");
		for(Costumer c1:arr) {
			list.add(c1.getFirstName()+" "+c1.getLastName());
		}
	}
}

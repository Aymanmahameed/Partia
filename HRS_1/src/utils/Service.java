package utils;

import java.awt.Choice;
import java.io.File;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.toedter.calendar.JYearChooser;

import Exceptions.MyExeption;
import model.Person;
import model.Room;
import model.StandardRoom;
/* Samar Amoun  212247431*/

public class Service {
	public static Boolean flag= false;
	public static Clip clip ;
	public static Clip cliplogin ;
	public static void playAudio(String filePath) {
		try {
			File audioFile = new File(filePath);
			clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(audioFile));
			
			clip.start();
			
			flag=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void playAudioLogin(String filePath) {
		try {
			File audioFile = new File(filePath);
			cliplogin = AudioSystem.getClip();
			cliplogin.open(AudioSystem.getAudioInputStream(audioFile));
			cliplogin.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	@SuppressWarnings("unchecked")
	public static <T> void fillcombo(JComboBox<T> list, HashMap<String, T> hash) {
		ArrayList<T> all = new ArrayList<T>();
		for (T b : hash.values()) {
			all.add(b);
		}
		list.setModel(new DefaultComboBoxModel<T>((T[]) all.toArray()));
		list.setVisible(true);

	}

	public static boolean isNum(String s) {
		if (s == null)
			return false;
		if (s.isEmpty())
			return false;

		if (s.equals(""))
			return false;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9')
				return false;
		}
		return true;
	}

	public static int isGoodDate(Date d) {
		if (d == null)
			return -5;
		Date date = new Date();
		return date.compareTo(d);
	}

	public static Person getTheperson(JTextField idtf1, JTextField fname, JTextField lanme, JTextField phone,
			Choice gender, Choice area, JYearChooser chooser) throws MyExeption {
		Person p = new Person(null, null, null, null, null, null, 0);
		String id = idtf1.getText();
		String firsname = fname.getText();
		String lastname = lanme.getText();
		String phonenum = phone.getText();
		Area a = null;
		Gender g = null;
		if (!area.getSelectedItem().equals("-")) {
			a = Area.valueOf(area.getSelectedItem());
		}
		if (!gender.getSelectedItem().equals("-")) {
			g = Gender.valueOf(gender.getSelectedItem());
		}
		int birth = chooser.getYear();

		if (Service.isNum(id) && !firsname.isEmpty() && !lastname.isEmpty() && Service.isNum(phonenum) && a != null
				&& g != null && birth < java.time.LocalDate.now().getYear()) {
			p = new Person(id, lastname, lastname, phonenum, a, g, birth);

		}

		return p;
	}
	public static Room getTheRoom(JTextField floor,JTextField roomgrade,JTextField size,JTextField dprice,JTextField avgdaliycost,Choice maxpop,Choice view)  throws MyExeption  {
		Room r = new StandardRoom(0, 0, 0, 0, 0, 0, false);
	
		int fl=0 ;
		if(isNum(floor.getText())) {
			fl = Integer.parseInt(floor.getText());
		}
		double roomG=-1;
		if(!roomgrade.getText().equals("")) {
			roomG = Double.parseDouble(roomgrade.getText());
		}
		int s =-1 ;
		if(isNum(size.getText())) {
			s=Integer.parseInt(size.getText());
		}
		boolean isview=false;
		double dailyprice = -1;
		if(!dprice.getText().equals("")) {
			dailyprice = Double.parseDouble(dprice.getText());
		}
		double avg =-1;
		if(!avgdaliycost.getText().equals("")) {
			 avg = Double.parseDouble(avgdaliycost.getText());
		}
		int maxpopu=-1;
		if(!maxpop.getSelectedItem().equals("-")) {
			maxpopu=Integer.parseInt(maxpop.getSelectedItem());
		}
		
		if(view.getSelectedItem().equals("Yes")) {
			isview=true;
		}
		
		r.setFloor(fl);
		r.setDailyPrice(dailyprice);
		r.setAvgDailyCost(avg);
		r.setSize(s);
		r.setRoomGrade(roomG);
		r.setMaxPopulationCapacity(maxpopu);
		((StandardRoom)r).setHasView(isview);
		return r;
	}
	public static void emptytxtfPerson(JTextField id,JTextField fn,JTextField ln,JTextField ph,Choice ge,Choice ar,JYearChooser ch) {
		id.setText("");
		fn.setText("");
		ln.setText("");
		ph.setText("");
		ge.select(0);
		ar.select(0);
		ch.setYear(Year.now().getValue());
	}
	public static void emptytxtfRoom(JTextField f,JTextField rg,JTextField s,JTextField dp,JTextField avg,Choice ar, Choice v) {
		f.setText("");
		rg.setText("");
		s.setText("");
		dp.setText("");
		avg.setText("");
		ar.select(0);
		v.select(0);
	}
	
	
}

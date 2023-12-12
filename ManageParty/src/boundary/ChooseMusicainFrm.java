package boundary;

import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import control.MusicianLogic;
import entity.Musician;

public class ChooseMusicainFrm extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel labmus= new JLabel("Please choose concert Musicians:");
	ArrayList<Musician> musicians = MusicianLogic.getInstance().getMusicians();
	public ChooseMusicainFrm() throws HeadlessException {
		super();
		
	}
	

}

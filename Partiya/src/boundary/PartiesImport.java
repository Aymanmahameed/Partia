package boundary;

import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.ImportControl;

public class PartiesImport extends JFrame {

	/**
	 * 
	 */
	private String path;
	
	public PartiesImport(String path) throws HeadlessException {
		super();
		this.path = path;
		ImportControl.getInstance().importPartiesFromJSON(this.path);
		JOptionPane.showMessageDialog(this,"Parties data imported successfully and vip customers has been got a message about new parties");
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	private static final long serialVersionUID = 1L;
	
	PartiesImport() throws HeadlessException{
		
		
	}
 
}

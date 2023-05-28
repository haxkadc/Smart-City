package Project;

import javax.swing.JOptionPane;


public class AlternedPlate implements RedCodeStrategy {
	
	@Override
	public void deviationMethod(String ss) {
			JOptionPane.showMessageDialog(null," Cars with odd license plates cannot enter into: "+ StreetController.text);
		}
	

	
	    
}

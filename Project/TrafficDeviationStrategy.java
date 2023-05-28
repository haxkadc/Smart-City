package Project;


import javax.swing.JOptionPane;


public class TrafficDeviationStrategy implements RedCodeStrategy {
	   
		@Override
		public void deviationMethod(String text) {	
			JOptionPane.showMessageDialog(null,"The traffic on  "+ StreetController.text + " will be divert on Via Napoli");
		}				
}
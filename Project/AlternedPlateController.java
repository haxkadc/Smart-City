package Project;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class AlternedPlateController {
	 @FXML
	    private TextField targaInput;
	    @FXML
	    private TextField viaInput;
	    @FXML
	    private TextField idInput;
	 @FXML
	 private void addNewCar(ActionEvent event) {
		 
		 SingletonConnection sc = SingletonConnection.getinstance();
		 AlternedPlate a = new AlternedPlate();
		 ThresholdController b = new ThresholdController();
		 String ss = StreetController.text;
		 String query  = "INSERT INTO E_TRANSITATO  (TARGA_VEICOLO,STRADA_COLONNINA,ID_COLONNINA) VALUES (?,?,?) ";
	         try (PreparedStatement ps = sc.con.prepareStatement(query)) {
	        	 
	        	 int i = (int)(Math.random()*10);
	        	 System.out.println(i);
	        	
	        	  

	        	 ps.setString(1, targaInput.getText());
	             ps.setString(2, viaInput.getText());
	             ps.setString(3, idInput.getText());
	             
	             if( i%2 != 0) {
	 	         a.deviationMethod(ss);
	        	 i++;
	             b.alternedPButton(event);

	             }else {
	           
	            
	             ps.executeQuery();
	             JOptionPane.showMessageDialog(null,"VEHICLE ADDED");
	             i++;
	             ps.close();
	             }
	    	 }catch(Exception e){
	         
	    		 if (e instanceof SQLException)
	             JOptionPane.showMessageDialog(null,"ERRORE SQL");
	    		 else JOptionPane.showMessageDialog(null,"Altro Errore!!");
	             }

	 }
	 
	 public void backToMenu(ActionEvent event) throws IOException
	 {
			
	     Parent tableViewParent = FXMLLoader.load(getClass().getResource("ThresholdController.fxml"));
	     Scene tableViewScene = new Scene(tableViewParent);
	     
	     //This line gets the Stage information
	     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	     
	     window.setScene(tableViewScene);
	     window.show();
			

	 }
	 public void backHome(ActionEvent event) throws IOException
	 {
			
	     Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
	     Scene tableViewScene = new Scene(tableViewParent);
	     
	     //This line gets the Stage information
	     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	     
	     window.setScene(tableViewScene);
	     window.show();
			

	 }
	 
	 
}

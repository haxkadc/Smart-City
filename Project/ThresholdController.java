package Project;

import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class ThresholdController implements Initializable {
	

	public static int threshold_p;
	public static int threshold_t;
	public static int threshold_c;
	@FXML
	public Label label;
	
	@FXML
    private TableView<DataStreet> table;
    
    @FXML
    private TableColumn<DataStreet, String> street;
 
    public  String cod = null;
    
    ObservableList<DataStreet> oblist = FXCollections.observableArrayList();
	
	
	public void initialize(URL url, ResourceBundle rb) {
        SingletonConnection sc;
        sc = SingletonConnection.getinstance();
    	String query  = "SELECT * FROM COLONNINE WHERE STRADA = ?";
        try (PreparedStatement ps = sc.con.prepareStatement(query)) {
        			ps.setString(1,StreetController.text);
                	ResultSet rs = ps.executeQuery();
                	while(rs.next())
                	{
                		oblist.add(new DataStreet(rs.getString(1),rs.getString(6)));
                		pass(rs.getString(6));
                	}

                	ps.close();
                } catch (SQLException ex) 
            		{
                		ex.printStackTrace();
                	}
        street.setCellValueFactory(new PropertyValueFactory<>("street"));
        table.setItems(oblist); 
    }    

	void pass(String codd) {
		cod =codd;
	}
		
	
	
	
	
	 public void backButton(ActionEvent event) throws IOException
	    {
			
	        Parent tableViewParent = FXMLLoader.load(getClass().getResource("DataStreet.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(tableViewScene);
	        window.show();
			

	    }
	 
	    
	 public void alternedP(ActionEvent event) throws IOException {
		 
		 if(!cod.equals("ROSSO")) {
				JOptionPane.showMessageDialog(null,"Operazione disponibile solo per le le strade in codice ROSSO ");

		 }else {
				alternedPButton(event);
		 }
	 }
	
	 public void alternedPButton(ActionEvent event) throws IOException
	    {
			
	        Parent tableViewParent = FXMLLoader.load(getClass().getResource("AlternedPlate.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(tableViewScene);
	        window.show();
			

	    }
	 
public void deviationTP(ActionEvent event) throws IOException {
		 
		 if(!cod.equals("ROSSO")) {
				JOptionPane.showMessageDialog(null,"Operazione disponibile solo per le le strade in codice ROSSO ");

		 }else {
			 deviatioTPButton(event);
		 }
	 }
	 
	 public void deviatioTPButton(ActionEvent event) throws IOException
	    {
			
	        Parent tableViewParent = FXMLLoader.load(getClass().getResource("TrafficDeviation.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(tableViewScene);
	        window.show();
			

	    }
	 
	
		 
		    
		 
	 


	
}
 
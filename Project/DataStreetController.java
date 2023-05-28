package Project;

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


public class DataStreetController implements Initializable{

   
		@FXML
	    private TableView<DataStreet> table;
	    
	    @FXML
	    private TableColumn<DataStreet, String> street;
	    
	    @FXML
	    private TableColumn<DataStreet, String> pollutionthreshold;

	    @FXML
	    private TableColumn<DataStreet, String> temperaturethreshold;
	    
	    @FXML
	    private TableColumn<DataStreet, String> carthreshold;
	    
	    @FXML
	    private TableColumn<DataStreet,String> id;
	   
	 
	    
	    ObservableList<DataStreet> oblist = FXCollections.observableArrayList();

	    @FXML
	    private void goToTC(ActionEvent event) {
	    	 SingletonConnection sc;      
	         sc = SingletonConnection.getinstance();

	     	String query  = "SELECT CODICE FROM COLONNINE WHERE STRADA = ?";
	            try (PreparedStatement ps =sc.con.prepareStatement(query)) {
	            	
	            	ps.setString(1,StreetController.text);
	                ResultSet rs = ps.executeQuery();
	                String verifica_nome = null;
	                while(rs.next())
	                {
	                    verifica_nome = rs.getString("CODICE");
	                   
	                }
	                if (verifica_nome != null )
	                {
	                JOptionPane.showMessageDialog(null,"CODICE " + verifica_nome);
	                
	                ps.close();
	                thresholdButton(event);
	                }
	                else
	                {
	                    JOptionPane.showMessageDialog(null,"Dati Errati!!!!");
	                    ps.close();
	                }
	            } catch(Exception e){
	            if (e instanceof SQLException)
	                JOptionPane.showMessageDialog(null,"ERRORE SQL");
	            else JOptionPane.showMessageDialog(null,"Altro Errore!!");
	                }

	    }
	    
	    
	 @FXML
		public void thresholdButton(ActionEvent event) throws IOException
	    {    	       
	    	    try{
	    	    	  Parent tableViewParent = FXMLLoader.load(getClass().getResource("ThresholdController.fxml"));
	    	          Scene tableViewScene = new Scene(tableViewParent);
	    	          
	    	          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	    	          
	    	          window.setScene(tableViewScene);
	    	          window.show();
	    	        }
	    	        catch(Exception e){
	    	        }
    
    
}
    
    public void initialize(URL url, ResourceBundle rb) {
        SingletonConnection sc;
    	System.out.println("conn");
    	String query  = "SELECT * FROM COLONNINE WHERE STRADA = ?";
        sc = SingletonConnection.getinstance();
        try (PreparedStatement ps = sc.con.prepareStatement(query)) {
        			ps.setString(1,StreetController.text);
                	ResultSet rs = ps.executeQuery();
                	while(rs.next())
                	{
                		oblist.add(new DataStreet(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getString(6)));

                	}

                	ps.close();
                } catch (SQLException ex) 
            		{
                		ex.printStackTrace();
                	}
        street.setCellValueFactory(new PropertyValueFactory<>("street"));
        pollutionthreshold.setCellValueFactory(new PropertyValueFactory<>("pollutionThreshold"));
        temperaturethreshold.setCellValueFactory(new PropertyValueFactory<>("temperaturethreshold"));
        carthreshold.setCellValueFactory(new PropertyValueFactory<>("carThreshold"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        System.out.println(street);
        table.setItems(oblist); 
        
    }    



	public void backButton(ActionEvent event) throws IOException
    {
		
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Street.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
		

    }
    
	
	

    
    
    
	
}

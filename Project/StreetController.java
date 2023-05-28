package Project;


import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class StreetController  {
	
	
	@FXML
	private TextField street;
    
	public static  String text;
	
    @FXML
    private void controlStreet(ActionEvent event) {
    	 SingletonConnection sc;      
         sc = SingletonConnection.getinstance();

     	String query  = "SELECT * FROM COLONNINE WHERE STRADA = ?";
            try (PreparedStatement ps =sc.con.prepareStatement(query)) {
                text = street.getText();
            	ps.setString(1,text);
                ResultSet rs = ps.executeQuery();
                String verifica_nome = null;
                while(rs.next())
                {
                    verifica_nome = rs.getString("STRADA");
                   
                }
                if (verifica_nome != null )
                {
                JOptionPane.showMessageDialog(null,"VIA CORRETTA");
                
                ps.close();
                streetButton(event);
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
	public void streetButton(ActionEvent event) throws IOException
    {    	       
    	    try{
    	    	  Parent tableViewParent = FXMLLoader.load(getClass().getResource("DataStreet.fxml"));
    	          Scene tableViewScene = new Scene(tableViewParent);
    	          
    	          Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    	          
    	          window.setScene(tableViewScene);
    	          window.show();
    	        }
    	        catch(Exception e){
    	        }
    	     
    	    
    }
    public void backButton(ActionEvent event) throws IOException
    {
		
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.show();
		

    }
    
  
    
    
}

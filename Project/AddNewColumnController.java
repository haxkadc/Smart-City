package Project;


import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pattern.memento.Originator;
import pattern.memento.Originator.Memento;



public class AddNewColumnController implements Initializable  {
	 	
    @FXML
    private Button button;
    @FXML
    private TextField nomeInput;
    @FXML
    private TextField numInput;
    @FXML
    private TextField nomeInput2;

    @FXML
    private AnchorPane rootLayout;

    public String text2 ;
    public String num2;
    Originator originator = new Originator();
    Memento mementoState1 = originator.createMemento();

   
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}	
         	
 @FXML
 public void addColumn(ActionEvent event) throws SQLException {
	
	 SingletonConnection sc = SingletonConnection.getinstance();
	 
     try (PreparedStatement ps = sc.con.prepareStatement( "INSERT INTO COLONNINE (STRADA,INQUINAMENTO,TEMPERATURA,N_AUTOVEICOLI,ID,CODICE) VALUES (?,?,?,?,?,?) ")){
    	 ps.setString(1, nomeInput.getText());
    	 String text = numInput.getText();
    	 int ID = Integer.parseInt(text);
    	 ps.setString(2, "1");
    	 ps.setString(3, "1");
    	 ps.setString(4, "1");
    	 ps.setString(6, "VERDE");

    	 ps.setInt(5,ID);
    	 ps.executeQuery();

    	 JOptionPane.showMessageDialog(null,"COLUMN ADDED IN "+ nomeInput.getText());
         ps.close();

     }catch(Exception e){
         if (e instanceof SQLException)
             JOptionPane.showMessageDialog(null,"ERRORE SQL");
         else JOptionPane.showMessageDialog(null,"Altro Errore!!");
     }  

 }
 
 public void backToMenu(ActionEvent event) throws IOException
 {
		
     Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
     Scene tableViewScene = new Scene(tableViewParent);
     
     //This line gets the Stage information
     Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
     
     window.setScene(tableViewScene);
     window.show();
		

 }
 
	public void init() {
    	originator.setOriginatorState(text2 = null);

	}	
        
 
 public void mobileColumn(ActionEvent event) {
	 
	 	init();
   	 	originator.setOriginatorState(text2 = nomeInput2.getText());
   	 	JOptionPane.showMessageDialog(null,"MOBILE COLUMN ADDED IN "+ nomeInput2.getText());
 }
 
 
 public void removeMobileColumn(ActionEvent event) {
	
	 originator.restoreMemento(mementoState1);     
	 JOptionPane.showMessageDialog(null,"MOBILE COLUMN REMOVED FROM "+ nomeInput2.getText());

 }

 
 }
	
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.stage.Stage;



public class GraphicController  {

	@FXML
	private CategoryAxis xAxis;
	
	@FXML
	private NumberAxis yAxis;

	@FXML
	private Button button;
	
	@FXML
	private BarChart <String,Number> stackedBarChart;

	
	public void printChart(ActionEvent event) throws SQLException {
		SingletonConnection sc;      
        sc = SingletonConnection.getinstance();
        XYChart.Series<String,Number> series1 = new XYChart.Series<>();


    	String query  = "SELECT * FROM COLONNINE  ";
           try (PreparedStatement ps =sc.con.prepareStatement(query)) {
           	
               ResultSet rs = ps.executeQuery();
               while(rs.next()) {
            	 
                   series1.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(2)));
                   series1.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(2)));
                   series1.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(2)));
                   series1.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(2)));
                   series1.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(2)));
                   series1.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(2)));
                   series1.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(2)));
                   series1.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(2)));
                   series1.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(2)));

                   

            	   
               }
               stackedBarChart.getData().add(series1);

   
		
           }catch(Exception e){
               if (e instanceof SQLException)
                   JOptionPane.showMessageDialog(null,"ERRORE SQL");
               else JOptionPane.showMessageDialog(null,"Altro Errore!!");
                   }

       }
	
	
	public void printTemp(ActionEvent event) throws SQLException {
		SingletonConnection sc;      
        sc = SingletonConnection.getinstance();
        XYChart.Series<String,Number> series2 = new XYChart.Series<>();


    	String query  = "SELECT * FROM COLONNINE  ";
           try (PreparedStatement ps =sc.con.prepareStatement(query)) {
           	
           		//ps.setString(1,"VIA_COMO");
               ResultSet rs = ps.executeQuery();
               while(rs.next()) {
            	 
            	   series2.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(3)));
            	   series2.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(3)));
            	   series2.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(3)));
            	   series2.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(3)));
            	   series2.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(3)));
            	   series2.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(3)));
            	   series2.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(3)));
            	   series2.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(3)));
            	   series2.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(3)));

                   

            	   
               }
               stackedBarChart.getData().add(series2);

   
		
           }catch(Exception e){
               if (e instanceof SQLException)
                   JOptionPane.showMessageDialog(null,"ERRORE SQL");
               else JOptionPane.showMessageDialog(null,"Altro Errore!!");
                   }

       }
	
	
	public void printCar(ActionEvent event) throws SQLException {
		SingletonConnection sc;      
        sc = SingletonConnection.getinstance();
        XYChart.Series<String,Number> series3 = new XYChart.Series<>();


    	String query  = "SELECT * FROM COLONNINE  ";
           try (PreparedStatement ps =sc.con.prepareStatement(query)) {
           	
           		//ps.setString(1,"VIA_COMO");
               ResultSet rs = ps.executeQuery();
               while(rs.next()) {
            	 
            	   series3.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(4)));
            	   series3.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(4)));
            	   series3.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(4)));
            	   series3.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(4)));
            	   series3.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(4)));
            	   series3.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(4)));
            	   series3.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(4)));
            	   series3.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(4)));
            	   series3.getData().add(new Data<String, Number>(rs.getString(1),rs.getInt(4)));

                   

            	   
               }
               stackedBarChart.getData().add(series3);

   
		
           }catch(Exception e){
               if (e instanceof SQLException)
                   JOptionPane.showMessageDialog(null,"ERRORE SQL");
               else JOptionPane.showMessageDialog(null,"Altro Errore!!");
                   }

       }
	
	
	 public void HomeButton(ActionEvent event) throws IOException
	    {
			
	        Parent tableViewParent = FXMLLoader.load(getClass().getResource("Menu.fxml"));
	        Scene tableViewScene = new Scene(tableViewParent);
	        
	        //This line gets the Stage information
	        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        
	        window.setScene(tableViewScene);
	        window.show();
			

	    }
}

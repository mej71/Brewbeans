package brewbeans;
//Declare imports
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author Wes
 */
public class FXMLLogInPageController implements Initializable
{//reference FXML document variables
    @FXML
    private Button logInButton;
    
    @FXML
    private Button closeButton;
    
    @FXML
    private TextField username_box;
    
    @FXML
    private PasswordField password_box;
    
    @FXML
    private Label invalid_label;
    
    int userNum;
        
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }    
    
    @FXML
    private void onClickLogIn(ActionEvent event) throws Exception 
    {               
        //after lick log on determines if allowed access
        if (isValidCredentials())
        {   //builds the new scene and gets the controller
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLHomePage.fxml"));   
            Parent root = (Parent)fxmlLoader.load();          
            FXMLHomePageController controller = fxmlLoader.<FXMLHomePageController>getController();
            
            controller.setUserNum(userNum);
            //makes scene available and sets title, icon, etc..
            Scene scene = new Scene(root); 
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();    
            app_stage.setScene(scene);
            app_stage.setResizable(false);
            app_stage.getIcons().add(new Image("file:src/brewbeans/images/55-512.png"));
            scene.getStylesheets().add("brewbeans/LogInStyleSheet.css");
            app_stage.setTitle("Shop Brew Beans");
            app_stage.centerOnScreen();
            app_stage.show(); 
        }
        else
        {   //resets the boxes and tells user it was incorrect  
            username_box.clear();
            username_box.requestFocus();
            password_box.setText("");
            invalid_label.setText("Invalid username/password"); 
        }
    }
    
    
    
    private boolean isValidCredentials()
    {
        boolean let_in = false;
        
        try
        {  //conects to the databse and checks if the username and pass combo are in DB
            //load the driver class  
            Class.forName("oracle.jdbc.driver.OracleDriver");  

            
            try ( //create  the connection object
                    Connection con = DriverManager.getConnection(
                            "jdbc:oracle:thin:@oracle.gulfcoast.edu:1521/orcl.gulfcoast.edu","teamCoffee","oracleTC"); //create the statement object
                    Statement stmt = con.createStatement(); //execute query
                    ResultSet rs = stmt.executeQuery( "SELECT IDSHOPPER, USERNAME, PASSWORD FROM BB_SHOPPER" )) 
                    {
                                        
                        while ( rs.next() )
                        {                        //test strings against DB    
                            if (rs.getString("USERNAME") != null && rs.getString("USERNAME").toLowerCase().equals(username_box.getText().toLowerCase()) && rs.getString("PASSWORD") != null && rs.getString("PASSWORD").equals(password_box.getText()))
                            {
                                let_in = true;
                                userNum = rs.getInt("IDSHOPPER");
                            } 
                        }                        
                    }
        }
        catch(ClassNotFoundException | SQLException e)
        { 
            System.out.println(e);
        }
        return true;
        //return let_in; database no longer existing
        
    }
    
    @FXML
    private void onClickClose(ActionEvent event) throws Exception
    {
        System.exit(0);//program exits correctly
    }    

}



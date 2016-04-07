package brewbeans;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;




/**
 *
 * @author Wes
 */
public class BrewBeans extends Application
{   
    @Override
    public void start(Stage stage) throws Exception
    {           
        Parent root = FXMLLoader.load(getClass().getResource("FXMLLogInPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:src/brewbeans/images/55-512.png"));        
        scene.getStylesheets().add("brewbeans/LogInStyleSheet.css");
        stage.setTitle("Shop Brew Beans Log In");
        stage.sizeToScene();
        stage.centerOnScreen();        
        stage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}

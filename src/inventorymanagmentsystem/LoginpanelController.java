
package inventorymanagmentsystem;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Muhammed
 */
public class LoginpanelController implements Initializable {
    
    @FXML
    private Button close;
    
    @FXML
    private Button loginbtn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;
    
    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    
    private double x= 0 ;
    private double y= 0;
    
    logindata login_data;
    public void login(){
        
        String sql = "SELECT * FROM users WHERE username = ? and password = ?";
        
        connect = database.connectDb();
        
        try{
            Alert alert;
            
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, username.getText());
            prepare.setString(2, password.getText());
            
            result = prepare.executeQuery();

            if(username.getText().isEmpty() || password.getText().isEmpty()){
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                if(result.next()){  
                   /* user = new user(username.getText(),
                            result.getInt("WarehouseID"),
                            result.getInt("permission"));*/
                   login_data.username = username.getText();
                    
                    loginbtn.getScene().getWindow().hide();
                    
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/dashboard.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    
                    root.setOnMousePressed((MouseEvent event) ->{
                        x = event.getSceneX();
                        y = event.getSceneY();
                    });
                    
                    root.setOnMouseDragged((MouseEvent event) ->{
                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);
                    });
                    
                    stage.initStyle(StageStyle.TRANSPARENT);
                    
                    stage.setScene(scene);
                    stage.show();
                    
                }else{
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username/Password");
                    alert.showAndWait();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            Alert alert;
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(e.toString());
            alert.showAndWait();
                }
        }
        
    
    public void close(){
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

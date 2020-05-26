/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem.ui.addMember;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mohamad
 */
public class MemberAddController implements Initializable {

    Statement statement;
    @FXML
    private TextField Name;
    @FXML
    private TextField userID;
    @FXML
    private TextField Password;
    @FXML
    private TextField Email;
    @FXML
    private Button saveButton;
    @FXML
    private Button cancelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection connection =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/library?zeroDateTimeBehavior=convertToNull", "root", "");
            
            this.statement = (Statement) connection.createStatement();
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }    

    @FXML
    private void addMember(ActionEvent event) throws SQLException {
        String memberName = Name.getText();
        String MemberID = userID.getText();
        String memberPassword = Password.getText();
        String memberEmail = Email.getText();
        
        if(memberName.isEmpty() || MemberID.isEmpty() || memberPassword.isEmpty() || memberEmail.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }
        String qu = "insert into users (user_id,name,password,email) values ('"+ MemberID + "','"+ memberName + "','"+ memberPassword + "','"+ memberEmail +"')";
        //ResultSet rs = this.statement.executeQuery(qu);
        this.statement.executeUpdate(qu);
    }

    @FXML
    private void cancel(ActionEvent event) {
        Name.clear();
        userID.clear();
        Password.clear();
        Email.clear();
    }
    
}

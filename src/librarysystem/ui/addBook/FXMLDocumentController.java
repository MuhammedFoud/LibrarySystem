/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem.ui.addBook;

import java.sql.Statement;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;

/**
 * FXML Controller class
 *
 * @author mohamad
 */
public class FXMLDocumentController implements Initializable {

    Statement statement;
    @FXML
    private TextField title;
    @FXML
    private TextField id;
    @FXML
    private TextField author;
    @FXML
    private TextField publisher;
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
    private void addBook(ActionEvent event) throws SQLException {
        String BoodID = id.getText();
        String BoodAuther = author.getText();
        String BoodName = title.getText();
        String BoodPublisher = publisher.getText();
        
        if(BoodID.isEmpty() || BoodAuther.isEmpty() || BoodName.isEmpty() || BoodPublisher.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid input");
            alert.setContentText("Please fill all the fields");
            alert.showAndWait();
            return;
        }
        String qu = "insert into books (book_id, title, author, publisher) values ('"+ BoodID + "','"+ BoodName + "','"+ BoodAuther + "','"+ BoodPublisher +"')";
        //ResultSet rs = this.statement.executeQuery(qu);
        this.statement.executeUpdate(qu);


    }

    @FXML
    private void cancel(ActionEvent event) {
        title.clear();
        id.clear();
        author.clear();
        publisher.clear();
    }
    
}

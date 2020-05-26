/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem.ui.main;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author mohamad
 */
public class MainController implements Initializable {

    Statement statement;
    @FXML
    private TextField bookIDTextField;
    @FXML
    private TextField borrowerIDTextField;
    @FXML
    private Button Borrowbtn;
    @FXML
    private TextField bookIDTextField2;
    @FXML
    private Button Renewbtn;
    @FXML
    private Button Submissionbtn;
    @FXML
    private Button addBook;
    @FXML
    private ImageView addBookbtn;
    @FXML
    private Button viewBooks;
    @FXML
    private Button viewBorrowers;
    @FXML
    private Button addUser;
    @FXML
    private ImageView addBookbtn1;

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
    private void BorrowABook(ActionEvent event) {
    }

    @FXML
    private void RenewTheBorrow(ActionEvent event) {
    }

    @FXML
    private void Submission(ActionEvent event) {
    }

    @FXML
    private void addBook(ActionEvent event) {
    }

    @FXML
    private void viewBooks(ActionEvent event) {
    }

    @FXML
    private void viewBorrowers(ActionEvent event) {
    }

    @FXML
    private void addUser(ActionEvent event) {
    }
    
    
}

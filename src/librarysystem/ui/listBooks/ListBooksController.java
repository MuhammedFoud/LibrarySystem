/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem.ui.listBooks;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author mohamad
 */
public class ListBooksController implements Initializable {
    
    ObservableList<Book> list = FXCollections.observableArrayList();

    Statement statement;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TableView<Book> tableView;
    @FXML
    private TableColumn<Book, String> titleCol;
    @FXML
    private TableColumn<Book, String> idCol;
    @FXML
    private TableColumn<Book, String> authorCol;
    @FXML
    private TableColumn<Book, String> publisherCol;
    @FXML
    private TableColumn<Book, Boolean> availabilityCol;

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
        titleCol.setCellValueFactory(new PropertyValueFactory("title"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        authorCol.setCellValueFactory(new PropertyValueFactory("author"));
        publisherCol.setCellValueFactory(new PropertyValueFactory("publisher"));
        availabilityCol.setCellValueFactory(new PropertyValueFactory("avilability"));
    } 
        
    private void loadData() throws SQLException { 
        ResultSet rs = this.statement.executeQuery("Select * From books");
        tableView.getItems().clear();
        while(rs.next()){
            String title = rs.getString("title");
            String author = rs.getString("author");
            String id = rs.getString("book_id");
            String publisher = rs.getString("publisher");
            //Boolean avail = rs.getBoolean("isAvailable");
            
            list.add(new Book(title, id, author, publisher ));
            
            }
        tableView.getItems().setAll(list);
    }
    }   



    
    class Book{
        private final SimpleStringProperty title;
        private final SimpleStringProperty id;
        private final SimpleStringProperty author;
        private final SimpleStringProperty publisher;
        //private final SimpleBooleanProperty availability;

   
        
        public Book(String title, String id,String author, String pub) {
            this.title = new SimpleStringProperty(title);
            this.id = new SimpleStringProperty(id);
            this.author = new SimpleStringProperty(author);
            this.publisher = new SimpleStringProperty(pub);
            //this.availability = new SimpleBooleanProperty(avail);
        }

        public String getTitle() {
            return title.get();
        }

        public String getId() {
            return id.get();
        }

        public String getAuthor() {
            return author.get();
        }

        public String getPublisher() {
            return publisher.get();
        }

        /*
        public Boolean getAvailability() {
            return availability.get();
        }
        */

        
    }

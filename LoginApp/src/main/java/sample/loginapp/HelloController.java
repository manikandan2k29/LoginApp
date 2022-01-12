package sample.loginapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class HelloController {
    @FXML
    private Button log_btn;

    @FXML
    private PasswordField pwd_txt;

    @FXML
    private TextField uname_txt;

    Connection conn;
    PreparedStatement pst;
    ResultSet rslt;

    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    void login(ActionEvent event) {
        String uname =uname_txt.getText();
        String pass = pwd_txt.getText();
        if (uname.equals("") && pass.equals("")){
            JOptionPane.showMessageDialog(null,"Username & Password is Missing");
        }

        else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/myapp","root","password");
                pst = conn.prepareStatement("select * from users where username=? and password=?");
                pst.setString(1, uname);
                pst.setString(2, pass);
                rslt = pst.executeQuery();

                if(rslt.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successfull");
                     root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("loggedIn.fxml")));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                     scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Login Failed");
                    uname_txt.setText("");
                    pwd_txt.setText("");
                    uname_txt.requestFocus();
                }
            } catch (ClassNotFoundException | SQLException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    }

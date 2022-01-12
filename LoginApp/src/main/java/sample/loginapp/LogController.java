package sample.loginapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.sql.*;

public class LogController {

    @FXML
    private TextField address_txt;

    @FXML
    private TextField city_txt;

    @FXML
    private TextField country_txt;

    @FXML
    private TextField f_name_txt;

    @FXML
    private TextField l_name_txt;

    @FXML
    private TextField mob_num;

    @FXML
    private TextField state_txt;




    Connection con;
    PreparedStatement pst;


    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/myapp","root","password");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void add_data(ActionEvent event) {
        connect();
        String fname = f_name_txt.getText();
        String lname = l_name_txt.getText();
        String mobno = mob_num.getText();
        String address = address_txt.getText();
        String city = city_txt.getText();
        String state = state_txt.getText();
        String country = country_txt.getText();

        try {
            pst = con.prepareStatement("insert into userdata(fname,lname,mobilenum,address,city,state,country) values(?,?,?,?,?,?,?)");
            pst.setString(1,fname);
            pst.setString(2,lname);
            pst.setString(3,mobno);
            pst.setString(4,address);
            pst.setString(5,city);
            pst.setString(6,state);
            pst.setString(7,country);

            int status = pst.executeUpdate();

            if (status==1){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText("Success");
                alert.setContentText("User added successfully");
                alert.showAndWait();

                f_name_txt.setText("");
                l_name_txt.setText("");
                mob_num.setText("");
                address_txt.setText("");
                city_txt.setText("");
                state_txt.setText("");
                country_txt.setText("");
                f_name_txt.requestFocus();

            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Failed");
                alert.setHeaderText("Fail");
                alert.setContentText("User update failed");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    }





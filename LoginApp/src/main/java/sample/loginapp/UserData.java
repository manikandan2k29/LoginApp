package sample.loginapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class UserData {

    private final StringProperty fname;
    private final StringProperty lname;
    private final StringProperty mobno;
    private final StringProperty address;
    private final StringProperty city;
    private final StringProperty state;
    private final StringProperty country;


    public UserData(){
        fname = new SimpleStringProperty(this,"fname");
        lname = new SimpleStringProperty(this,"lname");
        mobno = new SimpleStringProperty(this,"mobno");
        address = new SimpleStringProperty(this,"address");
        city = new SimpleStringProperty(this,"city");
        state = new SimpleStringProperty(this,"state");
        country = new SimpleStringProperty(this,"country");

    }



    public StringProperty fnameProperty() {
        return fname;
    }
    public void setFname(String newAge){
        fname.set(newAge);
    }
    public String getfname() {
        return fname.get();
    }

    public StringProperty lnameProperty() {
        return lname;
    }
    public void setLname(String newAge){
        lname.set(newAge);
    }
    public String getLname() {
        return lname.get();
    }


    public StringProperty mobnoproperty() {
        return mobno;
    }
    public void setMobno(String newMobno){
        mobno.set(newMobno);
    }
    public String getMobno() {
        return mobno.get();
    }


    public StringProperty addressproperty() {
        return address;
    }
    public void setAddress(String newAddress){
        address.set(newAddress);
    }
    public String getAddress() {
        return address.get();
    }


    public StringProperty cityproperty() {
        return city;
    }
    public void setCity(String newCity){
        city.set(newCity);
    }
    public String getCity() {
        return city.get();
    }


    public StringProperty stateproperty() {
        return state;
    }
    public void setState(String newState){
        state.set(newState);
    }
    public String getState() {
        return state.get();
    }


    public StringProperty countryproperty() {
        return country;
    }
    public void setCountry(String newCountry){
        country.set(newCountry);
    }
    public String getCountry() {
        return country.get();
    }




}

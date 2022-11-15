package Actors;

public class Customer extends Shopper {
    public String forename;
    public String surname;
    public String houseNo;
    public String roadName;
    public String cityName;
    public String postCode;

    public Customer (String forename, String surname, String houseNo, String roadName, String cityName, String postCode){
        this.forename = forename;
        this.surname = surname;
        this.houseNo = houseNo;
        this.roadName = roadName;
        this.cityName = cityName;
        this.postCode = postCode;
    }

    //Getters and Setters
    public String getForename() {
        return forename;
    }
    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHouseNo() {
        return houseNo;
    }
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getRoadName() {
        return roadName;
    }
    public void setAddress(String roadName) {
        this.roadName = roadName;
    }

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

}
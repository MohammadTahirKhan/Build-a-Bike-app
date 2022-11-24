package Actors;

public class Address {
//    variables
    private int addressId;
    private int houseNo;
    private String roadName;
    private String cityName;
    private String postCode;

    /**
     * Constructor for an Address
     * @param houseNo House number
     * @param roadName Road name
     * @param cityName City name
     * @param postCode post code
     */
    public Address(int addressId, int houseNo, String roadName, String cityName, String postCode) {
        this.addressId = addressId;
        this.houseNo = houseNo;
        this.roadName = roadName;
        this.cityName = cityName;
        this.postCode = postCode;
    }
    public Address(int houseNo, String roadName, String cityName, String postCode) {
        this.addressId = -1;
        this.houseNo = houseNo;
        this.roadName = roadName;
        this.cityName = cityName;
        this.postCode = postCode;
    }

//    getters
    public int getAddressId() {
        return addressId;
    }
    public int getHouseNo() {
        return houseNo;
    }
    public String getRoadName() {
        return roadName;
    }
    public String getCityName() {
        return cityName;
    }
    public String getPostCode() {
        return postCode;
    }

//    setters
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }
    public void setAddress(String roadName) {
        this.roadName = roadName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
}

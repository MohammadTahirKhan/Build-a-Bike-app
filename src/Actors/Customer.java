package Actors;

public class Customer {
//    variables
    private int customerId;
    private String forename;
    private String surname;
    private Address address;

    /**
     * Constructor for a Customer
     * @param customerId Customer ID
     * @param forename First name
     * @param surname Last name
     * @param address Full address of the customer
     */
    public Customer (int customerId, String forename, String surname, Address address){
        this.customerId = customerId;
        this.forename = forename;
        this.surname = surname;
        this.address = address;
    }
    public Customer (String forename, String surname, Address address){
        this.customerId = -1;
        this.forename = forename;
        this.surname = surname;
        this.address = address;
    }

//    Getters
    public int getCustomerId() {
        return customerId;
    }
    public String getForename() {
        return forename;
    }
    public String getSurname() {
        return surname;
    }
    public Address getAddress() {
        return address;
    }

//    Setters
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public void setForename(String forename) {
        this.forename = forename;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

}

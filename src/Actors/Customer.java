package Actors;

public class Customer extends Shopper {
//    variables
    public int customerId;
    public String forename;
    public String surname;
    public Address address;

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

    //Getters and Setters

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

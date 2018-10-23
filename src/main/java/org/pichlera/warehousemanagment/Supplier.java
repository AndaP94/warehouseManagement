package org.pichlera.warehousemanagment;

/**
 * @author Andreas Pichler
 * @version 23.10.2018
 * This class represents the supplier for the article
 */
public class Supplier {

    private String firstname;
    private String lastname;
    private String company;

    /**
     * Create the Supplier
     * @param firstname firstname
     * @param lastname lastname
     * @param company company
     */
    public Supplier(String firstname, String lastname, String company) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.company = company;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String toString(){
        return "Company: " + getCompany() + "\nFirstname: " + getFirstname() + "\nLastname: " + getLastname();
    }

}

package org.pichlera.warehousemanagment;

public class Supplier {

    private String firstname;
    private String lastname;
    private String company;

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

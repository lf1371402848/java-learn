package oto.bean;

import java.util.Date;


public class Students {
    private int studId;
    private String name;
    private String email;
    private Date dob;
    private Addresses addresses;

    public Students() {
        // TODO Auto-generated constructor stub
    }

    public Students(String name, String email, Date dob) {
        super();
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public int getStudId() {
        return studId;
    }

    public void setStudId(int studId) {
        this.studId = studId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }
}

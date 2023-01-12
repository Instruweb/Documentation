package com.instruweb.domain;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.updateUser", query = "update User set address = :address, postalcode = :postalcode, phonenumber = :phonenumber where username = :username")
@NamedQuery(name = "User.getByUsername", query = "from User where username = :username")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String emailaddress;
    private String address;
    private String postalcode;
    private String phonenumber;

    public User() {
    }

    public User(Integer id, String username, String emailaddress, String address, String postalcode, String phonenumber) {
        this.id = id;
        this.username = username;
        this.emailaddress = emailaddress;
        this.address = address;
        this.postalcode = postalcode;
        this.phonenumber = phonenumber;
    }

    public Integer getId() {
        return id;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}

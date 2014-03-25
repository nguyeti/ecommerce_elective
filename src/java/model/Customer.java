/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Anthony, Etienne, Timothée
 */
public class Customer {
    private int id;
    private String firstname;
    private String lastname;
    private String phone;
    private String address;
    private String cc;
    private String email;
    private String pwd;
    
    public Customer(){
        this.id = 0;
        this.firstname = null;
        this.lastname = null;
        this.phone = null;
        this.address = null;
        this.cc = null;
        this.email = null;
        this.pwd = null;
    }
    
    public Customer(String email, String pwd){
        this.id = 0;
        this.firstname = null;
        this.lastname = null;
        this.phone = null;
        this.address = null;
        this.cc = null;
        this.email = email;
        this.pwd = pwd;    
    }
    
    public Customer(String firstname, String lastname, String phone, String address, String cc, String email, String pwd){
        this.id = 0;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.address = address;
        this.cc = cc;
        this.email = email;
        this.pwd = pwd;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the cc
     */
    public String getCc() {
        return cc;
    }

    /**
     * @param cc the cc to set
     */
    public void setCc(String cc) {
        this.cc = cc;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * @param pwd the pwd to set
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
}

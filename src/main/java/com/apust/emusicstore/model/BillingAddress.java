package com.apust.emusicstore.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

/**
 * Created by GUN
 * on 31.05.2016.
 */
public class BillingAddress implements Serializable {


    private static final long serialVersionUID = 7400475329596059994L;

    @Id
    @GeneratedValue
    private int billingAddressId;
    private String streetName;
    private String apartamentNumber;
    private String city;
    private String country;
    private String state;
    private String zipCode;

    @OneToOne
    private Customer customer;

    public String getApartamentNumber() {
        return apartamentNumber;
    }

    public void setApartamentNumber(String apartamentNumber) {
        this.apartamentNumber = apartamentNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(int billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    @Override
    public String toString() {
        return "BillingAddress{" +
                "apartamentNumber='" + apartamentNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}

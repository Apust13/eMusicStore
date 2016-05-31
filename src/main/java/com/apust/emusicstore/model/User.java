package com.apust.emusicstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by GUN
 * on 31.05.2016.
 */

@Entity
public class User {


    @Id
    @GeneratedValue
    private int id;
    private String usernamename;
    private String password;
    private boolean enabled;
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsernamename() {
        return usernamename;
    }

    public void setUsernamename(String usernamename) {
        this.usernamename = usernamename;
    }
}

package com.myself.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

    private Integer id;
    private String username;
    private Date brd;  //此行没有对应正确数据库的字段名,用的brd
    private String sex;
    private String address;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", brd=" + brd +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBrd() {
        return brd;
    }

    public void setBrd(Date brd) {
        this.brd = brd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User(Integer id, String username, Date brd, String sex, String address) {

        this.id = id;
        this.username = username;
        this.brd = brd;
        this.sex = sex;
        this.address = address;
    }
}

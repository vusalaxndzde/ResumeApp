package com.mycompany.entity;

import java.sql.Date;
import java.util.List;

public class User {
    
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private String profileDescription;
    private String address;
    private Date brithdate;
    private Country birthplace;
    private Country nationality;
    private List<UserSkill> userSkill;
    private String password;
    

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String name, String surname, String phone, String email, String profileDescription, String address, Date brithdate, Country birthplace, Country nationality) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.profileDescription = profileDescription;
        this.address = address;
        this.brithdate = brithdate;
        this.birthplace = birthplace;
        this.nationality = nationality;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBrithdate() {
        return brithdate;
    }

    public void setBrithdate(Date brithdate) {
        this.brithdate = brithdate;
    }

    public Country getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(Country birthplace) {
        this.birthplace = birthplace;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public List<UserSkill> getUserSkill() {
        return userSkill;
    }

    public void setUserSkill(List<UserSkill> userSkill) {
        this.userSkill = userSkill;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", email=" + email + ", profileDescription=" + profileDescription + ", address=" + address + ", brithdate=" + brithdate + ", birthplace=" + birthplace + ", nationality=" + nationality + ", userSkill=" + userSkill + '}';
    }
    
}

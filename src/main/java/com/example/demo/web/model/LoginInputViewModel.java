package com.example.demo.web.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginInputViewModel {
    @JsonProperty("CompanyDB")
    private String company_db;

    @JsonProperty("Password")
    private String passWord;

    @JsonProperty("UserName")
    private String userName;

    public LoginInputViewModel() {
    }

    public LoginInputViewModel(String company_db, String passWord, String userName) {
        this.company_db = company_db;
        this.passWord = passWord;
        this.userName = userName;
    }

    public String getCompany_db() {
        return company_db;
    }

    public void setCompany_db(String company_db) {
        this.company_db = company_db;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

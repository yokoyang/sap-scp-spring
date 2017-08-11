package com.example.demo.web.model;


public class LoginInput {
    private String CompanyDB;
    private String Password;
    private String UserName;

    public LoginInput(String companyDB, String password, String userName) {
        CompanyDB = companyDB;
        Password = password;
        UserName = userName;
    }

    public LoginInput() {
    }

    public String getCompanyDB() {
        return CompanyDB;
    }

    public void setCompanyDB(String companyDB) {
        CompanyDB = companyDB;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}

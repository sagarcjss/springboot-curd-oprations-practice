package com.cjss.model;


import com.cjss.annotations.CityCheck;
import com.cjss.annotations.EmailValidator;
import com.cjss.annotations.GenderCheck;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsersModel {
    @NotBlank(message = "Provide Valid Name")
    @Size(min = 2, max = 20 ,message = "Name length should be in 2 to 20 characters")
    private String userName;
    @NotBlank(message = "Please Enter Email")
    @EmailValidator
    //@Pattern(regexp = "[a-z0-9]+@a-z+.a-z", message = "Enter valid Email")
    private String email;
    @Size(max = 10, min = 10, message = "Enter Valid Mobile Number.")
    private String mobileNum;
    @GenderCheck
    private String gender;
    @CityCheck
    private String city;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNum=" + mobileNum +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

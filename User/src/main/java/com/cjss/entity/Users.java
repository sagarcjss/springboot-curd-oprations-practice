package com.cjss.entity;


import com.cjss.generator.UserIdSequenceGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "UserCjss")
public class Users {
    @Id
    @GenericGenerator(name = "userId",
            strategy = "org.thoughts.on.java.generators.UserIdSequenceGenerator",
            //strategy = "org.hibernate.generators.UserIdSequenceGenerator",
            //type = UserIdSequenceGenerator.class,
            parameters = {
                    @org.hibernate.annotations.Parameter(name = UserIdSequenceGenerator.INCREMENT_PARAM, value = "50"),
                    @org.hibernate.annotations.Parameter(name = UserIdSequenceGenerator.VALUE_PREFIX_PARAMETER, value = "CJSS_"),
                    @org.hibernate.annotations.Parameter(name = UserIdSequenceGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
   @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userID")
 //  @GeneratedValue(strategy = GenerationType.AUTO, generator = "userId")
//    @GenericGenerator(name = "userId", strategy = "org.hibernate.id.UUIDGenerator")
    private String userId;
    private String userName;
    private String email;
    private String mobileNum;
    private String gender;
    private String city; //hyd pune mumbai

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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
        return "Users{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", mobileNum=" + mobileNum +
                ", gender='" + gender + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}

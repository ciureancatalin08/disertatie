package msg.user.entity.dto;

import msg.role.entity.RoleEntity;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String userName;
    private ArrayList<RoleEntity> roles;


    public UserDTO(String firstName, String lastName, String email, String mobileNumber,String userName,ArrayList<RoleEntity> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.roles = roles;
    }

    public UserDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<RoleEntity> roles) {
        this.roles = roles;
    }
}

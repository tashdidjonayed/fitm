package com.framgia.fitm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private int user_type;
    private int status;
    private String bio;
    private String image_url;
    private String username;
    private String password;
    private String employee_code;
    
    public Integer getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    @Column(name = "first_name")
    @Size(max = 100, min = 3)
    @NotNull
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    
    @Column(name = "last_name")
    @Size(max = 100, min = 3)
    @NotNull
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    
    @Column(name = "email")
    @Size(max = 100, min = 3)
    @NotNull
    @Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getUser_type() {
        return user_type;
    }
    public void setUser_type(int user_type) {
        this.user_type = user_type;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    
    @Column(name = "username")
    @Size(max = 100, min = 3)
    @NotNull
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name = "password")
    @Size(max = 100, min = 3)
    @NotNull
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name = "employee_code")
    @Size(max = 8, min = 8)
    @NotNull
    public String getEmployee_code() {
        return employee_code;
    }
    public void setEmployee_code(String employee_code) {
        this.employee_code = employee_code;
    }

}

package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty; // Correct import for @NotEmpty

import java.util.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty
    @Column(nullable = false)
    private String firstName;
    private String lastName;
    @Column(nullable = false,unique = true)
    @NotEmpty
    @Email(message = "{errors.invalid_email}")
    private String email;
    @NotEmpty
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
        name="user role",
        joinColumns = {@JoinColumn(name="USER_ID",referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name="Role_ID",referencedColumnName = "ID")}

    )
    private List<Role> roles;
    public User(User user)
    {
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.roles=user.getRoles();
    }
    public User()
    {
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    
        public void setEmail(String email) {
            this.email = email;
        }
    
        public void setRoles(List<Role> roles) {
            this.roles = roles;
        }
    
    }
}

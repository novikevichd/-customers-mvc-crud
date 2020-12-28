package com.myproject.customercrud.entity;




import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="customers")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @NotNull(message = "is required!")
    @Size(min=1, max = 40, message= "is required! Maximum 40 chars!")
    private String firstName;

    @Column(name = "last_name")
    @NotNull(message = "is required!")
    @Size(min=1, max = 40, message= "is required! Maximum 40 chars!")
    private String lastName;

    @Column(name = "email")
    @NotNull(message = "is required!")
    @Size(min=1, max = 40, message= "is required! Maximum 20 chars!")
    @Email(message = "Enter a valid email!")
    private String email;


    public Customer() {

    }

    public Customer(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

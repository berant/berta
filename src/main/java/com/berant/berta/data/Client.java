package com.berant.berta.data;

import javax.persistence.*;


@Entity
@Table(name = "Client")
public class Client {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String toString() {
        return "Client {id=" + id
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", phone=8" + phone
                + "}";
    }
}

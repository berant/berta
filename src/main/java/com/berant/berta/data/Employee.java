package com.berant.berta.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "Employee")
public class Employee implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String position;
    private int rate;
    private Date startWork;
    private Date endWork;

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

    @Column(name = "lastName")
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

    @Column(name = "position")
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Column(name = "rate")
    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Column(name = "start_work")
    @Temporal(TemporalType.DATE)
    public Date getStartWork() {
        return startWork;
    }

    public void setStartWork(Date startWork) {
        this.startWork = startWork;
    }

    @Column(name = "end_work")
    @Temporal(TemporalType.DATE)
    public Date getEndWork() {
        return endWork;
    }

    public void setEndWork(Date endWork) {
        this.endWork = endWork;
    }

    public String toString() {
        return "Employee {id=" + id
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", phone=8" + phone
                + ", position=" + position
                + ", rate=" + rate
                + ", start_work=" + startWork
                + ", end_work=" + endWork
                + "}";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sulbasoft.business;

import com.sulbasoft.utility.GenderType;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author M. S. Ali (CCS)
 */
public class Student {
    private String id;
    private String fName;
    private String lName;
    private GenderType gender;
    private LocalDate birthDate;
    private double gpa;
    private String email;
    private String phone;
    private Address address;

    public Student() {
    }

    public Student(String id, String fName, String lName, GenderType gender, LocalDate birthDate, double gpa, String email, String phone) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.gpa = gpa;
        this.email = email;
        this.phone = phone;
        //this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", First Name=" + fName + ", Last Name=" + lName + ", Gender=" + gender + ", Date of birth=" + birthDate + ", GPA=" + gpa + ", Email=" + email + ", Phone=" + phone + ", address=" + address + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.fName);
        hash = 59 * hash + Objects.hashCode(this.lName);
        hash = 59 * hash + Objects.hashCode(this.gender);
        hash = 59 * hash + Objects.hashCode(this.birthDate);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.gpa) ^ (Double.doubleToLongBits(this.gpa) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.phone);
        hash = 59 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (Double.doubleToLongBits(this.gpa) != Double.doubleToLongBits(other.gpa)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fName, other.fName)) {
            return false;
        }
        if (!Objects.equals(this.lName, other.lName)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (!Objects.equals(this.birthDate, other.birthDate)) {
            return false;
        }
        return Objects.equals(this.address, other.address);
    }
}

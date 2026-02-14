package com.pioneers.universitysystem.models.entities;

import java.util.Objects;

public class Student {
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String password;
    private boolean isLogin;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return isLogin == student.isLogin
                && Objects.equals(id, student.id)
                && Objects.equals(fullName, student.fullName)
                && Objects.equals(email, student.email)
                && Objects.equals(phone, student.phone)
                && Objects.equals(password, student.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email, phone, password, isLogin);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='********" + '\'' +
                ", isLogin=" + isLogin +
                '}';
    }
}

package ru.gb.spring.LessonSeminar4.Model;

import java.util.HashMap;

public class ModelUser {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int age;
    private int semester;
    private HashMap<String,String> courseRegistered;


    public ModelUser(){

    }

    public ModelUser(int id, String name, String email, String phone, int age, int semester, HashMap<String,String> courseRegistered) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.semester = semester;
        this.courseRegistered = courseRegistered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public HashMap<String, String> getCourseRegistered() {
        return courseRegistered;
    }

    public void setCourseRegistered(HashMap<String,String> courseRegistered) {
        this.courseRegistered = courseRegistered;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

}

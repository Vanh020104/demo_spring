package com.example.demospring.dto;

public class StudentDTO {
    private String name;
    private Integer age;
    private String email;
    private String class_name;

    public StudentDTO(String name, Integer age, String email, String class_name) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.class_name = class_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}

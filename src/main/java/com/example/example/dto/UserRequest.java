package com.example.example.dto;

public class UserRequest {
    private String name;
    private String email;
    private int age;

    // 코드 - 생성(Alt + insert) 으로 getter/setter 생성
    // 또는 lombok 사용


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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // Alt + tab (마법사로 생성)
    @Override
    public String toString() {
        return "UserRequest{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}

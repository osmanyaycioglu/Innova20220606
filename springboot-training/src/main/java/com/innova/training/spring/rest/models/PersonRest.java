package com.innova.training.spring.rest.models;

import com.innova.training.spring.validation.StartWith;

import javax.validation.constraints.*;

public class PersonRest {
    @NotEmpty(message = "name null olamaz")
    @Size(min = 2,max = 20)
    @StartWith("n:")
    private String name;
    @NotEmpty(message = "surname null olamaz")
    @Size(min = 3,max = 25)
    @StartWith("s:")
    private String surname;
    @NotEmpty(message = "username boş olamaz")
    @Size(min = 8,max = 15)
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;
    @Max(300)
    @Min(50)
    private Integer height;
    @Positive
    @Max(300)
    @Min(10)
    private Integer weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

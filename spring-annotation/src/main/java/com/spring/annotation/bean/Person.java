package com.spring.annotation.bean;

import org.springframework.beans.factory.annotation.Value;

public class Person {
    @Value("${person.name}")
    private String name;

    @Value("男")
    private String sex;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

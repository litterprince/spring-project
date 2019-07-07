package com.spring.annotation.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Data
@ToString
public class Dog {
    @Value("${dog.name}")
    private String name;
}

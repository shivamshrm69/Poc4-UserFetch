package com.poc4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document(collection = "user")
@Data
public class User {
@Id
@Field(name = "user_id")
private int userId;
private String first_name;
private String last_name;
private String mobile;
private String gender;
private String dob;
Address address;
}

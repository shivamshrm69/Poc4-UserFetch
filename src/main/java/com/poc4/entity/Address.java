package com.poc4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Document
@Data
public class Address {
@Id
private int address_id;
@Field(name = "user_id")
private int userId;
private String address;
private String pincode;
private String landmark;
private String city;
private String state;
private String country;

}

package com.project.storageforsocks.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Socks {
    @Id
    int id;

    String color;
    int amount;
    int cottonPart;

}

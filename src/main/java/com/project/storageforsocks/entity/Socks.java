package com.project.storageforsocks.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "socks")
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socks_id")
    private Integer id;


    @Column(name = "color")
   // @NotEmpty(message="")
    private String color;


    @Column(name = "cotton_part")
    private int cottonPart;


    @Column(name = "amount")
    private int amount;

}

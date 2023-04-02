package com.project.storageforsocks.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "socks")
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socks_id")
    private Integer id;

    @Column(name = "color")
    private String color;


    @Column(name = "cotton_part")
    private Integer cottonPart;


    @Column(name = "amount")
    private int quantity;


}

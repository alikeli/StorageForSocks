package com.project.storageforsocks.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "socks")
@RequiredArgsConstructor
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socks_id")
    private int id;
    @Column(name = "color")
    private String color;
    @Column(name = "cotton_part")
    private int cottonPart;
    @Column(name = "amount")
    private int amount;

}

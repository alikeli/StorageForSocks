package com.project.storageforsocks.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
   // @NotEmpty(message="")
    private String color;


    @Column(name = "cotton_part")
    private int cottonPart;


    @Column(name = "amount")
    private int amount;

}

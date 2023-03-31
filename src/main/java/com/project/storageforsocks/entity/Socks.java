package com.project.storageforsocks.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table(name = "socks")
public class Socks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "socks_id")
    private Integer id;


    @Column(name = "color")
    private String color;


    @Column(name = "cotton_part")
    private int cottonPart;


    @Column(name = "amount")
    private int amount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(int cottonPart) {
        this.cottonPart = cottonPart;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Socks{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", cottonPart=" + cottonPart +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Socks socks = (Socks) o;
        return cottonPart == socks.cottonPart && amount == socks.amount && Objects.equals(id, socks.id) && Objects.equals(color, socks.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, cottonPart, amount);
    }
}

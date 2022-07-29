package com.revature.SpringBootDemo.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shops")
@Data
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id")
    private int id;

    @Column(name = "s_name", unique = true, nullable = false)
    private String shopName;

    @Column(name = "s_inven_count", nullable = false)
    private int inventoryCount;


    public Shop() {
    }

    public Shop(int id, String shopName, int invertoryCount) {
        this.id = id;
        this.shopName = shopName;
        this.inventoryCount = invertoryCount;
    }

    public Shop(String shopName, int invertoryCount) {
        this.shopName = shopName;
        this.inventoryCount = invertoryCount;
    }
}

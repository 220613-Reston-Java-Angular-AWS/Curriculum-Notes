package com.revature.SpringBootDemo.services;


import com.revature.SpringBootDemo.models.Shop;

import java.util.List;
import java.util.Optional;

public interface ShopService {
    //creates a new candy
    boolean createShop(Shop shop);

    //get candy by id
    Shop getShopById(int id);

    //get all candies
    List<Shop> getAllShops();

    //update a candy
    boolean updateShop(Shop shop);

    //delete a candy
    boolean deleteShop(Shop shop);
}

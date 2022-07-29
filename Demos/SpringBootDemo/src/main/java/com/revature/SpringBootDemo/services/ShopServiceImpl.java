package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Shop;
import com.revature.SpringBootDemo.repos.ShopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class ShopServiceImpl implements ShopService{

    @Autowired
    private ShopRepo shrepo;

    @Autowired
    public ShopServiceImpl(ShopRepo shrepo) {
        this.shrepo = shrepo;
    }

    @Override
    public boolean createShop(Shop shop) {
        int pk = shrepo.save(shop).getId();
        return (pk > 0) ? true: false;
    }

    @Override
    public Shop getShopById(int id) {

        try{
            Optional<Shop> target = shrepo.findById(id);
            Shop shop = target.get();
            return shop;
        } catch (NoSuchElementException e){
            // log the error
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }

    @Override
    public List<Shop> getAllShops() {
        return shrepo.findAll();
    }

    @Override
    public boolean updateShop(Shop shop) {
        return shrepo.update(shop.getShopName(),shop.getInventoryCount(),shop.getId());
    }

    @Override
    public boolean deleteShop(Shop shop) {
        shrepo.delete(shop);
        return true;
    }
}

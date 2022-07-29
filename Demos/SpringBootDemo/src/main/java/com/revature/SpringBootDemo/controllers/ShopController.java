package com.revature.SpringBootDemo.controllers;

import static com.revature.SpringBootDemo.utils.ClientMessageUtils.*;
import com.revature.SpringBootDemo.models.ClientMessage;
import com.revature.SpringBootDemo.models.Shop;
import com.revature.SpringBootDemo.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Good practice for creating a RESTful app is using @RestController
//as well as maintaining the same 'base' url
@RestController
@RequestMapping("/app")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @GetMapping(value = "/shop", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody Shop getById(@RequestParam int id) {
        return shopService.getShopById(id);
    }

    @GetMapping("/shops")
    public @ResponseBody List<Shop> getAll(){
        return shopService.getAllShops();
    }

    @PostMapping("/shop")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public @ResponseBody ClientMessage createShop(@RequestBody Shop shop){
        return shopService.createShop(shop) ? CREATION_SUCCESSFUL : CREATION_FAILED;
    }

    @PutMapping("/shop")
    public @ResponseBody ClientMessage updateShop(@RequestBody Shop shop){
        return shopService.updateShop(shop) ? UPDATE_SUCCESSFUL : UPDATE_FAILED;
    }

    @DeleteMapping("/shop")
    public @ResponseBody ClientMessage deleteShop(@RequestBody Shop shop){
        return shopService.deleteShop(shop) ? DELETION_SUCCESSFUL : DELETION_FAILED;
    }

}

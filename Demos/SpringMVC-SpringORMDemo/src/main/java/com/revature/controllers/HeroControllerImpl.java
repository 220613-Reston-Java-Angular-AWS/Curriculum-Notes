package com.revature.controllers;

import static com.revature.utils.ClientMessageUtil.REGISTRATION_SUCCESSFUL;
import static  com.revature.utils.ClientMessageUtil.SOMETHING_IS_WRONG;

import com.revature.models.ClientMessage;
import com.revature.models.Hero;
import com.revature.services.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This will tell Spring MVC that this class can/will handle requests
@Controller
@RequestMapping("/app") //specifies a URL at which a method is available
public class HeroControllerImpl implements HeroController {

    @Autowired
    HeroService heroService;

    /**
     *GET mapping specifies that if the client sends a GET request to this url,
     * this method will trigger the response
     *
     * URL: http://localhost:8080/SpringMVC/app/findAllHeroes
     *
     * @ResponseBody specifies what we return to the client (typically in JSON format)
     * Java (JSON marshalling objects)
     */

    @Override
    @GetMapping("/findAllHeroes")
    public @ResponseBody List<Hero> findAllHeroes() {

        return heroService.getAllHeroes();//thanks to Jackson Databind, this will return a array of JSON objects
    }


    /**
     * @PostMapping automatically allows us to create new resources through
     * our controller
     * @RequestBody specifies the type of information this method is taking in
     *
     * Unmarshalling (taking in JSON and turning it into Java Objects)
     */

    @Override
    @PostMapping(path="/register", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ClientMessage registerHero(@RequestBody Hero hero) {

        //if this user is successfully registered it will return a successful client message
        //if not it will return that something went wrong

        return heroService.registerHero(hero) ? REGISTRATION_SUCCESSFUL : SOMETHING_IS_WRONG;
    }

    @Override
    @GetMapping("/findHero")
    public @ResponseBody Hero findHero(@RequestParam String name) {
        //ex: http://localhost:8080/SpringMVC/app/findHero?name=bob
        return heroService.getHero(name); //thanks to Jackson Databind, this will return a JSON object
    }
}

package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Candy;

import java.util.List;

public interface CandyService {

    //creates a new candy
    boolean createCandy(Candy candy);

    //get candy by id
    Candy getCandyById(int id);

    //get all candies
    List<Candy> getAllCandies();

    //update a candy
    boolean updateCandy(Candy candy);

    //delete a candy
    boolean deleteCandy(Candy candy);

}

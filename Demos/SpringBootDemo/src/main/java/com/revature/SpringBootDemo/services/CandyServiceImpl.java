package com.revature.SpringBootDemo.services;

import com.revature.SpringBootDemo.models.Candy;
import com.revature.SpringBootDemo.repos.CandyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CandyServiceImpl implements CandyService{

    @Autowired
    private CandyRepo cRepo;

    @Autowired
    public CandyServiceImpl(CandyRepo cRepo) {
        this.cRepo = cRepo;
    }

    @Override
    public boolean createCandy(Candy candy) {
        int pk = cRepo.save(candy).getId();
        return (pk > 0) ? true : false ;
    }

    @Override
    public Candy getCandyById(int id) {
        return cRepo.findById(id);
    }

    @Override
    public List<Candy> getAllCandies() {
        return cRepo.findAll();
    }

    @Override
    public boolean updateCandy(Candy candy) {

        return cRepo.update(candy.getName(),candy.getPrice(), candy.getId());
    }

    @Override
    public boolean deleteCandy(Candy candy) {
        cRepo.delete(candy);
        return true;
    }
}

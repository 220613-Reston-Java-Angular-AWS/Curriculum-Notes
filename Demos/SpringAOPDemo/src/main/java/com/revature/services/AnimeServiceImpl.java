package com.revature.services;


import com.revature.models.Anime;
import com.revature.repos.AnimeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimeServiceImpl implements AnimeService{


    private AnimeDAO animeDAO;

    @Autowired
    public AnimeServiceImpl(AnimeDAO animeDAO){
        this.animeDAO = animeDAO;
    }


    @Override
    public List<Anime> getAllAnimeShows() {
        return animeDAO.selectAll();
    }
}

package com.revature.repos;

import com.revature.models.Anime;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AnimeDAOImpl implements AnimeDAO{



    @Override
    public List<Anime> selectAll() {

        List<Anime> anime = new ArrayList<>();

        anime.add(new Anime(1,"Dragon Ball Z","Goku"));
        anime.add(new Anime(2,"One Piece","Luffy"));
        anime.add(new Anime(3,"Hunter X Hunter","Gon"));


        return anime;
    }
}

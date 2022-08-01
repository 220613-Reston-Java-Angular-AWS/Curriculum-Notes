package com.revature.repos;

import com.revature.models.Anime;

import java.util.List;

public interface AnimeDAO {

    List<Anime> selectAll();

}

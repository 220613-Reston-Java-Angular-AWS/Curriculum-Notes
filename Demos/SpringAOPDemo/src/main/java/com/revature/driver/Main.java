package com.revature.driver;

import com.revature.config.AppConfig;
import com.revature.models.Anime;
import com.revature.services.AnimeService;
import com.revature.services.AnimeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    static ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

    public static void main(String[] args) {
        AnimeService animeService = appContext.getBean(AnimeServiceImpl.class);
        List<Anime> animeList = animeService.getAllAnimeShows();
        System.out.println();
        System.out.println();
        for (Anime anime: animeList){
            System.out.println(anime);
        }
    }

}

package com.revature.driver;

import com.revature.model.Pokemon;
import com.revature.service.PokemonService;
import com.revature.service.PokemonServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    /**What is Spring?
     *  Spring is an ecosystem of various open-source projects and modules that help ease the process of building Java apps
     *
     *  What is a Spring module?
     *   - is a grouping of libraries put together to achieve some goal
     *   - each of these modules can be interchanged to fit the developer's needs of infrastructure in any project
     *
     *  What is a Spring Bean?
     *  - a class that its dependencies will be managed by Spring's IOC container
     *
     *  What is IOC?
     *  - inversion of control
     *  - when you give up control or functionality and give that responsibility to another framework or entity
     *
     *  What is Dependency Injection?
     *  - when you give up the instantiation of your dependencies to the framework or entity
     *
     * How do we define our IOC container in Spring?
     * - 2 ways:
     *  1) BeanFactory (the old way <- it doesn't allow annotation configuration of spring beans)
     *  2) ApplicationContext (newer way <- more framework-oriented way to configure beans through annotations)
     *
     *
     */

    //Step 1 - Set up the ApplicationContext so that we can define the IoC container
    //This way it will run while the app is running
    //In this example we configured our beans in the 'beans.xml' file

    static ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");


    public static void main(String[] args) {
        // Step 2 - Make an instance of the Service bean

        // here let us remember that when a class implements an interface
        //it can we 'stored' in the interfaces reference type
        PokemonService pokeService = appContext.getBean(PokemonServiceImpl.class);



        //Step 3 - We will need to retrieve our info
        //In this example it is our pokemon list
        List<Pokemon> pokemonList = pokeService.catchEmAll();


       // Print out the contents of our list
        for(Pokemon pokemon: pokemonList){
            System.out.println(pokemon);

            //just to show that Lombok works
            System.out.println(pokemon.getPokeType());
        }
    }

}

import com.animal.Animal;

public class Dog extends Animal {


    public Dog(){

    }

    //we are able to see protected and public variable / methods because
    //Dog extends Animal evern though its not in the package
    public Dog(String name, int age){
        super.name = name;
        super.age = age;
    }


}

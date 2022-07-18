# Rest with JSON

One of the more popular ways to represent the state of an object for external use by another application in Rest is JSON. There are multiple ways to create a JSON representation of a Java Object. For example, you might write your own library to do this. While this is a great exercise and a great way to practice your skills with Java Strings and the Reflection API, it is not recommended that you do this in any kind of production environment. This is because there are multiple libraries we can take advantage of that can perform this task for us. We will focus on Jackson in this guide. You may see other people utilize GSON, the concepts are similar.

## Jackson
To utilize the Jackson library, we first need to import it. Add these dependencies to your `pom.xml`.
```xml
    <dependency>
	    <groupId>com.fasterxml.jackson.core</groupId>
	    <artifactId>jackson-databind</artifactId>
	    <version>2.11.3</version>
	</dependency>
```

Next we'll create a data class to act as our resource:

```Java
public class Cat {
    private String name;
    private String color;
    private int lives;

    // No Arguments constructor will create a grey Tom cat with 9 lives.
    public Cat() {
        this("Tom", "Grey");
    }

    // All cats start with 9 lives.
    public Cat(String name, String color) {
        this.name = name;
        this.color = color;
        this.lives = 9;
    }

    // getters and setters, toString, and equals methods ommitted
}
```

With this done, we're going to utilize the Jackson `Object Mapper` to create a JSON representation of a cat.

```Java
public static void main(String... args) {
    Cat tom = new Cat();
    ObjectMapper om = new ObjectMapper();
    try {
        System.out.println(om.writeValueAsString(tom));
    } catch(Exception e) {
        e.printStackTrace();
    }
}
```

The output is as follows: `{"name":"Tom","color":"Grey","lives":9}`

Here, we have created a JSON representation of the object, but can we create an object representation of a JSON?


```Java
	public static void main(String[] args) {
		String cat = "{\"name\":\"Susan\",\"color\":\"White\",\"lives\":8}";
		ObjectMapper om = new ObjectMapper();
		Cat c = null;
		try {
			c = om.readValue(cat, Cat.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(c);
	}
```

The output is: `Cat [name=Susan, color=White, lives=8]`
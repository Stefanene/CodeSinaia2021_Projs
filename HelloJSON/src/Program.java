import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import com.google.gson.Gson;

public class Program {
    
    public static Star[] stars;
    public static Galaxy galaxy;
    
    public static void buildSkyMap() {
        Planet [] planets = {
                new Planet("Mercury"),
                new Planet("Venus"),
                new Planet("Earth"),
                new Planet("Mars"),
                new Planet("Jupiter"),
                new Planet("Saturn"),
                new Planet("Uranus"),
                new Planet("Neptune")
        };
        
        Sun sun = new Sun();
        sun.age = 4.603E9;
        sun.distanceToEarth = 8765432112L;
        sun.planets = planets;
        sun.hasLife = true;
        
        Planet[] otherPlanets = {
                new Planet("Pluto")
        };
        
        Star other = new Star();
        other.age = 98.76E10;
        other.distanceToEarth = 9876543456787567L;
        other.planets = otherPlanets;
        
        stars = new Star[] {sun, other};
        
        galaxy = new Galaxy();
        galaxy.stars = stars;
    }
    
    public static void saveStars() throws FileNotFoundException {
        // 2-lines serialization of an array of complex objects into string
        Gson serializer = new Gson();
        String starsText = serializer.toJson(stars);
        
        PrintStream file = new PrintStream(new File("Stars.json"));
        file.println(starsText);
        file.close();
    }
    
    public static void saveGalaxy() throws FileNotFoundException {
        // 2-lines serialization of a complex object into string
        Gson serializer = new Gson();
        String starsText = serializer.toJson(galaxy);
        
        PrintStream file = new PrintStream(new File("Galaxy.json"));
        file.println(starsText);
        file.close();
    }

    public static void loadStars() throws FileNotFoundException {
        Scanner reader = new Scanner(new File("Stars.json"));
        String text = "";
        while(reader.hasNextLine()) {
            text += reader.nextLine();
        }
        reader.close();
        
        // 2-lines deserialization of an array of complex objects
        Gson deserializer = new Gson();
        Star[] stars = deserializer.fromJson(text, Star[].class);

        System.out.println(stars);
    }
    
    public static void loadGalaxy() throws FileNotFoundException {
        Scanner reader = new Scanner(new File("Galaxy.json"));
        String text = "";
        while(reader.hasNextLine()) {
            text += reader.nextLine();
        }
        reader.close();
        
        // 2-lines deserialization of a complex object
        Gson deserializer = new Gson();
        Galaxy galaxy = deserializer.fromJson(text, Galaxy.class);

        System.out.println(galaxy);
    }

    public static void main(String[] args) throws FileNotFoundException {
        buildSkyMap();
        
        saveStars();
        saveGalaxy();
        
        loadStars();
        loadGalaxy();
    }

}

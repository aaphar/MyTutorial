package collections.theater.seats;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "This course is about Java");
            System.out.println("Java added successfully");
        }

        languages.put("Python", "An interpreted, object-oriented, hig-level programming language with dynamic semantics");
        languages.put("Algol", "An algorithmic language");

        System.out.println("This is brand new reference is " + languages.put("BASIC", "Beginners All Purposes Symbolic Instructor Code"));
        System.out.println(languages.put("Lisp", "Therein lies madness"));
        System.out.println("old reference is " + languages.put("Java", "An compiled high level object-oriented, platform independent language."));

        System.out.println("==============================================");

        System.out.println(languages.get("Java"));

        if (languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
        }

        System.out.println("==============================================");

//        languages.remove("Lisp");
        if (languages.remove("Algol", "An algorithmic language")) {
            System.out.println("Algol removed.");
        } else {
            System.out.println("Algol not removed, key/value pair not found");
        }

        System.out.println("_______________________________________________");

        if (languages.replace("Lisp", "Therein lies madness", "A functional programming language with imperative features.")) {
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }

//        System.out.println("return previous entry after replace: " + languages.replace("Lisp", "A functional programming language with imperative features."));
//        System.out.println("return null, and not added, cus not existing in map: " + languages.replace("Scale", "this will not be added"));

        System.out.println("==============================================");

        for (String key : languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}


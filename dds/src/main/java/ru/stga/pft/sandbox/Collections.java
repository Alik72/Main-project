package ru.stga.pft.sandbox;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by Homosapiens on 15.03.2016.
 */
public class Collections {
  public static void main(String[] args) {
    String[] langs = {"JAVA", "C#", "Python", "PHP"};
    List<String> languages = new ArrayList<String>();
    languages.add("JAVA");
    languages.add("C#");
    languages.add("Python");

    for (String  l : languages) {
      System.out.println("Я хочу выучить язык программирования " + l);
    }
  }
}
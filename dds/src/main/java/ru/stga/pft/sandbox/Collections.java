package ru.stga.pft.sandbox;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Homosapiens on 15.03.2016.
 */
public class Collections {
  public static void main(String[] args) {
    String[] langs = {"JAVA", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("JAVA", "C#", "Python");

    for (int i = 0; i<languages.size(); i++) {
      System.out.println("Я хочу выучить язык программирования " + languages.get(i));
    }
  }
}
package ru.stga.pft.sandbox;

/**
 * Created by Homosapiens on 15.03.2016.
 */
public class Collections {
  public static void main(String[] args) {
    String[] langs = {"JAVA", "C#", "Python", "PHP"};

    for (String  l : langs) {
      System.out.println("Я хочу выучить язык программирования " + l);
    }
  }
}
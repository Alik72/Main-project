package ru.stga.pft.sandbox;

/**
 * Created by Homosapiens on 15.03.2016.
 */
public class Collections {
  public static void main(String[] args) {
    String[] langs = new String[4];
    langs[0] = "JAVA";
    langs[1] = "C#";
    langs[2] = "Python";
    langs[3] = "PHP";
    for (int i = 0; i < langs.length; i++) {
      System.out.println("Я хочу знать язык " + langs[i]);
    }
  }
}
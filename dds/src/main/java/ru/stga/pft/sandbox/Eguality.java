package ru.stga.pft.sandbox;

import java.net.SocketTimeoutException;

/**
 * Created by Homosapiens on 09.03.2016.
 */
public class Eguality {


  public static void main(String[] args) {
    String s1 = "firefox";
    String s2 = new String(s1);

    System.out.println(s1==s2);
    System.out.println(s1.equals(s2));
}}

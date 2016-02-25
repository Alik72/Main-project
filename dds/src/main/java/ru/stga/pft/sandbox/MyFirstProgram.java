package ru.stga.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        Points p1 = new Points(6,2);
        Points p2 = new Points(10,2);

        System.out.println("Расстояние между двумя точками р1 и р2 =" + distance(p1,p2));
    }
    public static double distance(Points p1, Points p2){
        return Math.sqrt ((Math.pow((p2.x-p1.x), 2)) + (Math.pow((p2.y-p1.y), 2)) );
    }
}
package ru.stga.pft.sandbox;

/**
 * Created by Homosapiens on 25.02.2016.
 */
public class Point {
  public double x1;
  public double y1;
  public double x2;
  public double y2;

  public static void main(String[] args) {
    Point p = new Point(1, 2, 4, 6);
    System.out.println("Расстояние между двумя точками р1 и р2 =" + p.distance());
  }
  public double distance(){
    return Math.sqrt ((Math.pow((this.x2-this.x1), 2)) + (Math.pow((this.y2-this.y1), 2)) );
  }
  public Point(double x1, double y1, double x2, double y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }
}



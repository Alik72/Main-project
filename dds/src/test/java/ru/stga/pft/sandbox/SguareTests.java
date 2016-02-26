package ru.stga.pft.sandbox;

/**
 * Created by Homosapiens on 26.02.2016.
 */
@Test


public class SguareTests {
  public void testArea (){
    Sguare s = new Sguare(5);
    assert s.area()==25;
  }
}

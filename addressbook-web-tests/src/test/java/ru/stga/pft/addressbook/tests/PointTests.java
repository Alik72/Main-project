package ru.stga.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.Point;

/**
 * Created by Homosapiens on 29.02.2016.
 */
@Test
public class PointTests {
  public void testDistance()
  {
    Point p = new Point(1,2,4,6);
    Assert.assertEquals(p.distance(),5.0);
  }
}
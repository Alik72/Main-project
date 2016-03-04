package ru.stga.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.Sguare;

/**
 * Created by Homosapiens on 26.02.2016.
 */
@Test

public class SguareTests {
  public void testArea (){
    Sguare s = new Sguare(5);
    Assert.assertEquals(s.area(),25.0);
  }
}

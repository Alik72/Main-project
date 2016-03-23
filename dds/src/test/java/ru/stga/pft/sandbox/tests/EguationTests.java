package ru.stga.pft.sandbox.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.Eguation;



public class EguationTests {
  @Test(enabled = false)
  public void test0() {
    Eguation e = new Eguation(1, 1, 1);
    Assert.assertEquals(e.rootNumber(), 0);
  }
  @Test(enabled = false)
  public void test1() {
    Eguation e = new Eguation(1, 2, 1);
    Assert.assertEquals(e.rootNumber(), 1);
  }
  @Test(enabled = false)
  public void test2() {
    Eguation e = new Eguation(1, 5, 6);
    Assert.assertEquals(e.rootNumber(), 2);
  }
  @Test(enabled = false)
  public void testLinear() {
    Eguation e = new Eguation(0, 1, 1);
    Assert.assertEquals(e.rootNumber(), 1);
  }
  @Test(enabled = false)
  public void testConstant() {
    Eguation e = new Eguation(0, 0, 1);
    Assert.assertEquals(e.rootNumber(), 0);
  }
  @Test(enabled = false)
  public void testZero() {
    Eguation e = new Eguation(0, 0, 0);
    Assert.assertEquals(e.rootNumber(), -1);
  }
}



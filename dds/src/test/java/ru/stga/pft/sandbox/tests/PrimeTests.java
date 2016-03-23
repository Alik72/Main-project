package ru.stga.pft.sandbox.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.Primes;

/**
 * Created by Homosapiens on 14.03.2016.
 */
public class PrimeTests {
  @Test(enabled = false)
  public void testPrime()  {
    Assert.assertTrue(Primes.isPrimesFast(Integer.MAX_VALUE));
  }
  @Test (enabled = false)
  public void testPrimeLong()  {
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimes(n));
  }

  @Test(enabled = false)
  public void testNonPrime()  {
    Assert.assertFalse(Primes.isPrimes(Integer.MAX_VALUE - 2));
  }
}

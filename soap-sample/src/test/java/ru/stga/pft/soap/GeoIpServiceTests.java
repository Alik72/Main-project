package ru.stga.pft.soap;

import net.webservicex.GeoIP;
import net.webservicex.GeoIPService;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Homosapiens on 23.04.2016.
 */
public class GeoIpServiceTests {

  @Test
  public void testMyIp(){

    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("194.28.29.152");
    assertEquals(geoIP.getCountryCode(), "RUS");
  }
  @Test
  public void testInvalidIp(){

    GeoIP geoIP = new GeoIPService().getGeoIPServiceSoap12().getGeoIP("194.28.29.xxx");
    assertEquals(geoIP.getCountryCode(), "RUS");
  }
}

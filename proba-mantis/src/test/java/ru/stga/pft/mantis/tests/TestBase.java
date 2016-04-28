package ru.stga.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stga.pft.mantis.appmanager.ApplicationManager;

import java.io.IOException;

/**
 * Created by Homosapiens on 29.02.2016.
 */
public class TestBase {


  protected static final ApplicationManager app
          = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();

  }

  @AfterSuite (alwaysRun = true)
  public void tearDown() throws IOException {
    app.stop();
  }

}

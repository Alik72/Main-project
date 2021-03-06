package ru.stga.pft.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.testng.Assert.assertTrue;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class NavigationHelper extends HelperBase {


  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
            return;}
      click(By.linkText("groups"));
    }

  public void HomePage() {

   if (isElementPresent(By.id ("maintable"))){
    return;
  }
    click(By.linkText("home"));
}
}
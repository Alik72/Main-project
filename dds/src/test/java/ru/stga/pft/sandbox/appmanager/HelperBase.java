package ru.stga.pft.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.firefox.FirefoxDriver;
/**
 * Created by Homosapiens on 01.03.2016.
 */
public class HelperBase {
  protected FirefoxDriver wd;

  private boolean acceptNextAlert = true;

  public HelperBase(FirefoxDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {

    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
  }
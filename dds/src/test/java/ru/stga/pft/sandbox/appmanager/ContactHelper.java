package ru.stga.pft.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stga.pft.sandbox.model.ContactData;
import ru.stga.pft.sandbox.model.GroupData;

import static org.testng.Assert.assertTrue;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(FirefoxDriver wd) {

    super(wd);
  }


  public void initContactCreation() {

    click(By.linkText("add new"));
  }


  public void submitContactCreation() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("address2"), contactData.getAddress());


  }


  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));

  }
  public void closeWindowContact() {
    closedWindows("^Delete 1 addresses[\\s\\S]$");
  }
}





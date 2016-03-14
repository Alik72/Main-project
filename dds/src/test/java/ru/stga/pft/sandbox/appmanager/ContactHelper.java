package ru.stga.pft.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stga.pft.sandbox.model.ContactData;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {

    super(wd);
  }


  public void initContactCreation() {

    click(By.linkText("add new"));
  }


  public void submitContactCreation() {

    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("home"), contactData.getHomePhone());
    type(By.name("email"), contactData.getEmail());
    type(By.name("address2"), contactData.getAddress());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));

    }
  }

  public void selectContact() {
    click(By.name("selected[]"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));

  }

  public void initContactModification() {
    click(By.xpath("//img[@alt='Edit']"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void allertDeletionContact() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact,b);
    submitContactCreation();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }
}





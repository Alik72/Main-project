package ru.stga.pft.sandbox.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stga.pft.sandbox.model.ContactData;
import ru.stga.pft.sandbox.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

  public void selectContactById(int id) {

    wd.findElement((By.cssSelector("input[value ='" + id +"']"))).click();
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

  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact,b);
    submitContactCreation();
    contactCache = null;
  }
  public void modify ( ContactData contact) {
    selectContactById(contact.getId());
    initContactModification();
    fillContactForm(contact,false);
    submitContactModification();
    contactCache = null;
  }

  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteSelectedContact();
    allertDeletionContact();
    contactCache = null;
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

    public Contacts all() {
if (contactCache != null){
  return new Contacts (contactCache);
}
      contactCache = new Contacts();
    List<WebElement>elements = wd.findElements(By.xpath("//tr[@name='entry']"));
    for (WebElement element : elements){
      String lastname = element.getText();
      String firstname = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")) ;
      contactCache.add(new ContactData ().withId(id).withLastname(lastname).withFirstname(firstname));
    }
    return new Contacts(contactCache);
  }


}





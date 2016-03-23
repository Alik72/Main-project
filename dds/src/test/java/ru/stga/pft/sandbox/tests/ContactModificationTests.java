package ru.stga.pft.sandbox.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

import java.util.List;

/**
 * Created by Homosapiens on 02.03.2016.
 */
public class ContactModificationTests extends TestBase{

@Test(enabled = false)
  public void testContactModification () {
  app.goTo().gotoHomePage();
  if (! app.getContactHelper().isThereAContact()){
    app.getContactHelper().createContact (new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва","test1"),true);
  }
  List<ContactData> before = app.getContactHelper().getContactList();
  app.getContactHelper().selectContact(before.size() - 1);
  app.getContactHelper().initContactModification();
  app.getContactHelper().fillContactForm(new ContactData("33", "33", "123456789", "user1.user2@mail.ru", "Новосибирск", null),false);
  app.getContactHelper().submitContactModification();
  List<ContactData> after = app.getContactHelper().getContactList();
  Assert.assertEquals(after.size(), before.size());
  }
}

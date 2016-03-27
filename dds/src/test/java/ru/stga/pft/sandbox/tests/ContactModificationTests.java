package ru.stga.pft.sandbox.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Homosapiens on 02.03.2016.
 */
public class ContactModificationTests extends TestBase{

@Test
  public void testContactModification () {
  app.goTo().gotoHomePage();
  if (! app.getContactHelper().isThereAContact()){
    app.getContactHelper().createContact (new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва","test1"),true);
  }
  List<ContactData> before = app.getContactHelper().getContactList();
  app.getContactHelper().selectContact(before.size() - 1);
  app.getContactHelper().initContactModification();
  ContactData contact  = new ContactData(before.get(before.size() - 1).getId(),"user1", "user2", "123456789", "user1.user2@mail.ru", "Москва","test1");
  app.getContactHelper().fillContactForm(contact,false);
  app.getContactHelper().submitContactModification();
  List<ContactData> after = app.getContactHelper().getContactList();
  Assert.assertEquals(after.size(), before.size());

  before.remove(before.size() - 1);
  before.add(contact);
  Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
  before.sort(byId);
  after.sort(byId);
  Assert.assertEquals(before, after);
  }
}

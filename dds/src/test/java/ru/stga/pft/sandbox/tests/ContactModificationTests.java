package ru.stga.pft.sandbox.tests;

import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

/**
 * Created by Homosapiens on 02.03.2016.
 */
public class ContactModificationTests extends TestBase{

@Test
  public void testContactModification () {
  app.getNavigationHelper().gotoHomePage();
  app.getContactHelper().selectContact();
  app.getContactHelper().initContactModification();
  app.getContactHelper().fillContactForm(new ContactData("33", "33", "123456789", "user1.user2@mail.ru", "Новосибирск", null),false);
  app.getContactHelper().submitContactModification();
  }
}

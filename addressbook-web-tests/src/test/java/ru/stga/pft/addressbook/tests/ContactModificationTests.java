package ru.stga.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

/**
 * Created by Homosapiens on 02.03.2016.
 */
public class ContactModificationTests extends TestBase{

@Test
  public void testContactModification () {
  app.goTo().HomePage();
  app.contact().selectContact();
  app.contact().initContactModification();
  app.contact().fillContactForm(new ContactData("33", "33", "123456789", "user1.user2@mail.ru", "Новосибирск"));
  app.contact().submitContactModification();
  }
}

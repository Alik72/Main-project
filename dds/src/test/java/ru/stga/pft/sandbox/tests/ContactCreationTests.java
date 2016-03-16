package ru.stga.pft.sandbox.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testFormCreation() {

    app.getNavigationHelper().gotoHomePage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва", "test1"), true);
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }
}

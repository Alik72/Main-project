package ru.stga.pft.sandbox.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testFormCreation() {

    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().contactCount();
    app.getContactHelper().createContact(new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва", "test1"), true);
    int after = app.getContactHelper().contactCount();
    Assert.assertEquals(after, before + 1);
  }
}

package ru.stga.pft.sandbox.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion () {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact (new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва","test1"),true);
    }
    int before = app.getContactHelper().contactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().allertDeletionContact();
    int after = app.getContactHelper().contactCount();
    Assert.assertEquals(after, before - 1);

  }
}

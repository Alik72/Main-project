package ru.stga.pft.sandbox.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

import java.util.List;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.goTo().gotoHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size() - 1);
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().allertDeletionContact();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before,after);
    }

}

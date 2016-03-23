package ru.stga.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion () {
    app.goTo().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().allertDeletionContact();

  }
}

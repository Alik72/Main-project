package ru.stga.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion () {
    app.goTo().HomePage();
    app.contact().selectContact();
    app.contact().deleteSelectedContact();
    app.contact().allertDeletionContact();

  }
}

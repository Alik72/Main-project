package ru.stga.pft.sandbox.tests;

import org.testng.annotations.Test;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class ContactDeletionTests extends TestBase{

  @Test
  public void testContactDeletion () {
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.getContactHelper().allertDeletionContact();

  }
}

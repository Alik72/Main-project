package ru.stga.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

public class ContactCreationTests extends TestBase {

   @Test
    public void testFormCreation() {

        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва"));
        app.getContactHelper().submitContactCreation();
    }


}

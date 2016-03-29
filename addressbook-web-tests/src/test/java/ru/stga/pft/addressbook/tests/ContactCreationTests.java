package ru.stga.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

public class ContactCreationTests extends TestBase {

   @Test
    public void testFormCreation() {

        app.goTo().HomePage();
        app.contact().initContactCreation();
        app.contact().fillContactForm(new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва"));
        app.contact().submitContactCreation();
    }


}

package ru.stga.pft.sandbox.tests;


import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

public class ContactCreationTests extends TestBase {

   @Test
    public void testFormCreation() {

        app.initContactCreation();
        app.fillContactForm(new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва"));
        app.submitContactCreation();
    }


}

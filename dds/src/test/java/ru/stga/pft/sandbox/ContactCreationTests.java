package ru.stga.pft.sandbox;


import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

   @Test
    public void testFormCreation() {

        app.initContactCreation();
        app.fillContactForm(new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва"));
        app.submitContactCreation();
    }


}

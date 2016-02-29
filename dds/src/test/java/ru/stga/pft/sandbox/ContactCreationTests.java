package ru.stga.pft.sandbox;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

   @Test
    public void testFormCreation() {

        initContactCreation();
        fillContactForm(new ContactData("user1", "user2", "123456789", "user1.user2@mail.ru", "Москва"));
        submitContactCreation();
    }


}

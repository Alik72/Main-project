package ru.stga.pft.sandbox.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;

/**
 * Created by Homosapiens on 29.03.2016.
 */
public class ContactPhoneTests extends TestBase{
  @BeforeMethod
  public void ensurePrecondition(){
    if (app.contact().all().size()==0){
      app.contact().create(new ContactData().withFirstname("user1").withLastname("user2").withHomePhone("123456789").withEmail("user1.user2@mail.ru")
              .withAddress("Москва").withGroup("test1"),true);
    }
  }
  @Test
  public void testContactPhones (){
    app.goTo().HomePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);



  }
}

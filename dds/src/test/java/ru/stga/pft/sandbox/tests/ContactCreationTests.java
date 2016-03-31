package ru.stga.pft.sandbox.tests;



import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;
import ru.stga.pft.sandbox.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test ()
  public void testFormCreation() {

    app.goTo().HomePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/1.png");
    ContactData contact = new ContactData()
            .withFirstname("user1").withLastname("user2").withHomePhone("123456789").withEmail("user1.user2@mail.ru")
            .withAddress("Москва").withPhoto(photo).withGroup("test");
    app.contact().create(contact, true);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo (before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c)->c.getId()).max().getAsInt()))) );
  }
 @Test (enabled = false)
  public void testBadFormCreation() {

    app.goTo().HomePage();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withFirstname("user1'").withLastname("user2'").withHomePhone("123456789'").withEmail("user1.user2@mail.ru'")
            .withAddress("Москва'").withGroup("test1");
    app.contact().create(contact, true);

   assertThat(app.contact().count(), equalTo (before.size()));

   Contacts after = app.contact().all();

    assertThat(after, equalTo(before) );
  }
  @Test(enabled = false)
  public void testCurrentDir (){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/1.png");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }
}

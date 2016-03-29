package ru.stga.pft.sandbox.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;
import ru.stga.pft.sandbox.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by Homosapiens on 02.03.2016.
 */
public class ContactModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition(){
    if (app.contact().all().size()==0){
      app.contact().create(new ContactData().withFirstname("user1").withLastname("user2").withHomePhone("123456789").withEmail("user1.user2@mail.ru")
              .withAddress("Москва").withGroup("test1"),true);
    }
  }

@Test
  public void testContactModification () {
  app.goTo().HomePage();

  Contacts before = app.contact().all();
  ContactData modifiedContact = before.iterator().next();
  ContactData contact  = new ContactData().withId(modifiedContact.getId()).withFirstname("user1").withLastname("user2")
          .withHomePhone("123456789").withEmail("user1.user2@mail.ru").withAddress("Москва").withGroup("test1");

  app.contact().modify(contact);

  Contacts after = app.contact().all();
  assertEquals(after.size(), before.size());

  assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
  }


}

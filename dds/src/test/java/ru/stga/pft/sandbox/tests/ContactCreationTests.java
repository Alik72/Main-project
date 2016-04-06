package ru.stga.pft.sandbox.tests;



import com.thoughtworks.xstream.XStream;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.ContactData;
import ru.stga.pft.sandbox.model.Contacts;
import ru.stga.pft.sandbox.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider

  public Iterator<Object[]> validContacts() throws IOException {
    BufferedReader reader = new BufferedReader (new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null){
      xml+=line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>)xstream.fromXML(xml);
    return contacts.stream().map((g)-> new Object[] {g}).collect(Collectors.toList()).iterator();

  }

  @Test (dataProvider = "validContacts")
  public void testFormCreation(ContactData contact) {
    app.goTo().HomePage();
    Contacts before = app.contact().all();
    app.contact().create(contact);
    assertThat(app.contact().count(), Matchers.equalTo(before.size() + 1));
    Contacts after = app.contact().all();
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
    app.contact().create(contact);

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

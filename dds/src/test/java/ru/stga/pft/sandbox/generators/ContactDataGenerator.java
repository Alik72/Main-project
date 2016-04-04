package ru.stga.pft.sandbox.generators;

import ru.stga.pft.sandbox.model.ContactData;
import ru.stga.pft.sandbox.model.GroupData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Homosapiens on 04.04.2016.
 */
public class ContactDataGenerator {
  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<ContactData> contacts = generateContacts(count);
    save(contacts, file);
  }

  private static void save(List<ContactData> contacts, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (ContactData contact : contacts) {
      writer.write(String.format("%s;%s;%s\n", contact.getFirstname(), contact.getLastname(), contact.getAddress()));
    }
    writer.close();
  }

  private static List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstname(String.format("Aleksei %s", i))
              .withLastname(String.format("Baransev %s", i)).withAddress(String.format("Moskva %s", i)));
    }
    return contacts;
  }
}


package ru.stga.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.GroupData;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification(){
    app.goTo().groupPage();
    app.group().selectGroup();
    app.group().initGroupModification();
    app.group().fillGroupForm(new GroupData("proba11", "proba22", "proba33"));
    app.group().submitGroupModification();
    app.group().returnToGroupPage();
  }
}

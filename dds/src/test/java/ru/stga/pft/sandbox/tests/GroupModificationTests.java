package ru.stga.pft.sandbox.tests;

import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.GroupData;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("proba11", "proba22", "proba33"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
  }
}

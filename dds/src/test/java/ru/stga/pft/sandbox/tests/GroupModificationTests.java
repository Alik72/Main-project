package ru.stga.pft.sandbox.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.GroupData;

import java.util.List;

/**
 * Created by Homosapiens on 01.03.2016.
 */
public class GroupModificationTests extends TestBase {
  @Test
  public void testGroupModification(){
    app.getNavigationHelper().gotoGroupPage();
    if(! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("test1", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1 );
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("proba11", "proba22", "proba33"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    Assert.assertEquals(after.size(),before.size());
  }
}

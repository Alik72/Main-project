package ru.stga.pft.sandbox.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.GroupData;
import ru.stga.pft.sandbox.model.Groups;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Homosapiens on 01.03.2016.
 */


public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    app.group().modify(group);
    Groups after = app.group().all();
    Assert.assertEquals(after.size(), before.size());
    assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));

  }
}


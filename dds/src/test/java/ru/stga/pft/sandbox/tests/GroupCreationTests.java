package ru.stga.pft.sandbox.tests;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.GroupData;
import ru.stga.pft.sandbox.model.Groups;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GroupCreationTests extends TestBase {

@DataProvider

public Iterator<Object[]> validGroups(){
  List<Object[]>list = new ArrayList<Object[]>();
  list.add(new Object[] {new GroupData ().withName("test1").withHeader("header1").withFooter("footer1")});
  list.add(new Object[] {new GroupData ().withName("test2").withHeader("header2").withFooter("footer2")});
  list.add(new Object[] {new GroupData ().withName("test3").withHeader("header3").withFooter("footer3")});
  return list.iterator();

  }

  @Test(dataProvider = "validGroups")
  public void testGroupCreation(GroupData group) {
      app.goTo().groupPage();
      Groups before = app.group().all();
      app.group().create(group);
      assertThat(app.group().count(), equalTo(before.size() + 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }
    @Test (enabled = false)
    public void testBadGroupCreation() {
      app.goTo().groupPage();
      Groups before = app.group().all();
      GroupData group = new GroupData().withName("test'");
      app.group().create(group);
      assertThat(app.group().count(), equalTo(before.size()));
      Groups after = app.group().all();
      assertThat(after, equalTo(before));
    }
  }


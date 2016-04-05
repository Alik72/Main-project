package ru.stga.pft.sandbox.tests;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.GroupData;
import ru.stga.pft.sandbox.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GroupCreationTests extends TestBase {

@DataProvider

public Iterator<Object[]> validGroups() throws IOException {
  List<Object[]>list = new ArrayList<Object[]>();
  BufferedReader reader = new BufferedReader (new FileReader(new File("src/test/resources/groups.csv")));
  String line = reader.readLine();
  while (line != null){
    String[] split = line.split(";");
    list.add(new Object []{new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
    line = reader.readLine();
  }
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


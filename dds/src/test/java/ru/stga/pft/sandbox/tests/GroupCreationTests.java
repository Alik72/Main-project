package ru.stga.pft.sandbox.tests;



import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.GroupData;
import ru.stga.pft.sandbox.model.Groups;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class GroupCreationTests extends TestBase {



  @Test
  public void testGroupCreation() {
    String[] names = new String[]{"test1", "test2", "test3"};
    for (String name : names) {
      app.goTo().groupPage();
      Groups before = app.group().all();
      GroupData group = new GroupData().withName(name);
      app.group().create(group);
      assertThat(app.group().count(), equalTo(before.size() + 1));
      Groups after = app.group().all();
      assertThat(after, equalTo(
              before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }
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


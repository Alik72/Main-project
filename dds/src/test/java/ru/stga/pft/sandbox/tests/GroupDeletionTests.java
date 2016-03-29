package ru.stga.pft.sandbox.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.GroupData;
import ru.stga.pft.sandbox.model.Groups;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition () {
        app.goTo().groupPage();
        if (app.group().all().size() == 0 ) {
            app.group().create(new GroupData().withName("test1"));
        }
    }
    @Test
    public void testGroupDeletion() {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.group().all();
        assertEquals(after.size(),before.size() - 1 );
        assertThat( after, equalTo(before.without(deletedGroup)));
        }




}



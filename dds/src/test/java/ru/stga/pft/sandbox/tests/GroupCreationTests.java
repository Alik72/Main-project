package ru.stga.pft.sandbox.tests;


import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.GroupData;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("proba11", "proba22", "proba33"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();
    }

}

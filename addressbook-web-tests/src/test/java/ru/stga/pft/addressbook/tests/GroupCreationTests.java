package ru.stga.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stga.pft.sandbox.model.GroupData;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        app.goTo().groupPage();
        app.group().initGroupCreation();
        app.group().fillGroupForm(new GroupData("proba11", "proba22", "proba33"));
        app.group().submitGroupCreation();
        app.group().returnToGroupPage();
    }

}

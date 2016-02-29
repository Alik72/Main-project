package ru.stga.pft.sandbox;


import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("proba11", "proba22", "proba33"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}

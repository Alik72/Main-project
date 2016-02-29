package ru.stga.pft.sandbox;


import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

    @Test
    public void testGroupCreation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("proba11", "proba22", "proba33"));
        submitGroupCreation();
        returnToGroupPage();
    }

}

package ru.stga.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() {

        app.goTo().groupPage();
        app.group().selectGroup();
        app.group().deleteSelectedGroups();
        app.group().returnToGroupPage();
    }

}

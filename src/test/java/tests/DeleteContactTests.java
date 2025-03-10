package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;
import utils.TestNGListener;

@Listeners(TestNGListener.class)

public class DeleteContactTests extends ApplicationManager {

    UserDto user = new UserDto("qa_mail@mail.com", "Qwerty123!");

    ContactsPage contactsPage;

    @BeforeMethod(alwaysRun = true)
    public void login() {
        new HomePage(getDriver()).clickBtnLoginHeader();
        new LoginPage(getDriver()).typeLoginForm(user);
        contactsPage = new ContactsPage(getDriver());
    }

    @Test(groups = "smoke")
    public void deleteContactPositiveTest() {
        int quantityBeforeDelete = contactsPage.quantityContacts();
        System.out.println("quantityBeforeDelete--> " + quantityBeforeDelete);
        contactsPage.deleteFirstContact();
        int quantityAfterDelete = contactsPage.quantityContacts();
        System.out.println("quantityAfterDelete--> " + quantityAfterDelete);
        Assert.assertEquals(quantityBeforeDelete-1, quantityAfterDelete);
    }
}

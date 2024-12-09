package tests;

import dto.ContactDtoLombok;
import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddPage;
import pages.ContactsPage;
import pages.HomePage;
import pages.LoginPage;

public class AddContactTests extends ApplicationManager {

    UserDto user = new UserDto("qa_mail@mail.com", "Qwerty123!");
    AddPage addPage;

    @BeforeMethod
    public void login(){
        new HomePage(getDriver()).clickBtnLoginHeader();
        new LoginPage(getDriver()).typeLoginForm(user);
        new ContactsPage(getDriver()).clickBtnAdd();
        addPage = new AddPage(getDriver());
    }

    @Test
    public void addNewContactPositiveTest(){
        ContactDtoLombok contact = ContactDtoLombok.builder()
                .name("Name123")
                .lastName("Last name123")
                .phone("1234567890")
                .email("lastname@mail.com")
                .address("address st.1")
                .description("description")
                .build();
        addPage.typeContactForm(contact);
        Assert.assertTrue(new ContactsPage(getDriver())
                .validateLastElementContactList(contact));
    }
}

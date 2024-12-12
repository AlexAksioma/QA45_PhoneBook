package pages;

import dto.ContactDtoLombok;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactsPage extends BasePage{
    public ContactsPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver,10), this);
    }

    @FindBy(xpath = "//button[text()='Sign Out']")
    WebElement btnSignOut;
    @FindBy(xpath = "//a[text()='ADD']")
    WebElement btnAdd;
    @FindBy(xpath = "//div[@class='contact-page_leftdiv__yhyke']/div/div[last()]")
    WebElement lastElementContactList;
    @FindBy(xpath = "//div[@class='contact-item_card__2SOIM']")
    WebElement firstElementContactList;
    @FindBy(xpath = "//button[text()='Remove']")
    WebElement btnRemove;

    public void deleteFirstContact(){
        clickWait(firstElementContactList, 3);
        clickWait(btnRemove, 3);
        pause(3);
    }

    public boolean validateLastElementContactList(ContactDtoLombok contact){
        System.out.println(lastElementContactList.getText());
        return lastElementContactList.getText().contains(contact.getName());
    }

    public void clickBtnSignOut(){
        //pause(3);
        //btnSignOut.click();
        clickWait(btnSignOut, 5);
    }

    public void clickBtnAdd(){
        btnAdd.click();
    }


    public boolean isSignOutPresent(){
        //pause(3);
        return btnSignOut.isDisplayed();
    }


    public int quantityContacts() {
//        pause(5);
//        return driver.findElements(
//                By.xpath("//div[@class='contact-item_card__2SOIM']")).size();
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//div[@class='contact-item_card__2SOIM']"))).size();
    }
}

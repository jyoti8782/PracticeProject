package pageObjects;

import functionalLibrary.CommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header extends CommonFunctions
{
    public WebDriver driver;
    public Header(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver =driver;
    }

    @FindBy(xpath="//input[@title='Search Items']")
    public WebElement searchIcon;

    @FindBy(id="sli_search_1")
    public WebElement searchTextField;

    public void enterSearchTextField(String searchTerm)
    {
        searchTextField.sendKeys(searchTerm);
    }

    public void clickSearchIcon()
    {
        searchIcon.click();
    }

}

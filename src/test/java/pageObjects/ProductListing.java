package pageObjects;

import functionalLibrary.CommonFunctions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListing extends CommonFunctions
{
    public WebDriver driver;
    public ProductListing(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
        this.driver=driver;
    }
    @FindBy(xpath ="//a[@class='TitleText']/span" )
    public List <WebElement> productList;

    @FindBy(xpath = "//a[@class='dk_toggle dk_label']")
    public WebElement sortField;

    @FindBy(xpath = "/a[@class='dk_dropdown_option']")
    public List<WebElement> sortConditions;

    public void validateSearchResult(String expectedsearchTerm)
    {
        System.out.println(productList.size());
        for(WebElement eachProduct: productList)
        {
            String actualProductName=eachProduct.getText();
            String expectedTerm2="Denim";
            String expectedTerm3="Jean";
            System.out.println(actualProductName);
            Assert.assertTrue((actualProductName.contains(expectedsearchTerm))||(actualProductName.contains(expectedTerm2))||(actualProductName.contains(expectedTerm3)));
        }
    }

    public void sortSearchResult(String sortTerm)
    {
        sortField.click();
        for(WebElement eachSort: sortConditions)
        {
            if(sortTerm.equals(eachSort.getText()))
            {
                eachSort.click();
            }
        }
    }


}

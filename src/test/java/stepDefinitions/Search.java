package stepDefinitions;

import functionalLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TakesScreenshot;
import pageObjects.Header;
import pageObjects.ProductListing;

public class Search extends CommonFunctions
{

    Header header = new Header(driver);
    ProductListing productListing=new ProductListing(driver);

    @Given("I'm on home page")
    public void i_m_on_home_page()throws Exception
    {
        driver.get(readPropertyFile("url"));
        String actualTitle = driver.getTitle();
        String expectedTitle = "Next Official Site";
        takeScreenShots("/homepagee.png");
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }
    @When("I enter search term as {string}")
    public void i_enter_search_term_as(String searchTerm)
    {
        header.enterSearchTextField(searchTerm);
    }
    @When("Click on Search icon")
    public void click_on_search_icon()
    {
        header.clickSearchIcon();

    }
    @Then("I should be redirected to item listing page with appropriate result with term {string}")
    public void i_should_be_redirected_to_item_listing_page_with_appropriate_result_with_term(String searchTerm)
    {
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle = "Buy from the Next";
        //Assert.assertTrue(actualTitle.contains(expectedTitle));
        productListing.validateSearchResult(searchTerm);
    }

    @Then("I should sort Product List from {string}")
    public void i_should_sort_product_list_from(String sortTerm) {
       productListing.sortSearchResult(sortTerm);
    }

}

package stepDefinition;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CartPages;
import pages.HomeDemoPages;
import pages.WishlistPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class demoStepDefinition {
    public WebDriver driver;

    @Before
    public void beforeScenario(){
        String path = "src/test/resources";
        File file = new File(path);
        String absolutePath = file.getAbsolutePath();
        System.setProperty("webdriver.chrome.driver", absolutePath+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://testscriptdemo.com/");
        driver.manage().window().maximize();
    }

    @Given("^I add four different products to my wishlist$")
    public void i_add_four_different_products_to_my_wishlist() throws Throwable {
        //Creating object of home page
        HomeDemoPages home = new HomeDemoPages(driver);
        home.addFourProductsToTheCart();
    }

    @When("^I view my wishlist table$")
    public void i_view_my_wishlist_table() throws Throwable {
        WishlistPages wishlistPages = new WishlistPages(driver);
        wishlistPages.clickOnWishListIcon();
    }

    @Then("^I find total four selected items in my wishlist$")
    public void i_find_total_four_selected_items_in_my_wishlist() throws Throwable {
        WishlistPages wishlistPages = new WishlistPages(driver);
        wishlistPages.getLowestItemPriceFromWishlist();
    }

    @When("^I search for lowest price item to my cart$")
    public void i_search_for_lowest_price_item_to_my_cart() throws Throwable {
        WishlistPages wishlistPages = new WishlistPages(driver);
        wishlistPages.clickOnLowestItemToTheCart();
    }

    @Then("^I am to verify the item in my cart$")
    public void i_am_to_verify_the_item_in_my_cart() throws Throwable {
        CartPages cartPages=new CartPages(driver);
        cartPages.verifyLowestItemInTheCart();
    }
    @After
    public void afterScenario(){
        driver.quit();
    }
}

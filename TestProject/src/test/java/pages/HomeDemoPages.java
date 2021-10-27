package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeDemoPages{

        WebDriver driver;
//        @FindBy(xpath = "//span[text()='Add to wishlist']")
//        List<WebElement> addToWishlist;

        @FindBy(xpath = "//a[@class='envo-categories-menu-first']")
        WebElement categoryMenu;

        @FindBy(xpath = "//a[@title='Clothing']")
        WebElement clothingMenu;

        public HomeDemoPages(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void clickOnClothingMenu()
        {
            Actions actions=new Actions(driver);
            actions.moveToElement(categoryMenu).build().perform();
            clothingMenu.click();
        }
        public void  addFourProductsToTheCart() throws InterruptedException {
            clickOnClothingMenu();
            driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
            List<WebElement> addToWishlist=driver.findElements(By.xpath("//span[text()='Add to wishlist']"));
            for (int i=1;i<=4;i++)
            {
                addToWishlist.get(i).click();
                driver.manage().timeouts().pageLoadTimeout(1000, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
                Thread.sleep(1000);
            }
        }



}

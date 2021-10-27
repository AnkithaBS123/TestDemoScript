package pages;

import globalVariables.Global;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPages{
    WebDriver driver;

    @FindBy(xpath = "(//a[@title='Cart'])[1]/i")
    WebElement cartIcon;

    @FindBy(xpath = "//tr[@class='woocommerce-cart-form__cart-item cart_item']/td[4]/span/bdi")
    WebElement cartItemPrice;

    public CartPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void verifyLowestItemInTheCart() throws InterruptedException {
        Thread.sleep(300);
        Actions actions=new Actions(driver);
        actions.click(cartIcon).build().perform();
        Thread.sleep(300);
        int lowestVal= Global.lowestPrice.get("lowPrice");
        String getLowestValueStringVal=String.valueOf(lowestVal);
        if (cartItemPrice.getText().contains(getLowestValueStringVal))
        {
            System.out.println("Item added in the cart is the lowest value");
        }
        else
        {
            throw new IllegalArgumentException("Item added in the cart is not the lowest value");
        }
    }
}

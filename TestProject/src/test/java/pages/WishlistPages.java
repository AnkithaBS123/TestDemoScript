package pages;

import globalVariables.Global;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WishlistPages {
    WebDriver driver;

    @FindBy(xpath = "//a[@title='Wishlist']")
    WebElement wishListIcon;

    @FindBy(xpath = "//tbody[@class='wishlist-items-wrapper']/tr")
    List<WebElement> wishListTable;

    public WishlistPages(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickOnWishListIcon()
    {
        wishListIcon.click();
    }
    public List<Integer> getLowestItemPriceFromWishlist() throws InterruptedException {
        List<Integer> priceAmt=new ArrayList<Integer>();
        Thread.sleep(1500);
        for (int i=1;i<=wishListTable.size();i++)
        {
            WebElement discountWebElement=driver.findElement(By.xpath("//tbody[@class='wishlist-items-wrapper']/tr["+i+"]/td[4]"));
            String getPrice=discountWebElement.getText().trim();
            if (getPrice.length()>7 && !getPrice.contains("-")) {
                String[] splitval = getPrice.split("£");
                String splitval1 = splitval[2].substring(0, 2);
                int convertToInt = Integer.parseInt(splitval1);
                priceAmt.add(convertToInt);
            }
            else
            {
                String[] splitval = getPrice.split("£");
                String splitval1 = splitval[1].substring(0, 2);
                int convertToInt = Integer.parseInt(splitval1);
                priceAmt.add(convertToInt);
            }
        }
        Collections.sort(priceAmt);
        Global.lowestPrice.put("lowPrice",priceAmt.get(0));
        System.out.println("Lowest Price Item is "+priceAmt.get(0));
        return priceAmt;
    }
    public void clickOnLowestItemToTheCart() throws InterruptedException {
        int lowestVal=Global.lowestPrice.get("lowPrice");
        String getLowestValueStringVal=String.valueOf(lowestVal);
        System.out.println(getLowestValueStringVal);
        for (int i=1;i<=wishListTable.size();i++)
        {
            WebElement discountWebElement=driver.findElement(By.xpath("//tbody[@class='wishlist-items-wrapper']/tr["+i+"]/td[4]"));
            if (discountWebElement.getText().contains(getLowestValueStringVal))
            {
                driver.findElement(By.xpath("//tbody[@class='wishlist-items-wrapper']/tr["+i+"]/td[6]/a")).click();
                Thread.sleep(1000);
                break;
            }
        }
    }
}

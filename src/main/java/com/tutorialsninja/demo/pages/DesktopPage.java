package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;

public class DesktopPage extends Utility {
    By showAllDesktops = By.linkText("Show All Desktops");
    By sortByZToA = By.id("input-sort");
    By beforeSortedProducts = By.xpath("//h4/a");

    By afterSortedProducts = By.xpath("//h4/a");
    By sortByAToZ = By.id("input-sort");
    By clickOnHpLaptop = By.xpath("//a[contains(text(),'HP LP3065')]");
    By hpLaptopText = By.xpath("//h1[contains(text(),'HP LP3065')]");
    By clearQuantity = By.name("quantity");
    By enterQuantity = By.name("quantity");
    By addToCartButton = By.id("button-cart");
    By successMessage = By.cssSelector("body:nth-child(2) div.container:nth-child(4) > div.alert.alert-success.alert-dismissible");
    By clickShoppingCart = By.xpath("//a[text()='shopping cart']");
    By shoppingCartText = By.xpath("//div[@id='content']//h1");
    By productNameHPLP3065 = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/a");
    //By deliveryDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");
    By productModel = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");

    By currency = By.xpath("//span[text()='Currency']");
    By sterlingPound = By.xpath("//button[contains(text(),'£ Pound Sterling')]");
    By total = By.xpath("//tbody/tr[1]/td[6]");

    public void clickOnShowAllDesktops() {
        clickOnElement(showAllDesktops);
    }

   public void sortByNameZToA() {
        selectByVisibleTextFromDropDown(sortByZToA, "Name (Z - A)");
    }


    public void sortByNameAToZ() {
        selectByVisibleTextFromDropDown(sortByAToZ, "Name (A - Z)");

    }

    public void clickOnHpLp3065() {
        clickOnElement(clickOnHpLaptop);
    }

    public String getHpLaptopText() {
        return getTextFromElement(hpLaptopText);
    }

    public void clearQuantityField() {
        driver.findElement(clearQuantity).clear();
    }

    public void changeTheQuantity() {
        sendTextToElement(enterQuantity, "1");
    }

    public void clickOnAddToCartButton() {
        clickOnElement(addToCartButton);
    }

    public String getSuccessMessage() {
        return getTextFromElement(successMessage);
    }

    public void clickOnShoppingCartText() {
        clickOnElement(clickShoppingCart);
    }

    public String getShoppingCartText() {
        return getTextFromElement(shoppingCartText);
    }

    public String getProductName() {
        return getTextFromElement(productNameHPLP3065);
    }

    public String getProductModelName() {
        return getTextFromElement(productModel);
    }

    public void clickOnCurrency() {
        clickOnElement(currency);
    }

    public void clickOnSterlingPound() {
        clickOnElement(sterlingPound);
    }

    public String getTotal() {
        return getTextFromElement(total);
    }

}

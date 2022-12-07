package com.tutorialsninja.demo.pages;

import com.tutorialsninja.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class DesktopPage extends Utility {
    //1.2 Click on “Show All Desktops”
    By clickOnShowAllDesktops = By.linkText("Show All Desktops");

    public void showAllDesktops() {
        clickOnElement(clickOnShowAllDesktops);
    }

    //1.3 Select Sort By position "Name: Z to A"
    By sortSelectZToA = By.id("input-sort");

    public void setSortSelectZToA() {
        selectByVisibleTextFromDropDown(sortSelectZToA, "Name (Z - A)");
    }

    //1.4 Verify the Product will arrange in Descending order
    By selectOrderBy = By.id("input-sort");

    public void setSelectOrderByZToA() {
        selectByVisibleTextFromDropDown(selectOrderBy, "Name (Z - A)");
    }

    public Map<String, ArrayList> verifyProductArrangeInDescendingOrder() {

        Map<String, ArrayList> mapArrays = new HashMap<String, ArrayList>();

        List<WebElement> products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> originalProductsName = new ArrayList<>();
        for (WebElement e : products) {
            originalProductsName.add(e.getText());
        }
        System.out.println(originalProductsName);
        // Sort By Reverse order
      //  Collections.reverse(originalProductsName);
        System.out.println(originalProductsName);
        // Select sort by Name Z - A
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");
        // After filter Z -A Get all the products name and stored into array list
        products = driver.findElements(By.xpath("//h4/a"));
        ArrayList<String> afterSortByZToAProductsName = new ArrayList<>();
        for (WebElement e : products) {
            afterSortByZToAProductsName.add(e.getText());
        }
        //System.out.println(afterSortByZToAProductsName);
        //mapArrays.put("originalProductsName", (ArrayList) originalProductsName);
        //mapArrays.put("afterSortByZToAProductsName", afterSortByZToAProductsName);
        //return mapArrays;
       // System.out.println("Orginial Name before Sort " +originalProductsName);
       // System.out.println("After Sort:" + afterSortByZToAProductsName);
        mapArrays.put("originalProductsName", originalProductsName);
        mapArrays.put("afterSortByZToAProductsName", afterSortByZToAProductsName);
        return mapArrays;

    }

    //2.3 Select Sort By position "Name: A to Z"
    By sortOrderByAToZ = By.id("input-sort");

    public void sortAToZ() {
        selectByVisibleTextFromDropDown(sortOrderByAToZ, "Name (A - Z)");
    }

    //2.4 Select product “HP LP3065”
    By selectProduct = By.xpath("//a[contains(text(),'HP LP3065')]");

    public void setSelectProduct() {
        clickOnElement(selectProduct);
    }

    //2.5 Verify the Text "HP LP3065"
    By selectHPLP3065 = By.xpath("//a[contains(text(),'HP LP3065')]");

    public String getProductText() {
        return getTextFromElement(selectHPLP3065);
    }

    //2.6 Select Delivery Date "2022-11-30"
    public void pickDate() {
        String year = "2023";
        String month = "November";
        String date = "30";
        clickOnElement(By.xpath("//div[@class = 'input-group date']//button"));
        while (true) {
            String monthAndYear = driver.findElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='picker-switch']")).getText();
            String[] arr = monthAndYear.split(" ");
            String mon = arr[0];
            String yer = arr[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("//div[@class = 'datepicker']/div[1]//th[@class='next']"));
            }
        }
        List<WebElement> allDates = driver.findElements(By.xpath("//div[@class = 'datepicker']/div[1]//tbody/tr/td[@class = 'day']"));
        for (WebElement e : allDates) {
            if (e.getText().equalsIgnoreCase(date)) {
                e.click();
                break;
            }
        }
    }

    //2.7.Enter Qty "1” using Select class

    //2.8 Click on “Add to Cart” button
    By addToCartTab = By.xpath("//button[@id='button-cart']");

    public void addProductToCart() {
        clickOnElement(addToCartTab);
    }

    //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
    By successfullyAddedToCartText = By.xpath("//div[@class='alert alert-success alert-dismissible']");

    public String productAddedToCartDisplayed() {
        return getTextFromElement(successfullyAddedToCartText);
    }

    // 2.10 Click on link “shopping cart” display into success message
    By shoppingCart = By.linkText("shopping cart");

    public void setShoppingCart() {
        clickOnElement(shoppingCart);
    }

    // 2.11 Verify the text "Shopping Cart"
    By textShoppingCart = By.xpath("//a[text()='Shopping Cart']");

    public String textShoppingCart() {
        return getTextFromElement(textShoppingCart);
    }

    // 2.12 Verify the Product name "HP LP3065"
    By productText = By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]");

    public String getProductText1() {
        return getTextFromElement(productText);
    }

    //2.13 Verify the Delivery Date "2022-11-30"
    By deliveryDate = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[2]/small[1]");

    public String verifyDeliveryDate() {
        return getTextFromElement(deliveryDate);
    }

    //2.14 Verify the Model "Product21"
    By productModel = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[3]");

    public String verifyProductModel() {
        return getTextFromElement(productModel);
    }

    By total = By.xpath("//div[@class = 'table-responsive']/table/tbody/tr/td[6]");

    public String total() {
        return getTextFromElement(total);
    }

    public void selectYourCurrency() {
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        List<WebElement> currencyList = driver.findElements(By.xpath("//ul[@class = 'dropdown-menu']/li"));
        for (WebElement e : currencyList) {
            if (e.getText().equalsIgnoreCase("£ Pound Sterling")) {
                e.click();
                break;
            }
        }
    }



}

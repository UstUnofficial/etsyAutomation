package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.IDN;
import java.util.*;

public class ProductListingPage extends BasePage {

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.ebay.mobile:id/up_arrow']")
    WebElement saveThisNotification;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.ebay.mobile:id/fixed_appbar']//android.widget.TextView")
    WebElement productPageText;

    @FindBy(xpath = "//android.widget.TextView[@text='Sponsored']")
    WebElement sponsoredTag;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Filter']")
    WebElement filterTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Condition']")
    WebElement categoryTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Good - Refurbished']")
    WebElement refurbished;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.ebay.mobile:id/call_to_action_button']")
    WebElement showResultBtn;

    @FindBy(id = "com.ebay.mobile:id/button_sort")
    WebElement sortingTab;

    @FindBy(xpath = "(//android.widget.TextView[@resource-id = 'com.ebay.mobile:id/textview_primary_0']//ancestor::android.view.ViewGroup[@resource-id=\"com.ebay.mobile:id/cell_collection_item\"])[1]")
    WebElement firstElementCard;

    @FindBy(xpath = "(//android.widget.TextView[@text=\"Sponsored\"])[1]")
    WebElement sponsorTag;

    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.ebay.mobile:id/search_item_card_details\"])/android.widget.TextView[1]")
    List<WebElement> actualPrice;

    @FindBy(xpath = "//android.widget.TextView[@resource-id = 'com.ebay.mobile:id/textview_primary_0']")
    WebElement firstElementActualPrice;

    //    @FindBy(xpath = "(//android.view.ViewGroup[@resource-id=\"com.ebay.mobile:id/search_item_card_details\"])[1]/android.widget.TextView[4]")
    @FindBy(xpath = "(//android.widget.TextView[contains(@content-desc,'hipping')])")
    List<WebElement> shippingPrice;

    @FindBy(xpath = "//android.widget.TextView[@resource-id = 'com.ebay.mobile:id/textview_primary_0']/following-sibling::android.widget.TextView[contains(@content-desc, 'hipping')]")
    WebElement firstElementActualShipping;
    @FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.ebay.mobile:id/search_item_card_header']")
    List<WebElement> titleElementList;

    @FindBy(id = "com.ebay.mobile:id/recyclerview_items")
    WebElement scrollUpStart;

    @FindBy(id = "com.ebay.mobile:id/primary_toolbar")
    WebElement scrollUpEnd;


    public void clickOnNotification() {
        if (isDisplayed(saveThisNotification)) {
            saveThisNotification.click();
        }
    }

    public boolean isOnProductPage(String productName) {
        System.out.println(productPageText.getText().toLowerCase());
        System.out.println(productName.toLowerCase());
        return productPageText.getText().toLowerCase().contains(productName.toLowerCase());
    }

    public void selectBrandFromWatches(String brandName) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String xpath = "//android.widget.Button[contains(@content-desc,'%s')]";
        xpath = String.format(xpath, brandName);
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean containsBrandNameInEachProduct() {

        List<WebElement> currentProductList = driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/cell_collection_item']"));

        int x = currentProductList.get(0).getLocation().getX();
        int y = currentProductList.get(0).getLocation().getY();
        int cardWidth = currentProductList.get(0).getSize().getWidth();
        int cardHeight = currentProductList.get(0).getSize().getHeight();

        for (int i = 0; i <= 5; i++) {

            String currentData1 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_header_0' and @text]")).getText().toLowerCase();
            String currentData2 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_subheader_0' and @text]")).getText().toLowerCase();
            String brandName = ConfigReader.getValue("brand.name").toLowerCase();
            System.out.println(currentData1 + "////////////");
            System.out.println(currentData2);
            System.out.println(brandName + "00000000000000000000");
            if (isPresent(sponsoredTag)) {
                continue;
            } else if (!(currentData1.contains(brandName) || currentData2.contains(brandName))) {
                System.out.println(brandName + "-------------");
                return false;
            }

            scrollOrSwipe(cardWidth / 2, cardHeight / 2, cardWidth / 2, 0);

//            currentProductList =  driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/cell_collection_item']"));
        }
        return true;
    }

    public boolean isOnLaptopProductPage() {
        return productPageText.getText().toLowerCase().contains("laptop");

    }

    public void LaptopFiltering() {
        filterTab.click();
        categoryTab.click();
        refurbished.click();

        if (isDisplayed(showResultBtn)) {
            showResultBtn.click();
        }


    }

    public boolean isLaptopFiltered() {
        return true;
    }

    public void filter(String filter) {
        if (isDisplayed(filterTab)) {

            filterTab.click();
        }

        String xpath = "//android.widget.Button[@resource-id=\"com.ebay.mobile:id/filter_pill\" and @text='%s']";
        xpath = String.format(xpath, filter);
        driver.findElement(By.xpath(xpath)).click();

        if (isDisplayed(showResultBtn)) {
            showResultBtn.click();
        }

    }

    public void sortWith(String sortingOption) {

        sortingTab.click();

        String xpath = "//android.widget.TextView[@resource-id=\"com.ebay.mobile:id/search_textview_filter_title\" and @text='%s']";
        xpath = String.format(xpath, sortingOption);

        driver.findElement(By.xpath(xpath)).click();

    }


    public List<Double> priceList = new ArrayList<>();

    public void storeListOfPrice(int count) {
        // scrolling little bit to avoid some kind of problem
        int startHeight = scrollUpStart.getSize().getHeight();
        int startWidth = scrollUpStart.getSize().getWidth();
        int startX = scrollUpStart.getLocation().getX();
        int startY = scrollUpStart.getLocation().getY();

        int endHeight = scrollUpEnd.getSize().getHeight();
        int endWidth = scrollUpEnd.getSize().getWidth();
        int endX = scrollUpEnd.getLocation().getX();
        int endY = scrollUpEnd.getLocation().getY();

        scrollOrSwipe((startX + startWidth)/2, startY + startHeight , (endX + endWidth) /2 , endY + endHeight);


        int height = firstElementCard.getSize().getHeight();
        int width = firstElementCard.getSize().getWidth();
        int x = firstElementCard.getLocation().getX();
        int y = firstElementCard.getLocation().getY();

        while (priceList.size() < count) {
            if (isPresent(sponsorTag)) {
                scrollOrSwipe((x + width) / 2, y + height, x / 2, y);
                continue;
            }

            if(!isPresent(actualPrice.get(0))){
                scrollOrSwipe((x + width) / 2, y + height, x / 2, y);
                continue;
            }

            System.out.println(priceList.size());

            System.out.println(actualPrice.get(0).getText());

            String[] priceArray = firstElementActualPrice.getText().split(" ");
            String temp = priceArray[priceArray.length - 1].replaceAll("[^0-9.]", "");
            System.out.println(temp);
            double price = Double.parseDouble(temp);

            System.out.println(price);
            String shippingPriceString = firstElementActualShipping.getText();

            double shippingPrice = 0;
            if (!shippingPriceString.toLowerCase().contains("free")) {

                shippingPrice = Double.parseDouble(shippingPriceString.replaceAll("[^0-9.]", ""));

            }


            System.out.println("price : "+price);
            System.out.println("shipping price : "+shippingPrice);

            double totalPrice = price + shippingPrice;

            if (!priceList.contains(totalPrice)) {
                priceList.add(totalPrice);
            }
            scrollOrSwipe((x + width) / 2, y + height, x / 2, y);


            System.out.println(priceList.size());
            System.out.println(priceList);
        }

    }

    public boolean isPriceSortedIn(String sortingOption) {

        storeListOfPrice(5);

        System.out.println(priceList);

        List<Double> priceListCopy = new ArrayList<>(priceList);

        if (sortingOption.equals("Lowest Price + Shipping")) {
            Collections.sort(priceListCopy);
        }

        else {
            Collections.sort(priceListCopy);
            Collections.reverse(priceListCopy);
        }

        System.out.println("manual sorted :" +priceListCopy);
        System.out.println("from the site :"+priceList);

        return priceListCopy.equals(priceList);
    }
}

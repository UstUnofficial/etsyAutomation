package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListingPage extends  BasePage{

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.ebay.mobile:id/up_arrow']")
    WebElement saveThisNotification;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.ebay.mobile:id/fixed_appbar']//android.widget.TextView")
    WebElement productPageText;

    @FindBy(xpath = "//android.widget.TextView[@text='Sponsored']")
    WebElement sponsoredTag;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Filter']")
    WebElement filterTab;


    @FindBy(xpath = "//android.widget.Button[@resource-id='com.ebay.mobile:id/call_to_action_button']")
    WebElement showResultBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Back to all refinements']")
    WebElement filterBackButton;

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/cell_collection_item']")
    List<WebElement> firstProduct;


    public  void clickOnNotification(){
        if(isDisplayed(saveThisNotification)){
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

        for(int i=0;i<=5;i++){

            String currentData1 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_header_0' and @text]")).getText().toLowerCase();
            String currentData2 = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_subheader_0' and @text]")).getText().toLowerCase();
            String brandName = ConfigReader.getValue("brand.name").toLowerCase();
            if(isPresent(sponsoredTag)){
                continue;
            } else if (!(currentData1.contains(brandName)||currentData2.contains(brandName))) {
                return false;
            }

            scrollOrSwipe(cardWidth/2,cardHeight/2,cardWidth/2,0);

//            currentProductList =  driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/cell_collection_item']"));
        }
        return true;
    }

    public boolean isOnLaptopProductPage() {
        return productPageText.getText().toLowerCase().contains("laptop");

    }

    public void laptopFiltering(String filterCategory) {

        if(isPresent(filterTab)){
            filterTab.click();
        }

        if(isPresent(filterBackButton)){
            filterBackButton.click();
        }
        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, filterCategory);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void subFiltering(String subCategory){
        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, subCategory);
        driver.findElement(By.xpath(xpath)).click();

    }

    public boolean isLaptopFiltered(String data) {
        List<WebElement> currentProductList = driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/cell_collection_item']"));

        int x = currentProductList.get(0).getLocation().getX();
        int y = currentProductList.get(0).getLocation().getY();
        int cardWidth = currentProductList.get(0).getSize().getWidth();
        int cardHeight = currentProductList.get(0).getSize().getHeight();
        for(int i=0;i<=5;i++){

            String xpath = "//android.widget.TextView[contains(@content-desc,'%s')]";
            xpath = String.format(xpath, data);
            WebElement refurbishedText = driver.findElement(By.xpath(xpath));

             if (!isDisplayed(refurbishedText)) {
                return false;
             }

            scrollOrSwipe(cardWidth/2,cardHeight/2,cardWidth/2,0);

//            currentProductList =  driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/cell_collection_item']"));
        }

        return true;
    }

    public boolean isLaptopFilteredByTwoCondition(String data1, String data2) {
        List<WebElement> currentProductList = driver.findElements(By.xpath("//android.view.ViewGroup[@resource-id='com.ebay.mobile:id/cell_collection_item']"));

        int x = currentProductList.get(0).getLocation().getX();
        int y = currentProductList.get(0).getLocation().getY();
        int cardWidth = currentProductList.get(0).getSize().getWidth();
        int cardHeight = currentProductList.get(0).getSize().getHeight();
        for(int i=0;i<=5;i++){

            String xpath = "//android.widget.TextView[contains(@content-desc,'%s')]";
            xpath = String.format(xpath, data1);
            WebElement conditionText1 = driver.findElement(By.xpath(xpath));

            xpath = String.format(xpath, data2);
            WebElement conditionText2 =  driver.findElement(By.xpath(xpath));

            if (!(isDisplayed(conditionText1)&&(isDisplayed(conditionText2)))) {
                return false;
            }

            scrollOrSwipe(cardWidth/2,cardHeight/2,cardWidth/2,0);
        }

        return true;
    }


    public void subFilteringFromShipping(String subCategory) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String xpath = "//android.widget.Switch[@text='%s']";
        xpath = String.format(xpath, subCategory);
        WebElement subCategoryText = driver.findElement(By.xpath(xpath));
        if(isDisplayed(subCategoryText)){
            subCategoryText.click();
        }

    }

    public void clickOnSearchBtn() {
        if(isDisplayed(showResultBtn)){
            showResultBtn.click();
        }
    }

    public void clickOnFirstProduct() {
        firstProduct.get(0).click();
    }

    public void clickOnSecondProduct() {
        Dimension dimension=driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        scrollOrSwipe(width/2,height/2,width/2,0);
        firstProduct.get(1).click();
    }
}

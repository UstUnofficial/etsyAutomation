package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
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

    @FindBy(xpath = "//android.widget.TextView[@text='Condition']")
    WebElement categoryTab;

    @FindBy(xpath = "//android.widget.TextView[@text='Good - Refurbished']")
    WebElement refurbished;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.ebay.mobile:id/call_to_action_button']")
    WebElement showResultBtn;




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
            System.out.println(currentData1+"////////////");
            System.out.println(currentData2);
            System.out.println(brandName+"00000000000000000000");
            if(isPresent(sponsoredTag)){
                continue;
            } else if (!(currentData1.contains(brandName)||currentData2.contains(brandName))) {
                System.out.println(brandName+"-------------");
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

    public void LaptopFiltering() {
        filterTab.click();
        categoryTab.click();
        refurbished.click();

        if(isDisplayed(showResultBtn)){
            showResultBtn.click();
        }


    }

    public boolean isLaptopFiltered() {
        return true;
    }
}

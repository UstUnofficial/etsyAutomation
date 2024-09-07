package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoryListPage extends BasePage{

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_category' and @text")
    WebElement productCategoryTitles;

//    public  void scrollTheWindow(WebElement element){
//        Dimension dimension=driver.manage().window().getSize();
//        int width = dimension.getWidth();
//        int height = dimension.getHeight();
//
//        while(!isPresent(element)){
//            scrollOrSwipe(width/2,height/2,width/2,0);
//        }
//
//    }

    public void clickOnTheProductCategory(String category) {

        Dimension dimension=driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        String categoryXpath = "//android.widget.TextView[@resource-id='com.ebay.mobile:id/textview_category' and @text='%s']";
        String categoryXpathLocation = String.format(categoryXpath, category);
        WebElement productCategory = driver.findElement(By.xpath(categoryXpathLocation));

        while (!isPresent(productCategory)){
            scrollOrSwipe(width/2,height/2,width/2,0);
        }
        productCategory.click();

















//        List<WebElement> currentCard = driver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.ebay.mobile:id/parent\"]"));
//        int x = currentCard.get(0).getLocation().getX();
//        int y = currentCard.get(0).getLocation().getY();
//        int cardWidth = currentCard.get(0).getSize().getWidth();
//        int cardHeight = currentCard.get(0).getSize().getHeight();
//        Dimension dimension=driver.manage().window().getSize();
////        int width = dimension.getWidth();
////        int height = dimension.getHeight();
////        scrollOrSwipe(width/2,height/2,width/2,0);
////        scrollOrSwipe(width/2,height/2,width/2,0);
//        String categoryXpath = "//android.widget.TextView[@text='%s']";
//        String categoryXpathLocation = String.format(categoryXpath, category);
//        WebElement productCategory = driver.findElement(By.xpath(categoryXpathLocation));
//
//        while(isPresent(currentCard.get(0))){
//            System.out.println("-----------");
//            scrollOrSwipe(cardWidth/2,cardHeight/2,cardWidth/2,0);
//            currentCard = driver.findElements(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.ebay.mobile:id/parent\"]"));
//            if(isPresent(productCategory)){
//                break;
//            }
//        }
//        productCategory.click();

    }

    public void clickOnTheProductSubCategory(String subCategory) {
        Dimension dimension=driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
//        scrollOrSwipe(width/2,height/2,width/2,0);
//        scrollOrSwipe(width/2,height/2,width/2,0);
//        scrollOrSwipe(width/2,height/2,width/2,0);



        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, subCategory);
        WebElement productSubCategory = driver.findElement(By.xpath(xpath));
        while(!isPresent(productSubCategory)){
            scrollOrSwipe(width/2,height/2,width/2,0);
        }
        productSubCategory.click();

    }

    public void clickOnTheProductInnerSubCategory(String innerSubCategory) {

        Dimension dimension=driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
//        scrollOrSwipe(width/2,height/2,width/2,0);
//        scrollOrSwipe(width/2,height/2,width/2,0);


        String xpath = "//android.widget.TextView[@text='%s']";
        xpath = String.format(xpath, innerSubCategory);
        WebElement productInnerSubCategory = driver.findElement(By.xpath(xpath));
        while(!isPresent(productInnerSubCategory)){
            scrollOrSwipe(width/2,height/2,width/2,0);
        }
        productInnerSubCategory.click();

    }
}

package org.prog.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//TODO: create separate test-ng.xml file with this class only
//TODO: move your selenium test to this class
//TODO: Add assertion that goods name is not null
//TODO: Add assertion that goods name has > 0 length

public class AlloUaNGTestHW {

    @Test
public void ngTest1(){
        System.out.println("And what next?");
    }

    @Test
public void ngTest2() throws InterruptedException {
        WebDriver driver = null;
        try {
            driver = new EdgeDriver();
            driver.get("https://allo.ua/ua");
            WebElement searchInput = driver.findElement(By.name("search"));
            searchInput.sendKeys("xiaomi");
            searchInput.sendKeys(Keys.ENTER);
            Thread.sleep(500);
            WebElement model = driver.findElement(By.xpath("//div[@class='product-card__content']/a[@href='https://allo.ua/ua/products/mobile/xiaomi-redmi-note-14-pro-8-256gb-midnight-black.html']"));
            System.out.println(model.getText());
           // Assert.assertNotNull(model, "not Empty");
        } finally {
            if (driver !=null){
                driver.quit();
            }
        }

    }



}

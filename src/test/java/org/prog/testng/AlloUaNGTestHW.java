package org.prog.testng;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

//TODO: create separate test-ng.xml file with this class only
//TODO: move your selenium test to this class
//TODO: Add assertion that goods name is not null
//TODO: Add assertion that goods name has > 0 length

public class AlloUaNGTestHW {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() {
        driver = new EdgeDriver();
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testAllo() throws InterruptedException {
        driver.get("https://allo.ua/ua");
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("xiaomi");
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        WebElement model = driver.findElement(By.xpath("//div[@class='product-card__content']/a[@href='https://allo.ua/ua/products/mobile/xiaomi-redmi-note-14-pro-8-256gb-midnight-black.html']"));
        System.out.println(model.getText());
        //Assert.assertEquals(s.length(), length, "String length mismatch!");
        //Assert.assertTrue(imagesEmpty.isEmpty(),"Expected list of images to eb empty because image is in iframe!");
        //Assert.assertFalse(imagesPresent.isEmpty(),"Expected list of images to be NOT empty because selenium is INSIDE iframe!");

        //parseBoolean анализирует строковый аргумент как логический
        Assert.assertFalse(Boolean.parseBoolean(model.getText()), "Expected name to be NOT empty");

        /*var size = model.getSize();
        System.out.println(size);*/

        String l = model.getText();
        int stringLength = l.length();
        System.out.println("length name " + stringLength);
        Assert.assertNotNull(stringLength, "Expected name to be NOT null");


    }
}

package org.prog;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.List;

//TODO: go to allo.ua
//TODO: search for ANY PHONE
//TODO: print phone name for 1st phone in search
//TODO: For example: Apple iPhone 16 Pro Max 256GB Desert Titanium (MYWX3)
public class SeleniumHomeWork {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        try {
        driver = new EdgeDriver();
        driver.get("https://allo.ua/ua");
        WebElement searchInput = driver.findElement(By.name("search"));
        searchInput.sendKeys("xiaomi");
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        WebElement model = driver.findElement(By.xpath("//div[@class='product-card__content']/a[@href='https://allo.ua/ua/products/mobile/xiaomi-redmi-note-14-pro-8-256gb-midnight-black.html']"));
        //WebElement model = driver.findElement(By.xpath("//a[@href='https://allo.ua/ua/products/mobile/xiaomi-redmi-note-14-pro-8-256gb-midnight-black.html']"));
        //WebElement model = driver.findElement(By.xpath("//a[contains(@href, 'Xiaomi Redmi Note 14 Pro 8/256GB Midnight Black')]"));
        //driver.findElements(By.xpath("//a[contains(@href,'technologies/cookies')]"));
        System.out.println(model.getText());
        System.out.println("found");
        } finally {
            if (driver !=null){
                driver.quit();
            }
        }
    }
}

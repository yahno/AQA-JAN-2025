package org.prog.cucumber.steps_amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebStepsAmazon {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;

            //driver = new ChromeDriver();
            driver = new EdgeDriver();
            driver.get("https://www.amazon.com");
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("redmi");
            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click();
            Thread.sleep(500);
            //WebElement model = driver.findElement(By.xpath("//div[@class='product-card__content']/a[@href='https://allo.ua/ua/products/mobile/xiaomi-redmi-note-14-pro-8-256gb-midnight-black.html']"));
            //System.out.println(model.getText());
            System.out.println("found");
        }
    }


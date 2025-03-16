package org.prog.cucumber.steps_allo;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebStepsAllo {

    @Given("I using selenium go to alloua and search for a phone")
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
            System.out.println(model.getText());
            System.out.println("found");
        } finally {
            if (driver !=null){
                driver.quit();
            }
        }
    }
}

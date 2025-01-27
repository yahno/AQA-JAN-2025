package org.prog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDemo {

    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://google.com/");
            WebElement element = driver.findElement(By.name("q"));
            System.out.println(element.isDisplayed());
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}

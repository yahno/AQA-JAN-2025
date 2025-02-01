package org.prog;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_images_trulli");

            Thread.sleep(500);

            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30L));
            WebElement acceptCookiesButton =
                    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accept-choices")));
            acceptCookiesButton.click();

            System.out.println(acceptCookiesButton.getText());

            List<WebElement> imagesEmpty = driver.findElements(By.xpath("//img[@src='pic_trulli.jpg']"));

            WebElement iframe = driver.findElement(By.id("iframeResult"));
            driver.switchTo().frame(iframe);

            List<WebElement> imagesPresent = driver.findElements(By.xpath("//img[@src='pic_trulli.jpg']"));

            driver.switchTo().defaultContent();

//            WebElement shadowRootElement = driver.findElement(By.id("shadowRoot"));
//            SearchContext searchContext = shadowRootElement.getShadowRoot();

            System.out.println("done!");
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}

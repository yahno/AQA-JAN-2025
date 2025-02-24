package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.prog.cucumber.steps.SqlSteps;
import org.prog.cucumber.steps.WebSteps;
import org.prog.pages.GooglePage;
import org.prog.pages.W3SchoolsPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.prog.cucumber.steps",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private WebDriver driver;

    @BeforeSuite
    public void setUp() throws ClassNotFoundException, SQLException, MalformedURLException {
        this.driver = getRemoteDriver();
        WebSteps.w3SchoolsPage = new W3SchoolsPage(driver);
        Class.forName("com.mysql.cj.jdbc.Driver");
        SqlSteps.connection =
                DriverManager.getConnection("jdbc:mysql://mysql-db-1:3306/db", "user", "password");
    }

    @AfterSuite
    public void tearDown() throws SQLException {
        SqlSteps.connection.close();
        if (driver != null) {
            driver.quit();
        }
    }

    public WebDriver getRemoteDriver() throws MalformedURLException {
        return new RemoteWebDriver(
                new URL("http://selenoid-selenoid-1:4444/wd/hub"), new ChromeOptions());
    }
}
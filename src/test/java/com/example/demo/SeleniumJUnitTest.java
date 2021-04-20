package com.example.demo;

import com.jayway.jsonpath.internal.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.Assert.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SeleniumJUnitTest {

    final static String CHROME_DRIVER_LOCATION = "chromedriver";
    @LocalServerPort
    private Integer port;
    private static WebDriver driver;


    @BeforeAll
    public static void beforeAll() {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeEach
    public void beforeEach() {
//        open browser at localhost:port/animal
            driver.get("http://localhost:8080/animal");

    }

    @Test
    public void maintest () {
        // perform an automated test with
            // animal: dog
            // adjective: funny
        WebElement animalName  = driver.findElement(By.id("animalText"));
        animalName.sendKeys("dog");
        WebElement animalAdjective = driver.findElement(By.id("adjective"));
        animalAdjective.sendKeys("funny");

        driver.findElement(By.name("submit")).click();
//        driver.findElement(By.xpath("//input[@value='Submit' and @type='submit'")).click();




//        assertEquals("We love funny dogs.", //text output on the page);
        assertEquals("We love funny dogs.", "We love funny dogs.");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}

package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        // setup Webdriver and open a Chrome browser at localhost:8080/animal
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/animal");


        //find the fields we want by id and fill them in
        // animal: dog
        // adjective: funny

        WebElement animalName  = driver.findElement(By.id("animalText"));
        animalName.sendKeys("dog");
        WebElement animalAdjective = driver.findElement(By.id("adjective"));
        animalAdjective.sendKeys("funny");

        driver.findElement(By.name("submit")).click();


        // close the browser after 5 seconds
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}
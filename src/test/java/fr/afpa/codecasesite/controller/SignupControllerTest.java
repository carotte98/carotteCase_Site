package fr.afpa.codecasesite.controller;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * SeleniumConfig
 * <i>de fr.afpa.codecasesite.selenium</i>
 * <hr>
 * <p></p>
 *
 * @author Mordant Thierry
 * @version 0.0.1
 * @since 15/04/2026
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Disabled
 class SignupControllerTest {

    private WebDriver driver;
    URI uri;


    @BeforeAll
    void setup(){
//        ChromeOptions options = new ChromeOptions();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
    }

    @AfterAll
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    @Order(1)
    @Disabled
    void testCreateUserPage() {
        driver.get("http://localhost:9001/signup");

        driver.findElement(By.name("emailUser"))
                .sendKeys("test@mail.com");

        driver.findElement(By.name("passwordUser"))
                .sendKeys("1234");

        driver.findElement(By.name("pseudoUser"))
                .sendKeys("tester");

        driver.findElement(By.name("avatarUser"))
                .sendKeys("avatar.png");

        driver.findElement(By.tagName("form"))
                .submit();

        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        uri = URI.create(driver.getCurrentUrl());
        assertEquals("/", uri.getPath());
    }

    @Test
    @Order(2)
    @Disabled
    void testChangeUser() {
        driver.get("http://localhost:9001/espaceUser?userMail=test@mail.com");

        WebElement input = driver.findElement(By.name("pseudoUser"));
        input.clear();
        input.sendKeys("LeTester");

        driver.findElement(By.id("formSave"))
                .submit();

        driver.get("http://localhost:9001/espaceUser?userMail=test@mail.com");

        String value = driver.findElement(By.name("pseudoUser"))
                .getAttribute("value");

        assertEquals("LeTester", value);
    }

    @Test
    @Order(3)
    @Disabled
    void testUserSpace() {
        driver.get("http://localhost:9001/espaceUser?userMail=test@mail.com");

        driver.findElement(By.id("formDelete"))
                .submit();

        uri = URI.create(driver.getCurrentUrl());
        assertEquals("/", uri.getPath());
        System.out.println("Sortie");
    }

}

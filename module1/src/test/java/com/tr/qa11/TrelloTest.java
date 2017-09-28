package com.tr.qa11;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class TrelloTest {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void TrelloTest() {
        openSite();
        // wd.findElement(By.cssSelector("div.layout-centered")).click();
        wd.findElement(By.xpath(".//*[@href='/login?returnUrl=%2F']")).click();
        wd.findElement(By.id("user")).click();
        wd.findElement(By.id("user")).clear();
        wd.findElement(By.id("user")).sendKeys("jra220576@gmail.com");
        wd.findElement(By.id("password")).click();
        wd.findElement(By.id("password")).clear();
        wd.findElement(By.id("password")).sendKeys("z21051980z");
        wd.findElement(By.id("login")).click();
       // wd.findElement(By.xpath("//div[@class='header-user']/a[1]/span")).click();
      //  wd.findElement(By.linkText("Создание карточки Доска представляет собой совокупность карточек, упорядоченных в списках. Используйте её для управления проектом, отслеживания или организации чего угодно.")).click();
        wd.findElement(By.cssSelector("a.board-tile.mod-add")).click();
        wd.findElement(By.id("boardNewTitle")).click();
        wd.findElement(By.id("boardNewTitle")).clear();
        wd.findElement(By.id("boardNewTitle")).sendKeys("new1");
        wd.findElement(By.xpath("//div[5]/div/div[2]/div/div/div/form/input[3]")).click();
    }

    public void openSite() {
        wd.get("https://trello.com/");
    }

    @AfterMethod
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}

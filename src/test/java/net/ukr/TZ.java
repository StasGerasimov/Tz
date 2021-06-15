package net.ukr;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TZ {
    WebDriver chromeDriver;
    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        chromeDriver = new ChromeDriver();              //создаем обьект
        chromeDriver.manage().window().maximize();
    }

    @Test
    public void testOne () {
        chromeDriver.get("https://ukr.net");
        WebElement content = chromeDriver.findElement(By.cssSelector("#content"));          //ищем элемент
        Assert.assertTrue(content.isDisplayed());
    }

    @Test
    public void auth () {
        chromeDriver.get("https://ukr.net");
        WebElement content = chromeDriver.findElement(By.cssSelector("#content"));
        Assert.assertTrue(content.isDisplayed()); //assert = моментальная проверка
        WebElement signIn = chromeDriver.findElement(By.cssSelector("div.frontHero__signin button[title='Створити Скриньку']"));

        signIn.click();

        WebDriverWait wait = new WebDriverWait(chromeDriver,5); //проверяем await
        WebElement signIn1 = chromeDriver.findElement(By.cssSelector("div.modal__modal"));
        wait.until(ExpectedConditions.visibilityOf(signIn1));
        WebElement userName = chromeDriver.findElement(By.cssSelector("[name='username']"));
        userName.sendKeys("yourusername");
        WebElement emailEnter = chromeDriver.findElement(By.cssSelector("div.signinInitialStep button[title='Войти']"));

        emailEnter.click();

        WebElement passWord = chromeDriver.findElement(By.cssSelector("[name='password']"));
        wait.until(ExpectedConditions.visibilityOf(passWord));
        passWord.sendKeys("yourpassword");
        WebElement signInButton = chromeDriver.findElement(By.cssSelector("div.signinWithPassword button[title='Войти']"));

        signInButton.click();

    }

    @After
    public void setDown (){
        chromeDriver.quit();
    }
}




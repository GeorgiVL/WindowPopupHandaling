package com.handling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class fileUpload {
    public static void main(String[] args) throws InterruptedException, IOException {

        String downloadPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", "D://Selenium//chromedriver.exe");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        ChromeOptions opt = new ChromeOptions();
        opt.setExperimentalOption("prefs",chromePrefs);

        WebDriver driver = new ChromeDriver(opt);
        driver.get("https://altoconvertpdftojpg.com/");
        driver.findElement(By.cssSelector("#dropzoneInput-label")).click();
        Thread.sleep(3000);
        Runtime.getRuntime().exec("C://Users//Valka//OneDrive//Документи//fileUpload//fileuploadc.exe");

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".g-btn.g-btn--primary.g-btn--medium")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
        driver.findElement(By.cssSelector(".g-btn.g-btn--primary.g-btn--medium")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download")));
        driver.findElement(By.linkText("Download")).click();

        Thread.sleep(5000);
        File f = new File(downloadPath + "//Result.zip");
        if (f.exists()) {
            System.out.println("File is found");
            f.delete();
        }


    }
}

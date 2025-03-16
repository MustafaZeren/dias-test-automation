package com.zeren.hepsiburada.utils;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Helper {
    private static final Logger logger = Logger.getLogger(Helper.class.getName());
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    public Helper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void navigateTo(String url) {
        driver.get(url);
        logger.info("Navigated to URL: " + url);
        Assert.assertEquals("Navigation failed!", url, driver.getCurrentUrl());
    }

    public WebElement find(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            logger.info("Element found: " + locator);
            Assert.assertNotNull("Element should not be null!", element);
            return element;
        } catch (TimeoutException e) {
            logger.log(Level.SEVERE, "Element not found: " + locator, e);
            throw e;
        }
    }

    public void isTextPresent(String text) {
        boolean present = driver.getPageSource().contains(text);
        logger.info("Text presence check: " + text + " | Found: " + present);
        Assert.assertTrue("Expected text not found on page!", present);
    }

    public List<WebElement> findAll(By locator) {
        try {
            List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            logger.info("Elements found: " + locator);
            Assert.assertFalse("Expected elements were not found!", elements.isEmpty());
            return elements;
        } catch (TimeoutException e) {
            logger.log(Level.SEVERE, "Elements not found: " + locator, e);
            throw e;
        }
    }

    public void click(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            logger.info("Clicked on element: " + locator);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Click failed: " + locator, e);
        }
    }

    public void type(By locator, String text) {
        try {
            WebElement element = find(locator);
            element.clear();
            element.sendKeys(text);
            logger.info("Typed text into element: " + locator + " | Text: " + text);
            Assert.assertEquals("Text input mismatch!", text, element.getAttribute("value"));
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Typing failed: " + locator, e);
        }
    }

    public void isDisplayed(By locator) {
        boolean displayed = find(locator).isDisplayed();
        logger.info("Element visibility check: " + locator + " | Visible: " + displayed);
        Assert.assertTrue("Element should be displayed!", displayed);
    }

    public void scrollToElement(By locator) {
        try {
            WebElement element = find(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            logger.info("Scrolled to element: " + locator);
            Assert.assertTrue("Element should be visible after scrolling!", element.isDisplayed());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Scrolling failed: " + locator, e);
        }
    }

    public void hoverOver(By locator) {
        try {
            WebElement element = find(locator);
            actions.moveToElement(element).perform();
            logger.info("Hovered over element: " + locator);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Hover failed: " + locator, e);
        }
    }

    public String getTitle() {
        String title = driver.getTitle();
        logger.info("Page title retrieved: " + title);
        Assert.assertNotNull("Page title should not be null!", title);
        return title;
    }

    public void refreshPage() {
        try {
            driver.navigate().refresh();
            logger.info("Page refreshed.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Page refresh failed.", e);
        }
    }
}

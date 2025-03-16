package com.zeren.hepsiburada.pages.MainPage;

import com.zeren.hepsiburada.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.zeren.hepsiburada.pages.CategoryPage.Constants.CATEGORY_PAGE_TITLE;
import static com.zeren.hepsiburada.pages.MainPage.Constants.*;

public class MainPage {
    private final Helper helper;


    public MainPage(WebDriver driver) {
        this.helper = new Helper(driver);
    }

    public void navigateToMainPage() {
        helper.navigateTo(BASE_URL);
    }

    public void navigateToSpecificSubCategory() {
        By category1Locator = By.xpath("(//li/span/..)[1]");
        By category2Locator = By.xpath("((//li/span/..)[1]/div/div/div/div/ul/li/a)[1]");
        By category3Locator = By.xpath("((//li/span/..)[1]/div/div/div/div/ul/li/div/ul/li/ul[2]/li/a)[1]");
        helper.refreshPage();
        helper.isDisplayed(category1Locator);
        helper.hoverOver(category1Locator);
        helper.isDisplayed(category2Locator);
        helper.hoverOver(category2Locator);
        helper.isDisplayed(category3Locator);
        helper.click(category3Locator);

        Assert.assertTrue("The title: " + helper.getTitle() + " | Should contain " + CATEGORY_PAGE_TITLE,
                helper.getTitle().contains(CATEGORY_PAGE_TITLE));
    }
}

package com.zeren.hepsiburada.pages.CartPage;

import com.zeren.hepsiburada.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.zeren.hepsiburada.pages.CategoryPage.CategoryPage.mostExpensiveProductPrice;

public class CartPage {
    private final Helper helper;
    public CartPage(WebDriver driver) {
        this.helper = new Helper(driver);
    }


    public void checkPriceFromCart() {
        helper.find(By.xpath("//div[contains(text(), '"+mostExpensiveProductPrice+"')]"));
    }
}

package com.zeren.hepsiburada.pages.ProductPage;

import com.zeren.hepsiburada.pages.CartPage.CartPage;
import com.zeren.hepsiburada.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.zeren.hepsiburada.pages.ProductPage.Constants.PRODUCT_ADD_TO_CART_BUTTON_XPATH;
import static com.zeren.hepsiburada.pages.ProductPage.Constants.PRODUCT_GO_TO_CART_BUTTON_XPATH;

public class ProductPage {
    private final Helper helper;

    public ProductPage(WebDriver driver) {
        this.helper = new Helper(driver);
    }

    public void addToCart() {
        helper.click(By.xpath(PRODUCT_ADD_TO_CART_BUTTON_XPATH));
    }
    public void goToCart() {
        helper.click(By.xpath(PRODUCT_GO_TO_CART_BUTTON_XPATH));
    }
}

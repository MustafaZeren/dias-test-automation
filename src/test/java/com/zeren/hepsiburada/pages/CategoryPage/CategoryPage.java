package com.zeren.hepsiburada.pages.CategoryPage;

import com.zeren.hepsiburada.utils.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static com.zeren.hepsiburada.pages.CategoryPage.Constants.PRODUCT_PRICE_XPATH;

public class CategoryPage {
    private final WebDriver driver;
    private final Helper helper;
    public static String mostExpensiveProductPrice;
    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.helper = new Helper(driver);
    }

    public void clickSpecificCategory(String category) {
        WebElement appleCategory =helper.find(By.xpath("//label/div/a[text()='"+category+"']/../../input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", appleCategory);
        helper.refreshPage();
    }

    public void findAndClickMostExpensiveProduct() {
        List<WebElement> priceElements = helper.findAll(By.xpath(PRODUCT_PRICE_XPATH));
        List<Double> prices = new ArrayList<>();
        double maxPrice = Double.MIN_VALUE;

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("TL", "").trim();
            try {
                double price = Double.parseDouble(priceText.replace(".", "").replace(",", ".")); // Sayıya çevir
                prices.add(price);
                if (price > maxPrice) {
                    maxPrice = price;
                }
            } catch (NumberFormatException e) {
            }
        }

        if (!prices.isEmpty()) {
            DecimalFormat df = new DecimalFormat("#,###");
            String formattedPrice = df.format(maxPrice).replace(",", ".");
            System.out.println("En pahalı ürünün fiyatı: " + formattedPrice + " TL");
            mostExpensiveProductPrice=formattedPrice;
            WebElement mostExpensiveProduct = helper.find(By.xpath("//div[contains(text(), '" + formattedPrice + "')]/../../../.."));
            String fullUrl;
            fullUrl = mostExpensiveProduct.getAttribute("href");
            System.out.println("Ürün URL: " + fullUrl);
            helper.navigateTo(fullUrl);
            helper.isTextPresent(formattedPrice);
        } else {
            System.out.println("Fiyatlar bulunamadı.");
        }
    }
}

package com.zeren.hepsiburada.steps;

import com.zeren.hepsiburada.pages.CartPage.CartPage;
import com.zeren.hepsiburada.pages.CategoryPage.CategoryPage;
import com.zeren.hepsiburada.pages.MainPage.MainPage;
import com.zeren.hepsiburada.pages.ProductPage.ProductPage;
import com.zeren.hepsiburada.tests.BaseTest;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HepsiBuradaSteps extends BaseTest {
    private MainPage mainPage;
    private CategoryPage categoryPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Before
    public void setup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        categoryPage = new CategoryPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }
    @Given("Open main page")
    public void navigateToMainPage() {
        mainPage.navigateToMainPage();
    }

    @When("Navigate to category")
    public void navigateToCategory() {
        mainPage.navigateToSpecificSubCategory();
    }

    @When("Select {string} category from left side menu")
    public void selectCategoryFromLeftSideMenu(String category) {
        categoryPage.clickSpecificCategory(category);
    }

    @When("Find the most expensive product")
    public void findAndClickMostExpensiveProduct() {
        categoryPage.findAndClickMostExpensiveProduct();
    }

    @When("Add to cart")
    public void addToCart() {
        productPage.addToCart();
    }

    @When("Go to cart")
    public void goToCart() {
        productPage.goToCart();
    }

    @Then("Check price from the cart")
    public void checkPriceFromCart() {
        cartPage.checkPriceFromCart();
    }
}

package com.nttdata.steps;

import com.nttdata.screens.SauceLoginScreen;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.android.AndroidElement;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;

public class SuaceLabsLoginSteps {
    SauceLoginScreen login;

@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc=\"App logo and name\"]")
private WebElement logoLabel;

@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/productRV")
private WebElement products;

@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/plusIV")
private WebElement increaseButton;

@AndroidFindBy(id="com.saucelabs.mydemoapp.android:id/cartBt")
private WebElement AddToCartButton;

@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Displays number of items in your cart']")
private WebElement cartButton;



 ////////////////////////////////////
    public void validoSauceLabs() {
        login.validoapp();}


    public void validoCargaCorrectaProductos() {
        login.validocarga();}



    public void validoAgregarUnidsyProducto(int unidades, String producto) {
        login.validounidsyprod(unidades,producto);}


    public void validoCarritoActualizado() {
        login.validocarrito();}



    }


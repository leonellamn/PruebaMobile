package com.nttdata.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.cucumber.java.en.Given;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;

public class SauceLoginScreen extends PageObject {

    // Constructor por defecto
    public SauceLoginScreen() {
    }
    private int expectedCartQuantity = 0;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/header")
    private WebElement logoLabel;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV")
    private WebElement products;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement increaseButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement AddToCartButton;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='Displays number of items in your cart']")
    private WebElement cartButton;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement quantity;


    public void validoapp() {
        if (logoLabel == null) {
            throw new NullPointerException("logoLabel no está inicializado.");
        }

        System.out.println("Esperando que la aplicación cargue...");
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(logoLabel));
        System.out.println("La aplicación ha cargado.");
    }


    public void validocarga() {
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        wait.until(ExpectedConditions.visibilityOf(products));
    }


    public void validounidsyprod(int unidades, String producto) {
        WebDriverWait wait = new WebDriverWait(getDriver(),5);

        // 1. Hacer clic en el producto
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[@content-desc='" + producto + "']")));
        product.click();

        // 2. Esperar que cargue la pantalla del producto
        WebElement productDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.saucelabs.mydemoapp.android:id/productTV")));

        // 3. Incrementar las unidades si es necesario
        if (unidades > 1) {
            // Utiliza el botón de incremento ya declarado
            for (int i = 1; i < unidades; i++) { // Por defecto ya hay 1 unidad
                increaseButton.click();
            }  }

        // 4. Hacer clic en el botón "Add to cart"
        AddToCartButton.click();

        // Actualizar la cantidad esperada
        expectedCartQuantity += unidades;
    }

    public void validocarrito() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);

        cartButton.click();

        // Esperar a que el badge del carrito sea visible
        WebElement cartBadgeElement = wait.until(ExpectedConditions.visibilityOf(quantity));

        // Obtener el texto del badge (debería ser la cantidad de productos en el carrito)
        String cartQuantity = cartBadgeElement.getText();

        // Añadir registro para depuración
        System.out.println("Cantidad en el carrito: " + cartQuantity);

        // Comparar la cantidad obtenida con la cantidad esperada
        assertEquals(String.valueOf(expectedCartQuantity), cartQuantity);

    }
    }























    //@AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    //    private WebElement txtUsuario;
    //
    //    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    //    private WebElement txtPassword;
    //
    //    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    //    private WebElement btnLogin;
    //
    //    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    //    private WebElement tituloApp;

    //@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Item\"]")
    //private List<WebElement> lista2;

    //public void ingresarUsuario(String texto){
    //        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    //        wait.until(ExpectedConditions.elementToBeClickable(txtUsuario));
    //
    //        waitFor(ExpectedConditions.elementToBeClickable(txtUsuario));
    //
    //
    //        txtUsuario.sendKeys(texto);
    //    }
    //
    //    public void esperarElemento(WebElement elemento){
    //        waitFor(ExpectedConditions.elementToBeClickable(elemento));
    //    }
    //
    //    public void ingresarClave(String arg0) {
    //        txtPassword.sendKeys(arg0);
    //    }
    //
    //    public void ingresar() {
    //        btnLogin.click();
    //    }
    //    public int getCountElements(){
    //        //List<WebElement> lista = getDriver().findElements(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Item\"]"));
    //        return lista2.size();
    //    }
    //
    //
    //    public String getTitulo() {
    //        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
    //        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")));
    //
    //        //WebElement titulo2 = getDriver().findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"));
    //
    //        //return titulo2.getText();
    //        return tituloApp.getText();
    //
    //
    //    }


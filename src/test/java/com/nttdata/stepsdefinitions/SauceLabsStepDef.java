package com.nttdata.stepsdefinitions;

import com.nttdata.screens.SauceLoginScreen;
import com.nttdata.steps.SuaceLabsLoginSteps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static java.sql.DriverManager.getDriver;

public class SauceLabsStepDef {
    @Steps
    SuaceLabsLoginSteps login;

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
            login.validoSauceLabs();
    }

        @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        login.validoCargaCorrectaProductos();
    }

    @When("agrego unidades {int} del siguiente producto {string}")
    public void agregoUnidadesDelSiguienteProducto(int unidades, String producto) {
        login.validoAgregarUnidsyProducto(unidades,producto);
    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        login.validoCarritoActualizado();
    }
}

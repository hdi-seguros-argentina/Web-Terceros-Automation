package steps;

import com.core.utility.MasterPage;
import io.cucumber.java.en.*;
import pages.HomePage;

public class HomeSteps {
    HomePage homePage = new HomePage();

    @Given("el usuario ingresa a la home")
    public void elUsuarioIngresaALaHome() {
        MasterPage.openUrl();
    }

    @Then("el usuario verifica que el encabezado es correcto")
    public void elUsuarioVerificaQueElEncabezadoEsCorrecto() {
        homePage.verificarTextoEncabezado();
    }

    @And("el usuario verifica que el titulo {string} es correcto")
    public void elUsuarioVerificaQueElTituloEsCorrecto(String arg0) {
        homePage.verificarTitulo(arg0);
    }

    @And("el usuario verifica que el boton {string} es correcto")
    public void elUsuarioVerificaQueElBotonEsCorrecto(String arg0) {
        homePage.verificarBoton(arg0);
    }

    @When("el usuario selecciona {string}")
    public void elUsuarioSelecciona(String arg0) {
        homePage.verificarSeleccion(arg0);
    }

    @And("el usuario verifica que el boton {string} de {string} es correcto")
    public void elUsuarioVerificaQueElBotonDeEsCorrecto(String arg0, String arg1) {
        homePage.verificarEstiloBoton(arg0);
    }

    @And("el usuario verifica que la descripcion de {string} es correcta")
    public void elUsuarioVerificaQueLaDescripcionDeEsCorrecta(String arg0) {
        homePage.VerificarDescripcion(arg0);
    }

    @And("el usuario hace clic en {string}")
    public void elUsuarioHaceClicEn(String arg0) {
        homePage.clicBoton(arg0);
    }

    @Then("el usuario verifica que el campo {string} es correcto")
    public void elUsuarioVerificaQueElCampoEsCorrecto(String arg0) {
        homePage.verificarCampos(arg0);
    }

    @Then("el usuario verifica que el titulo {string} de {string} es correcto")
    public void elUsuarioVerificaQueElTituloDeEsCorrecto(String arg0, String arg1) {
        homePage.verificarTituloDeTipoDeDaño(arg0);
    }

    @Then("el usuario verifica que los elementos del footer son visibles y correctos")
    public void elUsuarioVerificaQueLosElementosDelFooterSonVisiblesYCorrectos() {
        homePage.verificarFooter();
    }

    @Then("el usuario ingresa un dato en el campo {string}")
    public void elUsuarioIngresaUnDatoEnElCampo(String arg0) {
        homePage.elUsuarioIngresaUnDato(arg0);
    }

    @Then("el usuario verifica que el mensaje de error es correcto")
    public void elUsuarioVerificaQueElMensajeDeErrorEsCorrecto() {
        homePage.elUsuarioVerificaQueElMensajeDeErrorEsCorrecto();
    }

    @And("el usuario ingresa un dato correcto en el campo {string} en {string}")
    public void elUsuarioIngresaUnDatoCorrectoEnElCampoEn(String arg0, String arg1) {
        homePage.ingresaUnDatoCorrecto(arg0, arg1);
    }

    @Then("el usuario verifica que el sistema muestra el resultado de búsqueda correctamente para {string}")
    public void elUsuarioVerificaQueElSistemaMuestraElResultadoDeBúsquedaCorrectamentePara(String arg0) {
        homePage.verificaBusquedaCorrecta(arg0);
    }
}
package pages;

import com.core.utility.MasterPage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

import static locators.HomeLocators.*;

public class HomePage extends MasterPage {
    SoftAssertions softAssertions = new SoftAssertions();
    public static final String COLOR_NEGRO = "rgb(0, 0, 0)";
    public static final String COLOR_NEGRO2 = "rgba(0, 0, 0, 0.88)";
    public static final String COLOR_GRIS = "rgba(0, 0, 0, 0.12)";
    public static final String COLOR_GRIS2 = "rgb(99, 99, 99)";
    public static final String COLOR_GRIS3 = "rgb(245, 245, 245)";
    public static final String COLOR_BLANCO = "rgb(255, 255, 255)";
    public static final String COLOR_TRANSPARENTE = "rgba(0, 0, 0, 0)";
    public static final String COLOR_1 = "rgb(227, 32, 94)";     //Magenta
    public static final String COLOR_7 = "rgb(232, 69, 121)";    //Magenta claro
    public static final String COLOR_8 = "rgb(217, 217, 217)";   //Gris claro
    public static final String COLOR_3 = "rgb(0, 91, 187)";      //Azul
    public static final String COLOR_GRIS_FONDO_TEMA = "rgb(250, 250, 250)";
    public static final String COLOR_GRIS_TEXTO_TEMA = "rgb(157, 157, 157)";
    public static final String COLOR_NARANJA = "rgb(219, 99, 1)";
    public static final String FUENTE_BASE = "Montserrat";

    public void verificarTextoEncabezado() {
        auto_verifyVisibility(ENCABEZADO_IMG_XPATH);
    }

    public void verificarTitulo(String arg0) {
        auto_waitForElementVisibility(String.format(TITULO_HOME_XPATH, arg0));
        auto_verifyVisibility(String.format(TITULO_HOME_XPATH, arg0));
        Locator boton = page.get().locator(String.format(TITULO_HOME_XPATH, arg0));
        auto_verificarEstilos(boton, COLOR_NEGRO, "rgb(225, 225, 225)", COLOR_TRANSPARENTE, FUENTE_BASE);
    }

    public void verificarBoton(String arg0) {
        Locator boton = page.get().locator(String.format(SELECCION_ESTILO_XPATH, arg0));

        auto_verificarEstilos(boton, COLOR_GRIS2, COLOR_GRIS, COLOR_BLANCO, FUENTE_BASE);

        boton.click();

        auto_verificarEstilos(boton, COLOR_NEGRO, COLOR_1, COLOR_GRIS3, FUENTE_BASE);
    }

    public void verificarSeleccion(String arg0) {
        auto_verifyVisibility(String.format(SELECCION_HOME_XPATH, arg0));
        auto_setClickElement(String.format(SELECCION_HOME_XPATH, arg0));
    }

    public void verificarEstiloBoton(String arg0) {
        Locator boton = (arg0.equalsIgnoreCase("VOLVER") || arg0.equalsIgnoreCase("BUSCAR") || arg0.equalsIgnoreCase("Aceptar"))
                ? page.get().locator(String.format(BOTON2_ESTILO_GENERIC_XPATH, arg0))
                : page.get().locator(String.format(BOTON_ESTILO_GENERIC_XPATH, arg0));

        auto_verificarEstilos(boton, COLOR_BLANCO, COLOR_BLANCO, COLOR_3, "Arial");

        boton.hover();

        auto_verificarEstilos(boton, COLOR_BLANCO, COLOR_BLANCO, "rgb(112, 48, 160)", "Arial");
    }

    public void VerificarDescripcion(String arg0) {
        String contenido = page.get().locator(TABLA_INFODOCS_XPATH).first().innerText();
        Map<String, List<String>> docs = Map.of(
                "Daños Materiales", List.of(
                        "DENUNCIA RECLAMO DE TERCEROS DE HDI COMPLETO",
                        "CBU",
                        "CERTIFICADO DE COBERTURA O CONSTANCIA DE NO SEGURO",
                        "CONSTANCIA DE CUIL/CUIT",
                        "DNI - FRENTE",
                        "DNI - DORSO",
                        "PRESUPUESTO",
                        "REGISTRO DE CONDUCIR - FRENTE",
                        "REGISTRO DE CONDUCIR - DORSO",
                        "TITULO DE PROPIEDAD - FRENTE",
                        "TITULO DE PROPIEDAD - DORSO",
                        "FOTOS DAÑOS"
                ),
                "Lesiones", List.of(
                        "DENUNCIA RECLAMO DE TERCEROS DE HDI COMPLETO",
                        "CBU",
                        "CERTIFICADO MEDICO",
                        "CONSTANCIA DE CUIL/CUIT",
                        "DNI - FRENTE",
                        "DNI - DORSO"
                ),
                "Otros", List.of(
                        "DENUNCIA RECLAMO DE TERCEROS DE HDI COMPLETO",
                        "CBU",
                        "CONSTANCIA DE CUIL/CUIT",
                        "DENUNCIA ADMINISTRATIVA O CONSTANCIA DE NO SEGURO",
                        "DNI - FRENTE",
                        "DNI - DORSO",
                        "ESCRITURA Y/O CONTRATO DE ALQUILER",
                        "PRESUPUESTO",
                        "FOTOS DAÑOS"
                )
        );
        docs.get(arg0).forEach(txt ->
                softAssertions.assertThat(contenido)
                        .as("Falta: " + txt + " en " + arg0)
                        .contains(txt)
        );
        softAssertions.assertAll();
    }

    public void clicBoton(String arg0) {
        auto_setClickElement(String.format(BOTON_GENERIC_XPATH, arg0));
    }

    public void verificarTituloDeTipoDeDaño(String arg0) {
        auto_verifyVisibility(String.format(TITULO_TIPODAÑO_XPATH, arg0));
    }

    public void verificarCampos(String arg0) {
        auto_waitForElementVisibility(String.format(INPUT_ESTILO_GENERIC_XPATH, arg0));
        Locator input = page.get().locator(String.format(INPUT_ESTILO_GENERIC_XPATH, arg0));

        auto_verificarEstilos(input, "rgba(0, 0, 0, 0.6)", "rgb(225, 225, 225)", COLOR_TRANSPARENTE, "Roboto, sans-serif");

        input.click();

        auto_verificarEstilos(input, "rgba(63, 81, 181, 0.87)", "rgb(225, 225, 225)", COLOR_TRANSPARENTE, "Roboto, sans-serif");
    }

    public void verificarFooter() {
        Map<String, String> elementos = Map.of(
                "empresa", FOOTER_EMPRESA_XPATH,
                "direccion", FOOTER_DIRECCION_XPATH,
                "servicio", FOOTER_SERVICIO_ATENCION_XPATH,
                "privacidad", FOOTER_POLITICA_PRIVACIDAD_XPATH,
                "cookies", FOOTER_POLITICA_COOKIES_XPATH
        );

        elementos.values().forEach(xpath -> {
            auto_verifyVisibility(xpath);
            Locator elemento = page.get().locator(xpath);
            auto_verificarEstilos(
                    elemento,
                    COLOR_NEGRO,
                    "rgb(225, 225, 225)",
                    COLOR_TRANSPARENTE,
                    "montserrat"
            );
        });
        auto_verifyVisibility(FOOTER_INSTITUCIONAL_XPATH);
        Locator footerInstitucional = page.get().locator(FOOTER_INSTITUCIONAL_XPATH);
        auto_verificarEstilos(
                footerInstitucional,
                COLOR_BLANCO,
                "rgb(224, 36, 94)",
                "rgb(35, 31, 32)",
                "montserrat"
        );
    }

    public void elUsuarioIngresaUnDato(String arg0) {
        String xpath = String.format(INPUT_GENERIC_XPATH, arg0);
        String valor;

        if (arg0.toLowerCase().contains("patente")) {
            valor = "ABC123";
        } else if (arg0.toLowerCase().contains("fecha")) {
            valor = java.time.LocalDate.now()
                    .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else {
            valor = "Dato de prueba";
        }
        auto_setTextToInput(xpath, valor);
    }

    public void elUsuarioVerificaQueElMensajeDeErrorEsCorrecto() {
        auto_waitForElementVisibility(MODAL_ERROR_ICONO_XPATH);
        auto_verifyVisibility(MODAL_ERROR_ICONO_XPATH);
        auto_waitForElementVisibility(MODAL_ERROR_TEXTO_XPATH);
        auto_verifyVisibility(MODAL_ERROR_TEXTO_XPATH);
    }

    public void ingresaUnDatoCorrecto(String arg0, String arg1){
        String xpath = String.format(INPUT_GENERIC_XPATH, arg0);
        String valor = "";

        switch (arg1.toLowerCase()) {
            case "daños materiales":
                if (arg0.toLowerCase().contains("patente")) {
                    valor = "KRD524";
                } else if (arg0.toLowerCase().contains("fecha")) {
                    valor = "25/09/2025";
                }
                break;

            case "lesiones":
                if (arg0.toLowerCase().contains("patente")) {
                    valor = "AD786HK";
                } else if (arg0.toLowerCase().contains("fecha")) {
                    valor = "22/09/2025";
                }
                break;

            case "otros":
                if (arg0.toLowerCase().contains("patente")) {
                    valor = "AD786HK";
                } else if (arg0.toLowerCase().contains("fecha")) {
                    valor = "22/09/2025";
                }
                break;

            default:
                valor = "Dato de prueba";
        }
        auto_setTextToInput(xpath, valor);
    }

    public void verificaBusquedaCorrecta(String arg0){
        auto_waitForElementVisibility(TITULO_DATOS_CONTACTO_XPATH);
        auto_waitForElementVisibility(TITULO_DOCUMENTACION_XPATH);
    }
}
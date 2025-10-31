package locators;

public class HomeLocators {
    public static final String ENCABEZADO_IMG_XPATH = "//img[contains(@src,'Tuve-un-siniestro')]";
    public static final String TITULO_HOME_XPATH = "//*[text()='%s']";
    public static final String SELECCION_ESTILO_XPATH = "//*[text()=' %s ']/ancestor::mat-card[contains(@class,'menuBoton')]";
    public static final String SELECCION_HOME_XPATH = "//*[text()=' %s ']";
    public static final String TABLA_INFODOCS_XPATH = "//table[contains(@class, 'tablaInfoDocs')]";
    public static final String BOTON_GENERIC_XPATH = "//*[contains(text(), '%s')]";
    public static final String BOTON_ESTILO_GENERIC_XPATH = "//*[contains(text(), '%s')]/parent::*";
    public static final String BOTON2_ESTILO_GENERIC_XPATH = "//button[contains(text(), '%s')]";
    public static final String INPUT_GENERIC_XPATH = "//*[text()='%s']";
    public static final String INPUT_ESTILO_GENERIC_XPATH = "//*[text()='%s']/parent::*";
    public static final String TITULO_TIPODAÑO_XPATH = "//p[contains(text(), '%s')]";
    public static final String FOOTER_EMPRESA_XPATH = "//span[contains(text(),'BARBUSS RISK SEGUROS (ARGENTINA) S.A.')]";
    public static final String FOOTER_DIRECCION_XPATH = "//p[contains(.,'Tte. Gral. Juan D. Perón 650')]";
    public static final String FOOTER_SERVICIO_ATENCION_XPATH = "//a[contains(text(),'Servicio de atención al asegurado')]";
    public static final String FOOTER_POLITICA_PRIVACIDAD_XPATH = "//a[contains(text(),'Política de privacidad')]";
    public static final String FOOTER_POLITICA_COOKIES_XPATH = "//span[contains(text(),'Política de cookies')]";
    public static final String FOOTER_INSTITUCIONAL_XPATH = "//div[contains(@class,'barbuss-footer')]";
    public static final String MODAL_ERROR_ICONO_XPATH = "//img[contains(@class,'imgError') and contains(@src,'assets/error.png')]";
    public static final String MODAL_ERROR_TEXTO_XPATH = "//div[contains(@class,'alignCenter') and contains(text(),'Los datos ingresados no corresponden')]";
    public static final String TITULO_DATOS_CONTACTO_XPATH = "//p[contains(text(),'Datos de contacto')]";
    public static final String TITULO_DOCUMENTACION_XPATH = "//p[contains(text(),'Adjuntar documentación del siniestro')]";


}
package com.core.utility;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.MouseButton;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import com.core.hooks.Hooks;
import org.assertj.core.api.SoftAssertions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;

public abstract class MasterPage extends Hooks {
    private static final Dotenv dotenv = Dotenv.load();

    SoftAssertions softAssertions = new SoftAssertions();

    public static void auto_openURLInBrowser(){
        try {
            page.get().navigate(System.getProperty("applicationUrl"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void auto_openNewURLInBrowser(String url){
        try {
            page.get().navigate(url);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void openUrl(){
        try {
            page.get().navigate(dotenv.get("NAVIGATE_URL"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String auto_getCurrentUrl(){
        return page.get().url();
    }

    public static String auto_getPageTitle(){
        return page.get().title();
    }

    public static void auto_setClickElement(String locator){
        page.get().click(locator);
    }

    public static void auto_setDoubleClickElement(String locator){
        page.get().dblclick(locator);
    }

    public static void auto_setClickElementAndHold(String locator){
        page.get().locator(locator).click((new Locator.ClickOptions()
                .setButton(MouseButton.RIGHT)
                .setDelay(5000)));
    }

    public static void auto_setTextToInput(String locator, String value){
        page.get().locator(locator).clear();
        page.get().fill(locator, value);
    }

    public static void auto_setTextToInputWithoutClear(String locator, String value){
        page.get().fill(locator, value);
    }

    public static void auto_clearInput(String locator){
        page.get().locator(locator).clear();
    }

    public static String auto_getElementText(String locator){
        return page.get().locator(locator).textContent();
    }

    public static String auto_getInputValue(String locator){
        return page.get().locator(locator).inputValue();
    }

    public static void auto_selectCheckbox(String locator){
        page.get().locator(locator).isVisible();
        if (!page.get().locator(locator).isChecked()){
            page.get().locator(locator).check();
        }
    }

    public static void auto_deselectCheckbox(String locator){
        page.get().locator(locator).isVisible();
        if (page.get().locator(locator).isChecked()){
            page.get().locator(locator).uncheck();
        }
    }

    public static boolean auto_isElementVisible(String locator){
        return page.get().locator(locator).isVisible();
    }

    public static boolean auto_isInputEmpty(String locator){
        return page.get().locator(locator).getAttribute("value").isEmpty();
    }

    public static void auto_waitForElementPresent(String locator){
        page.get().locator(locator).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.ATTACHED));
    }

    public static void auto_waitForElementVisibility(String locator){
        page.get().locator(locator).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(50000));
    }

    public static void auto_waitForElementInvisibility(String locator){
        page.get().locator(locator).waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.HIDDEN).setTimeout(50000));
    }

    public static void auto_setTextToClipboard(String value){
        StringSelection stringSelection = new StringSelection(value);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, (ClipboardOwner)null);
    }

    public static boolean auto_isElementEnabled(String locator){
        return page.get().locator(locator).isEnabled();
    }

    public static boolean auto_isElementEditable(String locator){
        return page.get().locator(locator).isEditable();
    }

    public static String auto_getAttribute(String locator, String attribute){
        return page.get().locator(locator).getAttribute(attribute);
    }

    public static void auto_HoverElement(String locator){
        page.get().locator(locator).hover();
    }

    public static void auto_ScrollToElement(String locator){
        page.get().locator(locator).scrollIntoViewIfNeeded();
    }

    public static void auto_scrollToElementJS(int x, int y) {
        page.get().evaluate("window.scrollBy(" + x + ", " + y + ");");
    }

    public static void auto_switchToIframe(String iFrame){
        page.get().frameLocator(iFrame);
    }

    public static void auto_goBack(){
        page.get().goBack();
    }

    public static void auto_sendKeys(String locator, String key){
        page.get().locator(locator).press(key);
    }

    public static void auto_selectOptionFromLabel(String locator,String value){
        ElementHandle select = page.get().querySelector(locator);
        select.selectOption(new SelectOption().setLabel(value));
    }

    public static void auto_selectOptionFromIndex(String locator,int value){
        ElementHandle select = page.get().querySelector(locator);
        select.selectOption(new SelectOption().setIndex(value));
    }

    public static void auto_selectOptionFromValue(String locator,String value){
        ElementHandle select = page.get().querySelector(locator);
        select.selectOption(new SelectOption().setValue(value));
    }

    public void auto_verifyVisibility(String locator) {
        softAssertions.assertThat(page.get().isVisible(locator))
                .as("El elemento no es visible [%s]", locator).isTrue();
    }

    public void auto_verifyVisibilities(String... locators){
        for (String locator : locators) {
            auto_waitForElementVisibility(locator);
            softAssertions.assertThat(locator).as("El elemento no se visualiza correctamente").isVisible();
        }
        softAssertions.assertAll();
    }

    public void auto_verifyInvisibilities(String... locators){
        for (String locator : locators) {
            auto_waitForElementInvisibility(locator);
            softAssertions.assertThat(auto_isElementVisible(locator)).as("El elemento no es invisible").isFalse();
        }
        softAssertions.assertAll();
    }

    public void auto_waitForLoadStates(LoadState loadState){
        try {
            page.get().waitForLoadState(loadState);
        } catch (Exception e) {
            System.err.println(STR."Error al esperar el estado de carga: \{e.getMessage()}");
        }
    }

    protected String auto_getCssValue(Locator locator, String property) {
        return locator.evaluate(
                "(el, prop) => window.getComputedStyle(el).getPropertyValue(prop)",
                property
        ).toString().trim();
    }

    public void auto_verificarEstilos(Locator locator, String color, String borderColor, String backgroundColor, String textFont){
        page.get().waitForTimeout(700);

        String colorValue = auto_getCssValue(locator,"color");
        String borderColorValue = auto_getCssValue(locator,"border-color");
        String backgroundColorValue = auto_getCssValue(locator,"background-color");
        String textFontValue = auto_getCssValue(locator,"font-family");

        softAssertions.assertThat(colorValue).as("Color de texto elemento " + locator + " incorrecto").isEqualTo(color);
        softAssertions.assertThat(borderColorValue).as("Borde elemento " + locator + " incorrecto").isEqualTo(borderColor);
        softAssertions.assertThat(backgroundColorValue).as("Background elemento " + locator + " incorrecto").isEqualTo(backgroundColor);
        softAssertions.assertThat(textFontValue).as("Fuente elemento " + locator + " incorrecta").contains(textFont);
        softAssertions.assertAll();
    }

    public void auto_verificarIconos(String xpath, String colorEsperado) {
        page.get().waitForTimeout(500);

        List<Locator> iconos = page.get().locator(xpath).all();
        for (int i = 0; i < iconos.size(); i++) {
            Locator icono = iconos.get(i);
            softAssertions.assertThat(auto_getCssValue(icono, "color"))
                    .as("Color de icono en posición [" + i + "] incorrecto")
                    .isEqualTo(colorEsperado);
        }
        softAssertions.assertAll();
    }
}
package com.PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;

public class MainPage {
    public final static String MAIN_PAGE_URL = "https://stellarburgers.nomoreparties.site/";

    @FindBy(how = How.XPATH,using = ".//p[text()='Личный Кабинет']")
    private SelenideElement personalAccountButton;

    @FindBy(how = How.XPATH,using = ".//button[text()='Войти в аккаунт']")
    private SelenideElement enterAccountButton;

    @FindBy(how = How.XPATH, using = ".//span[text()='Булки']")
    private SelenideElement bunTab;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'current')]/span[text()='Булки']")
    private SelenideElement selectedBunTab;

    @FindBy(how = How.XPATH, using = ".//span[text()='Соусы']")
    private SelenideElement sauceTab;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'current')]/span[text()='Соусы']")
    private SelenideElement selectedSauceTab;

    @FindBy(how = How.XPATH, using = ".//span[text()='Начинки']")
    private SelenideElement fillingTab;

    @FindBy(how = How.XPATH, using = ".//div[contains(@class, 'current')]/span[text()='Начинки']")
    private SelenideElement selectedFillingTab;

    @Step ("Вход на страницу Личного кабинета")
    public void personalAccountClick() {personalAccountButton.click();}

    @Step("Проверка наличия текста Соусы и Начинки.")
    public void checkSaucesAndFillingText() {
        sauceTab.shouldBe(visible);
        fillingTab.shouldBe(visible);
    }
    @Step("Вход в аккаунт")
    public void clickEnterInAccount(){
        enterAccountButton.click();
    }

    @Step("Проверка перехода по вкладкам в конструкторе")
    public void checkCorrectTransitionBetweenTabs(){
        sauceTab.click();
        selectedSauceTab.shouldBe(visible);
        bunTab.click();
        selectedBunTab.shouldBe(visible);
        fillingTab.click();
        selectedFillingTab.shouldBe(visible);
    }
}

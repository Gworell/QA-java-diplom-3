package com.PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.*;

public class LoginPage {

    @FindBy(how = How.XPATH,using = ".//a[text()='Зарегистрироваться']")
    private SelenideElement registerAccountButton;

    @FindBy(how = How.XPATH, using = "//a[@class='Auth_link__1fOlj'][text()='Восстановить пароль']")
    private SelenideElement recoveryPasswordButton;

    @FindBy(how = How.XPATH, using = ".//div[@class='Auth_login__3hAey']//form//button[text()='Войти']")
    private SelenideElement loginButton;

    @FindBy(how = How.XPATH,using = ".//div[@class='input__container']//div/input[@type='text']")
    private SelenideElement emailField;

    @FindBy(how = How.XPATH,using = ".//div[@class='input__container']//div/input[@type='password']")
    private SelenideElement passwordField;

    @Step("Регистрация нового аккаунта")
    public void registerNewAccountClickButton(){registerAccountButton.click();}

    @Step("Проверка видимости кнопки Восстановить пароль и Войти")
    public void recoveryButtonAndEnterButtonShouldBeVisible() {
        recoveryPasswordButton.shouldBe(visible);
        loginButton.shouldBe(visible, enabled);
    }

    @Step("Вход в аккаунт через кнопку Войти")
    public void clickLoginButton(){loginButton.click();}

    @Step("Ввод регистрационных данных и Вход в личный кабинет через кнопку Войти")
    public void setRegistrationDataAndClickEnter(String email, String password){
        emailField.setValue(email);
        passwordField.setValue(password);
        clickLoginButton();
    }
    @Step("Клик по кнопке восстановить пароль")
    public void clickOnRecoveryButton(){recoveryPasswordButton.click();}
}

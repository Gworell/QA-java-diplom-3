package com.PageObject.chrome;

import com.PageObject.ForgotPasswordPage;
import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.RegisterPage;
import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Map;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginTest {

    private UserOperations userOperations;
    private MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private LoginPage loginPage = page(LoginPage.class);
    private RegisterPage registerPage = page(RegisterPage.class);
    private ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @Test
    @DisplayName("Проверка входа в личный кабинет по кнопке Войти в аккаунт на главной")
    public void loginFromMainPageEnterAccountButtonTest() {
        Map<String, String> userData = userOperations.register();
        mainPage.clickEnterInAccount();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.checkSaucesAndFillingText();
    }
    @Test
    @DisplayName("Проверка входа в личный кабинет через кнопку Личный кабинет")
    public void loginFromMainPagePersonalAccountButtonTest(){
        Map<String, String> userData = userOperations.register();
        mainPage.personalAccountClick();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.checkSaucesAndFillingText();
    }
    @Test
    @DisplayName("Проверка входа в личный кабинет через кнопку в форме регистрации")
    public void loginFromRegisterPageEnterButtonTest() {
        Map<String, String> userData = userOperations.register();
        mainPage.personalAccountClick();
        loginPage.registerNewAccountClickButton();
        registerPage.clickEnterAccountButton();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.checkSaucesAndFillingText();
    }
    @Test
    @DisplayName("Проверка входа в личный кабинет через кнопку в форме восстановления пароля")
    public void loginFromLoginPageRecoveryButtonTest() {
        Map<String, String> userData = userOperations.register();
        mainPage.personalAccountClick();
        loginPage.clickOnRecoveryButton();
        forgotPasswordPage.clickLoginButton();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.checkSaucesAndFillingText();

    }
    @After
    public void tearDown () {
        userOperations.delete();
        getWebDriver().quit();
    }

}

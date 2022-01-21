package com.PageObject.chrome;

import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.RegisterPage;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class RegistrationNewUserTest {

    private MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private LoginPage loginPage = page(LoginPage.class);
    private RegisterPage registerPage = page(RegisterPage.class);

    @Test
    @DisplayName("Проверка успешной регистрации пользователя")
    public void correctRegisterNewUserTest() {
        mainPage.personalAccountClick();
        loginPage.registerNewAccountClickButton();
        String name = registerPage.getRandomName();
        String email = registerPage.getRandomEmail();
        String password = registerPage.getRandomPassword();
        registerPage.fillUserDataAndClickRegister(name, email, password);
        loginPage.recoveryButtonAndEnterButtonShouldBeVisible();
    }
    @Test
    @DisplayName("Регистрация с паролем менее 6 символов и получение сообщения об ошибке")
    public void registrationWithIncorrectPassword() {
        mainPage.personalAccountClick();
        loginPage.registerNewAccountClickButton();
        String name = registerPage.getRandomName();
        String email = registerPage.getRandomEmail();
        String password = registerPage.getIncorrectRandomPassword();
        registerPage.fillUserDataAndClickRegister(name, email, password);
        registerPage.checkVisibleErrorText();
    }

    @After
    public void tearDown () {
        getWebDriver().quit();
    }
}
package com.PageObject.yandex;

import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.PageObject.ProfilePage;
import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class PersonalAccountTest {

    private UserOperations userOperations;
    private MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private LoginPage loginPage = page(LoginPage.class);
    private ProfilePage profilePage = page(ProfilePage.class);

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @Test
    @DisplayName("Проверка перехода по в Личный кабинет")
    public void loginInPersonalAccountPositiveTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Map<String, String> userData = userOperations.register();
        mainPage.clickEnterInAccount();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.personalAccountClick();
        profilePage.checkCorrectLoginInProfile();
    }
    @Test
    @DisplayName("Проверка перехода по клику в Конструктор из личного кабинета")
    public void loginInPersonalAccountAndClickConstructorPositiveTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Map<String, String> userData = userOperations.register();
        mainPage.clickEnterInAccount();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.personalAccountClick();
        profilePage.transitionInConstructor();
        mainPage.checkSaucesAndFillingText();
    }
    @Test
    @DisplayName("Проверка перехода по Лого в Конструктор из личного кабинета")
    public void loginInPersonalAccountAndClickLogoPositiveTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Map<String, String> userData = userOperations.register();
        MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
        mainPage.clickEnterInAccount();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.personalAccountClick();
        profilePage.clickConstructorButton();
        mainPage.checkSaucesAndFillingText();
    }
    @Test
    @DisplayName("Проверка входа и вызода из личного кабинета по кнопке Выйти")
    public void loginInPersonalAccountAndLogoutPositiveTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Map<String, String> userData = userOperations.register();
        mainPage.clickEnterInAccount();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.personalAccountClick();
        profilePage.clickLogoutButton();
        loginPage.recoveryButtonAndEnterButtonShouldBeVisible();
    }
    @After
    public void tearDown () {
        userOperations.delete();
        getWebDriver().quit();
    }
}

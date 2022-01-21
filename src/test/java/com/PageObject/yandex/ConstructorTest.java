package com.PageObject.yandex;

import com.PageObject.LoginPage;
import com.PageObject.MainPage;
import com.UserOperations;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class ConstructorTest {

    private UserOperations userOperations;
    private MainPage mainPage = open(MainPage.MAIN_PAGE_URL, MainPage.class);
    private LoginPage loginPage = page(LoginPage.class);

    @Before
    public void setUp() {
        userOperations = new UserOperations();
    }

    @Test
    @DisplayName("Переключение между вкладок конструктора")
    public void checkCorrectTransitionBetweenConstructorTabsTest(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
        Map<String, String> userData = userOperations.register();
        mainPage.clickEnterInAccount();
        loginPage.setRegistrationDataAndClickEnter(userData.get("email"), userData.get("password"));
        mainPage.checkCorrectTransitionBetweenTabs();
    }

    @After
    public void deleteUser() {
        userOperations.delete();
    }
}

package com.PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import static com.codeborne.selenide.Condition.visible;

public class ProfilePage {

    @FindBy(how = How.CLASS_NAME,using = "AppHeader_header__logo__2D0X2")
    private SelenideElement logo;

    @FindBy(how = How.XPATH,using = ".//p[text()='Конструктор']")
    private SelenideElement constructorButton;

    @FindBy(how = How.XPATH,using = ".//button[text()='Выход']")
    private SelenideElement logoutButton;

    @Step("Проверка успешного входа в профиль")
    public void checkCorrectLoginInProfile(){logoutButton.shouldBe(visible);}

    @Step("Переход на главную страницу через кнопку Конструктор")
    public void transitionInConstructor(){constructorButton.click();}

    @Step("Переход на главную страницу через кнопку Конструктор")
    public void clickConstructorButton(){logo.click();}

    @Step("Выход на главную страницу через кнопку Выход")
    public void clickLogoutButton(){logoutButton.click();}
}

package com.PageObject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {

    @FindBy(how = How.XPATH,using = ".//a[@class='Auth_link__1fOlj'][text()='Войти']")
    private SelenideElement loginButton;

    @Step("Вход в аккаунт через кнопку Войти")
    public void clickLoginButton(){loginButton.click();}
}

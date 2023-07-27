package ui.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginElements {
    public SelenideElement userField() {
        return $("#form-username");
    }

    public SelenideElement passwordField() {
        return $("#form-password");
    }

    public SelenideElement signInButton() {
        return $x("//button[@type='submit']");
    }

    public SelenideElement loginPage() {
        return $(By.className("form-login"));
    }

    public SelenideElement errorMessage() {
        return $(byText("Bad username or password"));

    }

}

package ui.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class NewTaskElements {
    public SelenideElement newTaskPage() {
        return $(By.className("task-form-container"));
    }
    public SelenideElement descriptionTask() {
        return $("#form-title");
    }
    public SelenideElement titleTask() {
        return $("[name='description']");
    }
    public SelenideElement saveButton() {

        return $x("//button[@type='submit']");
    }

}

package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateNewProjectElements {
    public SelenideElement nameProjectField() {
        return $("#form-name");
    }
    public SelenideElement identifierProjectField() {
        return $("#form-identifier");
    }
    public SelenideElement checkboxProjectField() {
        return $x("//input[@name='per_swimlane_task_limits']");
    }
    public SelenideElement taskLimitProjectField() {
        return $("#form-task_limit, class min=11");
    }

    public SelenideElement createAnotherProjectField() {
        return $("#form-src_project_id, value=0");
    }
    public SelenideElement saveButton() {
        return $x("//button[@type='submit']");
    }
}

package ui.steps;

import com.codeborne.selenide.SelenideElement;
import ui.elements.TaskElements;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static utils.EnvProperties.BASE_URL;

public class TaskPage extends TaskElements {
    public TaskPage openLoginPage() {
        open("");
        return new TaskPage();
    }
    public TaskPage openNewTaskCreatePage() {
        openNewTaskCreatePageElement().click();
        return this;
    }
//    public TaskPage openExistTask(String name) {
//        existTaskOpen(name);
//        return this;
//    }
}

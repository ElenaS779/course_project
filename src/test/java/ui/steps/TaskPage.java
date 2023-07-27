package ui.steps;

import ui.elements.TaskElements;

import static com.codeborne.selenide.Selenide.open;


public class TaskPage extends TaskElements {
    public TaskPage openLoginPage() {
        open("");
        return new TaskPage();
    }

    public TaskPage openNewTaskCreatePage() {
        openNewTaskCreatePageElement().click();
        return this;
    }
}

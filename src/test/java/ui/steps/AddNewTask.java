package ui.steps;

import com.codeborne.selenide.Condition;
import ui.elements.NewTaskElements;
import ui.elements.TaskElements;
import static com.codeborne.selenide.Condition.visible;

public class AddNewTask extends NewTaskElements {
    private String nameTask;

    public AddNewTask addNewTask(String title, String description) {
        titleTask().shouldBe(visible).sendKeys(title);
        descriptionTask().shouldBe(visible).sendKeys(description);
        saveButton().shouldBe(visible).click();
        return this;
    }

    public AddNewTask assertCreateTask() {
        new TaskElements().nameTask()
                .shouldBe(Condition.partialText(nameTask));
        return this;
    }
}

package ui.steps;

import ui.elements.TaskElements;

import static com.codeborne.selenide.Condition.visible;

public class OpenExistTask extends TaskElements {
    public OpenExistTask openTask(){
        taskBoardTitle().shouldBe(visible).click();
        return this;
    }
}

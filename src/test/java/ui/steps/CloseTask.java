package ui.steps;

import com.codeborne.selenide.Condition;
import ui.elements.TaskElements;
import utils.Helper;

import static com.codeborne.selenide.Condition.visible;

public class CloseTask extends TaskElements {

    public CloseTask closeTask(){
        new OpenExistTask().openTask();
        Helper.scrollToXPath("//*[@id=\"task-view\"]/div[1]/ul[2]/li[14]/a");
        closeElement().click();
        yesButton().click();
        return this;
    }
    public CloseTask assertCloseTask() {
        new TaskElements().closedStatusTask()
                .shouldBe(visible);
        return this;
    }
}

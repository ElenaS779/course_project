package ui.steps;

import com.codeborne.selenide.Condition;
import ui.elements.TaskElements;
import utils.Helper;

import static com.codeborne.selenide.Condition.visible;


public class AddCommentsToTask extends TaskElements {

    public AddCommentsToTask addNewCommentToTask(String comment) {
        new OpenExistTask().openTask();
        commentsButtonElement().shouldBe(visible).click();
        textArea().shouldBe(visible).sendKeys(comment);
        Helper.scrollToXPath("//*[@id=\"comments\"]/form/div[2]/div/button");
        saveButton().shouldBe(visible).click();
        return this;
    }
    public AddCommentsToTask assertAddComment(String commentText) {
        new TaskElements().commentTextElement(commentText)
                .shouldBe(visible);
        return this;
    }


}

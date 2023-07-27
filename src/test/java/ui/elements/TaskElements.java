package ui.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class TaskElements {

    public SelenideElement openNewTaskCreatePageElement(){
        return $x("//*[@id=\"board\"]/tbody/tr[1]/th[1]/div[2]/div/a");
    }
    public SelenideElement closeElement(){
        return $x("//*[@id=\"task-view\"]/div[1]/ul[2]/li[14]/a");
    }
    public SelenideElement yesButton() {

        return $("#modal-confirm-button");
    }
    public SelenideElement taskBoardTitle() {
        return $x("//*[@id=\"board\"]/tbody/tr[2]/td[1]/div[1]/div/div[2]/div[3]/a");
    }
    public SelenideElement commentsButtonElement(){
        return $x("//*[@id=\"task-view\"]/div[2]/details[6]/summary[contains(text(), 'Comments')]");
    }
    public SelenideElement textArea(){

        return $x("//*[@id=\"comments\"]/form/div[1]/div/div[2]/textarea");
    }
    public SelenideElement saveButton() {

        return $x("//*[@id=\"comments\"]/form/div[2]/div/button");
    }
    public SelenideElement nameTask() {
        return $(By.className("task-board-title"));
    }
     public SelenideElement closedStatusTask(){
        return $x(" //*[@id=\"task-summary\"]/div/div/div[1]/ul/li[1]/span[contains(text(),'closed')]");
     }
     public SelenideElement commentTextElement(String text){
        return $x(String.format("//div[@class='markdown']/p[contains(text(), '%s')]", text));
     }
}

package ui.steps;

import com.codeborne.selenide.Condition;
import ui.elements.MainElements;
import static com.codeborne.selenide.Selenide.open;
import static utils.EnvProperties.BASE_URL;


public class MainPage extends MainElements {

    public MainPage openLoginPage() {
        open("");
        return new MainPage();
    }
    public MainPage openExistProject(String id) {
        open(BASE_URL + "/board/" + id);
        return this;
    }
    public MainPage assertMainSectionIsOpened() {
        mainSection().shouldBe(Condition.visible);
        return this;
    }

}

package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class MainElements {
    public SelenideElement mainSection() {
        return $("#main");
    }
    public SelenideElement newProject(){
        return $x("//*[@id=\"main\"]/div/ul/li[1]/a");
    }

}

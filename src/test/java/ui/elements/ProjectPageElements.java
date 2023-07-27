package ui.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProjectPageElements {
    public SelenideElement nameProject() {
        return $(By.className("title"));
    }
}

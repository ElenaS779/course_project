package ui.steps;

import com.codeborne.selenide.Condition;
import ui.elements.CreateNewProjectElements;
import ui.elements.ProjectPageElements;

import static com.codeborne.selenide.Condition.visible;

public class NewProjectPage extends CreateNewProjectElements {

    MainPage mainPage = new MainPage();
    private String nameProject;

    public NewProjectPage openNewProjectPage() {
        mainPage.newProject().shouldBe(visible);
        mainPage.newProject().click();
        return new NewProjectPage();
    }

    public NewProjectPage createNewProject(String name, String identifier) {
        nameProjectField().shouldBe(visible).sendKeys(name);
        identifierProjectField().shouldBe(visible).sendKeys(identifier);
        saveButton().click();
        nameProject = name;
        return this;
    }

    public NewProjectPage assertNewProjectPageIsOpened() {
        mainPage.newProject().shouldBe(Condition.visible);
        return this;
    }

    public NewProjectPage assertCreateProject() {
        new ProjectPageElements().nameProject()
                .shouldBe(Condition.partialText(nameProject));
        return this;
    }
}

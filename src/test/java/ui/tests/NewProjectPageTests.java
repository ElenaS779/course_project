package ui.tests;

import api.steps.UserApiSteps;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.LoginPage;
import ui.steps.NewProjectPage;

import java.lang.reflect.InvocationTargetException;


public class NewProjectPageTests extends BaseTest {
    static final long currMs = System.currentTimeMillis();
    private static final String USERNAME = (String.format("Maria567%d", currMs));
    private static final String PASSWORD = (String.format("maria564%d", currMs));
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;
    private static final String PROJECT_NAME = "New project create test";
    private static final String PROJECT_IDENTIFIER = ("test565758" + currMs);

    @BeforeMethod
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        System.out.println(userId);
    }

    @Test
    @Description("Test: open new project page")
    public void openNewProjectPage() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD, NewProjectPage.class)
                .openNewProjectPage()
                .assertNewProjectPageIsOpened();
    }

    @Test
    @Description("Test: create a new project")
    public void createNewProject() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD, NewProjectPage.class)
                .openNewProjectPage()
                .createNewProject(PROJECT_NAME, PROJECT_IDENTIFIER)
                .assertCreateProject();
    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(Integer.parseInt(userId));
    }

}
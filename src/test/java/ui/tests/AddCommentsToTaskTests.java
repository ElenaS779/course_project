package ui.tests;

import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.*;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;

public class AddCommentsToTaskTests {
    static final long currMs = System.currentTimeMillis();
    private static final String USERNAME = (String.format("Maria567%d", currMs));
    private static final String PASSWORD = (String.format("maria564%d", currMs));
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;
    private static final String PROJECT_NAME = "New project create test for task";
    private static final String PROJECT_IDENTIFIER = (String.format("test%d", currMs));
    private static final String DESCRIPTION = "creating test project for task test";
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    private String projectId;
    private static final String TITLE = "New task create";
    private static final String DESC_TITLE = "New task create via ui test";
    private static final String COMMENT = "New comment added";

    @BeforeMethod
    public void prepareDataForTest() throws ParseException {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        System.out.println(userId);
        projectId = projectApiSteps.createProject(PROJECT_NAME, PROJECT_IDENTIFIER, DESCRIPTION, Integer.parseInt(userId));
        System.out.println(projectId);
    }

    @Test
    @Description("Test: adding comment to the task")
    public void addCommentToTask() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD, MainPage.class)
                .openExistProject(projectId);
        new TaskPage()
                .openNewTaskCreatePage();
        new AddNewTask()
                .addNewTask(TITLE, DESC_TITLE);
        new AddCommentsToTask()
                .addNewCommentToTask(COMMENT)
                .assertAddComment(COMMENT);

    }

    @AfterMethod(alwaysRun = true)
    public void removeDataAfterTest() {
        projectApiSteps.deleteProject(Integer.parseInt(projectId), USERNAME, PASSWORD);
        userApiSteps.deleteUser(Integer.parseInt(userId));
    }
}

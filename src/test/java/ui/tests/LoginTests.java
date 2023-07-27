package ui.tests;

import api.steps.UserApiSteps;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.steps.LoginPage;
import ui.steps.MainPage;

import java.lang.reflect.InvocationTargetException;

public class LoginTests extends BaseTest {
    private static final String USERNAME = "Maria567";
    private static final String PASSWORD = "maria564";
    private static final String BAD_PASSWORD = "maria";
    private static final String USERNAME_EMPTY = "";
    private static final String PASSWORD_EMPTY = "";


    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;

    @BeforeMethod
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        System.out.println(userId);
    }

    @Test(priority = 1)
    @Description("Invalid Login Scenario with password 5 characters (should be at least 6 characters)")
    public void loginUserBadPassword() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, BAD_PASSWORD, LoginPage.class)
                .assertLoginPageIsOpened()
                .errorMessage();
    }

    @Test(priority = 2)
    @Description("Login a new user")
    public void loginByNewUser() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD, MainPage.class)
                .assertMainSectionIsOpened();
    }

    @Test(priority = 3)
    @Description("Invalid Login Scenario with empty user")
    public void loginUserEmptyUser() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME_EMPTY, PASSWORD, LoginPage.class)
                .assertLoginPageIsOpened();

    }

    @Test(priority = 4)
    @Description("Invalid Login Scenario with empty password")
    public void loginUserEmptyPassword() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD_EMPTY, LoginPage.class)
                .assertLoginPageIsOpened();
    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(Integer.parseInt(userId));
    }
}

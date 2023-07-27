package api.tests;

import api.steps.BaseApiSteps;
import api.steps.UserApiSteps;
import io.qameta.allure.Description;
import org.apache.commons.lang3.StringUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class UserTests extends BaseApiSteps {
    private static final String USERNAME = "Tamarin34";
    private static final String PASSWORD = "tamarin545";
    UserApiSteps userApiSteps = new UserApiSteps();
    private Integer userId;
    @BeforeTest
    public void setup() {

        Init();
    }
    @Test
    @Description("create a new user")
    public void createUser() {
        String resultValue = userApiSteps.createUser(USERNAME, PASSWORD);
        Assert.assertNotEquals(resultValue, "false", "User creation failed");
        Assert.assertTrue(StringUtils.isNumeric(resultValue));
        userId = Integer.parseInt(resultValue);
    }

    @Test
    @Description("delete user")
    public void deleteUser(){
       Boolean resultValue = userApiSteps.deleteUser(userId);
       Assert.assertTrue(resultValue,"Delete failed");

    }
}

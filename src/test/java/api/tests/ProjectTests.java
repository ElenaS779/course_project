package api.tests;

import api.steps.BaseApiSteps;
import api.steps.ProjectApiSteps;
import io.qameta.allure.Description;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.EnvProperties;

import java.text.ParseException;

import static utils.EnvProperties.API_PASSWORD;
import static utils.EnvProperties.API_USERNAME;

public class ProjectTests extends BaseApiSteps {
    private Integer projectId;
    private String projectName;
    private String projectIdentifier;
    private String description = "created project via api";
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();

    @BeforeTest
    public void setup() {
        Init();
        final long currMs = System.currentTimeMillis();
        projectName = "TestApiCreateProject" + currMs;
        projectIdentifier = "Test" + currMs;
    }

    @Test(priority = 1)
    @Description("create a new project")
    public void createProject() throws ParseException {
        String resultValue = projectApiSteps.createProject(projectName, projectIdentifier, description, EnvProperties.API_USER_ID);
        Assert.assertNotEquals(resultValue, "false", "Project creation failed");
        Assert.assertTrue(StringUtils.isNumeric(resultValue));
        projectId = Integer.parseInt(resultValue);
    }

    @Test
    @Description("delete project")
    public void deleteProject() {
        Boolean resultValue = projectApiSteps.deleteProject(projectId, API_USERNAME, API_PASSWORD);
        Assert.assertTrue(resultValue, "Delete failed");
    }
}

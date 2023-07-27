package api.tests;

import api.steps.BaseApiSteps;
import api.steps.TaskApiSteps;
import io.qameta.allure.Description;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.ParseException;

public class TaskTests extends BaseApiSteps {
    private Integer taskId;

    TaskApiSteps taskApiSteps = new TaskApiSteps();
    @BeforeTest
    public void setup() {
        Init();
    }

    @Test
    @Description("create a new task")
    public void createTask() throws ParseException {
        String resultValue = taskApiSteps.createTask();
        Assert.assertNotEquals(resultValue, "false", "Task creation failed");
        Assert.assertTrue(StringUtils.isNumeric(resultValue));
        taskId = Integer.parseInt(resultValue);
    }
    @Test
    @Description("delete task")
    public void deleteTask(){
        Boolean resultValue = taskApiSteps.deleteTask(taskId);
        Assert.assertTrue(resultValue,"Delete failed");
    }
}

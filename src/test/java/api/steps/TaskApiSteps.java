package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.task.CreateTask;
import api.models.task.DeleteTask;
import io.restassured.response.Response;
import utils.EnvProperties;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static api.methods.Tasks.CREATE_TASK;
import static api.methods.Tasks.DELETE_TASK;
import static utils.EnvProperties.API_PASSWORD;
import static utils.EnvProperties.API_USERNAME;


public class TaskApiSteps extends BaseApiSteps {
    private Integer projectId;
    final long currMs = System.currentTimeMillis();
    private String projectName = "TestApiCreateProject" + currMs;
    private String projectIdentifier = "Test" + currMs;
    private String description = "created project via api";
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    public String createTask() throws ParseException {
        String resultValue = projectApiSteps.createProject(projectName, projectIdentifier, description,EnvProperties.API_USER_ID);
        projectId = Integer.parseInt(resultValue);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        BodyArgs body = BodyArgs.builder()
                .params(new CreateTask().builder()
                        .project_id(projectId)
                        .owner_id(EnvProperties.API_USER_ID)
                        .swimlane_id(projectId)
                        .date_due(dtf.format(now.plusDays(3)))
                        .date_started(dtf.format(now.minusDays(1)))
                        .build())
                        .method(CREATE_TASK)
                        .build();
        Response response = postRequest(body,API_USERNAME, API_PASSWORD);
        response.prettyPrint();
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

      public boolean deleteTask(Integer taskId) {
        BodyArgs body = BodyArgs.builder()
                .params(new DeleteTask().builder()
                        .task_id(taskId)
                        .build())
                .method(DELETE_TASK)
                .build();
        Response response = postRequest(body,API_USERNAME, API_PASSWORD);
        response.prettyPrint();
        response.then().statusCode(200);
        return (boolean) response.as(Result.class).getResult();

    }

}



package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.project.CreateProject;
import api.models.project.DeleteProject;
import io.restassured.response.Response;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static api.methods.Projects.CREATE_PROJECT;
import static api.methods.Projects.DELETE_PROJECT;
import static utils.EnvProperties.API_PASSWORD;
import static utils.EnvProperties.API_USERNAME;

public class ProjectApiSteps extends BaseApiSteps {

    public String createProject(String projectName,String projectIdentifier, String description, Integer owner_id) throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        BodyArgs body = BodyArgs.builder().
                params(new CreateProject().builder()
                .name(projectName)
                .description(description)
                .owner_id(owner_id)
                .identifier(projectIdentifier)
                .start_date(dtf.format(now.minusDays(3)))
                .end_date(dtf.format(now.plusDays(3)))
                .build())
                .method(CREATE_PROJECT)
                .build();
        Response response = postRequest(body,API_USERNAME, API_PASSWORD);
        response.prettyPrint();
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    public boolean deleteProject(Integer projectId, String userName, String password){
        BodyArgs body = BodyArgs.builder().
                params(new DeleteProject().builder()
                        .project_id(projectId)
                                .build())
                     .method(DELETE_PROJECT)
                .build();
        Response response = postRequest(body,userName, password);
        response.prettyPrint();
        response.then().statusCode(200);
        return (boolean) response.as(Result.class).getResult();
    }
}

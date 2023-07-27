package api.steps;

import api.models.project.GetProjectByName;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

import api.models.args.BodyArgs;

import java.util.List;

import static utils.EnvProperties.*;

public class BaseApiSteps {
    public Response postRequest(BodyArgs bodyArgs, String userName, String password) {
        return RestAssured.given()
                .log().all()
                .auth().basic(userName, password)
                .body(bodyArgs)
                .when()
                .post(API_URL);
    }
 public void Init(){
     RestAssured.baseURI="http://localhost/jsonrpc.php";
     RestAssured.requestSpecification = new RequestSpecBuilder()
             .addHeader("Authorization", "Basic SGVsZW5hU1M6QnVsbCRoaXQxMjk=")
             .build();
 }

    public GetProjectByName getProjectByName(BodyArgs bodyArgs){
        Response response = RestAssured.given()
                .log().all()
                .auth().basic(API_USERNAME, API_PASSWORD)
                .body(bodyArgs)
                .when()
                .post(API_URL);
        response.prettyPrint();
        return response.body().jsonPath().getObject(".", GetProjectByName.class);
    }
}

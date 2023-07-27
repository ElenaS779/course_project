package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.user.CreateUser;
import api.models.user.DeleteUser;
import io.restassured.response.Response;

import static api.enums.UserRoles.MANAGER;
import static api.methods.Users.CREATE_USER;
import static api.methods.Users.DELETE_USER;
import static utils.EnvProperties.API_PASSWORD;
import static utils.EnvProperties.API_USERNAME;

public class UserApiSteps extends BaseApiSteps {

    public String createUser(String username, String pass) {
        BodyArgs body = BodyArgs.builder()
                .params(new CreateUser().builder()
                        .username(username)
                        .password(pass)
                        .name(username)
                        .email(username + "@cuvox.de")
                        .role(MANAGER.getRole())
                        .build())
                .method(CREATE_USER)
                .build();
        Response response = postRequest(body, API_USERNAME, API_PASSWORD);
        response.prettyPrint();
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    public boolean deleteUser(Integer userId) {
        BodyArgs body = BodyArgs.builder()
                .params(new DeleteUser().builder()
                        .user_id(userId)
                        .build())
                .method(DELETE_USER)
                .build();
        Response response = postRequest(body, API_USERNAME, API_PASSWORD);
        response.prettyPrint();
        response.then().statusCode(200);
        return (boolean) response.as(Result.class).getResult();
    }

}

package api.models.user;

import api.enums.UserRoles;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUser {
   private String  username;// Must be unique (string, required)
    private String password;// Must have at least 6 characters (string, required)
    private String name;
    private String email;
    private String role;// (string, optional, example: app-admin, app-manager, app-user)
}

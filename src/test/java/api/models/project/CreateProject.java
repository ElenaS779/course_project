package api.models.project;

import lombok.*;
import org.testng.annotations.BeforeTest;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProject {

    private String name; //required
    private String description;
    private Integer owner_id;
    private String identifier;// (alphanumeric string, optional)
    private String start_date;
    private String end_date;

}

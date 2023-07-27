package api.models.task;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTask {
    @Builder.Default
    private String title = "New task"; // required
    private Integer project_id; // required
    @Builder.Default
    private String color_id = "green";
    @Builder.Default
    private Integer column_id = 2;
    private Integer owner_id;
    @Builder.Default
    private Integer creator_id = 0;
    private String date_due;
    @Builder.Default
    private String description = "task created via api";// Markdown content (string, optional)
    @Builder.Default
    private Integer category_id = 0;
    @Builder.Default
    private Integer score = 0;
    private Integer swimlane_id;
    @Builder.Default
    private Integer priority = 1;
    @Builder.Default
    private Integer recurrence_status = 0;
    @Builder.Default
    private Integer recurrence_trigger = 0;
    @Builder.Default
    private Integer recurrence_factor = 0;
    @Builder.Default
    private Integer recurrence_timeframe = 0;
    @Builder.Default
    private Integer recurrence_basedate = 0;
    @Builder.Default
    private String reference = "reference";
    @Builder.Default
    private String[] tags = new String[]{"new", "test", "api"};
    private String date_started;

}

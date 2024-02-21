package teamcubation.io.taskapi.dtos;

import lombok.Builder;
import lombok.Data;
import teamcubation.io.taskapi.domain.enums.TaskStatus;

@Data
@Builder
public class TaskRequestDto {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
}

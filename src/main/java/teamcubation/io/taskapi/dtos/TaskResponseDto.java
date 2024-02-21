package teamcubation.io.taskapi.dtos;

import lombok.Builder;
import lombok.Data;
import teamcubation.io.taskapi.domain.enums.TaskStatus;

@Builder
@Data
public class TaskResponseDto{

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
}

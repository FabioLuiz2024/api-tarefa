package teamcubation.io.taskapi.dtos;


import lombok.Builder;
import teamcubation.io.taskapi.domain.Task;
import teamcubation.io.taskapi.domain.enums.TaskStatus;


@Builder
public record TaskResponseDto(Long id, String title, String description, TaskStatus status){

    public TaskResponseDto(Task task){
        this(task.getId(), task.getTitle(), task.getDescription(), task.getStatus());
    }


}

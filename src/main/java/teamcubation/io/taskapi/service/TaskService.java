package teamcubation.io.taskapi.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamcubation.io.taskapi.domain.Task;
import teamcubation.io.taskapi.domain.enums.TaskStatus;
import teamcubation.io.taskapi.dtos.TaskRequestDto;
import teamcubation.io.taskapi.dtos.TaskResponseDto;
import teamcubation.io.taskapi.exceptions.TaskNotFoundException;
import teamcubation.io.taskapi.repository.TaskRepository;

import java.util.List;


@Service
@Data
public class TaskService {

    private final TaskRepository taskRepository;

    public Task create(TaskRequestDto taskRequestDto){
        return taskRepository.save(Task.builder()
                        .status(TaskStatus.TODO)
                        .title(taskRequestDto.getTitle())
                        .description(taskRequestDto.getDescription())
                .build());
     }

    public Task update(TaskRequestDto taskRequestDto, Long id) {
        Task task = taskRepository.findById(taskRequestDto.getId()).orElseThrow(() -> new TaskNotFoundException("Task not found!"));
        task.setTitle(taskRequestDto.getTitle());
        task.setDescription(taskRequestDto.getDescription());
        task.setStatus(taskRequestDto.getStatus());
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        Task todo = this.findTask(id);

        taskRepository.delete(todo);
    }

    public Task findTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarefa não encontrada!"));
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }

}

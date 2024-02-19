package teamcubation.io.taskapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamcubation.io.taskapi.domain.Task;
import teamcubation.io.taskapi.domain.enums.TaskStatus;
import teamcubation.io.taskapi.dtos.TaskRequestDto;
import teamcubation.io.taskapi.dtos.TaskResponseDto;
import teamcubation.io.taskapi.exceptions.TaskNotFoundException;
import teamcubation.io.taskapi.repository.TaskRepository;


@Service
public class TaskService {

    @Autowired
    private  TaskRepository taskRepository;

    @Transactional
    public TaskResponseDto add(TaskRequestDto taskRequestDto){

        Task task = new Task(taskRequestDto);
        task.setStatus(TaskStatus.TODO);
        task.setTitle(taskRequestDto.title());
        task.setDescription(taskRequestDto.description());

        Task taskSave= taskRepository.save(task);
        return new TaskResponseDto(taskSave);

     }

    @Transactional
    public TaskResponseDto update(Long id) {
        Task task = this.findTask(id);

        Task todoUpdated = taskRepository.save(task);

        return new TaskResponseDto(todoUpdated);
    }

    @Transactional
    public void delete(Long id) {
        Task todo = this.findTask(id);

        taskRepository.delete(todo);
    }

    public Task findTask(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarefa não encontrada!"));
    }

}

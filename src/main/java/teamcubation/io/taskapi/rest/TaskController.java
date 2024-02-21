package teamcubation.io.taskapi.rest;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamcubation.io.taskapi.domain.Task;
import teamcubation.io.taskapi.dtos.TaskRequestDto;
import teamcubation.io.taskapi.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Data
public class TaskController {


    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> saveTask(@RequestBody TaskRequestDto taskRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(taskRequestDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> updateTask(@RequestBody TaskRequestDto body, @PathVariable Long id) {
        return ResponseEntity.ok().body(taskService.update(body, id));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTAsk(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findById (@PathVariable Long id){
        Task task = taskService.findTask(id);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> findAll(){
        List<Task> taskList = taskService.findAll();
        return ResponseEntity.ok().body(taskList);
    }




}

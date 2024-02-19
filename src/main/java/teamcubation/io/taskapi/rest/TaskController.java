package teamcubation.io.taskapi.rest;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamcubation.io.taskapi.dtos.TaskRequestDto;
import teamcubation.io.taskapi.dtos.TaskResponseDto;
import teamcubation.io.taskapi.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@Data
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskResponseDto> saveTask(@RequestBody TaskRequestDto taskRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.add(taskRequestDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TaskResponseDto> updateTask(@PathVariable Long id) {
        return ResponseEntity.ok().body(taskService.update(id));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTAsk(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

package teamcubation.io.taskapi.rest;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamcubation.io.taskapi.domain.User;
import teamcubation.io.taskapi.dtos.TaskRequestDto;
import teamcubation.io.taskapi.dtos.UserRequestDto;
import teamcubation.io.taskapi.dtos.UserResponseDto;
import teamcubation.io.taskapi.service.UserService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/users")
@Data
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userRequestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserRequestDto body, @PathVariable Long id) {
       return ResponseEntity.ok(userService.updateUser( body,id));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTAsk(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findUser(id);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> userList = userService.findUserAll();
        return ResponseEntity.ok().body(userList);
    }
}

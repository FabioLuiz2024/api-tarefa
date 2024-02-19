package teamcubation.io.taskapi.rest;


import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teamcubation.io.taskapi.dtos.UserRequestDto;
import teamcubation.io.taskapi.dtos.UserResponseDto;
import teamcubation.io.taskapi.service.UserService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/users")
@Data
public class UserController {

    private final UserService userService;



    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserRequestDto userRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(userRequestDto));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.update(id));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTAsk(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}

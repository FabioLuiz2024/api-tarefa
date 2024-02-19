package teamcubation.io.taskapi.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamcubation.io.taskapi.domain.User;
import teamcubation.io.taskapi.dtos.UserRequestDto;
import teamcubation.io.taskapi.dtos.UserResponseDto;
import teamcubation.io.taskapi.repository.UserRepository;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;
    @Transactional
    public UserResponseDto create(UserRequestDto userRequestDto){

        User user= new User(userRequestDto);
        user.setName(userRequestDto.name());
        user.setTeam(userRequestDto.team());

        User userSave= userRepository.save(user);
        return new UserResponseDto(userSave);

    }

    @Transactional
    public UserResponseDto update(Long id) {
        User user= this.fimdUser(id);

        User userUpdated = userRepository.save(user);

        return new UserResponseDto(userUpdated);
    }

    @Transactional
    public void delete(Long id) {
        User user = this.fimdUser(id);

        userRepository.delete(user);
    }

    public User fimdUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada!"));
    }
}

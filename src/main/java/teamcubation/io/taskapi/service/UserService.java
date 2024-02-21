package teamcubation.io.taskapi.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teamcubation.io.taskapi.domain.User;
import teamcubation.io.taskapi.dtos.UserRequestDto;
import teamcubation.io.taskapi.dtos.UserResponseDto;
import teamcubation.io.taskapi.repository.UserRepository;

import java.util.List;

@Service
@Data

public class UserService {

    private final UserRepository userRepository;

    public User create(UserRequestDto userRequestDto){
        return userRepository.save(User.builder()
                        .name(userRequestDto.getName())
                        .team(userRequestDto.getTeam())
                .build());
    }

    public User updateUser(UserRequestDto userRequestDto, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        user.setName(userRequestDto.getName());
        user.setTeam(userRequestDto.getTeam());
        return userRepository.save(user);
    }

    public void delete(Long id) {

        User user = this.findUser(id);

        userRepository.delete(user);
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    public List<User> findUserAll(){
        return userRepository.findAll();
    }

}

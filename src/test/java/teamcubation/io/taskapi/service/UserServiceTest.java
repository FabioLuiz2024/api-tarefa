package teamcubation.io.taskapi.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import teamcubation.io.taskapi.domain.User;
import teamcubation.io.taskapi.dtos.UserRequestDto;
import teamcubation.io.taskapi.repository.UserRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test
    void create() {

        // Given
        Long id = 1L;
        UserRequestDto userRequestDto = new UserRequestDto(id, "Fabio", "Team A");
        User userToSave = new User(id, "Fabio", "Team A");
        when(userRepository.save(any(User.class))).thenReturn(userToSave);

        // When
        User createdUser = userService.create(userRequestDto);

        // Then
        assertEquals(userToSave.getName(), createdUser.getName());
    }

    @Test
    void updateUser() {
        // Given
        Long id = 1L;
        UserRequestDto userRequestDto = new UserRequestDto(id, "Fabio Denilson", "Mercado Livre");
        User existingUser = new User(id, "Fabio", "Team A");
        User updatedUser = new User(id, "Fabio Denilson", "Mercado Livre");
        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        // When
        User result = userService.updateUser(userRequestDto, id);
        // Then
        assertEquals(updatedUser, result);

    }

    @Test
    void delete() {
        // Given
        Long id = 1L;
        User existingUser = new User(id, "John Doe", "Team A");
        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));

        // When
        userService.delete(id);

    }

    @Test
    void findUser() {

        Long id = 1L;
        User userToSave = new User(id, "John Doe", "Team A");

        when(userRepository.findById(id)).thenReturn(Optional.of(userToSave));

        User response = userService.findUser(id);

        assertEquals(userToSave, response);
    }

    @Test
    void findUserAll() {
        // Given
        Long id = 1L;
        List<User> expectedUsers = Arrays.asList(
                new User(id, "Fabio", "Team A"),
                new User(id, "Ester", "Team B")
        );
        when(userRepository.findAll()).thenReturn(expectedUsers);

        // When
        List<User> result = userService.findUserAll();

        // Then
        assertEquals(expectedUsers, result);
    }

}
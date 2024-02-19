package teamcubation.io.taskapi.dtos;

import lombok.Builder;
import teamcubation.io.taskapi.domain.User;

@Builder
public record UserResponseDto (Long id, String name, String team){

    public UserResponseDto(User user){
        this(user.getId(), user.getName(), user.getTeam());
    }
}

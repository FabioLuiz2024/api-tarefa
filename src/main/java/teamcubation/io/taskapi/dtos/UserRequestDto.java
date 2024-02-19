package teamcubation.io.taskapi.dtos;

import lombok.Builder;

@Builder
public record UserRequestDto(
        String name,
        String team) {

}

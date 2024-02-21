package teamcubation.io.taskapi.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponseDto {
    private Long id;
    private String name;
    private String team;
}

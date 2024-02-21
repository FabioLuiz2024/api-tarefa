package teamcubation.io.taskapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UserRequestDto {
    private Long id;
    private String name;
    private String team;
}

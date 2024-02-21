package teamcubation.io.taskapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import teamcubation.io.taskapi.domain.enums.TaskStatus;


@Entity
@Table(name = "tasks")
@Data@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    private TaskStatus status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
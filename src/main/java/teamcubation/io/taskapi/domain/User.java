package teamcubation.io.taskapi.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import teamcubation.io.taskapi.dtos.UserRequestDto;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "team")
    private String team;

    public User() {
    }

    public User(Long id, String name, String team) {
        this.name = name;
        this.team = team;
    }

    public User(UserRequestDto userRequestDto) {
        this.name = userRequestDto.name();
        this.team = userRequestDto.team();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}

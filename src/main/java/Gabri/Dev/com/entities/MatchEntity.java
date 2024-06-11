package Gabri.Dev.com.entities;

import Gabri.Dev.com.models.MatchDifficulty;
import Gabri.Dev.com.models.MatchStatus;
import Gabri.Dev.com.models.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "matches")
public class MatchEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity userEntity;

    @Enumerated(EnumType.STRING)
    private MatchDifficulty difficulty;


    private Integer numberToGuess;

    private Integer remainingTries;

    @Enumerated(EnumType.STRING)
    private MatchStatus status;


    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

}

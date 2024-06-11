package Gabri.Dev.com.dtos;


import Gabri.Dev.com.models.MatchDifficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class MatchDto {

    private Long id;

    private MatchDifficulty difficulty;

    private Integer remainingTries;

}

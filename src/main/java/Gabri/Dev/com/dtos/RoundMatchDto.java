package Gabri.Dev.com.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoundMatchDto {
    private MatchDto matchDto;
    private String respuesta;
}

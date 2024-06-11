package Gabri.Dev.com.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String email;
}

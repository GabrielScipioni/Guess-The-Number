package Gabri.Dev.com.services;

import Gabri.Dev.com.models.Match;
import Gabri.Dev.com.models.MatchDifficulty;
import Gabri.Dev.com.models.RoundMatch;
import Gabri.Dev.com.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(String userName, String email);
    Match createUserMatch(Long userId, MatchDifficulty matchDifficulty);

    RoundMatch playUserMatch(Long userId, Long MatchId, Integer numberToPlay);



}

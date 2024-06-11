package Gabri.Dev.com.services;

import Gabri.Dev.com.models.Match;
import Gabri.Dev.com.models.MatchDifficulty;
import Gabri.Dev.com.models.RoundMatch;
import Gabri.Dev.com.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {
    Match createMatch(User user, MatchDifficulty difficulty);
    Match getMatchById(Long matchId);
    RoundMatch playMatch (Match match, Integer number);


}


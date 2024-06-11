package Gabri.Dev.com.services.impl;

import Gabri.Dev.com.entities.UserEntity;
import Gabri.Dev.com.models.Match;
import Gabri.Dev.com.models.MatchDifficulty;
import Gabri.Dev.com.models.RoundMatch;
import Gabri.Dev.com.models.User;
import Gabri.Dev.com.repositories.UserRepository;
import Gabri.Dev.com.services.MatchService;
import Gabri.Dev.com.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MatchService matchService;

    @Override
    public User createUser(String userName, String email) {
        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(email);
        if (userEntityOptional.isPresent()){
            //TODO enviar error al usurario.
            return null;
        }else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userName);
            userEntity.setEmail(email);
            UserEntity userEntitysave = userRepository.save(userEntity);
            return modelMapper.map(userEntitysave,User.class);
        }
    }

    @Override
    public Match createUserMatch(Long userId, MatchDifficulty matchDifficulty) {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if (userEntity.isEmpty()){
            throw new EntityNotFoundException();
        }else {
            User user = modelMapper.map(userEntity.get(),User.class);
            return matchService.createMatch(user,matchDifficulty);
        }
    }

    @Override
    public RoundMatch playUserMatch(Long userId, Long matchId, Integer numberToPlay) {
        Match match = matchService.getMatchById(matchId);
        if (match.getUser().getId().equals(userId)){
            //Todo error
            return null;
        }else {
            return matchService.playMatch(match,numberToPlay);
        }
    }


}

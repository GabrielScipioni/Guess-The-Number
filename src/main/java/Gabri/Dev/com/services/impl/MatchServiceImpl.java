package Gabri.Dev.com.services.impl;

import Gabri.Dev.com.entities.MatchEntity;
import Gabri.Dev.com.entities.UserEntity;
import Gabri.Dev.com.models.*;
import Gabri.Dev.com.repositories.MatchRepository;
import Gabri.Dev.com.services.MatchService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private ModelMapper modelMapper;

    private final Random random = new Random();


    @Override
    public Match createMatch(User user, MatchDifficulty difficulty) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setUserEntity(modelMapper.map(user, UserEntity.class));
        matchEntity.setDifficulty(difficulty);
        switch (difficulty) {
            case HARD -> matchEntity.setRemainingTries(5);
            case MEDIUM -> matchEntity.setRemainingTries(8);
            case EASY -> matchEntity.setRemainingTries(10);
        }
        matchEntity.setNumberToGuess(random.nextInt(100) + 1);
        matchEntity.setStatus(MatchStatus.PLAYING);
        matchEntity.setCreatedAt(LocalDateTime.now());
        matchEntity.setUpdatedAt(LocalDateTime.now());
        MatchEntity matchEntitySaved = matchRepository.save(matchEntity);
        return modelMapper.map(matchEntitySaved, Match.class);
    }


    @Override
    public Match getMatchById(Long matchId) {
        Optional <MatchEntity> matchEntityOptional = matchRepository.findById(matchId);
        if (matchEntityOptional.isEmpty()){
            throw new EntityNotFoundException();
        }else {
            return modelMapper.map(matchEntityOptional.get(),Match.class);
        }
    }

    @Override
    public RoundMatch playMatch(Match match, Integer number) {
        RoundMatch roundMatch = new RoundMatch();
        roundMatch.setMatch(match);
        if (match.getStatus().equals(MatchStatus.FINISH)){
            //Todo error
            return null;
        }
        if (match.getNumberToGuess().equals(number)){
            // todo: calcular score

            // todo: dar respuesta
            match.setStatus(MatchStatus.FINISH);
            roundMatch.setRespuesta("GANO!!!!!");
            return null;
        }else {
            match.setRemainingTries(match.getRemainingTries()-1);
            if (match.getRemainingTries().equals(0)){
            }else {
                if (number > match.getNumberToGuess()){
                    roundMatch.setRespuesta("Menor");

                }else {
                    roundMatch.setRespuesta("Mayor");

                }
            }
        }
        UserEntity userEntity =modelMapper.map(match.getUser(), UserEntity.class);
        MatchEntity matchEntity = modelMapper.map(match,MatchEntity.class);
        matchEntity.setUserEntity(userEntity);
        matchEntity.setUpdatedAt(LocalDateTime.now());
        matchRepository.save(matchEntity);
        return roundMatch;
    }
}


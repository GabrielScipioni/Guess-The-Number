package Gabri.Dev.com.controllers;


import Gabri.Dev.com.dtos.*;
import Gabri.Dev.com.models.Match;
import Gabri.Dev.com.models.RoundMatch;
import Gabri.Dev.com.models.User;
import Gabri.Dev.com.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guess-the-number/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        User user = userService.createUser(userDto.getUserName(), userDto.getEmail());
        UserDto userDtoCreated =modelMapper.map(user, UserDto.class);
        return ResponseEntity.ok(userDtoCreated);
    }
    @PostMapping("{userid}/matches")
    public ResponseEntity<MatchDto> createUserMatch( @PathVariable Long userid,
                                                    @RequestBody CreateUserMatchDto createUserMatchDto){
        Match match = userService.createUserMatch(userid,createUserMatchDto.getDifficulty());
        MatchDto matchDto = modelMapper.map(match,MatchDto.class);
        return ResponseEntity.ok(matchDto);
    }
    @PostMapping("{userid}/matches/{matchId}")
    public ResponseEntity<RoundMatchDto> playUserMatch(@PathVariable Long userid,
                                                       @PathVariable Long matchId,
                                                       @RequestBody PlayUserMatchDto playUserMatchDto){
        RoundMatch roundMatch = userService.playUserMatch(userid,matchId,playUserMatchDto.getNumber());
        MatchDto matchDto = modelMapper.map(roundMatch.getMatch(),MatchDto.class);
        RoundMatchDto roundMatchDto = modelMapper.map(roundMatch,RoundMatchDto.class);
        roundMatchDto.setMatchDto(matchDto);
        return ResponseEntity.ok(roundMatchDto);
    }


















}

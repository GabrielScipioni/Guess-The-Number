package Gabri.Dev.com.controllers;


import Gabri.Dev.com.dtos.MatchDto;
import Gabri.Dev.com.models.Match;
import Gabri.Dev.com.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guess-the-number/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;




















}

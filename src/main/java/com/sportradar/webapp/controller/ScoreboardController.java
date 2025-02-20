package com.sportradar.webapp.controller;


import com.sportradar.scoreboard.service.MatchDto;
import com.sportradar.scoreboard.service.ScoreboardService;
import com.sportradar.scoreboard.service.ScoreboardServiceFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class ScoreboardController {
    ScoreboardService service = ScoreboardServiceFactory.createScoreboardService();

    @GetMapping
    public List<MatchDto> getSummary() {
        return service.getSummary();
    }

    @PostMapping
    void startMatch(String homeTeam, String awayTeam) {
        service.startMatch(homeTeam, awayTeam);
    }

    @PutMapping
    void updateScore(String homeTeam, int homeScore, String awayTeam, int awayScore) {
        service.updateScore(homeTeam, homeScore, awayTeam, awayScore);
    }

    @DeleteMapping
    void finishMatch(String homeTeam, String awayTeam) {
        service.finishMatch(homeTeam, awayTeam);
    }

}

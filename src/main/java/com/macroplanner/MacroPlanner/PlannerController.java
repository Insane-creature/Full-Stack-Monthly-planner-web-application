package com.macroplanner.MacroPlanner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // tells this class is a comtroller
public class PlannerController {
    private ChallengeServices challengeServices; // object of challenge service

    public PlannerController(ChallengeServices challengeServices) {
        this.challengeServices = challengeServices;
    }

    // Defining end point to get list of all the challenges
    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAlltChallenges() {

        return new ResponseEntity<>(challengeServices.getAlltChallenges(), HttpStatus.OK);
    }

    @PostMapping("/challenges")
    public ResponseEntity<String> addChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeServices.addChallenge(challenge);
        if (isChallengeAdded) {
            return new ResponseEntity<>("Challenge added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Challenge not added successfully", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallenges(@PathVariable String month) {
        Challenge challenge = challengeServices.getChallenges(month);
        if (challenge != null)
            return new ResponseEntity<>(challenge, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

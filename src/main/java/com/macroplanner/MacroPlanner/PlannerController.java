package com.macroplanner.MacroPlanner;

import java.util.ArrayList;
import java.util.List;

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
    public List<Challenge> getAlltChallenges() {

        return challengeServices.getAlltChallenges();
    }

    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge challenge) {
        boolean isChallengeAdded = challengeServices.addChallenge(challenge);
        if (isChallengeAdded) {
            return "Challenge added successfully";
        } else {
            return "Challenge not added successfully";
        }

    }

    @GetMapping("/challenges/{month}")
    public Challenge getChallenges(@PathVariable String month) {
        Challenge challenge = challengeServices.getChallenges(month);
        if (challenge != null)
            return challenge;
        else
            return null;
    }

}

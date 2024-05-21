package com.macroplanner.MacroPlanner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallengeServices {
    private List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;

    public ChallengeServices() {

    }

    public List<Challenge> getAlltChallenges() {
        return challenges;
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        } else {
            return false;
        }

    }

    public Challenge getChallenges(String month) {
        for (Challenge challenge : challenges) {
            if (challenge.getMonth().equalsIgnoreCase(month)) {
                return challenge;
            }
        }
        return null;
    }
}

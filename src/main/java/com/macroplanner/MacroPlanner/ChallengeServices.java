package com.macroplanner.MacroPlanner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallengeServices {
    private static List<Challenge> challenges = new ArrayList<>();

    public ChallengeServices() {
        Challenge challenge1 = new Challenge(1L, "January",
                "Create a new planner");

        challenges.add(challenge1);
    }

    public static List<Challenge> getAlltChallenges() {
        return challenges;
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenges.add(challenge);
            return true;
        } else {
            return false;
        }

    }
}

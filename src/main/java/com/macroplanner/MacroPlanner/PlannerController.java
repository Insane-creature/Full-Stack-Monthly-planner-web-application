package com.macroplanner.MacroPlanner;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // tells this class is a comtroller
public class PlannerController {
    private List<Challenge> challenges = new ArrayList<>();

    public PlannerController() {
        Challenge challenge1 = new Challenge(1L, "January", "Create a new planner");

        challenges.add(challenge1);

    }

    // Defining end point to get list of all the challenges
    @GetMapping("/challenges")
    public List<Challenge> getAlltChallenges() {
        return challenges;
    }

}

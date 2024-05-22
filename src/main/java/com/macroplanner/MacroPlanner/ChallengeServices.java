package com.macroplanner.MacroPlanner;

import java.util.ArrayList;
import java.util.List;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChallengeServices {
    // private List<Challenge> challenges = new ArrayList<>();

    private Long nextId = 1L;

    @Autowired
    ChallengeRepo challengeRepo;

    public ChallengeServices() {

    }

    public List<Challenge> getAlltChallenges() {
        return challengeRepo.findAll();
    }

    public boolean addChallenge(Challenge challenge) {
        if (challenge != null) {
            challenge.setId(nextId++);
            challengeRepo.save(challenge);
            return true;
        } else {
            return false;
        }

    }

    public Challenge getChallenges(String month) {
        Optional<Challenge> challenge = challengeRepo.findByMonthIgnoreCase(month);

        // for (Challenge challenge : challenges) { // Commented as we're not using list
        // now,
        // if (challenge.getMonth().equalsIgnoreCase(month)) { // we are interacting
        // with the DB now
        // return challenge; // so it will fetch directly through DB now
        // }
        // }
        // return null;

        return challenge.orElse(null);
    }

    public boolean updateChallenge(Long id, Challenge updatedChallenge) {
        Optional<Challenge> challenge = challengeRepo.findById(id);
        if (challenge.isPresent()) {
            Challenge challengeToUpdate = challenge.get();
            challengeToUpdate.setMonth(updatedChallenge.getMonth());
            challengeToUpdate.setDescription(updatedChallenge.getDescription());
            challengeRepo.save(challengeToUpdate);
            return true;
        }
        return false;

        // for (Challenge challenge : challenges) {
        // if (challenge.getId().equals(id)) {
        // challenge.setMonth(updatedChallenge.getMonth());
        // challenge.setDescription(updatedChallenge.getDescription());
        // return true;
        // }
        // }
        // return false;
    }

    public boolean deleteChallenge(Long id) {
        Optional<Challenge> challenge = challengeRepo.findById(id);
        if (challenge.isPresent()) {
            challengeRepo.deleteById(id);
            return true;
        }

        return false;
        // return challenges.removeIf(challenges -> challenges.getId().equals(id));
    }
}

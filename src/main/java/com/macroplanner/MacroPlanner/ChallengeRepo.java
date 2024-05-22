package com.macroplanner.MacroPlanner;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

//Using CRUD
public interface ChallengeRepo extends JpaRepository<Challenge, Long> {

    Optional<Challenge> findByMonthIgnoreCase(String month);

}

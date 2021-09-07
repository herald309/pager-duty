package com.example.Pager.Duty.repository;

import com.example.Pager.Duty.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {

    List<Developer> findByTeamId(Integer team_id);
}

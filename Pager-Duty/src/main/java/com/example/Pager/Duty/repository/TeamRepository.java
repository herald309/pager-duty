package com.example.Pager.Duty.repository;

import com.example.Pager.Duty.model.Developer;
import com.example.Pager.Duty.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {


}

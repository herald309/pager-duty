package com.example.Pager.Duty.controller;

import com.example.Pager.Duty.model.Developer;
import com.example.Pager.Duty.model.Team;
import com.example.Pager.Duty.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("team")
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @PostMapping("/createteam")
    public Team CreateTeam(@RequestBody Team team) throws Exception {

        try
        {
//            Team team = new Team();
//            team.setName("devops");
//            List<Developer> developers = new ArrayList<Developer>();
//            Developer developer = new Developer();
//            developer.setName("Herald");
//            developer.setPhone_number("7418523606");
//            developers.add(developer);
//
//            team.setDevelopers(developers);
            return teamRepository.save(team);
        }
        catch(Exception exception)
        {
            throw new Exception(exception.getMessage());
        }

    }

    @GetMapping("/getallteams")
    public List<Team> GetAllTeams(){
        return teamRepository.findAll();
    }

}

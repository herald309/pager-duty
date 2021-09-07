package com.example.Pager.Duty.controller;

import com.example.Pager.Duty.model.Developer;
import com.example.Pager.Duty.model.SmsRequest;
import com.example.Pager.Duty.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("developer")
public class DeveloperController {

    @Autowired DeveloperRepository developerRepository;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @GetMapping("/getdevelopersbyteamid/{team_id}")
    public List<Developer> GetDevelopersByTeamId(@PathVariable Integer team_id){
        List<Developer> developers =  developerRepository.findByTeamId(team_id);
        if(developers.size() == 0){
            return new ArrayList<>();
        }
        return developers;

    }

    @GetMapping("/alertteam/{team_id}")
    public Object AlertTeam(@PathVariable Integer team_id){
        List<Developer> developers =  developerRepository.findByTeamId(team_id);
        if(developers.size() == 0){
            return "There is no developers present in the team";
        }
        Random rand = new Random();
        Developer developer =  developers.get(rand.nextInt(developers.size()));

        SmsRequest request = new SmsRequest();
        request.setPhone_number(developer.getPhone_number());
        request.setMessage("Alert Because of violation");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<SmsRequest> entity = new HttpEntity<SmsRequest>(request,headers);

        return restTemplateBuilder.build().postForObject(
                "https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f", entity, String.class);

    }

}


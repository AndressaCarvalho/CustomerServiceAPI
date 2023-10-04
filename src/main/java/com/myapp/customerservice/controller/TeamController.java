package com.myapp.customerservice.controller;

import com.myapp.customerservice.dto.TeamDTO;
import com.myapp.customerservice.model.TeamModel;
import com.myapp.customerservice.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequestMapping("/customerservice/team")
@RestController
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;
    private static final Logger logger = LoggerFactory.getLogger(TeamController.class);

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAllTeam(){
        try {
            List<TeamDTO> teams = teamRepository.findAll().stream().map(TeamDTO::new).toList();

            return new ResponseEntity<List<TeamDTO>>(teams, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = {"{id}"})
    public ResponseEntity<TeamDTO> getQueueById(@PathVariable Long id){
        try {
            Optional<TeamModel> team = teamRepository.findById(id);

            TeamDTO teamDTO = new TeamDTO(
                    team.get().getId(),
                    team.get().getIdOperator(),
                    team.get().getIdTeamType(),
                    team.get().getDeleted()
            );

            return new ResponseEntity<TeamDTO>(teamDTO, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

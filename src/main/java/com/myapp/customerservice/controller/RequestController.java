package com.myapp.customerservice.controller;

import com.myapp.customerservice.dto.RequestDTO;
import com.myapp.customerservice.model.*;
import com.myapp.customerservice.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/customerservice/request")
@RestController
public class RequestController {
    @Autowired
    private TeamTypeRepository teamTypeRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private QueueRepository queueRepository;
    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);


    @GetMapping
    public ResponseEntity<List<RequestDTO>> getAllRequests(){
        try {
            List<RequestDTO> requests = requestRepository.findAll().stream().map(RequestDTO::new).toList();

            return new ResponseEntity<List<RequestDTO>>(requests, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = {"{id}"})
    public ResponseEntity<RequestDTO> getRequestById(@PathVariable Long id){
        try {
            Optional<RequestModel> request = requestRepository.findById(id);

            RequestDTO requestDTO = new RequestDTO(
                    request.get().getId(),
                    request.get().getIdOperator(),
                    request.get().getIdCustomer(),
                    request.get().getIdTeamType(),
                    request.get().getFinished()
            );

            return new ResponseEntity<RequestDTO>(requestDTO, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity postRequest(@RequestParam(required = true) Long customer, @RequestParam(required = true) Long subject) {
        try {
            Optional<SubjectModel> subj = subjectRepository.findById(subject);
            TeamTypeModel teamType = teamTypeRepository.findByIdSubject(subj.get().getId());
            List<TeamModel> teams = teamRepository.findByIdTeamTypeAndDeleted(teamType.getId(), false);

            Long idOperator = null;
            for(TeamModel team : teams)
            {
                List<RequestModel> requests = requestRepository.findByIdOperatorAndFinished(team.getIdOperator(), false);

                if((long) requests.size() < 3)
                {
                    idOperator = team.getIdOperator();
                    break;
                }
            }

            if(idOperator != null)
            {
                saveRequest(idOperator, customer, teamType.getId());
            }
            else
            {
                saveQueue(customer, teamType.getId());
            }

            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private void saveRequest(Long idOperator, Long idCustomer, Long idTeamType) {
        RequestModel newRequest = new RequestModel(idOperator, idCustomer, idTeamType, false);
        requestRepository.save(newRequest);
    }

    private void saveQueue(Long idCustomer, Long idTeamType) {
        QueueModel newRequestToQueue = new QueueModel(idCustomer, idTeamType, false);
        queueRepository.save(newRequestToQueue);
    }
}

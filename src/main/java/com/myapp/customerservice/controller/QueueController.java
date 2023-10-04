package com.myapp.customerservice.controller;

import com.myapp.customerservice.dto.QueueDTO;
import com.myapp.customerservice.model.QueueModel;
import com.myapp.customerservice.repository.QueueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/customerservice/queue")
@RestController
public class QueueController {
    @Autowired
    private QueueRepository queueRepository;
    private static final Logger logger = LoggerFactory.getLogger(QueueController.class);

    @GetMapping
    public ResponseEntity<List<QueueDTO>> getAllQueue(){
        try {
            List<QueueDTO> queues = queueRepository.findAll().stream().map(QueueDTO::new).toList();

            return new ResponseEntity<List<QueueDTO>>(queues, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = {"{id}"})
    public ResponseEntity<QueueDTO> getQueueById(@PathVariable Long id){
        try {
            Optional<QueueModel> queue = queueRepository.findById(id);

            QueueDTO queueDTO = new QueueDTO(
                    queue.get().getId(),
                    queue.get().getIdCustomer(),
                    queue.get().getIdTeamType(),
                    queue.get().getServed()
            );

            return new ResponseEntity<QueueDTO>(queueDTO, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

package com.myapp.customerservice.controller;

import com.myapp.customerservice.dto.OperatorDTO;
import com.myapp.customerservice.model.OperatorModel;
import com.myapp.customerservice.repository.OperatorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/customerservice/operator")
@RestController
public class OperatorController {
    @Autowired
    private OperatorRepository operatorRepository;
    private static final Logger logger = LoggerFactory.getLogger(OperatorController.class);


    @GetMapping
    public ResponseEntity<List<OperatorDTO>> getAllOperators(){
        try {
            List<OperatorDTO> operators = operatorRepository.findAll().stream().map(OperatorDTO::new).toList();

            return new ResponseEntity<List<OperatorDTO>>(operators, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = {"{id}"})
    public ResponseEntity<OperatorDTO> getOperatorById(@PathVariable Long id){
        try {
            Optional<OperatorModel> operator = operatorRepository.findById(id);

            OperatorDTO operatorDTO = new OperatorDTO(
                    operator.get().getId(),
                    operator.get().getName(),
                    operator.get().getDeleted()
            );

            return new ResponseEntity<OperatorDTO>(operatorDTO, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

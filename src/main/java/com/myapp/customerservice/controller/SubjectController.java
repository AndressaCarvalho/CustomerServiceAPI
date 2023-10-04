package com.myapp.customerservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.myapp.customerservice.model.SubjectModel;
import com.myapp.customerservice.dto.SubjectDTO;
import com.myapp.customerservice.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@RequestMapping("/customerservice/subject")
@RestController
public class SubjectController {
    @Autowired
    private SubjectRepository subjectRepository;
    private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);

    @GetMapping
    public ResponseEntity<List<SubjectDTO>> getAllSubjects(){
        try {
            List<SubjectDTO> subjects = subjectRepository.findAll().stream().map(SubjectDTO::new).toList();

            return new ResponseEntity<List<SubjectDTO>>(subjects, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = {"{id}"})
    public ResponseEntity<SubjectDTO> getSubjectById(@PathVariable Long id){
        try {
            Optional<SubjectModel> subject = subjectRepository.findById(id);

            SubjectDTO subjectDTO = new SubjectDTO(
                    subject.get().getId(),
                    subject.get().getDescription()
            );

            return new ResponseEntity<SubjectDTO>(subjectDTO, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

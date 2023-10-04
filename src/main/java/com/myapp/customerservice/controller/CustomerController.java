package com.myapp.customerservice.controller;

import com.myapp.customerservice.dto.CustomerDTO;
import com.myapp.customerservice.model.CustomerModel;
import com.myapp.customerservice.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/customerservice/customer")
@RestController
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(){
        try {
            List<CustomerDTO> customers = customerRepository.findAll().stream().map(CustomerDTO::new).toList();

            return new ResponseEntity<List<CustomerDTO>>(customers, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = {"{id}"})
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable Long id){
        try {
            Optional<CustomerModel> customer = customerRepository.findById(id);

            CustomerDTO customerDTO = new CustomerDTO(
                    customer.get().getId(),
                    customer.get().getName(),
                    customer.get().getDeleted()
            );

            return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
        }
        catch(Exception e)
        {
            logger.error("Error! Exception: ", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

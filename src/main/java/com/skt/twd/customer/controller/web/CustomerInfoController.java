package com.skt.twd.customer.controller.web;

import com.skt.twd.customer.core.object.command.CustomerRequestDTO;
import com.skt.twd.customer.core.object.query.ResponseDto;
import com.skt.twd.customer.core.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerInfoController {

    @Autowired
    CustomerService customerService;

    @ApiOperation(value = "고객정보 조회", httpMethod = "GET", notes = "전체 고객 정보 조회 API.")
    @GetMapping(value="/customer")
    public ResponseEntity<Object> getAllCustomer(){
        return new ResponseEntity<>(customerService.getAllCustomerList(), HttpStatus.OK);
    }

    @ApiOperation(value = "고객정보 조회 단건 ", httpMethod = "GET", notes = "전체 고객 정보 조회 단건 API.")
    @GetMapping(value="/customer/{custId}")
    public ResponseEntity<Object> getCustomer(@PathVariable String custId){
        return new ResponseEntity<>(new ResponseDto(customerService.getCustomer(custId)), HttpStatus.OK);
    }

    @ApiOperation(value = "고객정보 추가 ", httpMethod = "POST", notes = "전체 고객 정보 추가 API.")
    @PostMapping(value="/customer")
    public ResponseEntity<Object> insertCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerService.insertCustomer(customerRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "고객정보 수정", httpMethod = "PUT", notes = "전체 고객 정보 수 API.")
    @PutMapping(value="/customer")
    public ResponseEntity<Object> updateCustomer(@RequestBody CustomerRequestDTO customerRequestDTO){
        customerService.updateCustomer(customerRequestDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "고객정보 삭제 ", httpMethod = "DELETE", notes = "전체 고객 정보 삭제 API.")
    @DeleteMapping(value="/customer/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable String customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
package com.skt.twd.customer.controller.web;

import com.skt.twd.customer.core.service.AuthCustomerService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthCustomerController {
    @Autowired
    AuthCustomerService authCustomerService;

    @ApiOperation(value = "고객정보 인증 ", httpMethod = "GET", notes = "고객 정보 인증 API.")
    @GetMapping(value="/customer/auth/{custId}/{password}")
    public ResponseEntity<Object> authCustomer(@PathVariable String custId, @PathVariable String password){
        return new ResponseEntity<>(authCustomerService.authCustomer(custId, password), HttpStatus.OK);
    }

}

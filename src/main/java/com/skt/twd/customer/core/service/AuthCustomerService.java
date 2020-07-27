package com.skt.twd.customer.core.service;

import com.skt.twd.customer.core.entity.Customer;
import com.skt.twd.customer.core.port_infra.persistent.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class AuthCustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public boolean authCustomer(String custId, String password){
        Optional<Customer> optionalCustomer = customerRepository.findById(custId);
        if(!optionalCustomer.isPresent()){
            return false;
        }else{
            Customer customer = optionalCustomer.get();
            boolean isPwdMatch = passwordEncoder.matches(password,customer.getPassword());
            if(isPwdMatch){
                return true;
            }else{
                return false;
            }
        }
    }
}

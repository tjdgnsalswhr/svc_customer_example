package com.skt.twd.customer.core.service;

import com.skt.twd.customer.core.entity.Customer;
import com.skt.twd.customer.core.object.command.CustomerRequestDTO;
import com.skt.twd.customer.core.object.query.CustomerResponseDTO;
import com.skt.twd.customer.core.port_infra.persistent.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public List<Customer> getAllCustomerList(){
       return customerRepository.findAll();
    }

    public CustomerResponseDTO getCustomer(String id){
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isPresent()){
            return modelMapper.map(optionalCustomer.get(), CustomerResponseDTO.class);
        }else{
            return null;
        }
    }

    public void insertCustomer(CustomerRequestDTO customerRequestDTO){
        Customer customer = modelMapper.map(customerRequestDTO, Customer.class);
        String password = passwordEncoder.encode(customerRequestDTO.getPassword()); //비밀번호 암호화
        customer.setPassword(password);
        customerRepository.save(customer);
    }

    public void updateCustomer(CustomerRequestDTO customerRequestDTO){
        Customer customer = modelMapper.map(customerRequestDTO, Customer.class);
        String password = passwordEncoder.encode(customerRequestDTO.getPassword()); //비밀번호 암호화
        customer.setPassword(password);
        customerRepository.save(customer);
    }

    public void deleteCustomer(String custId){
        Optional<Customer> optionalCustomer = customerRepository.findById(custId);
        customerRepository.delete(optionalCustomer.get());
    }

}

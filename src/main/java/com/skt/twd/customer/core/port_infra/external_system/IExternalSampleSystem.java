package com.skt.twd.customer.core.port_infra.external_system;

import com.skt.twd.customer.core.object.command.SampleDomainCommandApiRequestDTO;
import org.springframework.http.ResponseEntity;

public interface IExternalSampleSystem {

    public ResponseEntity<String> doSomeExternalLogic(final SampleDomainCommandApiRequestDTO sampleDomainCommandApiRequestDTO);

}
package com.mtit.microservice.documentservice.documentservice.service;

import com.mtit.microservice.documentservice.documentservice.dto.FromRequest;
import com.mtit.microservice.documentservice.documentservice.repository.FromRepositroy;
import com.mtit.microservice.documentservice.documentservice.util.Form;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class FormService {

    @Autowired
    private FromRepositroy fromRepositroy;
    @Autowired
    private WebClient.Builder webClient;

    public void formSubmission(FromRequest fromRequest) throws IOException {
        Form form = Form.builder()
                .Email(fromRequest.getEmail())
                .Name(fromRequest.getName())
                .Message(fromRequest.getMessage())
                .Subject(fromRequest.getSubject())
                .build();


        fromRepositroy.save(form);

    }
}

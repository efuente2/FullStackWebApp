package com.mtit.microservice.documentservice.documentservice.service;

import com.mtit.microservice.documentservice.documentservice.dto.FormRequest;
import com.mtit.microservice.documentservice.documentservice.dto.FormResponse;
import com.mtit.microservice.documentservice.documentservice.dto.ProductResponse;
import com.mtit.microservice.documentservice.documentservice.repository.FormRepository;
import com.mtit.microservice.documentservice.documentservice.util.Form;
import com.mtit.microservice.documentservice.documentservice.util.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
public class FormService {

    @Autowired
    private FormRepository formRepository;
    @Autowired
    private WebClient.Builder webClient;

    public String formSubmission(FormRequest fromRequest) throws IOException {
        Form form = Form.builder()
                .Email(fromRequest.getEmail())
                .Name(fromRequest.getName())
                .Message(fromRequest.getMessage())
                .Subject(fromRequest.getSubject())
                .build();


        formRepository.save(form);
        log.info("Form " + form.getId() + " is saved");
        return "Form is saved";

    }

    public List<FormResponse> getAllForms(){
        List<Form> formList = formRepository.findAll();

        return formList.stream().map(this::mapToFormRepository).toList();
    }

    private FormResponse mapToFormRepository(Form form) {
        log.info("Product " + form.getId() + " was retrieved");


        return FormResponse.builder()
                .id(form.getId())
                .email(form.getEmail())
                .name(form.getName())
                .message(form.getMessage())
                .subject(form.getSubject())
                .build();
    }

}

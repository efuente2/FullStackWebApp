package com.mtit.microservice.documentservice.documentservice.repository;

import com.mtit.microservice.documentservice.documentservice.util.Form;
import com.mtit.microservice.documentservice.documentservice.util.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FromRepositroy extends JpaRepository<Form, Integer> {
}

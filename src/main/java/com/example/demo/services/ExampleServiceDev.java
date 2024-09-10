package com.example.demo.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class ExampleServiceDev implements ExampleService{
    @Override
    public void doSomething() {
        System.out.println("Doing QA stuff...");
    }
}

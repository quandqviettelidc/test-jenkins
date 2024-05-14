package com.example.demo.controller;

import com.cdancy.jenkins.rest.JenkinsClient;
import com.cdancy.jenkins.rest.domain.system.SystemInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingController {

    @GetMapping("/api/v1/testing")
    public String test() {

        JenkinsClient client = JenkinsClient.builder()
                .endPoint("https://jenkins.idist.dev") // Optional. Defaults to http://127.0.0.1:8080
                .credentials("devops:Vtdc@2024") // Optional.
                .build();

        SystemInfo systemInfo = client.api().systemApi().systemInfo();

        return systemInfo.jenkinsVersion();
    }
}

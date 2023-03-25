package com.mycompany.controller;

import com.mycompany.ResumerestapiApplication;
import com.mycompany.dto.ResponseDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(
        classes = ResumerestapiApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @DisplayName("Get Users")
    @Test
    public void getUsersTest() {
        ResponseEntity<ResponseDTO> response = restTemplate.getForEntity("/users", ResponseDTO.class);
        Assertions.assertSame(response.getStatusCode(), HttpStatus.OK);
        System.out.println(response.getBody());
    }

    @DisplayName("Filter")
    @Test
    public void filterTest() {
        ResponseEntity<ResponseDTO> response = restTemplate.getForEntity("/users/filter?name=vusal&surname=axundzade", ResponseDTO.class);
        Assertions.assertSame(response.getStatusCode(), HttpStatus.OK);
        System.out.println(response.getBody());
    }

    @DisplayName("Get User")
    @Test
    public void getUserTest() {
        ResponseEntity<ResponseDTO> response = restTemplate.getForEntity("/users/18", ResponseDTO.class);
        Assertions.assertSame(response.getStatusCode(), HttpStatus.OK);
        System.out.println(response.getBody());
    }

}

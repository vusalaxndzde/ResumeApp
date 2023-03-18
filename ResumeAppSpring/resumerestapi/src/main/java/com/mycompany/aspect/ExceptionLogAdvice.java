package com.mycompany.aspect;

import com.mycompany.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionLogAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseDTO> exceptionHandler(Exception ex) {
        return ResponseEntity.internalServerError().body(ResponseDTO.of(500, ex.getMessage()));
    }

}

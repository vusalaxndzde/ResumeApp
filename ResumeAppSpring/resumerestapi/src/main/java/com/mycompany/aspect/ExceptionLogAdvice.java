package com.mycompany.aspect;

import com.mycompany.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.logging.Level;
import java.util.logging.Logger;

@ControllerAdvice
public class ExceptionLogAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ResponseDTO> exceptionHandler(Exception ex) {
        Logger.getLogger(ExceptionLogAdvice.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        return ResponseEntity.internalServerError().body(ResponseDTO.of(500, ex.getMessage()));
    }

}

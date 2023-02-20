package com.Dashboard.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utils {


    public static ResponseEntity<String> getResponseEntity(String messageEntity, HttpStatus httpStatus){
        return new ResponseEntity<String>("{message : " +messageEntity+'}',httpStatus);
    }
}

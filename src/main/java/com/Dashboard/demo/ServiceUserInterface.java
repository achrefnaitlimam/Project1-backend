package com.Dashboard.demo;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ServiceUserInterface {
    public ResponseEntity<String> SignUp(Map<String,String> requestMap);
    public List<User> AfficheUser(Map<String,String> requestMap);
    public ResponseEntity<String> deleterUSR(String name);
}

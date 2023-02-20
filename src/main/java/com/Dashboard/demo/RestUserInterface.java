package com.Dashboard.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RequestMapping(path = "/")
public interface RestUserInterface {
@PostMapping(path = "/Register")
    public ResponseEntity<String> SignUp(@RequestBody(required = true) Map<String, String>requestMap);
@GetMapping(path ="/Users")
public List<User> affiche(@RequestBody(required = false) Map<String, String>requestMap);
@DeleteMapping(path ="/DeleteUsr")
public ResponseEntity<String> delteteUser(@RequestParam String name);

}

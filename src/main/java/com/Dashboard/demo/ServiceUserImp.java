package com.Dashboard.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ServiceUserImp implements ServiceUserInterface {
    @Autowired
    Repo mongo;
    @Override
    public ResponseEntity<String> SignUp(Map<String, String> requestMap) {
        if (verify(requestMap)) {
            if(mongo.findByName(requestMap.get("name")).isEmpty()){
                mongo.save(getUserFromMap(requestMap));
                return Utils.getResponseEntity("User Added", HttpStatus.ACCEPTED);
            }
            else {
                return Utils.getResponseEntity("Name Already existe",HttpStatus.ALREADY_REPORTED);
            }
        } else {
           return  Utils.getResponseEntity("INVALID DATA ", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<User> AfficheUser(Map<String, String> requestMap) {
              return mongo.findAll();
    }

    @Override
    public ResponseEntity<String> deleterUSR(String name) {
            mongo.deleteByName(name);
            return Utils.getResponseEntity("User Deleted", HttpStatus.ACCEPTED);
    }

    private User getUserFromMap(Map<String, String> requestMap) {
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setEmail(requestMap.get("email"));
        user.setPasword(requestMap.get("password"));
        return user;
    }

    private boolean verify(Map<String, String> requestMap) {
        if (requestMap.containsKey("name") && requestMap.containsKey("email"))
            return true;
        else return false;
    }

}
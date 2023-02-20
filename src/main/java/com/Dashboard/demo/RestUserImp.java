package com.Dashboard.demo;

import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public class RestUserImp implements RestUserInterface {
    @Autowired
    ServiceUserInterface ServiceUser;
    @Override
    public ResponseEntity<String> SignUp(Map<String, String> requestMap) {
        try{
            return ServiceUser.SignUp(requestMap);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return Utils.getResponseEntity("Something wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public List<User> affiche(Map<String, String> requestMap) {
            return ServiceUser.AfficheUser(requestMap);
    }

    @Override
    public ResponseEntity<String> delteteUser(String name) {

        return ServiceUser.deleterUSR(name);
    }


}

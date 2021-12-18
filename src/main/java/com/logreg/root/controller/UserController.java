package com.logreg.root.controller;

import com.logreg.root.dto.UserDTO;
import com.logreg.root.entity.User;
import com.logreg.root.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

   private final UserService userService;

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck(){

        return new ResponseEntity<>("Healthy", HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers(){
        return  new ResponseEntity<>(this.userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/{country}")
    public ResponseEntity<List<User>> getUsersByCountry(@PathVariable("country") String country){
        return  new ResponseEntity<>(this.userService.getUsersByCountry(country),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> registerUser(@RequestBody UserDTO userDTO) throws Exception {
        try {
            this.userService.addUser(userDTO.getUser());
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


}

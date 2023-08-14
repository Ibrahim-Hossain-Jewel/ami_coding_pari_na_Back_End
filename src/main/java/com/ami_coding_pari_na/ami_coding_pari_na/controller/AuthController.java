package com.ami_coding_pari_na.ami_coding_pari_na.controller;
import com.ami_coding_pari_na.ami_coding_pari_na.DTO.AuthDTO;
import com.ami_coding_pari_na.ami_coding_pari_na.DTO.KhojDTO;
import com.ami_coding_pari_na.ami_coding_pari_na.DTO.UserActivityDTO;
import com.ami_coding_pari_na.ami_coding_pari_na.model.KhojData;
import com.ami_coding_pari_na.ami_coding_pari_na.model.User;
import com.ami_coding_pari_na.ami_coding_pari_na.repo.KhojRepo;
import com.ami_coding_pari_na.ami_coding_pari_na.repo.LoginRepo;
import com.ami_coding_pari_na.ami_coding_pari_na.repo.RegistrationRepo;
import com.ami_coding_pari_na.ami_coding_pari_na.response.AuthResponse;
import com.ami_coding_pari_na.ami_coding_pari_na.response.KhojResponse;
import com.ami_coding_pari_na.ami_coding_pari_na.response.UserActivityDetailsResponse;
import com.ami_coding_pari_na.ami_coding_pari_na.service.authService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AuthController {
    @Autowired
    authService authService;
    @Autowired
    RegistrationRepo registrationRepo;
    @Autowired
    LoginRepo loginRepo;
    @Autowired(required = true)
    KhojRepo khojRepo;
    @PostMapping(path = "/registration")
    public ResponseEntity<?> registrationUser(@RequestBody AuthDTO authDTO){
        AuthResponse authResponse = authService.registration(authDTO);
        return ResponseEntity.ok(authResponse);
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody AuthDTO authDTO){
        AuthResponse authResponse = authService.login(authDTO);
        return ResponseEntity.ok(authResponse);
    }
    @PostMapping(path = "/Khoj")
    public ResponseEntity<?> KhojArray(@RequestBody KhojDTO khojDTO){
        System.out.println("your khojdata" + khojDTO);
        KhojResponse khojResponse = authService.khojSubmit(khojDTO);
        return ResponseEntity.ok(khojResponse);
    }
    @GetMapping(value = "/khojoutput")
    public List<KhojData>getTreeKhoj() {
        return khojRepo.findAll();
    }

    @PostMapping(path = "/activity")
    public ResponseEntity<?> getActivity(@RequestBody KhojDTO khojDTO){
//        return khojRepo.findAllByuserid(userid);
        UserActivityDetailsResponse userActivityDetailsResponse = authService.activityDetails(khojDTO);
        return ResponseEntity.ok(userActivityDetailsResponse);
    }
}

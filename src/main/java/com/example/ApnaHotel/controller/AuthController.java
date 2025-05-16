package com.example.ApnaHotel.controller;

import com.example.ApnaHotel.dto.LoginRequest;
import com.example.ApnaHotel.dto.Response;
import com.example.ApnaHotel.entity.User;
import com.example.ApnaHotel.service.interfac.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final org. slf4j. Logger log
            = org. slf4j. LoggerFactory. getLogger(AuthController.class);

    @Autowired
    private IUserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/register")
    public ResponseEntity<Response> register(@RequestBody User user) {
        log.info("email address here: "+user.getPassword());
        Response response = userService.register(user);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody LoginRequest loginRequest) {
        log.info("email address here: "+loginRequest.getEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        log.info("password check address here: "+encoder.matches("nohan@123",loginRequest.getPassword()));
        Response response = userService.login(loginRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
}

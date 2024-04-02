package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.requests.AuthenticationResponse;
import com.example.Fake_Twitter_Rest_API.models.requests.LoginRequest;
import com.example.Fake_Twitter_Rest_API.models.requests.RegistrationRequest;
import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.repositories.UserRepository;
import com.example.Fake_Twitter_Rest_API.services.regex.EmailValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

/**
 * This class is used for Register Logic
 */
@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationService {
    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Se inregistreaza un nou utilizator
     * @param request
     * @return
     */
    public AuthenticationResponse register(RegistrationRequest request) {
        User user = authenticateUser(request);
        var checkUser = userRepository.findByEmail(request.getEmail());
        if(checkUser.isPresent()){
            throw new RuntimeException("User already exist");
        }
        var jwtToken = jwtService.generateToken(user);
        if(checkUser.isEmpty())
            userRepository.save(user);
        return AuthenticationResponse.builder().token(jwtToken).build();

    }


    /**
     * Se face autentificarea userului
     * @return
     */
    private User authenticateUser(RegistrationRequest request){
        return User.builder()
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .email(request.getEmail())
                .password(bCryptPasswordEncoder.encode(request.getPassword()))
                .followList(new ArrayList<>())
                .followersList(new ArrayList<>())
                .build();
    }

    /**
     * Se face login
     * @param request
     * @return
     */
    public AuthenticationResponse authenticate(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );
        var user= userRepository.findByEmail(request.getUsername()).orElseThrow();

        var jwtToken =  jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    /**
     * This method allows the user to delete it's account permanently
     * @return
     */
    public String deletePersonalAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if(principal instanceof User){

            User userDetails =  (User) principal;

            String username = userDetails.getUsername();
            var user = userRepository.findByEmail(username);
            if(user.isPresent()){
                userRepository.delete(user.get());
                return "User deleted";
            }
        }

        SecurityContextHolder.clearContext();
        return "User does not exist";
    }
}

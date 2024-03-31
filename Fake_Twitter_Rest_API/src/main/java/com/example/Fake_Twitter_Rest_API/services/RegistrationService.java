package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.LoginRequest;
import com.example.Fake_Twitter_Rest_API.models.RegistrationRequest;
import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.repositories.UserRepository;
import com.example.Fake_Twitter_Rest_API.services.regex.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

/**
 * This class is used for Register Logic
 */
@Service
public class RegistrationService {
    @Autowired
    private EmailValidator emailValidator;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Se inregistreaza un nou utilizator
     * @param request
     * @return
     */
    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email not valid");
        }


        return userService.signUpUser(new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                request.getPassword()
        ));
    }

    /**
     * Se face autentificarea userului
     * @param email
     * @param password
     * @return
     */
    public User authenticateUser(String email, String password){
        System.out.println("Emailul userului:");
        Optional<User> authenticatedUser = userRepository.findByEmail(email);
        System.out.println(authenticatedUser.get().getEmail());
        if(authenticatedUser.isPresent() && bCryptPasswordEncoder.matches(password, authenticatedUser.get().getPassword())){
            return authenticatedUser.get();
        }
        return null;
    }
}

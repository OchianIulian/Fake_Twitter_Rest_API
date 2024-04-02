package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserActionsService {
    @Autowired
    UserRepository userRepository;
    public String getUserDetailsByUsername(String username) {
        Optional<User> user = userRepository.findByEmail(username);
        if(user.isPresent()){
            String userName = user.get().getUsername();
            String firstName = user.get().getFirstname();
            String lastName = user.get().getLastname();

            String response = "username: " + userName + "\nfirstName: " + firstName
                    + "\nlastName: " + lastName;
            return response;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public String getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if(principal instanceof UserDetails){
            User userDetails =  (User) principal;

            String username = userDetails.getUsername();
            String firstName = userDetails.getFirstname();
            String lastName = userDetails.getLastname();

            String response = "username: " + username + "\nfirstName: " + firstName
                    + "\nlastName: " + lastName;
            return response;
        } else throw new RuntimeException("Something wrong in getUserInfo()");
    }
}

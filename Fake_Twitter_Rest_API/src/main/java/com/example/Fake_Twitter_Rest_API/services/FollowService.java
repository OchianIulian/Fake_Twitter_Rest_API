package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This clas is responsible for following requests logic
 */
@Service
@AllArgsConstructor
public class FollowService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    /**
     * Follow somebody and the follower become followed by current user.
     * This information is stored in followersList and followList in UserEntity
     * @param userEmail
     * @return
     */
    public ResponseEntity<String> followByEmail(String userEmail) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        Optional<User> user = userRepository.findByEmail(userEmail);
        if(user.isPresent()){
            User newUser = (User) principal;
            User followedUser = user.get();
            List<String> followedList;
            List<String> followList = newUser.getFollowList();
            if(!followList.contains(userEmail)){
                followedList = followedUser.getFollowersList();
                followedList.add(newUser.getEmail());
                followedUser.setFollowersList(followedList);

                followList.add(userEmail);
                newUser.setFollowList(followList);
            } else {
                return ResponseEntity.ok("User already exist");
            }
            userRepository.save(newUser);
            userRepository.save(followedUser);
            return ResponseEntity.ok("Follow aproved");
        } else {
            return ResponseEntity.ok("Nu exista userul dat");
        }
    }
}

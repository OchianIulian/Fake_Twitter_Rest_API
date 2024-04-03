package com.example.Fake_Twitter_Rest_API.services;

import com.example.Fake_Twitter_Rest_API.models.User;
import com.example.Fake_Twitter_Rest_API.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * This class contains the logic for requests made by user after it logged in
 */
@Service
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserActionsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FollowService followService;

    /**
     * User obtain all information about another by it's username
     * @param username
     * @return
     */
    public String getUserDetailsByUsername(String username) {
        Optional<User> user = userRepository.findByEmail(username);
        if(user.isPresent()){
            String userName = user.get().getUsername();
            String firstName = user.get().getFirstname();
            String lastName = user.get().getLastname();

            List<String> followList = user.get().getFollowList();
            List<String> followersList = user.get().getFollowersList();

            String response = "username: " + username + "\nfirstName: " + firstName
                    + "\nlastName: " + lastName + "\nfollowing: "+followList.toString()
                    +"\nfollowers: "+followersList.toString();
            return response;
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    /**
     * Return all details about current user
     * @return
     */
    public String getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if(principal instanceof UserDetails){
            User userDetails =  (User) principal;

            String username = userDetails.getUsername();
            String firstName = userDetails.getFirstname();
            String lastName = userDetails.getLastname();

            List<String> followList = userDetails.getFollowList();
            List<String> followersList = userDetails.getFollowersList();

            String response = "username: " + username + "\nfirstName: " + firstName
                    + "\nlastName: " + lastName + "\nfollowing: "+followList.toString()
                    +"\nfollowers: "+followersList.toString();
            return response;
        } else throw new RuntimeException("Something wrong in getUserInfo()");
    }

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
        User newUser = (User) principal;
        //se verifica daca userul e diferit de cel conectat
        if(user.get().equals(newUser)){
            throw new RuntimeException("You can not follow same user");
        }

        if(user.isPresent() ){
            User followedUser = user.get();
            List<String> followedList;
            List<String> followList = newUser.getFollowList();
            //se verifica daca s-a mai dat follow inainte
            if(!followList.contains(userEmail)){
                followedList = followedUser.getFollowersList();
                followedList.add(newUser.getEmail());
                followedUser.setFollowersList(followedList);

                followList.add(userEmail);
                newUser.setFollowList(followList);
            } else {
                return ResponseEntity.ok("User already exist");
            }
            //save in tables
            userRepository.save(newUser);
            userRepository.save(followedUser);
            followService.followUser(newUser, followedUser);
            return ResponseEntity.ok("Follow aproved");
        } else {
            return ResponseEntity.ok("Nu exista userul dat");
        }
    }
}

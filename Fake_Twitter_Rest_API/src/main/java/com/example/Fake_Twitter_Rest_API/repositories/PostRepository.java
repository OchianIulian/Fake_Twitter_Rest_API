package com.example.Fake_Twitter_Rest_API.repositories;

import com.example.Fake_Twitter_Rest_API.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
    @Query("SELECT p FROM Post p WHERE p.user.id = :userId")
    List<Post> findPostsByUserId(@Param("userId") Long userId);

//    @Query("select p from post p where p.user_id in (" +
//            "select u.id from user u where u.id in (" +
//            "select f.following_user_id from follow f where f.user_id = :userId" +
//            ")" +
//            ")")
//    List<Post> getFeed( Long userId );

    @Query("SELECT p FROM Post p WHERE p.user.id IN (SELECT u.id FROM User u WHERE u.id IN (SELECT f.followingUser.id FROM Follow f WHERE f.user.id = :userId))")
    List<Post> getFeed( Long userId );
}

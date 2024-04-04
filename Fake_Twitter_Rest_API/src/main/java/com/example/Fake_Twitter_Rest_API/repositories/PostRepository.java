package com.example.Fake_Twitter_Rest_API.repositories;

import com.example.Fake_Twitter_Rest_API.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is used for managing post table
 */
@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {
    /**
     * Return as string with all posts of connected user
     * @param userId
     * @return
     */
    @Query("SELECT p FROM Post p WHERE p.user.id = :userId")
    List<Post> findPostsByUserId(@Param("userId") Long userId);

    /**
     * Return as string with all posts of connected user's friends
     * @param userId
     * @return
     */
    @Query("SELECT p FROM Post p WHERE p.user.id IN (SELECT u.id FROM User u WHERE u.id IN (SELECT f.followingUser.id FROM Follow f WHERE f.user.id = :userId))")
    List<Post> getFeed( Long userId );
}

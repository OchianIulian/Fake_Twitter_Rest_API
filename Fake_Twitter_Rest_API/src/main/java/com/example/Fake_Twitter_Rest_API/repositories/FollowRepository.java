package com.example.Fake_Twitter_Rest_API.repositories;

import com.example.Fake_Twitter_Rest_API.models.Follow;
import com.example.Fake_Twitter_Rest_API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * This class is used for managing follow table
 */
@Repository
@Transactional
public interface FollowRepository extends JpaRepository<Follow, Long> {

    @Query("SELECT f FROM Follow f where f.user = :follower and f.followingUser = :following")
    Optional<Follow> findFollow(@Param("follower") User follower, @Param("following")User following);
}

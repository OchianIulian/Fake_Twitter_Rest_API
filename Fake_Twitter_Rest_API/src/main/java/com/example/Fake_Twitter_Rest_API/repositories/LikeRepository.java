package com.example.Fake_Twitter_Rest_API.repositories;

import com.example.Fake_Twitter_Rest_API.models.Like;
import com.example.Fake_Twitter_Rest_API.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * This class is used for managing Like tables
 */
@Repository
@Transactional
public interface LikeRepository extends JpaRepository<Like, Long>{
    @Query("SELECT l FROM Like l where l.id = :postId")
    Optional<Like> findByPost(@Param("postId") Long postId);

    @Query("SELECT count(l) FROM Like l where l.id = :postId")
    long getPostLikes(@Param("postId") Long postId);

}

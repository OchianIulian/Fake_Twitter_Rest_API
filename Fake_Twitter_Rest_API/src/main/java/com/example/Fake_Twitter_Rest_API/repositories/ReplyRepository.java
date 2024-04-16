package com.example.Fake_Twitter_Rest_API.repositories;

import com.example.Fake_Twitter_Rest_API.models.Like;
import com.example.Fake_Twitter_Rest_API.models.Post;
import com.example.Fake_Twitter_Rest_API.models.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * This class is used for managing Reply tables
 */
@Repository
@Transactional
public interface ReplyRepository extends JpaRepository<Reply, Long>{

    @Query("SELECT r FROM Reply r where r.post = :postId")
    List<Reply> findByPost(@Param("postId") Post postId);

}

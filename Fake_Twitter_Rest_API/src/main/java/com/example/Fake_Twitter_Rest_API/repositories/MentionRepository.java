package com.example.Fake_Twitter_Rest_API.repositories;

import com.example.Fake_Twitter_Rest_API.models.Mention;
import com.example.Fake_Twitter_Rest_API.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface MentionRepository  extends JpaRepository<Mention, Long>{
    @Query("SELECT m.post FROM Mention m " +
            "where m.user.id = :userId")
    List<Post> findPostsByMentionedUserId(@Param("userId") Long userId);
}

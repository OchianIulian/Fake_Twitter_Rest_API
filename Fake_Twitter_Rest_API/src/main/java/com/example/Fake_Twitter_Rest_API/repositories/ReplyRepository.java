package com.example.Fake_Twitter_Rest_API.repositories;

import com.example.Fake_Twitter_Rest_API.models.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class is used for managing Reply tables
 */
@Repository
@Transactional
public interface ReplyRepository extends JpaRepository<Reply, Long>{
}

package com.example.Fake_Twitter_Rest_API.repositories;

import com.example.Fake_Twitter_Rest_API.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//@Repository
//@Transactional
public interface LikeRepository extends JpaRepository<Like, Long>{
}

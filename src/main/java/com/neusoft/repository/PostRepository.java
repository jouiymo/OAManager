package com.neusoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neusoft.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}

package com.codeup.repositories;

import com.codeup.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    Post findByTitle(String title);

    Post getById(long id);

}

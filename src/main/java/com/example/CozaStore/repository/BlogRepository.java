package com.example.CozaStore.repository;

import com.example.CozaStore.entity.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Integer> {

    @Query("select b FROM blog b")
    Page<BlogEntity> getBlogPaging(Pageable pageable);

    @Query("select b from blog b, tag_blog tb where b.id = tb.blog.id and tb.tag.id = :id")
    Page<BlogEntity> getAllBlogByTagId(Pageable pageable,int id);

    @Query("select b from blog b")
    List<BlogEntity> getAll();
}

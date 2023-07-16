package com.example.CozaStore.repository;


import com.example.CozaStore.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}

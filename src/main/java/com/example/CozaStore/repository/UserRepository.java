package com.example.CozaStore.repository;

import com.example.CozaStore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
//    @Query("from users where email = ?1")
//    List<UserEntity> getUserByEmail(String email);

    UserEntity findByEmail(String email);

    @Query("select u from user u where u.id = ?1")
    UserEntity findUserById(Integer Id);

}

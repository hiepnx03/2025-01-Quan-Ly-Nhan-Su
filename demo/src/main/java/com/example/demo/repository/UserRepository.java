package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    //    Optional<User> findByUsername(String username);
    User findByRefreshToken(String refreshToken);

    User findByEmail(String email);

    User findByUserName(String username);

    User findByEmailAndStatus(String userName, Integer status);

    User findByVerificationCode(String verificationCode);

    @Query("select u from User u where enabled = true")
    Page<User> findAllByEnabledPage(Pageable pageable);

    @Query("select u from User u where enabled = false")
    Page<User> findAllByDisablePage(Pageable pageable);
}


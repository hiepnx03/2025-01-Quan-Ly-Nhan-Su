package com.example.demo.repository;


import com.example.demo.entity.Hopdongcanbo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface HopdongcanboRepository extends JpaRepository<Hopdongcanbo, Long> {

    @Query("select h from Hopdongcanbo h")
    Page<Hopdongcanbo> getAllPage(Pageable pageable);
}

package com.example.demo.repository;


import com.example.demo.entity.Hopdongcanbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopdongcanboRepository extends JpaRepository<Hopdongcanbo, Long> {

}

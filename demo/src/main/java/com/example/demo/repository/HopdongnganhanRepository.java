package com.example.demo.repository;


import com.example.demo.entity.Hopdongnganhan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HopdongnganhanRepository extends JpaRepository<Hopdongnganhan, Long> {

}
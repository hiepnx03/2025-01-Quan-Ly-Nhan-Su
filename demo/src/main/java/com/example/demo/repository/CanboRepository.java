package com.example.demo.repository;

import com.example.demo.entity.Canbo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanboRepository extends JpaRepository<Canbo, Long> {

}

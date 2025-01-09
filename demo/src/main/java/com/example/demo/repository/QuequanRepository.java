package com.example.demo.repository;

import com.example.demo.entity.Quequan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuequanRepository extends JpaRepository<Quequan, Long> {

}

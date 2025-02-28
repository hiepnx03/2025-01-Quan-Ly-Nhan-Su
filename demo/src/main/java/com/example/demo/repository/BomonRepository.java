package com.example.demo.repository;

import com.example.demo.entity.Bomon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BomonRepository extends JpaRepository<Bomon, Long> {

    @Query("SELECT b FROM Bomon b")
    Page<Bomon> getAllPage (Pageable pageable);

    Page<Bomon> findByTenBoMonContainingIgnoreCase(String tenBoMon, Pageable pageable);

}

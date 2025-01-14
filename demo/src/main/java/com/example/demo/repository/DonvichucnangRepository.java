package com.example.demo.repository;


import com.example.demo.entity.Donvichucnang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DonvichucnangRepository extends JpaRepository<Donvichucnang, Long> {

    @Query("select d from Donvichucnang d")
    Page<Donvichucnang> getAllPage(Pageable pageable);
}

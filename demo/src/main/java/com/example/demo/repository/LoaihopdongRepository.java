package com.example.demo.repository;


import com.example.demo.entity.Loaihopdong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaihopdongRepository extends JpaRepository<Loaihopdong, Long> {

    @Query("select l from Loaihopdong l")
    Page<Loaihopdong> findAllPage(Pageable pageable);
}

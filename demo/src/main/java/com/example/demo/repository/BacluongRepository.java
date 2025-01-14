package com.example.demo.repository;

import com.example.demo.entity.Bacluong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BacluongRepository extends JpaRepository<Bacluong, Long>{
    @Query("SELECT b from Bacluong b")
    Page<Bacluong> findAllPage(Pageable pageable);
}

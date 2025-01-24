package com.example.demo.repository;


import com.example.demo.entity.Dantoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DantocRepository extends JpaRepository<Dantoc, Long> {

    @Query("select d from Dantoc d")
    Page<Dantoc> findAllPage(Pageable pageable);

    Page<Dantoc> findByTenDanTocContainingIgnoreCase(String tenDanToc, Pageable pageable);
}

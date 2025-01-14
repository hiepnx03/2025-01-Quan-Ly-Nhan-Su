package com.example.demo.repository;


import com.example.demo.entity.Tongiao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TongiaoRepository extends JpaRepository<Tongiao, Long> {

    @Query("select t from Tongiao t")
    Page<Tongiao> findAllPage(Pageable pageable);
}

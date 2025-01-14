package com.example.demo.repository;


import com.example.demo.entity.Loaiquyetdinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiquyetdinhRepository extends JpaRepository<Loaiquyetdinh, Long> {

    @Query("select l from Loaiquyetdinh l")
    Page<Loaiquyetdinh> findAllPage(Pageable pageable);
}

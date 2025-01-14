package com.example.demo.repository;


import com.example.demo.entity.Quyetdinh;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyetdinhRepository extends JpaRepository<Quyetdinh, Long> {

    @Query("select q from Quyetdinh q")
    Page<Quyetdinh> findAllPage(Pageable pageable);
}

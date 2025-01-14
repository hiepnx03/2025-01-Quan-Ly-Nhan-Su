package com.example.demo.repository;


import com.example.demo.entity.Chucvu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ChucvuRepository extends JpaRepository<Chucvu, Long> {

    @Query("select c from Chucvu c")
    Page<Chucvu> getAllPageable(Pageable pageable);
}

package com.example.demo.repository;


import com.example.demo.entity.Quyetdinhkyluat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyetdinhkyluatRepository extends JpaRepository<Quyetdinhkyluat, Long> {

    @Query("select q from Quyetdinhkyluat q")
    Page<Quyetdinhkyluat> findAllPage(Pageable pageable);
}

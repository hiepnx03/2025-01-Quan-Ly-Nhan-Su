package com.example.demo.repository;


import com.example.demo.entity.Quyetdinhkhenthuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyetdinhkhenthuongRepository extends JpaRepository<Quyetdinhkhenthuong, Long> {

}

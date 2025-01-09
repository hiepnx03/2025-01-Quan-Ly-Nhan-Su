package com.example.demo.repository;


import com.example.demo.entity.Loaihopdong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaihopdongRepository extends JpaRepository<Loaihopdong, Long> {

}

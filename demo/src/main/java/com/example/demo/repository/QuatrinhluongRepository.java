package com.example.demo.repository;


import com.example.demo.entity.Quatrinhluong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuatrinhluongRepository extends JpaRepository<Quatrinhluong, Long> {

}

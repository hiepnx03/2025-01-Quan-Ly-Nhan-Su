package com.example.demo.repository;


import com.example.demo.entity.Tongiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TongiaoRepository extends JpaRepository<Tongiao, Long> {

}

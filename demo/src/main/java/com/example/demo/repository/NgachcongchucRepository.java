package com.example.demo.repository;


import com.example.demo.entity.Ngachcongchuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgachcongchucRepository extends JpaRepository<Ngachcongchuc, Long> {

}

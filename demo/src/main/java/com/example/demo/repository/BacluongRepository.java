package com.example.demo.repository;

import com.example.demo.entity.Bacluong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacluongRepository extends JpaRepository<Bacluong, Long>{

}

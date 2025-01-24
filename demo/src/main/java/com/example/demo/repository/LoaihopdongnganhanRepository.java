package com.example.demo.repository;

import com.example.demo.entity.Loaihopdongnganhan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoaihopdongnganhanRepository extends JpaRepository<Loaihopdongnganhan , Long> {

    Page<Loaihopdongnganhan> findByTenLoaiHopDongContainingIgnoreCase(String tenLoaiHopDong, Pageable pageable);

}

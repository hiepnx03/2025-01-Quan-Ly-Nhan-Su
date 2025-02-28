package com.example.demo.repository;

import com.example.demo.entity.Quequan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuequanRepository extends JpaRepository<Quequan, Long> {
    List<Quequan> findByCanboId(Long canboId);
    Optional<Quequan> findByIdAndCanboId(Long quequanId, Long canboId);
}

package com.example.demo.repository;

import com.example.demo.entity.Canbo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CanboRepository extends JpaRepository<Canbo, Long> {

    @Query("SELECT c FROM Canbo c WHERE c.enabled = true")
    List<Canbo> findAllEnabled(); // Lấy danh sách cán bộ không bị xóa

    @Query("SELECT c FROM Canbo c WHERE c.enabled = true")
    Page<Canbo> findAllEnabledPage(Pageable pageable);

    @Query("SELECT c FROM Canbo c WHERE c.enabled = false")
    Page<Canbo> findAllDisabledPage(Pageable pageable);

    Page<Canbo> findByGioiTinhContainingIgnoreCase(String gioiTinh, Pageable pageable);
    Page<Canbo> findByDantocId(Long danTocId, Pageable pageable);
    Page<Canbo> findByTongiaoId(Long tonGiaoId, Pageable pageable);
    Page<Canbo> findByChucvuId(Long chucVuId, Pageable pageable);
    Page<Canbo> findByChucDanhContainingIgnoreCase(String chucDanh, Pageable pageable);
    Page<Canbo> findByBomonId(Long donViBoMonId, Pageable pageable);
    Page<Canbo> findByQuequansContainingIgnoreCase(String queQuan, Pageable pageable);
    Page<Canbo> findByNgachcongchucContainingIgnoreCase(String ngachCongChuc, Pageable pageable);
    Page<Canbo> findByDonvichucnangContainingIgnoreCase(String donViChucNang, Pageable pageable);
}

package com.example.demo.repository;


import com.example.demo.entity.Ngachcongchuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NgachcongchucRepository extends JpaRepository<Ngachcongchuc, Long> {
    Page<Ngachcongchuc> findByMaNgachContainingIgnoreCaseOrSoNamNangBacLuongContainingIgnoreCaseOrTenNgachContainingIgnoreCase(String maNgach, String soNamNangBacLuong, String tenNgach, Pageable pageable);

}

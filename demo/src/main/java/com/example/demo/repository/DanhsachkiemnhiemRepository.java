package com.example.demo.repository;

import com.example.demo.entity.Donvichucnang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DanhsachkiemnhiemRepository extends JpaRepository<Donvichucnang, Long> {

}

package com.example.demo.service.impl;


import com.example.demo.converter.DanhsachthamnienConverter;
import com.example.demo.dto.DanhsachthamnienDTO;
import com.example.demo.entity.Danhsachthamnien;
import com.example.demo.repository.DanhsachthamnienRepository;
import com.example.demo.service.DanhsachthamnienService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.converter.DanhsachthamnienConverter;
import com.example.demo.dto.DanhsachthamnienDTO;
import com.example.demo.entity.Danhsachthamnien;
import com.example.demo.repository.DanhsachthamnienRepository;
import com.example.demo.service.DanhsachthamnienService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DanhsachthamnienServiceImpl implements DanhsachthamnienService {

    private final DanhsachthamnienRepository repository;
    private final DanhsachthamnienConverter converter;

    @Override
    public List<DanhsachthamnienDTO> getAll() {
        List<Danhsachthamnien> entities = repository.findAll();
        return entities.stream().map(converter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<DanhsachthamnienDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Danhsachthamnien> entities = repository.findAll(pageable);
        return entities.map(converter::toDTO);
    }

    @Override
    public DanhsachthamnienDTO getById(Long id) {
        Danhsachthamnien entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy danh sách thâm niên với ID: " + id));
        return converter.toDTO(entity);
    }

    @Override
    public DanhsachthamnienDTO create(DanhsachthamnienDTO danhsachthamnienDTO) {
        Danhsachthamnien entity = converter.toEntity(danhsachthamnienDTO);
        Danhsachthamnien savedEntity = repository.save(entity);
        return converter.toDTO(savedEntity);
    }

    @Override
    public DanhsachthamnienDTO update(Long id, DanhsachthamnienDTO danhsachthamnienDTO) {
        Danhsachthamnien existingEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy danh sách thâm niên với ID: " + id));

        existingEntity.setSoThangBiGiamTru(danhsachthamnienDTO.getSoThangBiGiamTru());
        existingEntity.setGhiChuThoiDiemTang(danhsachthamnienDTO.getGhiChuThoiDiemTang());
        existingEntity.setGhiChuKhongPhuCapTn(danhsachthamnienDTO.getGhiChuKhongPhuCapTn());
        existingEntity.setPhuCapChucVu(danhsachthamnienDTO.getPhuCapChucVu());
        existingEntity.setVuotKhung(danhsachthamnienDTO.getVuotKhung());
        existingEntity.setTongHeSoLuong(danhsachthamnienDTO.getTongHeSoLuong());
        existingEntity.setPhuCapGiangVien(danhsachthamnienDTO.getPhuCapGiangVien());
        existingEntity.setMocTinhPhuCapTn(danhsachthamnienDTO.getMocTinhPhuCapTn());
        existingEntity.setThoiDiemTangPhuCapTn(danhsachthamnienDTO.getThoiDiemTangPhuCapTn());
        existingEntity.setTuNgay(danhsachthamnienDTO.getTuNgay());
        existingEntity.setDenNgay(danhsachthamnienDTO.getDenNgay());

        Danhsachthamnien updatedEntity = repository.save(existingEntity);
        return converter.toDTO(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy danh sách thâm niên với ID: " + id);
        }
        repository.deleteById(id);
    }
}
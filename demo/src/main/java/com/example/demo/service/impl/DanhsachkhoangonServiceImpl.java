package com.example.demo.service.impl;


import com.example.demo.converter.DanhsachkhoangonConverter;
import com.example.demo.dto.DanhsachkhoangonDTO;
import com.example.demo.entity.Danhsachkhoangon;
import com.example.demo.repository.DanhsachkhoangonRepository;
import com.example.demo.service.DanhsachkhoangonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
@AllArgsConstructor
public class DanhsachkhoangonServiceImpl implements DanhsachkhoangonService {

    private final DanhsachkhoangonRepository danhsachkhoangonRepository;
    private final DanhsachkhoangonConverter danhsachkhoangonConverter;

    @Override
    public List<DanhsachkhoangonDTO> getAll() {
        List<Danhsachkhoangon> entities = danhsachkhoangonRepository.findAll();
        return entities.stream().map(danhsachkhoangonConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<DanhsachkhoangonDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Danhsachkhoangon> entities = danhsachkhoangonRepository.findAll(pageable);
        return entities.map(danhsachkhoangonConverter::toDTO);
    }

    @Override
    public DanhsachkhoangonDTO getById(Long id) {
        Danhsachkhoangon entity = danhsachkhoangonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy danh sách khoán gọn với ID: " + id));
        return danhsachkhoangonConverter.toDTO(entity);
    }

    @Override
    public DanhsachkhoangonDTO create(DanhsachkhoangonDTO dto) {
        Danhsachkhoangon entity = danhsachkhoangonConverter.toEntity(dto);
        Danhsachkhoangon savedEntity = danhsachkhoangonRepository.save(entity);
        return danhsachkhoangonConverter.toDTO(savedEntity);
    }

    @Override
    public DanhsachkhoangonDTO update(Long id, DanhsachkhoangonDTO dto) {
        Danhsachkhoangon existingEntity = danhsachkhoangonRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy danh sách khoán gọn với ID: " + id));

        existingEntity.setHoTenCanBo(dto.getHoTenCanBo());
        existingEntity.setSoDienThoai(dto.getSoDienThoai());
        existingEntity.setSoCmnd(dto.getSoCmnd());
        existingEntity.setDiaChi(dto.getDiaChi());
        existingEntity.setNgayKyHopDong(dto.getNgayKyHopDong());

        Danhsachkhoangon updatedEntity = danhsachkhoangonRepository.save(existingEntity);
        return danhsachkhoangonConverter.toDTO(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!danhsachkhoangonRepository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy danh sách khoán gọn với ID: " + id);
        }
        danhsachkhoangonRepository.deleteById(id);
    }


}
package com.example.demo.service.impl;


import com.example.demo.converter.DanhsachkiemnhiemConverter;
import com.example.demo.dto.DanhsachkiemnhiemDTO;
import com.example.demo.entity.Danhsachkiemnhiem;
import com.example.demo.repository.DanhsachkiemnhiemRepository;
import com.example.demo.service.DanhsachkiemnhiemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
@AllArgsConstructor
public class DanhsachkiemnhiemServiceImpl implements DanhsachkiemnhiemService {

    private final DanhsachkiemnhiemRepository danhsachkiemnhiemRepository;
    private final DanhsachkiemnhiemConverter danhsachkiemnhiemConverter;

    @Override
    public List<DanhsachkiemnhiemDTO> getAll() {
        List<Danhsachkiemnhiem> danhsachkiemnhiemList = danhsachkiemnhiemRepository.findAll();
        return danhsachkiemnhiemList.stream().map(danhsachkiemnhiemConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<DanhsachkiemnhiemDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Danhsachkiemnhiem> danhsachkiemnhiemPage = danhsachkiemnhiemRepository.findAll(pageable);
        return danhsachkiemnhiemPage.map(danhsachkiemnhiemConverter::toDTO);
    }

    @Override
    public DanhsachkiemnhiemDTO getById(Long id) {
        Danhsachkiemnhiem entity = danhsachkiemnhiemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh sách kiêm nhiệm với ID: " + id));
        return danhsachkiemnhiemConverter.toDTO(entity);
    }

    @Override
    public DanhsachkiemnhiemDTO create(DanhsachkiemnhiemDTO dto) {
        Danhsachkiemnhiem entity = danhsachkiemnhiemConverter.toEntity(dto);
        Danhsachkiemnhiem savedEntity = danhsachkiemnhiemRepository.save(entity);
        return danhsachkiemnhiemConverter.toDTO(savedEntity);
    }

    @Override
    public DanhsachkiemnhiemDTO update(Long id, DanhsachkiemnhiemDTO dto) {
        Danhsachkiemnhiem existingEntity = danhsachkiemnhiemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy danh sách kiêm nhiệm với ID: " + id));

        existingEntity.setChucVuKiemNhiem(dto.getChucVuKiemNhiem());
        existingEntity.setTuNgay(dto.getTuNgay());
        existingEntity.setDenNgay(dto.getDenNgay());

        Danhsachkiemnhiem updatedEntity = danhsachkiemnhiemRepository.save(existingEntity);
        return danhsachkiemnhiemConverter.toDTO(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!danhsachkiemnhiemRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy danh sách kiêm nhiệm với ID: " + id);
        }
        danhsachkiemnhiemRepository.deleteById(id);
    }
}
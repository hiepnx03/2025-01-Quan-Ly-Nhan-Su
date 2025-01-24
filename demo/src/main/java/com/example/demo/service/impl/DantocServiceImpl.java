package com.example.demo.service.impl;


import com.example.demo.converter.DantocConverter;
import com.example.demo.dto.DantocDTO;
import com.example.demo.entity.Dantoc;
import com.example.demo.repository.DantocRepository;
import com.example.demo.service.DantocService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DantocServiceImpl implements DantocService {

    private final DantocRepository dantocRepository;
    private final DantocConverter dantocConverter;

    @Override
    public List<DantocDTO> getAll() {
        // Lấy danh sách tất cả dân tộc và chuyển đổi sang DTO
        return dantocRepository.findAll().stream()
                .map(dantocConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<DantocDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Dantoc> dantocPage = dantocRepository.findAllPage(pageable);
        Page<DantocDTO> dantocDTOPage = dantocPage.map(dantocConverter::toDTO);
        return dantocDTOPage;
    }

    @Override
    public DantocDTO getById(Long id) {
        // Tìm dân tộc theo ID
        Dantoc dantoc = dantocRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy dân tộc với ID: " + id));
        return dantocConverter.toDTO(dantoc);
    }

    @Override
    public DantocDTO create(DantocDTO dantocDTO) {
        // Chuyển đổi DTO sang Entity và lưu vào cơ sở dữ liệu
        Dantoc dantoc = dantocConverter.toEntity(dantocDTO);
        Dantoc savedDantoc = dantocRepository.save(dantoc);
        return dantocConverter.toDTO(savedDantoc);
    }

    @Override
    public DantocDTO update(Long id, DantocDTO dantocDTO) {
        // Tìm dân tộc theo ID
        Dantoc existingDantoc = dantocRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy dân tộc với ID: " + id));

        // Cập nhật các thuộc tính
        existingDantoc.setTenDanToc(dantocDTO.getTenDanToc());

        // Lưu thay đổi và trả về DTO
        Dantoc updatedDantoc = dantocRepository.save(existingDantoc);
        return dantocConverter.toDTO(updatedDantoc);
    }

    @Override
    public void delete(Long id) {
        // Xóa dân tộc theo ID
        if (!dantocRepository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy dân tộc với ID: " + id);
        }
        dantocRepository.deleteById(id);
    }


    @Override
    public Page<DantocDTO> searchByTenDanToc(String tenDanToc, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Dantoc> dantocPage = dantocRepository.findByTenDanTocContainingIgnoreCase(tenDanToc, pageable);
        return dantocPage.map(dantocConverter::toDTO);
    }

}

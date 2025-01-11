package com.example.demo.service.impl;


import com.example.demo.converter.DantocConverter;
import com.example.demo.dto.DantocDTO;
import com.example.demo.entity.Dantoc;
import com.example.demo.repository.DantocRepository;
import com.example.demo.service.DantocService;
import lombok.AllArgsConstructor;
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
    public DantocDTO getById(Long id) {
        // Tìm dân tộc theo ID
        Dantoc dantoc = dantocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dân tộc với ID: " + id));
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
                .orElseThrow(() -> new RuntimeException("Không tìm thấy dân tộc với ID: " + id));

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
            throw new RuntimeException("Không tìm thấy dân tộc với ID: " + id);
        }
        dantocRepository.deleteById(id);
    }
}

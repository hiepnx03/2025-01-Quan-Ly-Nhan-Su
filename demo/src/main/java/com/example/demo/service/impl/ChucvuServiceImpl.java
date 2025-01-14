package com.example.demo.service.impl;


import com.example.demo.converter.ChucvuConverter;
import com.example.demo.dto.ChucvuDTO;
import com.example.demo.entity.Chucvu;
import com.example.demo.repository.ChucvuRepository;
import com.example.demo.service.ChucvuService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChucvuServiceImpl implements ChucvuService {
    private final ChucvuRepository chucvuRepository;
    private final ChucvuConverter chucvuConverter;

    public ChucvuServiceImpl(ChucvuRepository chucvuRepository, ChucvuConverter chucvuConverter) {
        this.chucvuRepository = chucvuRepository;
        this.chucvuConverter = chucvuConverter;
    }


    @Override
    public List<ChucvuDTO> getAll() {
        // Lấy danh sách tất cả chức vụ và chuyển đổi sang DTO
        return chucvuRepository.findAll().stream()
                .map(chucvuConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<ChucvuDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable  = PageRequest.of(pageNo, pageSize);
        Page<Chucvu> chucvuPage = chucvuRepository.getAllPageable(pageable);
        Page<ChucvuDTO> chucvuDTOPage = chucvuPage.map(chucvuConverter::toDTO);
        return chucvuDTOPage;
    }

    @Override
    public ChucvuDTO getById(Long id) {
        // Tìm kiếm chức vụ theo ID
        Chucvu chucvu = chucvuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Chức vụ với ID: " + id));
        return chucvuConverter.toDTO(chucvu);
    }

    @Override
    public ChucvuDTO create(ChucvuDTO chucvuDTO) {
        // Chuyển đổi DTO thành Entity và lưu vào cơ sở dữ liệu
        Chucvu chucvu = chucvuConverter.toEntity(chucvuDTO);
        Chucvu savedChucvu = chucvuRepository.save(chucvu);
        return chucvuConverter.toDTO(savedChucvu);
    }

    @Override
    public ChucvuDTO update(Long id, ChucvuDTO chucvuDTO) {
        // Tìm kiếm chức vụ theo ID
        Chucvu existingChucvu = chucvuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Chức vụ với ID: " + id));
        existingChucvu.setTenChucVu(chucvuDTO.getTenChucVu());
        Chucvu updatedChucvu = chucvuRepository.save(existingChucvu);
        return chucvuConverter.toDTO(updatedChucvu);
    }

    @Override
    public void delete(Long id) {
        // Kiểm tra chức vụ có tồn tại không
        if (!chucvuRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy Chức vụ với ID: " + id);
        }
        chucvuRepository.deleteById(id);
    }
}

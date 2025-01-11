package com.example.demo.service.impl;


import com.example.demo.converter.CanboConverter;
import com.example.demo.converter.QuequanConverter;
import com.example.demo.dto.QuequanDTO;
import com.example.demo.entity.Canbo;
import com.example.demo.entity.Quequan;
import com.example.demo.repository.CanboRepository;
import com.example.demo.repository.QuequanRepository;
import com.example.demo.service.QuequanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuequanServiceImpl implements QuequanService {


    private final QuequanRepository quequanRepository;
    private final QuequanConverter quequanConverter;
    private final CanboRepository canboRepository;

    @Override
    public List<QuequanDTO> getAll() {
        List<Quequan> quequanList = quequanRepository.findAll();
        return quequanList.stream().map(quequanConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<QuequanDTO> getAllByCanboId(Long canboId) {
        // Kiểm tra nếu Canbo tồn tại
        Canbo canbo = canboRepository.findById(canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy cán bộ với id: " + canboId));

        // Lấy danh sách Quequan và chuyển sang DTO
        List<Quequan> quequans = quequanRepository.findByCanboId(canboId);
        return quequans.stream()
                .map(quequanConverter::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public QuequanDTO create(Long canboId, QuequanDTO quequanDTO) {
        Canbo canbo = canboRepository.findById(canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy cán bộ với ID: " + canboId));

        Quequan quequan = quequanConverter.toEntity(quequanDTO);
        quequan.setCanbo(canbo);

        Quequan savedQuequan = quequanRepository.save(quequan);
        return quequanConverter.toDTO(savedQuequan);
    }

    @Override
    public QuequanDTO update(Long canboId, Long quequanId, QuequanDTO quequanDTO) {
        // Kiểm tra nếu Canbo tồn tại
        Canbo canbo = canboRepository.findById(canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy cán bộ với id: " + canboId));

        // Lấy Quequan hiện tại
        Quequan existingQuequan = quequanRepository.findByIdAndCanboId(quequanId, canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quê quán với id: " + quequanId));

        // Cập nhật các trường từ DTO
        existingQuequan.setTenQueQuan(quequanDTO.getTenQueQuan()); // Ví dụ về cập nhật địa chỉ
        existingQuequan.setCanbo(canbo);

        // Lưu lại Quequan
        Quequan updatedQuequan = quequanRepository.save(existingQuequan);

        // Chuyển đổi sang DTO và trả về
        return quequanConverter.toDTO(updatedQuequan);
    }

    @Override
    public void delete(Long canboId, Long quequanId) {
        // Kiểm tra nếu Quequan tồn tại với Canbo
        Quequan quequan = quequanRepository.findByIdAndCanboId(quequanId, canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quê quán với id: " + quequanId));

        // Xóa Quequan
        quequanRepository.delete(quequan);
    }
}

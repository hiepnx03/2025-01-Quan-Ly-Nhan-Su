package com.example.demo.service.impl;

import com.example.demo.converter.LoaihopdongConverter;
import com.example.demo.dto.LoaihopdongDTO;
import com.example.demo.entity.Loaihopdong;
import com.example.demo.repository.LoaihopdongRepository;
import com.example.demo.service.LoaihopdongService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LoaihopdongServiceImpl implements LoaihopdongService {

    private final LoaihopdongRepository loaihopdongRepository;
    private final LoaihopdongConverter loaihopdongConverter;


    @Override
    public List<LoaihopdongDTO> getAll() {
        List<Loaihopdong> loaihopdongList = loaihopdongRepository.findAll();
        return loaihopdongList.stream().map(loaihopdongConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<LoaihopdongDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Loaihopdong> loaihopdongPage = loaihopdongRepository.findAllPage(pageable);
        Page<LoaihopdongDTO> loaihopdongDTOPage = loaihopdongPage.map(loaihopdongConverter::toDTO);
        return loaihopdongDTOPage;
    }

    @Override
    public LoaihopdongDTO getById(Long id) {
        Loaihopdong loaihopdong = loaihopdongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Loai hợp đồng với ID: " + id));
        return loaihopdongConverter.toDTO(loaihopdong);
    }

    @Override
    public LoaihopdongDTO create(LoaihopdongDTO loaihopdongDTO) {
        Loaihopdong loaihopdong = loaihopdongConverter.toEntity(loaihopdongDTO);
        Loaihopdong saveLoaiHopdong = loaihopdongRepository.save(loaihopdong);
        return loaihopdongConverter.toDTO(saveLoaiHopdong);
    }

    @Override
    public LoaihopdongDTO update(Long id, LoaihopdongDTO loaihopdongDTO) {
        Loaihopdong existingLoaihopdong = loaihopdongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Loại hợp đồng với ID: " + id));

        // Cập nhật các trường cần thiết
        existingLoaihopdong.setTenLoaiHopDong(loaihopdongDTO.getTenLoaiHopDong());
        // Lưu lại thay đổi
        Loaihopdong updatedLoaiHopdong = loaihopdongRepository.save(existingLoaihopdong);
        return loaihopdongConverter.toDTO(updatedLoaiHopdong);
    }

    @Override
    public void delete(Long id) {
        if (!loaihopdongRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy Chức vụ với ID: " + id);
        }
        loaihopdongRepository.deleteById(id);
    }
}

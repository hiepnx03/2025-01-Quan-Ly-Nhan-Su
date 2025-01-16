package com.example.demo.service.impl;


import com.example.demo.service.QuyetdinhkhenthuongService;
import org.springframework.stereotype.Service;

import java.util.List;


import com.example.demo.converter.QuyetdinhkhenthuongConverter;
import com.example.demo.dto.QuyetdinhkhenthuongDTO;
import com.example.demo.entity.Quyetdinhkhenthuong;
import com.example.demo.repository.QuyetdinhkhenthuongRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuyetdinhkhenthuongServiceImpl implements QuyetdinhkhenthuongService {

    private final QuyetdinhkhenthuongRepository quyetdinhkhenthuongRepository;
    private final QuyetdinhkhenthuongConverter quyetdinhkhenthuongConverter;

    @Override
    public List<QuyetdinhkhenthuongDTO> getAll() {
        List<Quyetdinhkhenthuong> quyetdinhkhenthuongList = quyetdinhkhenthuongRepository.findAll();
        return quyetdinhkhenthuongList.stream().map(quyetdinhkhenthuongConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<QuyetdinhkhenthuongDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Quyetdinhkhenthuong> quyetdinhkhenthuongPage = quyetdinhkhenthuongRepository.findAll(pageable);
        return quyetdinhkhenthuongPage.map(quyetdinhkhenthuongConverter::toDTO);
    }

    @Override
    public QuyetdinhkhenthuongDTO getById(Long id) {
        Quyetdinhkhenthuong entity = quyetdinhkhenthuongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quyết định khen thưởng với ID: " + id));
        return quyetdinhkhenthuongConverter.toDTO(entity);
    }

    @Override
    public QuyetdinhkhenthuongDTO create(QuyetdinhkhenthuongDTO dto) {
        Quyetdinhkhenthuong entity = quyetdinhkhenthuongConverter.toEntity(dto);
        Quyetdinhkhenthuong savedEntity = quyetdinhkhenthuongRepository.save(entity);
        return quyetdinhkhenthuongConverter.toDTO(savedEntity);
    }

    @Override
    public QuyetdinhkhenthuongDTO update(Long id, QuyetdinhkhenthuongDTO dto) {
        Quyetdinhkhenthuong existingEntity = quyetdinhkhenthuongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quyết định khen thưởng với ID: " + id));

        existingEntity.setSoQuyetDinh(dto.getSoQuyetDinh());
        existingEntity.setTenQuyetDinh(dto.getTenQuyetDinh());
        existingEntity.setNoiDungQuyetDinh(dto.getNoiDungQuyetDinh());
        existingEntity.setNguoiKy(dto.getNguoiKy());
        existingEntity.setFileKy(dto.getFileKy());
        existingEntity.setNgayKy(dto.getNgayKy());

        Quyetdinhkhenthuong updatedEntity = quyetdinhkhenthuongRepository.save(existingEntity);
        return quyetdinhkhenthuongConverter.toDTO(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!quyetdinhkhenthuongRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy quyết định khen thưởng với ID: " + id);
        }
        quyetdinhkhenthuongRepository.deleteById(id);
    }
}
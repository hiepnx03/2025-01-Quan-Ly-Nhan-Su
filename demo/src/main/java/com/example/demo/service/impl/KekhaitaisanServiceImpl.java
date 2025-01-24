package com.example.demo.service.impl;

import com.example.demo.converter.KekhaitaisanConverter;
import com.example.demo.dto.KekhaitaisanDTO;
import com.example.demo.entity.Kekhaitaisan;
import com.example.demo.repository.KekhaitaisanRepository;
import com.example.demo.service.KekhaitaisanService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Service
@AllArgsConstructor
public class KekhaitaisanServiceImpl implements KekhaitaisanService {

    private final KekhaitaisanRepository kekhaitaisanRepository;
    private final KekhaitaisanConverter kekhaitaisanConverter;

    @Override
    public List<KekhaitaisanDTO> getAll() {
        List<Kekhaitaisan> kekhaitaisanList = kekhaitaisanRepository.findAll();
        return kekhaitaisanList.stream().map(kekhaitaisanConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<KekhaitaisanDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Kekhaitaisan> kekhaitaisanPage = kekhaitaisanRepository.findAll(pageable);
        return kekhaitaisanPage.map(kekhaitaisanConverter::toDTO);
    }

    @Override
    public KekhaitaisanDTO getById(Long id) {
        Kekhaitaisan entity = kekhaitaisanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy kê khai tài sản với ID: " + id));
        return kekhaitaisanConverter.toDTO(entity);
    }

    @Override
    public KekhaitaisanDTO create(KekhaitaisanDTO kekhaitaisanDTO) {
        Kekhaitaisan entity = kekhaitaisanConverter.toEntity(kekhaitaisanDTO);
        Kekhaitaisan savedEntity = kekhaitaisanRepository.save(entity);
        return kekhaitaisanConverter.toDTO(savedEntity);
    }

    @Override
    public KekhaitaisanDTO update(Long id, KekhaitaisanDTO kekhaitaisanDTO) {
        Kekhaitaisan existingEntity = kekhaitaisanRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy kê khai tài sản với ID: " + id));

        existingEntity.setFileKeKhai(kekhaitaisanDTO.getFileKeKhai());
        existingEntity.setNgayKeKhai(kekhaitaisanDTO.getNgayKeKhai());

        Kekhaitaisan updatedEntity = kekhaitaisanRepository.save(existingEntity);
        return kekhaitaisanConverter.toDTO(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!kekhaitaisanRepository.existsById(id)) {
            throw new EntityNotFoundException("Không tìm thấy kê khai tài sản với ID: " + id);
        }
        kekhaitaisanRepository.deleteById(id);
    }
}

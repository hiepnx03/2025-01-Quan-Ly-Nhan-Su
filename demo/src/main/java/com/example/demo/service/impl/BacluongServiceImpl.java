package com.example.demo.service.impl;


import com.example.demo.converter.BacluongConverter;
import com.example.demo.dto.BacluongDTO;
import com.example.demo.entity.Bacluong;
import com.example.demo.repository.BacluongRepository;
import com.example.demo.service.BacluongService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BacluongServiceImpl implements BacluongService {

    private final BacluongRepository bacluongRepository;
    private final BacluongConverter bacluongConverter;

    @Override
    public List<BacluongDTO> getAll() {
        List<Bacluong> entities = bacluongRepository.findAll();
        return entities.stream().map(bacluongConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<BacluongDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Bacluong> bacluongPage = bacluongRepository.findAll(pageable);
        return bacluongPage.map(bacluongConverter::toDTO);
    }

    @Override
    public BacluongDTO getById(Long id) {
        Bacluong entity = bacluongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bậc lương với ID: " + id));
        return bacluongConverter.toDTO(entity);
    }

    @Override
    public BacluongDTO create(BacluongDTO dto) {
        Bacluong entity = bacluongConverter.toEntity(dto);
        Bacluong savedEntity = bacluongRepository.save(entity);
        return bacluongConverter.toDTO(savedEntity);
    }

    @Override
    public BacluongDTO update(Long id, BacluongDTO dto) {
        Bacluong existingEntity = bacluongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bậc lương với ID: " + id));

        existingEntity.setMaBacLuong(dto.getMaBacLuong());
        existingEntity.setHeSoLuong(dto.getHeSoLuong());
        existingEntity.setPhuCapVuotKhung(dto.getPhuCapVuotKhung());

        Bacluong updatedEntity = bacluongRepository.save(existingEntity);
        return bacluongConverter.toDTO(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!bacluongRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy bậc lương với ID: " + id);
        }
        bacluongRepository.deleteById(id);
    }
}

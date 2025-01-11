package com.example.demo.service.impl;


import com.example.demo.converter.QuyetdinhkyluatConverter;
import com.example.demo.dto.QuyetdinhkyluatDTO;
import com.example.demo.entity.Canbo;
import com.example.demo.entity.Quyetdinhkyluat;
import com.example.demo.repository.CanboRepository;
import com.example.demo.repository.QuyetdinhkyluatRepository;
import com.example.demo.service.QuyetdinhkyluatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuyetdinhkyluatServiceImpl implements QuyetdinhkyluatService {

    private final QuyetdinhkyluatRepository quyetdinhkyluatRepository;
    private final CanboRepository canboRepository;
    private final QuyetdinhkyluatConverter quyetdinhkyluatConverter;

    @Override
    public List<QuyetdinhkyluatDTO> getAll() {
        return quyetdinhkyluatRepository.findAll().stream()
                .map(quyetdinhkyluatConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuyetdinhkyluatDTO getById(Long id) {
        Quyetdinhkyluat quyetdinhkyluat = quyetdinhkyluatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quyết định kỷ luật với ID: " + id));
        return quyetdinhkyluatConverter.toDTO(quyetdinhkyluat);
    }

    @Override
    public QuyetdinhkyluatDTO create(QuyetdinhkyluatDTO dto) {
        Quyetdinhkyluat quyetdinhkyluat = quyetdinhkyluatConverter.toEntity(dto);

        if (dto.getCanboDTO() != null) {
            Canbo canbo = canboRepository.findById(dto.getCanboDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy cán bộ với ID: " + dto.getCanboDTO().getId()));
            quyetdinhkyluat.setCanbo(canbo);
        }

        Quyetdinhkyluat savedQuyetdinhkyluat = quyetdinhkyluatRepository.save(quyetdinhkyluat);
        return quyetdinhkyluatConverter.toDTO(savedQuyetdinhkyluat);
    }

    @Override
    public QuyetdinhkyluatDTO update(Long id, QuyetdinhkyluatDTO dto) {
        Quyetdinhkyluat existingQuyetdinhkyluat = quyetdinhkyluatRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quyết định kỷ luật với ID: " + id));

        existingQuyetdinhkyluat.setSoQuyetDinh(dto.getSoQuyetDinh());
        existingQuyetdinhkyluat.setTenQuyetDinh(dto.getTenQuyetDinh());
        existingQuyetdinhkyluat.setNoiDungQuyetDinh(dto.getNoiDungQuyetDinh());
        existingQuyetdinhkyluat.setNguoiKy(dto.getNguoiKy());

        if (dto.getCanboDTO() != null) {
            Canbo canbo = canboRepository.findById(dto.getCanboDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy cán bộ với ID: " + dto.getCanboDTO().getId()));
            existingQuyetdinhkyluat.setCanbo(canbo);
        } else {
            existingQuyetdinhkyluat.setCanbo(null);
        }

        Quyetdinhkyluat updatedQuyetdinhkyluat = quyetdinhkyluatRepository.save(existingQuyetdinhkyluat);
        return quyetdinhkyluatConverter.toDTO(updatedQuyetdinhkyluat);
    }

    @Override
    public void delete(Long id) {
        if (!quyetdinhkyluatRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy quyết định kỷ luật với ID: " + id);
        }
        quyetdinhkyluatRepository.deleteById(id);
    }
}

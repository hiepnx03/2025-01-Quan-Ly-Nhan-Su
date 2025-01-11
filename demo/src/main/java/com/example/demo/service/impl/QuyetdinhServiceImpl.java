package com.example.demo.service.impl;


import com.example.demo.converter.QuyetdinhConverter;
import com.example.demo.dto.QuyetdinhDTO;
import com.example.demo.entity.Canbo;
import com.example.demo.entity.Donvichucnang;
import com.example.demo.entity.Loaiquyetdinh;
import com.example.demo.entity.Quyetdinh;
import com.example.demo.repository.CanboRepository;
import com.example.demo.repository.DonvichucnangRepository;
import com.example.demo.repository.LoaiquyetdinhRepository;
import com.example.demo.repository.QuyetdinhRepository;
import com.example.demo.service.QuyetdinhService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuyetdinhServiceImpl implements QuyetdinhService {
    private final QuyetdinhRepository quyetdinhRepository;
    private final CanboRepository canboRepository;
    private final DonvichucnangRepository donvichucnangRepository;
    private final LoaiquyetdinhRepository loaiquyetdinhRepository;
    private final QuyetdinhConverter quyetdinhConverter;

    @Override
    public List<QuyetdinhDTO> getAll() {
        return quyetdinhRepository.findAll().stream()
                .map(quyetdinhConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public QuyetdinhDTO getById(Long id) {
        Quyetdinh quyetdinh = quyetdinhRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quyết định với ID: " + id));
        return quyetdinhConverter.toDTO(quyetdinh);
    }

    @Override
    public QuyetdinhDTO create(QuyetdinhDTO dto) {
        Quyetdinh quyetdinh = quyetdinhConverter.toEntity(dto);

        if (dto.getCanboDTO() != null) {
            Canbo canbo = canboRepository.findById(dto.getCanboDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy cán bộ với ID: " + dto.getCanboDTO().getId()));
            quyetdinh.setCanbo(canbo);
        }

        if (dto.getDonvichucnangDTO() != null) {
            Donvichucnang donvichucnang = donvichucnangRepository.findById(dto.getDonvichucnangDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn vị chức năng với ID: " + dto.getDonvichucnangDTO().getId()));
            quyetdinh.setDonvichucnang(donvichucnang);
        }

        if (dto.getLoaiquyetdinhDTO() != null) {
            Loaiquyetdinh loaiquyetdinh = loaiquyetdinhRepository.findById(dto.getLoaiquyetdinhDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy loại quyết định với ID: " + dto.getLoaiquyetdinhDTO().getId()));
            quyetdinh.setLoaiquyetdinh(loaiquyetdinh);
        }

        Quyetdinh savedQuyetdinh = quyetdinhRepository.save(quyetdinh);
        return quyetdinhConverter.toDTO(savedQuyetdinh);
    }

    @Override
    public QuyetdinhDTO update(Long id, QuyetdinhDTO dto) {
        Quyetdinh existingQuyetdinh = quyetdinhRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quyết định với ID: " + id));

        existingQuyetdinh.setSoQuyetDinh(dto.getSoQuyetDinh());
        existingQuyetdinh.setTenQuyetDinh(dto.getTenQuyetDinh());
        existingQuyetdinh.setNoiDungQuyetDinh(dto.getNoiDungQuyetDinh());
        existingQuyetdinh.setNguoiKy(dto.getNguoiKy());
        existingQuyetdinh.setFileKy(dto.getFileKy());
        existingQuyetdinh.setNgayKy(dto.getNgayKy());
        existingQuyetdinh.setTuNgay(dto.getTuNgay());
        existingQuyetdinh.setDenNgay(dto.getDenNgay());

        if (dto.getCanboDTO() != null) {
            Canbo canbo = canboRepository.findById(dto.getCanboDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy cán bộ với ID: " + dto.getCanboDTO().getId()));
            existingQuyetdinh.setCanbo(canbo);
        }

        if (dto.getDonvichucnangDTO() != null) {
            Donvichucnang donvichucnang = donvichucnangRepository.findById(dto.getDonvichucnangDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn vị chức năng với ID: " + dto.getDonvichucnangDTO().getId()));
            existingQuyetdinh.setDonvichucnang(donvichucnang);
        }

        if (dto.getLoaiquyetdinhDTO() != null) {
            Loaiquyetdinh loaiquyetdinh = loaiquyetdinhRepository.findById(dto.getLoaiquyetdinhDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy loại quyết định với ID: " + dto.getLoaiquyetdinhDTO().getId()));
            existingQuyetdinh.setLoaiquyetdinh(loaiquyetdinh);
        }

        Quyetdinh updatedQuyetdinh = quyetdinhRepository.save(existingQuyetdinh);
        return quyetdinhConverter.toDTO(updatedQuyetdinh);
    }

    @Override
    public void delete(Long id) {
        if (!quyetdinhRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy quyết định với ID: " + id);
        }
        quyetdinhRepository.deleteById(id);
    }
}

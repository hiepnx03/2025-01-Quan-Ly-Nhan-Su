package com.example.demo.service.impl;

import com.example.demo.converter.HopdongcanboConverter;
import com.example.demo.dto.HopdongcanboDTO;
import com.example.demo.entity.Hopdongcanbo;
import com.example.demo.repository.HopdongcanboRepository;
import com.example.demo.service.HopdongcanboService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HopdongcanboServiceImpl implements HopdongcanboService {

    private final HopdongcanboRepository hopdongcanboRepository;
    private final HopdongcanboConverter hopdongcanboConverter;

    @Override
    public List<HopdongcanboDTO> getAll() {
        List<Hopdongcanbo> hopdongcanboList = hopdongcanboRepository.findAll();
        return hopdongcanboList.stream()
                .map(hopdongcanboConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<HopdongcanboDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Hopdongcanbo> hopdongcanboPage = hopdongcanboRepository.findAll(pageable);
        return hopdongcanboPage.map(hopdongcanboConverter::toDTO);
    }

    @Override
    public HopdongcanboDTO getById(Long id) {
        Hopdongcanbo hopdongcanbo = hopdongcanboRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng cán bộ với ID: " + id));
        return hopdongcanboConverter.toDTO(hopdongcanbo);
    }

    @Override
    public HopdongcanboDTO create(HopdongcanboDTO hopdongcanboDTO) {
        Hopdongcanbo hopdongcanbo = hopdongcanboConverter.toEntity(hopdongcanboDTO);
        Hopdongcanbo savedHopdongcanbo = hopdongcanboRepository.save(hopdongcanbo);
        return hopdongcanboConverter.toDTO(savedHopdongcanbo);
    }

    @Override
    public HopdongcanboDTO update(Long id, HopdongcanboDTO hopdongcanboDTO) {
        Hopdongcanbo existingHopdongcanbo = hopdongcanboRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy hợp đồng cán bộ với ID: " + id));

        // Cập nhật các trường cần thiết
        existingHopdongcanbo.setMaHopDong(hopdongcanboDTO.getMaHopDong());
        existingHopdongcanbo.setTenHopDong(hopdongcanboDTO.getTenHopDong());
        existingHopdongcanbo.setChucVu(hopdongcanboDTO.getChucVu());
        existingHopdongcanbo.setTrichYeuNoiDung(hopdongcanboDTO.getTrichYeuNoiDung());
        existingHopdongcanbo.setFileHD(hopdongcanboDTO.getFileHD());
        existingHopdongcanbo.setNgayKy(hopdongcanboDTO.getNgayKy());
        existingHopdongcanbo.setTuNgay(hopdongcanboDTO.getTuNgay());
        existingHopdongcanbo.setDenNgay(hopdongcanboDTO.getDenNgay());

        // Xử lý quan hệ N-1 nếu cần
        if (hopdongcanboDTO.getDonvichucnangDTO() != null) {
            existingHopdongcanbo.setDonvichucnang(hopdongcanboConverter.toEntity(hopdongcanboDTO).getDonvichucnang());
        }
        if (hopdongcanboDTO.getLoaihopdongDTO() != null) {
            existingHopdongcanbo.setLoaihopdong(hopdongcanboConverter.toEntity(hopdongcanboDTO).getLoaihopdong());
        }
        if (hopdongcanboDTO.getCanboDTO() != null) {
            existingHopdongcanbo.setCanbo(hopdongcanboConverter.toEntity(hopdongcanboDTO).getCanbo());
        }

        Hopdongcanbo updatedHopdongcanbo = hopdongcanboRepository.save(existingHopdongcanbo);
        return hopdongcanboConverter.toDTO(updatedHopdongcanbo);
    }

    @Override
    public void delete(Long id) {
        if (!hopdongcanboRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy hợp đồng cán bộ với ID: " + id);
        }
        hopdongcanboRepository.deleteById(id);
    }
}

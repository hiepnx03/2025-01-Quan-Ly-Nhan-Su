package com.example.demo.service.impl;


import com.example.demo.converter.CanboConverter;
import com.example.demo.dto.CanboDTO;
import com.example.demo.entity.Canbo;
import com.example.demo.entity.Chucvu;
import com.example.demo.entity.Dantoc;
import com.example.demo.entity.Tongiao;
import com.example.demo.repository.*;
import com.example.demo.service.CanboService;
import com.example.demo.service.DonvichucnangService;
import com.example.demo.service.NgachcongchucService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CanboServiceImpl implements CanboService {
    private final CanboRepository canBoRepository;
    private final DonvichucnangRepository donViChucNangRepository;
    private final BomonRepository boMonRepository;
    private final BacluongRepository bacLuongRepository;
    private final ChucvuRepository chucVuRepository;
    private final DantocRepository danTocRepository;
    private final TongiaoRepository tonGiaoRepository;
    private final NgachcongchucRepository ngachCongChucRepository;
    private final QuequanRepository queQuanRepository;
    private final DonvichucnangService donViChucNangService;
    private final NgachcongchucService ngachCongChucService;
    private final CanboConverter canboConverter;

    @Override
    public List<CanboDTO> getAll() {
        List<Canbo> canBoList = canBoRepository.findAllEnabled();
        return canBoList.stream()
                .map(canboConverter::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CanboDTO getById(Long id) {
        Optional<Canbo> canbo = canBoRepository.findById(id);
        return canbo.map(canboConverter::toDTO).orElseThrow(() -> new RuntimeException("Cán bộ không tồn tại với id: " + id));
    }

    @Override
    public CanboDTO save(CanboDTO canboDTO) {
        if (canboDTO.getId() == null) {
            canboDTO.setEnabled(true);
        }


        Canbo canboEntity = canboConverter.toEntity(canboDTO);
        Canbo savedCanbo = canBoRepository.save(canboEntity);
        return canboConverter.toDTO(savedCanbo);
    }


    // ton giao
    @Override
    public CanboDTO addTongiao(Long canboId, Long tongiaoId) {
        Canbo canbo = canBoRepository.findById(canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Cán bộ với ID: " + canboId));
        Tongiao tongiao = tonGiaoRepository.findById(tongiaoId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Tôn giáo với ID: " + tongiaoId));
        canbo.setTongiao(tongiao);
        Canbo updatedCanbo = canBoRepository.save(canbo);
        return canboConverter.toDTO(updatedCanbo);
    }
    @Override
    public CanboDTO updateTongiao(CanboDTO canboDTO) {
        Canbo canbo = canBoRepository.findById(canboDTO.getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Cán bộ với ID: " + canboDTO.getId()));
        if (canboDTO.getTongiaoDTO() != null) {
            Tongiao tongiao = tonGiaoRepository.findById(canboDTO.getTongiaoDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Tôn giáo với ID: " + canboDTO.getTongiaoDTO().getId()));
            canbo.setTongiao(tongiao);
        } else {
            canbo.setTongiao(null);
        }
        Canbo updatedCanbo = canBoRepository.save(canbo);
        return canboConverter.toDTO(updatedCanbo);
    }
    @Override
    public CanboDTO deleteTongiao(Long canboId) {
        Canbo canbo = canBoRepository.findById(canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Cán bộ với ID: " + canboId));
        canbo.setTongiao(null);
        Canbo updatedCanbo = canBoRepository.save(canbo);
        return canboConverter.toDTO(updatedCanbo);
    }

    // chuc vu
    @Override
    public CanboDTO addChucVu(Long canboId, Long chucvuId) {
        Canbo canbo = canBoRepository.findById(canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Cán bộ với ID: " + canboId));
        Chucvu chucvu = chucVuRepository.findById(chucvuId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Chức vụ với ID: " + chucvuId));
        canbo.setChucvu(chucvu);
        Canbo updatedCanbo = canBoRepository.save(canbo);
        return canboConverter.toDTO(updatedCanbo);
    }
    @Override
    public CanboDTO updateChucVu(CanboDTO canboDTO) {
        Canbo canbo = canBoRepository.findById(canboDTO.getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Cán bộ với ID: " + canboDTO.getId()));
        if (canboDTO.getChucvuDTO() != null) {
            Chucvu chucvu = chucVuRepository.findById(canboDTO.getChucvuDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Chức vụ với ID: " + canboDTO.getChucvuDTO().getId()));
            canbo.setChucvu(chucvu);
        } else {
            canbo.setChucvu(null);
        }
        Canbo updatedCanbo = canBoRepository.save(canbo);
        return canboConverter.toDTO(updatedCanbo);
    }
    @Override
    public CanboDTO deleteChucVu(Long canboId) {
        Canbo canbo = canBoRepository.findById(canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Cán bộ với ID: " + canboId));
        canbo.setChucvu(null);
        Canbo updatedCanbo = canBoRepository.save(canbo);
        return canboConverter.toDTO(updatedCanbo);
    }

    // dan toc
    @Override
    public CanboDTO addDanToc(Long canboId, Long dantocId) {
        Canbo canbo = canBoRepository.findById(canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Cán bộ với ID: " + canboId));
        Dantoc dantoc = danTocRepository.findById(dantocId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Dân tộc với ID: " + dantocId));
        canbo.setDantoc(dantoc);
        Canbo updatedCanbo = canBoRepository.save(canbo);
        return canboConverter.toDTO(updatedCanbo);
    }
    @Override
    public CanboDTO updateDanToc(CanboDTO canboDTO) {
        Canbo canbo = canBoRepository.findById(canboDTO.getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Cán bộ với ID: " + canboDTO.getId()));
        if (canboDTO.getDantocDTO() != null) {
            Dantoc dantoc = danTocRepository.findById(canboDTO.getDantocDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy Dân tộc với ID: " + canboDTO.getDantocDTO().getId()));
            canbo.setDantoc(dantoc);
        } else {
            canbo.setDantoc(null); // Xóa dân tộc nếu không có trong DTO
        }
        Canbo updatedCanbo = canBoRepository.save(canbo);
        return canboConverter.toDTO(updatedCanbo);
    }
    @Override
    public CanboDTO deleteDanToc(Long canboId) {
        Canbo canbo = canBoRepository.findById(canboId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy Cán bộ với ID: " + canboId));
        canbo.setDantoc(null);
        Canbo updatedCanbo = canBoRepository.save(canbo);
        return canboConverter.toDTO(updatedCanbo);
    }


    @Override
    public CanboDTO update(CanboDTO canboDTO, Long id) {
        if (id == null) {
            throw new IllegalArgumentException("ID không được để trống khi cập nhật.");
        }

        Canbo existingCanbo = canBoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy cán bộ với id: " + id));

        if (canboDTO.getTen() != null) {
            existingCanbo.setTen(canboDTO.getTen());
        }
        if (canboDTO.getSoHieu() != null) {
            existingCanbo.setSoHieu(canboDTO.getSoHieu());
        }
        if (canboDTO.getGioiTinh() != null) {
            existingCanbo.setGioiTinh(canboDTO.getGioiTinh());
        }
        if (canboDTO.getNgaySinh() != null) {
            existingCanbo.setNgaySinh(canboDTO.getNgaySinh());
        }
        if (canboDTO.getEnabled() != null) { // Kiểm tra giá trị enabled
            existingCanbo.setEnabled(canboDTO.getEnabled());
        }

        if (canboDTO.getChucvuDTO() != null && canboDTO.getChucvuDTO().getId() != null) {
            Chucvu chucvu = chucVuRepository.findById(canboDTO.getChucvuDTO().getId())
                    .orElseThrow(() -> new RuntimeException("Không tìm thấy chức vụ với id: " + canboDTO.getChucvuDTO().getId()));
            existingCanbo.setChucvu(chucvu);
        }


        Canbo updatedCanbo = canBoRepository.save(existingCanbo);

        return canboConverter.toDTO(updatedCanbo);
    }


    @Override
    public void deleteById(Long id) {
        Canbo existingCanbo = canBoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy cán bộ với id: " + id));
        existingCanbo.setEnabled(false); // Đặt enabled về false
        canBoRepository.save(existingCanbo); // Lưu thay đổi
    }


}

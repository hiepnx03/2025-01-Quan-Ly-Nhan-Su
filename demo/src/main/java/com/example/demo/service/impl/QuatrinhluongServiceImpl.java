package com.example.demo.service.impl;


import com.example.demo.entity.Bacluong;
import com.example.demo.entity.Canbo;
import com.example.demo.entity.Ngachcongchuc;
import com.example.demo.repository.BacluongRepository;
import com.example.demo.repository.CanboRepository;
import com.example.demo.repository.NgachcongchucRepository;
import com.example.demo.service.QuatrinhluongService;
import org.springframework.stereotype.Service;


import com.example.demo.converter.QuatrinhluongConverter;
import com.example.demo.dto.QuatrinhluongDTO;
import com.example.demo.entity.Quatrinhluong;
import com.example.demo.repository.QuatrinhluongRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuatrinhluongServiceImpl implements QuatrinhluongService {

    private final QuatrinhluongRepository quatrinhluongRepository;
    private final QuatrinhluongConverter quatrinhluongConverter;
    private final CanboRepository canboRepository;
    private final NgachcongchucRepository ngachcongchucRepository;
    private final BacluongRepository bacluongRepository;

    @Override
    public List<QuatrinhluongDTO> getAll() {
        List<Quatrinhluong> quatrinhluongList = quatrinhluongRepository.findAll();
        return quatrinhluongList.stream().map(quatrinhluongConverter::toDTO).collect(Collectors.toList());
    }

    @Override
    public Page<QuatrinhluongDTO> getAllPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Quatrinhluong> quatrinhluongPage = quatrinhluongRepository.findAll(pageable);
        return quatrinhluongPage.map(quatrinhluongConverter::toDTO);
    }

    @Override
    public QuatrinhluongDTO getById(Long id) {
        Quatrinhluong entity = quatrinhluongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quá trình lương với ID: " + id));
        return quatrinhluongConverter.toDTO(entity);
    }

    @Override
    public QuatrinhluongDTO create(QuatrinhluongDTO dto) {
        // Lấy các đối tượng liên quan từ cơ sở dữ liệu
        Canbo canbo = canboRepository.findById(dto.getCanboDTO().getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy cán bộ với ID: " + dto.getCanboDTO().getId()));

        Bacluong bacluong = bacluongRepository.findById(dto.getBacluongDTO().getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy bậc lương với ID: " + dto.getBacluongDTO().getId()));

        Ngachcongchuc ngachcongchuc = ngachcongchucRepository.findById(dto.getNgachcongchucDTO().getId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy ngạch công chức với ID: " + dto.getNgachcongchucDTO().getId()));

        // Chuyển đổi từ DTO sang Entity
        Quatrinhluong entity = quatrinhluongConverter.toEntity(dto);

        // Gán các tham chiếu đã được quản lý
        entity.setCanbo(canbo);
        entity.setBacluong(bacluong);
        entity.setNgachcongchuc(ngachcongchuc);

        // Lưu vào cơ sở dữ liệu
        Quatrinhluong savedEntity = quatrinhluongRepository.save(entity);

        // Chuyển đổi từ Entity đã lưu thành DTO
        return quatrinhluongConverter.toDTO(savedEntity);
    }


    @Override
    public QuatrinhluongDTO update(Long id, QuatrinhluongDTO dto) {
        Quatrinhluong existingEntity = quatrinhluongRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy quá trình lương với ID: " + id));

        existingEntity.setLyDoLenLuongSom(dto.getLyDoLenLuongSom());
        existingEntity.setGhiChu(dto.getGhiChu());
        existingEntity.setThoiGianTinhHuong(dto.getThoiGianTinhHuong());
        existingEntity.setPhanTranPhuCap(dto.getPhanTranPhuCap());
        existingEntity.setThoiGianTangLuong(dto.getThoiGianTangLuong());
        existingEntity.setThoiGianChamLenLuong(dto.getThoiGianChamLenLuong());
        existingEntity.setLyDoChamLenLuong(dto.getLyDoChamLenLuong());
        existingEntity.setThoiGianLenLuongSom(dto.getThoiGianLenLuongSom());

        Quatrinhluong updatedEntity = quatrinhluongRepository.save(existingEntity);
        return quatrinhluongConverter.toDTO(updatedEntity);
    }

    @Override
    public void delete(Long id) {
        if (!quatrinhluongRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy quá trình lương với ID: " + id);
        }
        quatrinhluongRepository.deleteById(id);
    }
}

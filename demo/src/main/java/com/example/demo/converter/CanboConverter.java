package com.example.demo.converter;


import com.example.demo.dto.*;
import com.example.demo.entity.Canbo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class CanboConverter  {
    private final ModelMapper modelMapper;
    private final QuequanConverter quequanConverter;


    public CanboDTO toDTO(Canbo canbo) {
        CanboDTO canboDTO = modelMapper.map(canbo, CanboDTO.class);

        // 1 - n
        // Chuyển đổi danh sách Quê quán sang DTO
        if (canbo.getQuequans() != null) {
            canboDTO.setQuequanDTOS(
                    canbo.getQuequans().stream()
                            .map(quequanConverter::toDTO)
                            .collect(Collectors.toList())
            );
        }

        // Chuyển đổi Tôn giáo sang DTO
        if (canbo.getTongiao() != null) {
            TongiaoDTO tongiaoDTO = new TongiaoDTO();
            tongiaoDTO.setId(canbo.getTongiao().getId());
            tongiaoDTO.setTenTonGiao(canbo.getTongiao().getTenTonGiao());
            tongiaoDTO.setVersion(canbo.getTongiao().getVersion());
            canboDTO.setTongiaoDTO(tongiaoDTO); // Gán Tôn giáo vào DTO
        }

        // chuc vu
        if(canbo.getChucvu() != null) {
            ChucvuDTO chucvuDTO = new ChucvuDTO();
            chucvuDTO.setId(canbo.getChucvu().getId());
            chucvuDTO.setTenChucVu(canbo.getChucvu().getTenChucVu());
            chucvuDTO.setVersion(canbo.getChucvu().getVersion());
            canboDTO.setChucvuDTO(chucvuDTO);
        }

        //dan toc
        if(canbo.getDantoc() != null) {
            DantocDTO dantocDTO = new DantocDTO();
            dantocDTO.setId(canbo.getDantoc().getId());
            dantocDTO.setTenDanToc(canbo.getDantoc().getTenDanToc());
            dantocDTO.setVersion(canbo.getDantoc().getVersion());
            canboDTO.setDantocDTO(dantocDTO);
        }

        //don vi chuc nang
        if(canbo.getDonvichucnang() != null) {
            DonvichucnangDTO donvichucnangDTO = new DonvichucnangDTO();
            donvichucnangDTO.setId(canbo.getDonvichucnang().getId());
            donvichucnangDTO.setMaDonVi(canbo.getDonvichucnang().getMaDonVi());
            donvichucnangDTO.setTenDonVi(canbo.getDonvichucnang().getTenDonVi());

            donvichucnangDTO.setVersion(canbo.getDonvichucnang().getVersion());
        }


        return canboDTO;
    }

    public Canbo toEntity(CanboDTO canboDTO) {
        Canbo canbo = modelMapper.map(canboDTO, Canbo.class);

        // Chuyển đổi danh sách QuequanDTO sang Entity
        if (canboDTO.getQuequanDTOS() != null) {
            canbo.setQuequans(
                    canboDTO.getQuequanDTOS().stream()
                            .map(quequanConverter::toEntity)
                            .collect(Collectors.toList())
            );

            // Gán mối quan hệ ngược lại (cán bộ cho từng quê quán)
            canbo.getQuequans().forEach(quequan -> quequan.setCanbo(canbo));
        }


        // Chuyển đổi Tôn giáo DTO sang Entity
        if (canboDTO.getTongiaoDTO() != null) {
            canbo.getTongiao().setId(canboDTO.getTongiaoDTO().getId());
        }


        // chuc vu
        if(canboDTO.getChucvuDTO() != null) {
            canbo.getChucvu().setId(canboDTO.getChucvuDTO().getId());
        }

        // dan toc
        if(canboDTO.getDantocDTO() != null) {
            canbo.getDantoc().setId(canboDTO.getDantocDTO().getId());
        }

        // don vi chuc nang
        if(canboDTO.getDonvichucnangDTO() != null) {
            canbo.getDonvichucnang().setId(canboDTO.getDonvichucnangDTO().getId());
        }


        return canbo;
    }
}

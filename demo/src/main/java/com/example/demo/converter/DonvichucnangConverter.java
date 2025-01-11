package com.example.demo.converter;


import com.example.demo.dto.DonvichucnangDTO;
import com.example.demo.entity.Donvichucnang;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DonvichucnangConverter  {
    private final ModelMapper modelMapper;
    private final CanboConverter canboConverter;
    private final BomonConverter bomonConverter;


    public DonvichucnangDTO toDTO (Donvichucnang donvichucnang) {
        DonvichucnangDTO donvichucnangDTO = modelMapper.map(donvichucnang, DonvichucnangDTO.class);


        // 1 - n donvichucnang - canbo
        // Chuyển đổi danh sách Quê quán sang DTO
        if (donvichucnang.getCanBos() != null) {
            donvichucnangDTO.setCanboDTOS(
                    donvichucnang.getCanBos().stream()
                            .map(canboConverter::toDTO)
                            .collect(Collectors.toList())
            );
        }

        // 1 - n donvichucnang - bomon
        if (donvichucnang.getBoMons() != null) {
            donvichucnangDTO.setBomonDTOS(
                    donvichucnang.getBoMons().stream()
                            .map(bomonConverter::toDTO)
                            .collect(Collectors.toList())
            );
        }

        return donvichucnangDTO;
    }

    public Donvichucnang toEntity(DonvichucnangDTO donvichucnangDTO) {
        Donvichucnang donvichucnang = modelMapper.map(donvichucnangDTO, Donvichucnang.class);

        // 1 - n donvichucnang - canbo
        if (donvichucnangDTO.getCanboDTOS() != null) {
            donvichucnang.setCanBos(
                    donvichucnangDTO.getCanboDTOS().stream()
                            .map(canboConverter::toEntity)
                            .collect(Collectors.toList())
            );

            donvichucnang.getCanBos().forEach(canbo -> canbo.setDonvichucnang(donvichucnang));
        }

        // 1 - n donvichucnang - bomon
        if (donvichucnangDTO.getBomonDTOS() != null) {
            donvichucnang.setBoMons(
                    donvichucnangDTO.getBomonDTOS().stream()
                            .map(bomonConverter::toEntity)
                            .collect(Collectors.toList())
            );

            donvichucnang.getBoMons().forEach(bomon -> bomon.setDonvichucnang(donvichucnang));

        }




        return donvichucnang;
    }

}

package com.example.demo.converter;


import com.example.demo.dto.DonvichucnangDTO;
import com.example.demo.entity.Donvichucnang;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DonvichucnangConverter  {
    private final ModelMapper modelMapper;

    public DonvichucnangConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DonvichucnangDTO toDTO (Donvichucnang donvichucnang) {
        return modelMapper.map(donvichucnang, DonvichucnangDTO.class);
    }

    public Donvichucnang toEntity(DonvichucnangDTO donvichucnangDTO) {
        return modelMapper.map(donvichucnangDTO, Donvichucnang.class);
    }

}

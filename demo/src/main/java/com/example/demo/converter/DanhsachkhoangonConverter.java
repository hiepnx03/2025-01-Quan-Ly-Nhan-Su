package com.example.demo.converter;


import com.example.demo.dto.DanhsachkhoangonDTO;
import com.example.demo.entity.Danhsachkhoangon;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DanhsachkhoangonConverter {
    private final ModelMapper modelMapper;

    public DanhsachkhoangonConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DanhsachkhoangonDTO toDTO (Danhsachkhoangon danhsachkhoangon) {
        return modelMapper.map(danhsachkhoangon, DanhsachkhoangonDTO.class);
    }
    public Danhsachkhoangon toEntity (DanhsachkhoangonDTO danhsachkhoangonDTO) {
        return modelMapper.map(danhsachkhoangonDTO, Danhsachkhoangon.class);
    }
}

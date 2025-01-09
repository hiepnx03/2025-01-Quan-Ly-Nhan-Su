package com.example.demo.converter;


import com.example.demo.dto.DanhsachthamnienDTO;
import com.example.demo.entity.Danhsachthamnien;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DanhsachthamnienConverter {
    private final ModelMapper modelMapper;

    public DanhsachthamnienConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DanhsachthamnienDTO toDTO(Danhsachthamnien danhsachthamnien) {
        return modelMapper.map(danhsachthamnien, DanhsachthamnienDTO.class);
    }

    public Danhsachthamnien toEntity(DanhsachthamnienDTO danhsachthamnienDTO) {
        return modelMapper.map(danhsachthamnienDTO, Danhsachthamnien.class);
    }
}

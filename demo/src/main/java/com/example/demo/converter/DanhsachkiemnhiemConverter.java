package com.example.demo.converter;


import com.example.demo.dto.DanhsachkhoangonDTO;
import com.example.demo.dto.DanhsachkiemnhiemDTO;
import com.example.demo.entity.Danhsachkhoangon;
import com.example.demo.entity.Danhsachkiemnhiem;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DanhsachkiemnhiemConverter {
    private final ModelMapper modelMapper;

    public DanhsachkiemnhiemConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DanhsachkiemnhiemDTO toDTO (Danhsachkiemnhiem danhsachkiemnhiem) {
        return modelMapper.map(danhsachkiemnhiem,DanhsachkiemnhiemDTO.class);
    }

    public Danhsachkiemnhiem toEntity (DanhsachkiemnhiemDTO danhsachkiemnhiemDTO) {
        return modelMapper.map(danhsachkiemnhiemDTO,Danhsachkiemnhiem.class);
    }
}

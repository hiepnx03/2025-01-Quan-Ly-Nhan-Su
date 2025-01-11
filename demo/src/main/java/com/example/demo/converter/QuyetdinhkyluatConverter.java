package com.example.demo.converter;

import com.example.demo.dto.CanboDTO;
import com.example.demo.dto.DonvichucnangDTO;
import com.example.demo.dto.QuyetdinhkyluatDTO;
import com.example.demo.entity.Canbo;
import com.example.demo.entity.Donvichucnang;
import com.example.demo.entity.Quyetdinhkyluat;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class QuyetdinhkyluatConverter  {

    private final ModelMapper modelMapper;

    public QuyetdinhkyluatConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public QuyetdinhkyluatDTO toDTO (Quyetdinhkyluat quyetdinhkyluat) {
        QuyetdinhkyluatDTO quyetdinhkyluatDTO = modelMapper.map(quyetdinhkyluat, QuyetdinhkyluatDTO.class);

        if(quyetdinhkyluat.getCanbo() != null){
            CanboDTO canboDTO = new CanboDTO();
            canboDTO.setId(quyetdinhkyluat.getCanbo().getId());
            quyetdinhkyluatDTO.setCanboDTO(canboDTO);
        }

        if(quyetdinhkyluat.getDonvichucnang() != null){
            DonvichucnangDTO donvichucnangDTO = new DonvichucnangDTO();
            donvichucnangDTO.setId(quyetdinhkyluat.getDonvichucnang().getId());
            donvichucnangDTO.setMaDonVi(quyetdinhkyluat.getDonvichucnang().getMaDonVi());
            donvichucnangDTO.setTenDonVi(quyetdinhkyluat.getDonvichucnang().getTenDonVi());
            donvichucnangDTO.setVersion(quyetdinhkyluat.getVersion());
        }

        return quyetdinhkyluatDTO;
    }

    public Quyetdinhkyluat toEntity (QuyetdinhkyluatDTO quyetdinhkyluatDTO) {
       Quyetdinhkyluat quyetdinhkyluat = modelMapper.map(quyetdinhkyluatDTO, Quyetdinhkyluat.class);


        if (quyetdinhkyluatDTO.getCanboDTO() != null) {
            quyetdinhkyluat.getCanbo().setId(quyetdinhkyluatDTO.getCanboDTO().getId());
        }


        if (quyetdinhkyluatDTO.getDonvichucnangDTO() != null) {
            quyetdinhkyluat.getDonvichucnang().setId(quyetdinhkyluatDTO.getDonvichucnangDTO().getId());
        }

       return quyetdinhkyluat;
    }
}


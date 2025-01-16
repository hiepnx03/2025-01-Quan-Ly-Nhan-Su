package com.example.demo.converter;


import com.example.demo.dto.*;
import com.example.demo.entity.Hopdongcanbo;
import com.example.demo.entity.Hopdongcanbonganhan;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HopdongcanbonganhanConverter {
    private final ModelMapper modelMapper;

    public HopdongcanbonganhanConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HopdongcanbonganhanDTO toDTO(Hopdongcanbonganhan hopdongcanbonganhan) {
        HopdongcanbonganhanDTO hopdongcanbonganhanDTO = modelMapper.map(hopdongcanbonganhan, HopdongcanbonganhanDTO.class);

        //1-1 hopdongcanbonganhan-loaihopdongnganhan toDTO
        if(hopdongcanbonganhan.getLoaihopdongnganhan() != null){
            LoaihopdongnganhanDTO loaihopdongnganhanDTO = new LoaihopdongnganhanDTO();

            loaihopdongnganhanDTO.setId(hopdongcanbonganhan.getLoaihopdongnganhan().getId());
            loaihopdongnganhanDTO.setTenLoaiHopDong(hopdongcanbonganhan.getLoaihopdongnganhan().getTenLoaiHopDong());
            loaihopdongnganhanDTO.setVersion(hopdongcanbonganhan.getLoaihopdongnganhan().getVersion());

            hopdongcanbonganhanDTO.setLoaihopdongnganhanDTO(loaihopdongnganhanDTO);
        }

        //1-1 hopdongcanbonganhan-donvichucnang toDTO
        if(hopdongcanbonganhan.getDonvichucnang() != null){
            DonvichucnangDTO donvichucnangDTO = new DonvichucnangDTO();

            donvichucnangDTO.setId(hopdongcanbonganhan.getDonvichucnang().getId());
            donvichucnangDTO.setMaDonVi(hopdongcanbonganhan.getDonvichucnang().getMaDonVi());
            donvichucnangDTO.setTenDonVi(hopdongcanbonganhan.getDonvichucnang().getTenDonVi());
            donvichucnangDTO.setVersion(hopdongcanbonganhan.getDonvichucnang().getVersion());

            hopdongcanbonganhanDTO.setDonvichucnangDTO(donvichucnangDTO);
        }

        //1-1 hopdongcanbo-canbo toDTO
        if(hopdongcanbonganhan.getCanbo() != null){
            CanboDTO canboDTO = new CanboDTO();

            canboDTO.setId(hopdongcanbonganhan.getCanbo().getId());
            canboDTO.setSoHieu(hopdongcanbonganhan.getCanbo().getSoHieu());
            canboDTO.setImageUrl(hopdongcanbonganhan.getCanbo().getImageUrl());
            canboDTO.setTen(hopdongcanbonganhan.getCanbo().getTen());
            canboDTO.setTenGoiKhac(hopdongcanbonganhan.getCanbo().getTenGoiKhac());
            canboDTO.setGioiTinh(hopdongcanbonganhan.getCanbo().getGioiTinh());
            canboDTO.setNoiSinh(hopdongcanbonganhan.getCanbo().getNoiSinh());
            canboDTO.setSoCmnd(hopdongcanbonganhan.getCanbo().getSoCmnd());
            canboDTO.setNoiCapCmnd(hopdongcanbonganhan.getCanbo().getNoiCapCmnd());
            canboDTO.setNoiDKHoKhauThuongTru(hopdongcanbonganhan.getCanbo().getNoiDKHoKhauThuongTru());
            canboDTO.setNoiOHienNay(hopdongcanbonganhan.getCanbo().getNoiOHienNay());
            canboDTO.setNgheNghieidhiTuyenDung(hopdongcanbonganhan.getCanbo().getNgheNghieidhiTuyenDung());
            canboDTO.setCoQuanTuyenDung(hopdongcanbonganhan.getCanbo().getCoQuanTuyenDung());
            canboDTO.setCongViecDuocGiao(hopdongcanbonganhan.getCanbo().getCongViecDuocGiao());
            canboDTO.setChucDanh(hopdongcanbonganhan.getCanbo().getChucDanh());
            canboDTO.setTrinhDoGiaoDucPt(hopdongcanbonganhan.getCanbo().getTrinhDoGiaoDucPt());
            canboDTO.setTrinhDoChuyenMon(hopdongcanbonganhan.getCanbo().getTrinhDoChuyenMon());
            canboDTO.setHocVi(hopdongcanbonganhan.getCanbo().getHocVi());
            canboDTO.setHocHam(hopdongcanbonganhan.getCanbo().getHocHam());
            canboDTO.setLyLuanChinhTri(hopdongcanbonganhan.getCanbo().getLyLuanChinhTri());
            canboDTO.setQuanLyNhaNuoc(hopdongcanbonganhan.getCanbo().getQuanLyNhaNuoc());
            canboDTO.setNgoaiNgu(hopdongcanbonganhan.getCanbo().getNgoaiNgu());
            canboDTO.setTinHoc(hopdongcanbonganhan.getCanbo().getTinHoc());
            canboDTO.setThamGiaToChucCtxh(hopdongcanbonganhan.getCanbo().getThamGiaToChucCtxh());
            canboDTO.setNhomMau(hopdongcanbonganhan.getCanbo().getNhomMau());
            canboDTO.setSoBaoHiemXh(hopdongcanbonganhan.getCanbo().getSoBaoHiemXh());
            canboDTO.setLaThuongBinh(hopdongcanbonganhan.getCanbo().getLaThuongBinh());
            canboDTO.setLaConGiaDinhChinhSach(hopdongcanbonganhan.getCanbo().getLaConGiaDinhChinhSach());
            canboDTO.setNhanXet(hopdongcanbonganhan.getCanbo().getNhanXet());
            canboDTO.setQuanHamCaoNhat(hopdongcanbonganhan.getCanbo().getQuanHamCaoNhat());
            canboDTO.setDanhHieuPhongTang(hopdongcanbonganhan.getCanbo().getDanhHieuPhongTang());
            canboDTO.setKhenThuong(hopdongcanbonganhan.getCanbo().getKhenThuong());
            canboDTO.setKyLuat(hopdongcanbonganhan.getCanbo().getKyLuat());
            canboDTO.setTinhTrangSucKhoe(hopdongcanbonganhan.getCanbo().getTinhTrangSucKhoe());
            canboDTO.setVersion(hopdongcanbonganhan.getCanbo().getVersion());

            hopdongcanbonganhanDTO.setCanboDTO(canboDTO);
        }

        return hopdongcanbonganhanDTO;
    }

    public Hopdongcanbonganhan toEntity(HopdongcanbonganhanDTO hopdongcanbonganhanDTO) {
        Hopdongcanbonganhan hopdongcanbonganhan = modelMapper.map(hopdongcanbonganhanDTO, Hopdongcanbonganhan.class);

        //\tN-1 hopdongcanbonganhan-loaihopdongnganhan toEntity
        if(hopdongcanbonganhanDTO.getLoaihopdongnganhanDTO() != null){
            hopdongcanbonganhan.getLoaihopdongnganhan().setId(hopdongcanbonganhanDTO.getLoaihopdongnganhanDTO().getId());
        }
        //\tN-1 hopdongcanbonganhan-donvichucnang toEntity
        if(hopdongcanbonganhanDTO.getDonvichucnangDTO() != null){
            hopdongcanbonganhan.getDonvichucnang().setId(hopdongcanbonganhanDTO.getDonvichucnangDTO().getId());
        }

        //\tN-1 hopdongcanbonganhan-canbo toEntity
        if(hopdongcanbonganhanDTO.getCanboDTO() != null){
            hopdongcanbonganhan.getCanbo().setId(hopdongcanbonganhanDTO.getCanboDTO().getId());
        }

        return hopdongcanbonganhan;
    }
}

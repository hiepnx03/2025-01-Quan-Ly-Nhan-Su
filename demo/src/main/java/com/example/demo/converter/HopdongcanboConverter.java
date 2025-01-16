package com.example.demo.converter;


import com.example.demo.dto.CanboDTO;
import com.example.demo.dto.DonvichucnangDTO;
import com.example.demo.dto.HopdongcanboDTO;
import com.example.demo.dto.LoaihopdongDTO;
import com.example.demo.entity.Hopdongcanbo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HopdongcanboConverter  {
    private final ModelMapper modelMapper;

    public HopdongcanboConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public HopdongcanboDTO toDTO(Hopdongcanbo hopdongcanbo) {
        HopdongcanboDTO hopdongcanboDTO = modelMapper.map(hopdongcanbo, HopdongcanboDTO.class);

        //1-1 hopdongcanbo-loaihopdong toDTO
        if(hopdongcanbo.getLoaihopdong() != null){
            LoaihopdongDTO loaihopdongDTO = new LoaihopdongDTO();

            loaihopdongDTO.setId(hopdongcanbo.getLoaihopdong().getId());
            loaihopdongDTO.setTenLoaiHopDong(hopdongcanbo.getLoaihopdong().getTenLoaiHopDong());
            loaihopdongDTO.setVersion(hopdongcanbo.getLoaihopdong().getVersion());

            hopdongcanboDTO.setLoaihopdongDTO(loaihopdongDTO);
        }

        //1-1 hopdongcanbo-donvichucnang toDTO
        if(hopdongcanbo.getDonvichucnang() != null){
            DonvichucnangDTO donvichucnangDTO = new DonvichucnangDTO();

            donvichucnangDTO.setId(hopdongcanbo.getDonvichucnang().getId());
            donvichucnangDTO.setMaDonVi(hopdongcanbo.getDonvichucnang().getMaDonVi());
            donvichucnangDTO.setTenDonVi(hopdongcanbo.getDonvichucnang().getTenDonVi());
            donvichucnangDTO.setVersion(hopdongcanbo.getDonvichucnang().getVersion());

            hopdongcanboDTO.setDonvichucnangDTO(donvichucnangDTO);
        }

        //1-1 hopdongcanbo-canbo toDTO
        if(hopdongcanbo.getCanbo() != null){
            CanboDTO canboDTO = new CanboDTO();

            canboDTO.setId(hopdongcanbo.getCanbo().getId());
            canboDTO.setSoHieu(hopdongcanbo.getCanbo().getSoHieu());
            canboDTO.setImageUrl(hopdongcanbo.getCanbo().getImageUrl());
            canboDTO.setTen(hopdongcanbo.getCanbo().getTen());
            canboDTO.setTenGoiKhac(hopdongcanbo.getCanbo().getTenGoiKhac());
            canboDTO.setGioiTinh(hopdongcanbo.getCanbo().getGioiTinh());
            canboDTO.setNoiSinh(hopdongcanbo.getCanbo().getNoiSinh());
            canboDTO.setSoCmnd(hopdongcanbo.getCanbo().getSoCmnd());
            canboDTO.setNoiCapCmnd(hopdongcanbo.getCanbo().getNoiCapCmnd());
            canboDTO.setNoiDKHoKhauThuongTru(hopdongcanbo.getCanbo().getNoiDKHoKhauThuongTru());
            canboDTO.setNoiOHienNay(hopdongcanbo.getCanbo().getNoiOHienNay());
            canboDTO.setNgheNghieidhiTuyenDung(hopdongcanbo.getCanbo().getNgheNghieidhiTuyenDung());
            canboDTO.setCoQuanTuyenDung(hopdongcanbo.getCanbo().getCoQuanTuyenDung());
            canboDTO.setCongViecDuocGiao(hopdongcanbo.getCanbo().getCongViecDuocGiao());
            canboDTO.setChucDanh(hopdongcanbo.getCanbo().getChucDanh());
            canboDTO.setTrinhDoGiaoDucPt(hopdongcanbo.getCanbo().getTrinhDoGiaoDucPt());
            canboDTO.setTrinhDoChuyenMon(hopdongcanbo.getCanbo().getTrinhDoChuyenMon());
            canboDTO.setHocVi(hopdongcanbo.getCanbo().getHocVi());
            canboDTO.setHocHam(hopdongcanbo.getCanbo().getHocHam());
            canboDTO.setLyLuanChinhTri(hopdongcanbo.getCanbo().getLyLuanChinhTri());
            canboDTO.setQuanLyNhaNuoc(hopdongcanbo.getCanbo().getQuanLyNhaNuoc());
            canboDTO.setNgoaiNgu(hopdongcanbo.getCanbo().getNgoaiNgu());
            canboDTO.setTinHoc(hopdongcanbo.getCanbo().getTinHoc());
            canboDTO.setThamGiaToChucCtxh(hopdongcanbo.getCanbo().getThamGiaToChucCtxh());
            canboDTO.setNhomMau(hopdongcanbo.getCanbo().getNhomMau());
            canboDTO.setSoBaoHiemXh(hopdongcanbo.getCanbo().getSoBaoHiemXh());
            canboDTO.setLaThuongBinh(hopdongcanbo.getCanbo().getLaThuongBinh());
            canboDTO.setLaConGiaDinhChinhSach(hopdongcanbo.getCanbo().getLaConGiaDinhChinhSach());
            canboDTO.setNhanXet(hopdongcanbo.getCanbo().getNhanXet());
            canboDTO.setQuanHamCaoNhat(hopdongcanbo.getCanbo().getQuanHamCaoNhat());
            canboDTO.setDanhHieuPhongTang(hopdongcanbo.getCanbo().getDanhHieuPhongTang());
            canboDTO.setKhenThuong(hopdongcanbo.getCanbo().getKhenThuong());
            canboDTO.setKyLuat(hopdongcanbo.getCanbo().getKyLuat());
            canboDTO.setTinhTrangSucKhoe(hopdongcanbo.getCanbo().getTinhTrangSucKhoe());
            canboDTO.setVersion(hopdongcanbo.getCanbo().getVersion());

            hopdongcanboDTO.setCanboDTO(canboDTO);
        }

        return hopdongcanboDTO;
    }

    public Hopdongcanbo toEntity(HopdongcanboDTO hopdongcanboDTO) {
        Hopdongcanbo hopdongcanbo = modelMapper.map(hopdongcanboDTO, Hopdongcanbo.class);

        //\tN-1 hopdongcanbo-loaihopdong toEntity
        if(hopdongcanboDTO.getLoaihopdongDTO() != null){
            hopdongcanbo.getLoaihopdong().setId(hopdongcanboDTO.getLoaihopdongDTO().getId());
        }
        //\tN-1 hopdongcanbo-donvichucnang toEntity
        if(hopdongcanboDTO.getDonvichucnangDTO() != null){
            hopdongcanbo.getDonvichucnang().setId(hopdongcanboDTO.getDonvichucnangDTO().getId());
        }

        //\tN-1 hopdongcanbo-canbo toEntity
        if(hopdongcanboDTO.getCanboDTO() != null){
            hopdongcanbo.getCanbo().setId(hopdongcanboDTO.getCanboDTO().getId());
        }

        return hopdongcanbo;
    }
}

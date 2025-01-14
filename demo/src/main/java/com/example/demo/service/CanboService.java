package com.example.demo.service;


import com.example.demo.dto.CanboDTO;
import com.example.demo.entity.Canbo;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CanboService {
    public List<CanboDTO> getAll();
    public Page<CanboDTO> getCanboEnablePage(int pageNo, int pageSize);
    public Page<CanboDTO> getCanboDisablePage(int pageNo, int pageSize);
    public CanboDTO getById(Long id);

    public CanboDTO save(CanboDTO canboDTO);

    public CanboDTO addTongiao(Long canboId, Long tongiaoId);
    public CanboDTO updateTongiao(CanboDTO canboDTO);
    public CanboDTO deleteTongiao(Long id);

    public CanboDTO addChucVu(Long canboId, Long chucvuId);
    public CanboDTO updateChucVu(CanboDTO canboDTO);
    public CanboDTO deleteChucVu(Long id);

    public CanboDTO addDanToc(Long canboId, Long dantocId);
    public CanboDTO updateDanToc(CanboDTO canboDTO);
    public CanboDTO deleteDanToc(Long id);

    public CanboDTO update(CanboDTO canboDTO , Long id);

    void deleteById(Long id);
}

package com.example.demo.controller.admin;

import com.example.demo.dto.BomonDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.BomonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/bomon")
@AllArgsConstructor
public class BomonController {
    private final BomonService bomonService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<BomonDTO> list = bomonService.getAll();
        return ResponseEntity.ok(new ResponseObject("200", "Danh sách bộ môn", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        BomonDTO bomon = bomonService.getById(id);
        return ResponseEntity.ok(new ResponseObject("200", "Chi tiết bộ môn", bomon));
    }

    @PostMapping("/{donvichucnangId}/bomon")
    public ResponseEntity<ResponseObject> create(@PathVariable Long donvichucnangId, @RequestBody BomonDTO bomonDTO) {
        BomonDTO createdBomon = bomonService.create(donvichucnangId, bomonDTO);
        return ResponseEntity.ok(new ResponseObject("200", "Tạo mới bộ môn thành công", createdBomon));
    }

    @PutMapping("/{donvichucnangId}/bomon/{bomonId}")
    public ResponseEntity<ResponseObject> update(@PathVariable Long donvichucnangId,
                                                 @PathVariable Long bomonId,
                                                 @RequestBody BomonDTO bomonDTO) {
        BomonDTO updatedBomon = bomonService.update(donvichucnangId, bomonId, bomonDTO);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật bộ môn thành công", updatedBomon));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        bomonService.delete(id);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa bộ môn thành công", null));
    }


}

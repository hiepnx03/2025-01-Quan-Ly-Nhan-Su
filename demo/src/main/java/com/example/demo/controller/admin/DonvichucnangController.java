package com.example.demo.controller.admin;

import com.example.demo.dto.DonvichucnangDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.DonvichucnangService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/donvichucnang")
@AllArgsConstructor
public class DonvichucnangController {
    private final DonvichucnangService donvichucnangService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<DonvichucnangDTO> list = donvichucnangService.getAll();
        return ResponseEntity.ok(new ResponseObject("200", "Danh sách đơn vị chức năng", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        DonvichucnangDTO donvichucnang = donvichucnangService.getById(id);
        return ResponseEntity.ok(new ResponseObject("200", "Chi tiết đơn vị chức năng", donvichucnang));
    }

    @PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody DonvichucnangDTO dto) {
        DonvichucnangDTO created = donvichucnangService.create(dto);
        return ResponseEntity.ok(new ResponseObject("200", "Tạo mới đơn vị chức năng thành công", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody DonvichucnangDTO dto) {
        DonvichucnangDTO updated = donvichucnangService.update(id, dto);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật đơn vị chức năng thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        donvichucnangService.delete(id);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa đơn vị chức năng thành công", null));
    }
}

package com.example.demo.controller.admin;

import com.example.demo.dto.LoaiquyetdinhDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.LoaiquyetdinhService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/loaiquyetdinh")
@AllArgsConstructor
public class LoaiquyetdinhController  {
    private final LoaiquyetdinhService loaiquyetdinhService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<LoaiquyetdinhDTO> list = loaiquyetdinhService.getAll();
        return ResponseEntity.ok(new ResponseObject("200", "Danh sách loại quyết định", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        LoaiquyetdinhDTO loaiquyetdinh = loaiquyetdinhService.getById(id);
        return ResponseEntity.ok(new ResponseObject("200", "Chi tiết loại quyết định", loaiquyetdinh));
    }

    @PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody LoaiquyetdinhDTO dto) {
        LoaiquyetdinhDTO created = loaiquyetdinhService.create(dto);
        return ResponseEntity.ok(new ResponseObject("200", "Tạo mới loại quyết định thành công", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody LoaiquyetdinhDTO dto) {
        LoaiquyetdinhDTO updated = loaiquyetdinhService.update(id, dto);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật loại quyết định thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        loaiquyetdinhService.delete(id);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa loại quyết định thành công", null));
    }
}

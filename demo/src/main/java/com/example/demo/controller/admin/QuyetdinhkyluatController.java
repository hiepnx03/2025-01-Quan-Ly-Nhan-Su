package com.example.demo.controller.admin;

import com.example.demo.dto.QuyetdinhkyluatDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.QuyetdinhkyluatService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/quyetdinhkyluat")
@AllArgsConstructor
public class QuyetdinhkyluatController  {
    private final QuyetdinhkyluatService quyetdinhkyluatService;

    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<QuyetdinhkyluatDTO> list = quyetdinhkyluatService.getAll();
        return ResponseEntity.ok(new ResponseObject("200", "Danh sách quyết định kỷ luật", list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        QuyetdinhkyluatDTO quyetdinhkyluat = quyetdinhkyluatService.getById(id);
        return ResponseEntity.ok(new ResponseObject("200", "Chi tiết quyết định kỷ luật", quyetdinhkyluat));
    }

    @PostMapping
    public ResponseEntity<ResponseObject> create(@RequestBody QuyetdinhkyluatDTO dto) {
        QuyetdinhkyluatDTO created = quyetdinhkyluatService.create(dto);
        return ResponseEntity.ok(new ResponseObject("200", "Tạo mới quyết định kỷ luật thành công", created));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody QuyetdinhkyluatDTO dto) {
        QuyetdinhkyluatDTO updated = quyetdinhkyluatService.update(id, dto);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật quyết định kỷ luật thành công", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        quyetdinhkyluatService.delete(id);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa quyết định kỷ luật thành công", null));
    }
}

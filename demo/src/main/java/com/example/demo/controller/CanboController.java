package com.example.demo.controller;

import com.example.demo.dto.CanboDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.CanboService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canbo") // Endpoint gốc cho tất cả các yêu cầu liên quan đến Canbo
@AllArgsConstructor
public class CanboController {

    private final CanboService canboService;

    // Lấy danh sách tất cả các cán bộ
    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<CanboDTO> canbos = canboService.getAll();
        return ResponseEntity.ok(new ResponseObject("200", "getall", canbos));
    }

    // Lấy thông tin cán bộ theo ID
    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        CanboDTO canbo = canboService.getById(id);
        return ResponseEntity.ok(new ResponseObject("200", "getbyid", canbo));
    }

    // Thêm mới hoặc cập nhật thông tin cán bộ
    @PostMapping
    public ResponseEntity<ResponseObject> save(@RequestBody CanboDTO canboDTO) {
        CanboDTO savedCanbo = canboService.save(canboDTO);
        return ResponseEntity.ok(new ResponseObject("200", "save", savedCanbo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> update(@RequestBody CanboDTO canboDTO ,@PathVariable Long id) {
        CanboDTO savedCanbo = canboService.update(canboDTO, id);
        return ResponseEntity.ok(new ResponseObject("200", "update", savedCanbo));
    }

    // Xóa cán bộ theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        canboService.deleteById(id);
        return ResponseEntity.ok(new ResponseObject("200", "delete", canboService.getById(id)));
    }

    //TON GIAO
    @PutMapping("/{canboId}/tongiao/{tongiaoId}")
    public ResponseEntity<ResponseObject> addTongiao(
            @PathVariable Long canboId,
            @PathVariable Long tongiaoId) {
        CanboDTO updatedCanbo = canboService.addTongiao(canboId, tongiaoId);
        return ResponseEntity.ok(new ResponseObject("200", "Gán tôn giáo thành công", updatedCanbo));
    }
    @PutMapping("/tongiao")
    public ResponseEntity<ResponseObject> updateTongiao(@RequestBody CanboDTO canboDTO) {
        CanboDTO updatedCanbo = canboService.updateTongiao(canboDTO);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật tôn giáo thành công", updatedCanbo));
    }
    @DeleteMapping("/{canboId}/tongiao")
    public ResponseEntity<ResponseObject> deleteTongiao(@PathVariable Long canboId) {
        CanboDTO updatedCanbo = canboService.deleteTongiao(canboId);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa tôn giáo thành công", updatedCanbo));
    }

    //CHUC VU
    @PutMapping("/{canboId}/chucvu/{chucvuId}")
    public ResponseEntity<ResponseObject> addChucVu(
            @PathVariable Long canboId,
            @PathVariable Long chucvuId) {
        CanboDTO updatedCanbo = canboService.addChucVu(canboId, chucvuId);
        return ResponseEntity.ok(new ResponseObject("200", "Gán chức vụ thành công", updatedCanbo));
    }
    @PutMapping("/chucvu")
    public ResponseEntity<ResponseObject> updateChucVu(@RequestBody CanboDTO canboDTO) {
        CanboDTO updatedCanbo = canboService.updateChucVu(canboDTO);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật chức vụ thành công", updatedCanbo));
    }
    @DeleteMapping("/{canboId}/chucvu")
    public ResponseEntity<ResponseObject> deleteChucVu(@PathVariable Long canboId) {
        CanboDTO updatedCanbo = canboService.deleteChucVu(canboId);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa chức vụ thành công", updatedCanbo));
    }

    // DAN TOC
    @PutMapping("/{canboId}/dantoc/{dantocId}")
    public ResponseEntity<ResponseObject> addDanToc(
            @PathVariable Long canboId,
            @PathVariable Long dantocId) {
        CanboDTO updatedCanbo = canboService.addDanToc(canboId, dantocId);
        return ResponseEntity.ok(new ResponseObject("200", "Gán dân tộc thành công", updatedCanbo));
    }
    @PutMapping("/dantoc")
    public ResponseEntity<ResponseObject> updateDanToc(@RequestBody CanboDTO canboDTO) {
        CanboDTO updatedCanbo = canboService.updateDanToc(canboDTO);
        return ResponseEntity.ok(new ResponseObject("200", "Cập nhật dân tộc thành công", updatedCanbo));
    }
    @DeleteMapping("/{canboId}/dantoc")
    public ResponseEntity<ResponseObject> deleteDanToc(@PathVariable Long canboId) {
        CanboDTO updatedCanbo = canboService.deleteDanToc(canboId);
        return ResponseEntity.ok(new ResponseObject("200", "Xóa dân tộc thành công", updatedCanbo));
    }
}

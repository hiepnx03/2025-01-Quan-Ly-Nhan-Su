package com.example.demo.controller;

import com.example.demo.constants.PageableConstant;
import com.example.demo.dto.CanboDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.CanboService;
import com.example.demo.viewmodel.ErrorVm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/canbo") // Endpoint gốc cho tất cả các yêu cầu liên quan đến Canbo
@AllArgsConstructor
public class CanboController {

    private final CanboService canboService;

    // Lấy danh sách tất cả các cán bộ
    @Operation(summary = "Get all Canbo", description = "Lấy danh sách tất cả các cán bộ từ hệ thống")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<CanboDTO> canbos = canboService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "getall", canbos));
    }


    @GetMapping("/true")
    public ResponseEntity<Page<CanboDTO>> getCanboEnable(
            @RequestParam(value = "pageNo", defaultValue = PageableConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = PageableConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ) {
        Page<CanboDTO> pageableCanbos = canboService.getCanboEnablePage(pageNo, pageSize);
        return ResponseEntity.ok(pageableCanbos);
    }

    @GetMapping("/disable")
    public ResponseEntity<Page<CanboDTO>> getCanBoDisable(
            @RequestParam(value = "pageNo", defaultValue = PageableConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = PageableConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ) {
        Page<CanboDTO> pageableCanbos = canboService.getCanboDisablePage(pageNo, pageSize);
        return ResponseEntity.ok(pageableCanbos);
    }


    // Lấy thông tin cán bộ theo ID
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        CanboDTO canbo = canboService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "getbyid", canbo));
    }

    // Thêm mới hoặc cập nhật thông tin cán bộ
    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = CanboDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> save(@Valid @RequestBody CanboDTO canboDTO) {
        CanboDTO savedCanbo = canboService.save(canboDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "save", savedCanbo));
    }
//    public ResponseEntity<CanboDTO> createProduct(@Valid @RequestBody CanboDTO canboDTO) {
//        CanboDTO savedCanbo = canboService.save(canboDTO);
//        return new ResponseEntity<>(savedCanbo, HttpStatus.CREATED);
//    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Updated"),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> update(@RequestBody CanboDTO canboDTO, @PathVariable Long id) {
        CanboDTO savedCanbo = canboService.update(canboDTO, id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "update", savedCanbo));
    }

    // Xóa cán bộ theo ID
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        canboService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject("204", "delete", canboService.getById(id)));
//        return ResponseEntity.noContent().build();
    }

    //TON GIAO
    @PutMapping("/{canboId}/tongiao/{tongiaoId}")
    public ResponseEntity<ResponseObject> addTongiao(
            @PathVariable Long canboId,
            @PathVariable Long tongiaoId) {
        CanboDTO updatedCanbo = canboService.addTongiao(canboId, tongiaoId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Gán tôn giáo thành công", updatedCanbo));
    }

    @PutMapping("/tongiao")
    public ResponseEntity<ResponseObject> updateTongiao(@RequestBody CanboDTO canboDTO) {
        CanboDTO updatedCanbo = canboService.updateTongiao(canboDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Cập nhật tôn giáo thành công", updatedCanbo));
    }

    @DeleteMapping("/{canboId}/tongiao")
    public ResponseEntity<ResponseObject> deleteTongiao(@PathVariable Long canboId) {
        CanboDTO updatedCanbo = canboService.deleteTongiao(canboId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject("204", "Xóa tôn giáo thành công", updatedCanbo));
    }

    //CHUC VU
    @PutMapping("/{canboId}/chucvu/{chucvuId}")
    public ResponseEntity<ResponseObject> addChucVu(
            @PathVariable Long canboId,
            @PathVariable Long chucvuId) {
        CanboDTO updatedCanbo = canboService.addChucVu(canboId, chucvuId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Gán chức vụ thành công", updatedCanbo));
    }

    @PutMapping("/chucvu")
    public ResponseEntity<ResponseObject> updateChucVu(@RequestBody CanboDTO canboDTO) {
        CanboDTO updatedCanbo = canboService.updateChucVu(canboDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Cập nhật chức vụ thành công", updatedCanbo));
    }

    @DeleteMapping("/{canboId}/chucvu")
    public ResponseEntity<ResponseObject> deleteChucVu(@PathVariable Long canboId) {
        CanboDTO updatedCanbo = canboService.deleteChucVu(canboId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject("204", "Xóa chức vụ thành công", updatedCanbo));
    }

    // DAN TOC
    @PutMapping("/{canboId}/dantoc/{dantocId}")
    public ResponseEntity<ResponseObject> addDanToc(
            @PathVariable Long canboId,
            @PathVariable Long dantocId) {
        CanboDTO updatedCanbo = canboService.addDanToc(canboId, dantocId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Gán dân tộc thành công", updatedCanbo));
    }

    @PutMapping("/dantoc")
    public ResponseEntity<ResponseObject> updateDanToc(@RequestBody CanboDTO canboDTO) {
        CanboDTO updatedCanbo = canboService.updateDanToc(canboDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Cập nhật dân tộc thành công", updatedCanbo));
    }

    @DeleteMapping("/{canboId}/dantoc")
    public ResponseEntity<ResponseObject> deleteDanToc(@PathVariable Long canboId) {
        CanboDTO updatedCanbo = canboService.deleteDanToc(canboId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject("204", "Xóa dân tộc thành công", updatedCanbo));
    }


    @GetMapping("/export-salary/{id}")
    public ResponseEntity<byte[]> exportSalaryExcel(@PathVariable Long id) {
        try {
            byte[] excelFile = canboService.exportSalaryExcel(id);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=salary_info.xlsx");

            return new ResponseEntity<>(excelFile, headers, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

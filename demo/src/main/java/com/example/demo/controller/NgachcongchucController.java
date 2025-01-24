package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.PageableConstant;
import com.example.demo.dto.NgachcongchucDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.NgachcongchucService;
import com.example.demo.constants.ErrorVm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ngachcongchuc")
@AllArgsConstructor
public class NgachcongchucController {

    private final NgachcongchucService ngachcongchucService;

    @Operation(summary = "Get all ngạch công chức", description = "Lấy danh sách tất cả các ngạch công chức từ hệ thống")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<NgachcongchucDTO> result = ngachcongchucService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Danh sách ngạch công chức", result));
    }

    @GetMapping("/page")
    @Operation(summary = "Get all ngạch công chức (phân trang)", description = "Lấy danh sách tất cả các ngạch công chức từ hệ thống với phân trang")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<Page<NgachcongchucDTO>> getAllPage(
            @RequestParam(value = "pageNo", defaultValue = PageableConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = PageableConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ) {
        Page<NgachcongchucDTO> page = ngachcongchucService.getAllPage(pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))}
    )
    public ResponseEntity<ResponseObject> searchNgachCongChuc(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {

        Page<NgachcongchucDTO> results = ngachcongchucService.searchByMaNgachOrSoNamNangBacLuongOrTenNgach(keyword, pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("200", "Danh sách ngạch công chức tìm kiếm", results.getContent()));
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))}
    )
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        NgachcongchucDTO result = ngachcongchucService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Chi tiết ngạch công chức", result));
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = NgachcongchucDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> create(@RequestBody NgachcongchucDTO dto) {
        NgachcongchucDTO created = ngachcongchucService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "Tạo mới ngạch công chức thành công", created));
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Updated"),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody NgachcongchucDTO dto) {
        NgachcongchucDTO updated = ngachcongchucService.update(id, dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Cập nhật ngạch công chức thành công", updated));
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        ngachcongchucService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject("204", "Xóa ngạch công chức thành công", null));
    }
}

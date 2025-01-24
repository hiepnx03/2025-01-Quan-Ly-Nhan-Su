package com.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constants.PageableConstant;
import com.example.demo.dto.DanhsachkhoangonDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.DanhsachkhoangonService;
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
@RequestMapping("/api/danhsachkhoangon")
@AllArgsConstructor
public class DanhsachkhoangonController {

    private final DanhsachkhoangonService danhsachkhoangonService;

    @Operation(summary = "Get all danh sách khoán gọn", description = "Lấy danh sách tất cả các danh sách khoán gọn từ hệ thống")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<DanhsachkhoangonDTO> result = danhsachkhoangonService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Danh sách khoán gọn", result));
    }

    @GetMapping("/page")
    @Operation(summary = "Get all danh sách khoán gọn (phân trang)", description = "Lấy danh sách tất cả các danh sách khoán gọn từ hệ thống với phân trang")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<Page<DanhsachkhoangonDTO>> getAllPage(
            @RequestParam(value = "pageNo", defaultValue = PageableConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = PageableConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ) {
        Page<DanhsachkhoangonDTO> page = danhsachkhoangonService.getAllPage(pageNo, pageSize);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Chi tiết danh sách thành công", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Không tìm thấy danh sách với ID", content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Yêu cầu không hợp lệ", content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        DanhsachkhoangonDTO result = danhsachkhoangonService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Chi tiết danh sách khoán gọn", result));
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tạo mới danh sách thành công", content = @Content(schema = @Schema(implementation = DanhsachkhoangonDTO.class))),
            @ApiResponse(responseCode = "400", description = "Yêu cầu không hợp lệ", content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> create(@RequestBody DanhsachkhoangonDTO dto) {
        DanhsachkhoangonDTO created = danhsachkhoangonService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "Tạo mới danh sách khoán gọn thành công", created));
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Cập nhật danh sách thành công"),
            @ApiResponse(responseCode = "404", description = "Không tìm thấy danh sách với ID", content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Yêu cầu không hợp lệ", content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody DanhsachkhoangonDTO dto) {
        DanhsachkhoangonDTO updated = danhsachkhoangonService.update(id, dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Cập nhật danh sách khoán gọn thành công", updated));
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        danhsachkhoangonService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject("204", "Xóa danh sách khoán gọn thành công", null));
    }



}

package com.example.demo.controller.admin;

import com.example.demo.constants.PageableConstant;
import com.example.demo.dto.LoaihopdongDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.LoaihopdongService;
import com.example.demo.constants.ErrorVm;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loaihopdong")
@AllArgsConstructor
public class LoaihopdongController {

    private final LoaihopdongService loaihopdongService;

    @Operation(summary = "Get all loại hợp đồng", description = "Lấy danh sách tất cả các loại hợp đồng từ hệ thống")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<LoaihopdongDTO> result = loaihopdongService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Danh sách loại hợp đồng", result));
    }

    @GetMapping("/page")
    @Operation(summary = "Get all loại hợp đồng (phân trang)", description = "Lấy danh sách tất cả các loại hợp đồng từ hệ thống với phân trang")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<Page<LoaihopdongDTO>> getAllPage(
            @RequestParam(value = "pageNo", defaultValue = PageableConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = PageableConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ) {
        Page<LoaihopdongDTO> loaihopdongDTOPage = loaihopdongService.getAllPage(pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(loaihopdongDTOPage);
    }


    @GetMapping("/search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))}
    )
    public ResponseEntity<ResponseObject> searchLoaiHopDong(
            @RequestParam String tenLoaiHopDong,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {

        Page<LoaihopdongDTO> results = loaihopdongService.searchByTenLoaiHopDong(tenLoaiHopDong, pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("200", "Danh sách loại hợp đồng tìm kiếm", results.getContent()));
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
        LoaihopdongDTO result = loaihopdongService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Chi tiết loại hợp đồng", result));
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = LoaihopdongDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> create(@RequestBody LoaihopdongDTO loaihopdongDTO) {
        LoaihopdongDTO created = loaihopdongService.create(loaihopdongDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "Tạo mới loại hợp đồng thành công", created));
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Updated"),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody LoaihopdongDTO loaihopdongDTO) {
        LoaihopdongDTO updated = loaihopdongService.update(id, loaihopdongDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Cập nhật loại hợp đồng thành công", updated));
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        loaihopdongService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject("204", "Xóa loại hợp đồng thành công", null));
    }
}

package com.example.demo.controller.admin;

import com.example.demo.constants.PageableConstant;
import com.example.demo.dto.DonvichucnangDTO;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.DonvichucnangService;
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
@RequestMapping("/api/donvichucnang")
@AllArgsConstructor
public class DonvichucnangController {
    private final DonvichucnangService donvichucnangService;

    @Operation(summary = "Get all donvichucnang", description = "Lấy danh sách đơn vị chức năng từ hệ thống")
    @ApiResponse(responseCode = "200", description = "Success")
    @GetMapping
    public ResponseEntity<ResponseObject> getAll() {
        List<DonvichucnangDTO> list = donvichucnangService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Danh sách đơn vị chức năng", list));
    }


    @GetMapping("/page")
    public ResponseEntity<Page<DonvichucnangDTO>> getAllPage(
            @RequestParam(value = "pageNo", defaultValue = PageableConstant.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = PageableConstant.DEFAULT_PAGE_SIZE, required = false) int pageSize
    ) {
        Page<DonvichucnangDTO> donvichucnangDTOPage = donvichucnangService.getAllPage(pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK).body(donvichucnangDTOPage);
    }


    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> getById(@PathVariable Long id) {
        DonvichucnangDTO donvichucnang = donvichucnangService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Chi tiết đơn vị chức năng", donvichucnang));
    }

    // 🔍 API tìm kiếm đơn vị chức năng (có hỗ trợ phân trang)
    @GetMapping("/search")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> searchDonVi(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize) {
        Page<DonvichucnangDTO> results = donvichucnangService.searchByTenOrMaDonVi(keyword, pageNo, pageSize);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseObject("200", "Danh sách đơn vị chức năng tìm kiếm", results.getContent()));
    }

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = DonvichucnangDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> create(@RequestBody DonvichucnangDTO dto) {
        DonvichucnangDTO created = donvichucnangService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "Tạo mới đơn vị chức năng thành công", created));
    }

    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Updated"),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<ResponseObject> update(@PathVariable Long id, @RequestBody DonvichucnangDTO dto) {
        DonvichucnangDTO updated = donvichucnangService.update(id, dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new ResponseObject("202", "Cập nhật đơn vị chức năng thành công", updated));
    }

    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "No content", content = @Content()),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))})
    public ResponseEntity<ResponseObject> delete(@PathVariable Long id) {
        donvichucnangService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ResponseObject("204", "Xóa đơn vị chức năng thành công", null));
    }
}

package com.example.demo.controller;


import com.example.demo.dto.UserDTO;
import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.request.ResetPasswordRequest;
import com.example.demo.dto.response.ResponseObject;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtils;
import com.example.demo.util.TokenBlacklist;
import com.example.demo.viewmodel.ErrorVm;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
@Slf4j
public class AuthenticationController {

    private final String frontendUrl;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final TokenBlacklist tokenBlacklist;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = LoginRequest.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Map<String, String> tokens = userService.login(loginRequest);
            System.out.println("Thành công: " + tokens);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "Login successful", tokens));
        } catch (RuntimeException e) {
            System.out.println("Thất bại: " + e.getMessage());
            return ResponseEntity.badRequest().body(new ResponseObject("failed", e.getMessage(), ""));
        } catch (Exception e) {
            System.out.println("Thất bại: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseObject("failed", "An error occurred", ""));
        }
    }


    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody Map<String, String> request) {
        try {
            // Lấy refresh token từ request body
            String refreshToken = request.get("refreshToken");

            // Gọi service để làm mới token
            String newAccessToken = userService.refreshToken(refreshToken);

            // Trả về access token mới
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "Token refreshed successfully", Map.of("access_token", newAccessToken)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new ResponseObject("failed", e.getMessage(), ""));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseObject("failed", "An error occurred", ""));
        }
    }


    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            tokenBlacklist.addToBlacklist(token);
        }
        return ResponseEntity.ok("Logged out successfully");
    }

    @PostMapping("/register")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created",
                    content = @Content(schema = @Schema(implementation = UserDTO.class))),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(schema = @Schema(implementation = ErrorVm.class)))
    })
    public ResponseEntity<?> processRegister(@RequestBody UserDTO userDTO) {
        try {
            userService.register(userDTO);

            System.out.println(userDTO.getUserName());
            System.out.println(userDTO.getRoles());
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "Register successful. Please check your mail to verify!", userDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseObject("failed", e.getMessage(), ""));
        }
    }


    @GetMapping("/forgot-password")
    public ResponseEntity<ResponseObject> processForgotPassword(@RequestParam String email) {
        try {
            userService.forgotPassword(email, frontendUrl);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Sent mail to reset password", "Please check mail to reset password!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseObject("failed", e.getMessage(), ""));
        }
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ResponseObject> changePassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
        try {
            userService.resetPassword(resetPasswordRequest.getVerifyCode(), resetPasswordRequest.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseObject("201", "Reset password successful!", "Reset password successful!"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ResponseObject("failed", e.getMessage(), ""));

        }
    }
    @GetMapping("/reset")
    public ResponseEntity<ResponseObject> showResetPage(@RequestParam String code) {
        System.out.println("Received reset code: " + code);  // Log mã code nhận được
        ResponseObject response = new ResponseObject("ok", "Reset page accessed successfully with code", code);
        return ResponseEntity.ok(response);  // Trả về thông tin chi tiết trong JSON
    }


    @GetMapping("/verify")
    public ResponseEntity<ResponseObject> verifyUser(@Param("code") String code) {
        if (userService.verify(code)) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("200", "Successful verification!", "Xác minh email thành công!"));

        } else {
            return ResponseEntity.badRequest().body(new ResponseObject("failed", "Verification failed!", "Xác minh email thất bại!"));
        }
    }



//    @PostMapping("/authenticate")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserDTO userDTO) throws Exception {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword())
//            );
//        } catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
//
//        final UserDetails userDetails = userService.loadUserByUsername(userDTO.getUsername());
//        final String jwt = jwtUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new JwtResponse(jwt));
//    }
}

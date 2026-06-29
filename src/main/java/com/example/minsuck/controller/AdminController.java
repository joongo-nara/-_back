package com.example.minsuck.controller;

import com.example.minsuck.DTO.AdminDto.*;
import com.example.minsuck.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService; // 서비스 주입

    @GetMapping("/stats")
    public ResponseEntity<AdminStatsResponse> getStats(@RequestParam String period) {
        return ResponseEntity.ok(adminService.getStats(period));
    }

    @GetMapping("/quests/top")
    public ResponseEntity<List<TopQuestResponse>> getTopQuests(@RequestParam String period) {
        return ResponseEntity.ok(adminService.getTopQuests(period));
    }

    @PostMapping("/users/{id}/warn")
    public ResponseEntity<WarnResponse> warnUser(@PathVariable Long id, @RequestBody WarnRequest request) {
        return ResponseEntity.ok(adminService.sendWarningPush(id, request.messageType()));
    }
}
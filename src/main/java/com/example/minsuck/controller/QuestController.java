package com.example.minsuck.controller;

import com.example.minsuck.DTO.QuestDto.*;
import com.example.minsuck.service.QuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/quests")
@RequiredArgsConstructor
public class QuestController {
    private final QuestService questService;

    @GetMapping
    public ResponseEntity<List<QuestResponse>> getAssignedQuests(@RequestParam(required = false, defaultValue = "daily") String type) {
        // userId는 실무에선 SecurityContextHolder에서 가져옴
        return ResponseEntity.ok(questService.getAssignedQuests(1L, type));
    }

    @PostMapping("/{id}/auth/pin")
    public ResponseEntity<QuestAuthResponse> authenticateByPin(@PathVariable Long id, @RequestBody PinAuthRequest request) {
        return ResponseEntity.ok(questService.authByPin(1L, id, request.buddyPin()));
    }
}
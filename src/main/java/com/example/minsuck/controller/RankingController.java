package com.example.minsuck.controller;

import com.example.minsuck.DTO.RankingDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rankings")
@RequiredArgsConstructor
public class RankingController {
    @GetMapping
    public ResponseEntity<List<RankingResponse>> getRankings(@RequestParam(defaultValue = "전체") String unit) {
        return ResponseEntity.ok(List.of(new RankingResponse(1, "황병장", "병장", "본부중대", 42, 22000)));
    }

    @PostMapping("/{userId}/poke")
    public ResponseEntity<PokeResponse> pokeUser(@PathVariable Long userId) {
        return ResponseEntity.ok(new PokeResponse(true, "응원 알림 전송 완료"));
    }
}
package com.example.minsuck.controller;

import com.example.minsuck.DTO.UserDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getMyProfile() {
        Map<String, Integer> mockStats = Map.of("str", 20, "stamina", 25, "int", 15, "men", 30, "surv", 18);
        return ResponseEntity.ok(new UserProfileResponse("고차원", "일병", 6, 800, 1200, mockStats, true));
    }

    @PostMapping("/buddy/join")
    public ResponseEntity<BuddyJoinResponse> joinBuddyGroup(@RequestBody BuddyJoinRequest request) {
        return ResponseEntity.ok(new BuddyJoinResponse(true, 12L));
    }

    @PutMapping("/title")
    public ResponseEntity<TitleEquipResponse> equipTitle(@RequestBody TitleEquipRequest request) {
        return ResponseEntity.ok(new TitleEquipResponse(true, "불사조"));
    }
}
package com.example.minsuck.service;

import com.example.minsuck.DTO.UserDto.*;
import com.example.minsuck.domain.*;
import com.example.minsuck.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final BuddyGroupRepository buddyGroupRepository;
    private final TitleRepository titleRepository;

    public UserProfileResponse getMyProfile(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("유저 없음"));
        Map<String, Integer> stats = Map.of(
                "str", user.getStats().getStrength(), "stamina", user.getStats().getStamina(),
                "int", user.getStats().getIntelligence(), "men", user.getStats().getMental(),
                "surv", user.getStats().getSurvival()
        );
        return new UserProfileResponse(user.getNickname(), user.getRank(), user.getLevel(), user.getCurrentExp(), user.getMaxExp(), stats, user.isAdmin());
    }

    @Transactional
    public BuddyJoinResponse joinBuddyGroup(Long userId, String pin) {
        User user = userRepository.findById(userId).orElseThrow();
        BuddyGroup group = buddyGroupRepository.findByConnectionPin(pin).orElseThrow(() -> new IllegalArgumentException("PIN 오류"));
        // user.setBuddyGroup(group); // 연관관계 설정 로직
        return new BuddyJoinResponse(true, group.getId());
    }
}
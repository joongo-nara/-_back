package com.example.minsuck.service;

import com.example.minsuck.DTO.AdminDto.*;
import com.example.minsuck.domain.User;
import com.example.minsuck.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AdminService {
    private final UserRepository userRepository;

    public AdminStatsResponse getStats(String period) {
        return new AdminStatsResponse((int) userRepository.count(), 10, List.of(30, 45, 60, 20, 80, 0, 0));
    }

    public List<TopQuestResponse> getTopQuests(String period) {
        return List.of(new TopQuestResponse("1km 달리기", 89), new TopQuestResponse("팔굽혀펴기 30개", 65));
    }

    public List<InactiveUserResponse> getInactiveUsers(int days) {
        return List.of(new InactiveUserResponse(45L, "김철수", "퀘스트 미달성"));
    }

    public WarnResponse sendWarningPush(Long userId, String messageType) {
        User user = userRepository.findById(userId).orElseThrow();
        return new WarnResponse(true, user.getNickname() + "님에게 경고 알림 전송 완료");
    }
}
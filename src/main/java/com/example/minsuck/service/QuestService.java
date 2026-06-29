package com.example.minsuck.service;

import com.example.minsuck.DTO.QuestDto.*;
import com.example.minsuck.domain.*;
import com.example.minsuck.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class QuestService {
    private final UserAssignedQuestRepository aqRepo;

    public List<QuestResponse> getAssignedQuests(Long userId, String typeStr) {
        return aqRepo.findByUserIdAndAssignedDate(userId, LocalDate.now())
                .stream()
                .filter(aq -> aq.getQuest().getCategory().name().equalsIgnoreCase(typeStr))
                .map(aq -> new QuestResponse(
                        aq.getId(),
                        aq.getQuest().getTitle(),
                        aq.getQuest().getDescription(),
                        aq.getStatus().name(),
                        aq.getQuest().getRewardExp()
                ))
                .collect(Collectors.toList());
    }

    public QuestAuthResponse authByPin(Long userId, Long assignmentId, String buddyPin) {
        UserAssignedQuest aq = aqRepo.findById(assignmentId).orElseThrow();
        aq.completeQuest(); // 상태 변경 및 완료 시간 기록 (BaseTimeEntity 활용)

        return new QuestAuthResponse(
                true,
                aq.getQuest().getRewardExp(),
                aq.getQuest().getTargetStat(),
                aq.getQuest().getStatIncreaseAmt()
        );
    }
}
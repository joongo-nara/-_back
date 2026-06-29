package com.example.minsuck.repository;

import com.example.minsuck.domain.UserAssignedQuest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface UserAssignedQuestRepository extends JpaRepository<UserAssignedQuest, Long> {
    // 특정 유저가 특정 날짜에 할당받은 퀘스트 목록 조회
    List<UserAssignedQuest> findByUserIdAndAssignedDate(Long userId, LocalDate assignedDate);
}